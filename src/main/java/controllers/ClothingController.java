package controllers;

import db.DBCustomer;
import db.DBHelper;
import models.Customer;
import models.stock.Clothing;
import models.stock.Game;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static spark.Spark.get;
import static spark.Spark.post;

public class ClothingController {

    public ClothingController(){
        this.setupEndpoints();
    }

    private void setupEndpoints() {

        get("/clothing", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            List<Clothing> clothes = DBHelper.getAll(Clothing.class);
            String loggedInUser = LoginController.getLoggedInUserName(req, res);
            Customer foundCustomer = DBCustomer.findByUsername(loggedInUser, Customer.class);
            model.put("customer", foundCustomer);
            model.put("clothes", clothes);
            model.put("template", "templates/stock/clothing/index.vtl");
            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());

        get ("/clothing/new", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            String loggedInUser = LoginController.getLoggedInUserName(req, res);
            Customer foundCustomer = DBCustomer.findByUsername(loggedInUser, Customer.class);
            model.put("customer", foundCustomer);
            model.put("template", "templates/stock/clothing/create.vtl");
            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());

        post ("/clothing", (req, res) -> {
            String name = req.queryParams("name");
            String description = req.queryParams("description");
            int quantity = Integer.parseInt(req.queryParams("quantity"));
            int boughtInPrice = Integer.parseInt(req.queryParams("boughtInPrice"));
            int sellPrice = Integer.parseInt(req.queryParams("sellPrice"));
            String clothingImage = req.queryParams("clothing_url");
            Clothing clothing = new Clothing(name, description, quantity, boughtInPrice, sellPrice, clothingImage);
            DBHelper.saveOrUpdate(clothing);
            res.redirect("/clothing");
            return null;
        }, new VelocityTemplateEngine());

        get("/clothing/:id", (req, res) -> {
            String clothingId = req.params(":id");
            Integer intId = Integer.parseInt(clothingId);
            Clothing clothing = DBHelper.find(intId, Clothing.class);
            Map<String, Object> model = new HashMap<>();
            String loggedInUser = LoginController.getLoggedInUserName(req, res);
            Customer foundCustomer = DBCustomer.findByUsername(loggedInUser, Customer.class);
            model.put("customer", foundCustomer);
            model.put("clothing", clothing);
            model.put("template", "templates/stock/clothing/show.vtl");
            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());

    }


}
