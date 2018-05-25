package controllers;

import db.DBHelper;
import models.Stock.Game;
import models.Stock.Stock;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static spark.Spark.get;

public class StockController {

    public StockController(){
        this.setupEndpoints();
    }

    private void setupEndpoints() {

        get("/games", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            List<Game> games = DBHelper.getAll(Game.class);
            model.put("games", games);
            model.put("template", "templates/stock/index.vtl");
            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());
    }
}
