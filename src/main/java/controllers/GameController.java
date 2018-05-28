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

public class GameController {

    public GameController(){
        this.setupEndpoints();
    }

    private void setupEndpoints() {

        get("/games", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            List<Game> games = DBHelper.getAll(Game.class);
            String loggedInUser = LoginController.getLoggedInUserName(req, res);
            model.put("user", loggedInUser);
            model.put("games", games);
            model.put("template", "templates/stock/games/index.vtl");
            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());

        get ("/games/new", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            List<Console> consoles = DBHelper.getAll(Console.class);
            model.put("consoles", consoles);
            model.put("template", "templates/stock/games/create.vtl");
            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());



        get("/games/:id/edit", (req, res) -> {
            String gameId = req.params(":id");
            Integer intId = Integer.parseInt(gameId);
            Game game = DBHelper.find(intId, Game.class);
            List<Console> consoles = DBHelper.getAll(Console.class);

            Map<String, Object> model = new HashMap<>();
//            String loggedInUser = LoginController.getLoggedInUserName(req, res);
//            model.put("user", loggedInUser);
            model.put("consoles", consoles);
            model.put("template", "templates/stock/games/edit.vtl");
            model.put("game", game);

            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());

        get("/games/:id", (req, res) -> {
            String gameId = req.params(":id");
            Integer intId = Integer.parseInt(gameId);
            Game game = DBHelper.find(intId, Game.class);

            Map<String, Object> model = new HashMap<>();
          //  String loggedInUser = LoginController.getLoggedInUserName(req, res);
          //  model.put("user", loggedInUser);
            model.put("game", game);
            model.put("template", "templates/stock/games/show.vtl");

            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());

        post ("/games", (req, res) -> {
            String name = req.queryParams("name");
            String description = req.queryParams("description");
            int quantity = Integer.parseInt(req.queryParams("quantity"));
            double boughtInPrice = Double.parseDouble(req.queryParams("boughtInPrice"));
            double sellPrice = Double.parseDouble(req.queryParams("sellPrice"));
            String genre = req.queryParams("genre");
            int consoleId = Integer.parseInt(req.queryParams("console"));
            Console console = DBHelper.find(consoleId, Console.class);
            String gameKey = req.queryParams("gameKey");
            String gameImage = req.queryParams("gameImage");
            String gameTrailer = req.queryParams("gameTrailer");

            Game game = new Game(name, description, quantity, boughtInPrice, sellPrice, genre, console, gameKey, gameImage, gameTrailer);
            DBHelper.saveOrUpdate(game);
            res.redirect("/games");
            return null;
        }, new VelocityTemplateEngine());

        post ("/games/:id/delete", (req, res) -> {
            int id = Integer.parseInt(req.params(":id"));
            Game gameToDelete = DBHelper.find(id, Game.class);
            DBHelper.delete(gameToDelete);
            res.redirect("/games");
            return null;
        }, new VelocityTemplateEngine());

        post ("/games/:id", (req, res) -> {
            int consoleId = Integer.parseInt(req.queryParams("console"));
            Console console = DBHelper.find(consoleId, Console.class);
            String gameId = req.params(":id");
            Integer intId = Integer.parseInt(gameId);
            Game game = DBHelper.find(intId, Game.class);
            String name = req.queryParams("name");
            String description = req.queryParams("description");
            int quantity = Integer.parseInt(req.queryParams("quantity"));
            double boughtInPrice = Double.parseDouble(req.queryParams("boughtInPrice"));
            double sellPrice = Double.parseDouble(req.queryParams("sellPrice"));
            String genre = req.queryParams("genre");
            String image = req.queryParams("image");
            String gameTrailer = req.queryParams("gameTrailer");

            game.setName(name);
            game.setDescription(description);
            game.setQuantity(quantity);
            game.setBoughtInPrice(boughtInPrice);
            game.setSellPrice(sellPrice);
            game.setGenre(genre);
            game.setImage(image);
            game.setGameTrailer(gameTrailer);

            DBHelper.saveOrUpdate(game);
            res.redirect("/games");
            return null;

        }, new VelocityTemplateEngine());
    }
}
