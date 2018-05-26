package controllers;

import db.DBHelper;
import models.stock.Console;
import models.stock.Game;
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
            int boughtInPrice = Integer.parseInt(req.queryParams("boughtInPrice"));
            int sellPrice = Integer.parseInt(req.queryParams("sellPrice"));
            Console console = new Console(name, description, quantity, boughtInPrice, sellPrice);
            DBHelper.saveOrUpdate(console);
            res.redirect("/consoles");
            return null;
        }, new VelocityTemplateEngine());
    }


}
