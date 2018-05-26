package controllers;

import db.DBHelper;
import models.stock.Clothing;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static spark.Spark.get;
import static spark.Spark.post;

public class ClothingController {

    private void setupEndpoints() {

        get("/clothing", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            List<Clothing> clothing = DBHelper.getAll(Clothing.class);
            model.put("clothing", clothing);
            model.put("template", "templates/stock/clothing/index.vtl");
            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());

        get ("/clothing/new", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            model.put("template", "templates/stock/clothing/create.vtl");
            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());

        post ("/clothing", (req, res) -> {
            String name = req.queryParams("name");
            String description = req.queryParams("description");
            int quantity = Integer.parseInt(req.queryParams("quantity"));
            int boughtInPrice = Integer.parseInt(req.queryParams("boughtInPrice"));
            int sellPrice = Integer.parseInt(req.queryParams("sellPrice"));
            Clothing clothing = new Clothing(name, description, quantity, boughtInPrice, sellPrice);
            DBHelper.saveOrUpdate(clothing);
            res.redirect("/clothing");
            return null;
        }, new VelocityTemplateEngine());
    }


}
