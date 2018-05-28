package controllers;

import db.DBHelper;
import models.stock.Clothing;
import models.stock.Stock;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static spark.Spark.get;
import static spark.Spark.post;

public class BasketController {

    public BasketController(){
        this.setupEndpoints();
    }

    private void setupEndpoints() {

        get("/basket", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            List<Stock> basket = DBHelper.getAll(Stock.class);
            model.put("basket", basket);
            model.put("template", "templates/basket/index.vtl");
            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());

        post("/basket/:game_id", (req, res) -> {
            //This does not work

            String name = req.queryParams("name");
            int quantity = Integer.parseInt(req.queryParams("quantity"));
            int sellPrice = Integer.parseInt(req.queryParams("sellPrice"));
            String gameImage = req.queryParams("gameImage");

            res.redirect("/basket");
            return null;
        }, new VelocityTemplateEngine());
    }
}
