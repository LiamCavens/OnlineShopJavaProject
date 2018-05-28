package controllers;

import db.DBHelper;
import models.stock.Clothing;
import models.stock.Console;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static spark.Spark.get;
import static spark.Spark.post;

public class ConsoleController {

    public ConsoleController(){
        this.setupEndpoints();
    }

    private void setupEndpoints() {

        get("/consoles", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            List<Console> consoles = DBHelper.getAll(Console.class);
            model.put("consoles", consoles);
            model.put("template", "templates/stock/consoles/index.vtl");
            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());

        get ("/consoles/new", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            model.put("template", "templates/stock/consoles/create.vtl");
            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());

        post ("/consoles", (req, res) -> {
            String name = req.queryParams("name");
            String description = req.queryParams("description");
            int quantity = Integer.parseInt(req.queryParams("quantity"));
            double boughtInPrice = Double.parseDouble(req.queryParams("boughtInPrice"));
            double sellPrice = Double.parseDouble(req.queryParams("sellPrice"));
            String consoleImage = req.queryParams("console_image");
            Console console = new Console(name, description, quantity, boughtInPrice, sellPrice, consoleImage);
            DBHelper.saveOrUpdate(console);
            res.redirect("/consoles");
            return null;
        }, new VelocityTemplateEngine());

        get("/consoles/:id", (req, res) -> {
            String consoleId = req.params(":id");
            Integer intId = Integer.parseInt(consoleId);
            Console console = DBHelper.find(intId, Console.class);
            Map<String, Object> model = new HashMap<>();
            //  String loggedInUser = LoginController.getLoggedInUserName(req, res);
            //  model.put("user", loggedInUser);
            model.put("console", console);
            model.put("template", "templates/stock/consoles/show.vtl");
            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());

    }
}

