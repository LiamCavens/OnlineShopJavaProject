package controllers;

import db.DBHelper;
import models.stock.Game;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static spark.Spark.get;
import static spark.Spark.post;

public class GameController {

    public GameController(){
        this.setupEndpoints();
    }

    private void setupEndpoints() {

        get("/games", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            List<Game> games = DBHelper.getAll(Game.class);
            model.put("games", games);
            model.put("template", "templates/stock/games/index.vtl");
            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());

        get ("/games/new", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            model.put("template", "templates/stock/games/create.vtl");
            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());

        post ("/games", (req, res) -> {
            String name = req.queryParams("name");
            String description = req.queryParams("description");
            int quantity = Integer.parseInt(req.queryParams("quantity"));
            int boughtInPrice = Integer.parseInt(req.queryParams("boughtInPrice"));
            int sellPrice = Integer.parseInt(req.queryParams("sellPrice"));
            String genre = req.queryParams("genre");
            String gameKey = req.queryParams("gameKey");
            String gameImage = req.queryParams("gameImage");
            String gameTrailer = req.queryParams("gameTrailer");

            Game game = new Game(name, description, quantity, boughtInPrice, sellPrice, genre, gameKey, gameImage, gameTrailer);
            DBHelper.saveOrUpdate(game);
            res.redirect("/games");
            return null;
        }, new VelocityTemplateEngine());
    }
}
