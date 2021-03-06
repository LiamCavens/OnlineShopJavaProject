package controllers;

import db.DBCustomer;
import db.DBHelper;
import db.Seed;
import models.Customer;
import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.template.velocity.VelocityTemplateEngine;

import java.util.HashMap;
import java.util.Map;

import static spark.Spark.get;
import static spark.SparkBase.staticFileLocation;

public class MasterController {

    public static void main(String[] args) {

        Seed.seedData();
        staticFileLocation("/public");

        LoginController loginController = new LoginController();
        BasketController basketController = new BasketController();
        CustomerController customerController = new CustomerController();
        GameController gameController = new GameController();
        ConsoleController consoleController = new ConsoleController();
        ClothingController clothingController = new ClothingController();
        StockController stockController = new StockController();

        get("/", (Request req, Response res) -> {
            Map<String, Object> model = new HashMap<>();
            model.put("template", "templates/main.vtl");
            String loggedInUser = LoginController.getLoggedInUserName(req, res);
            Customer foundCustomer = DBCustomer.findByUsername(loggedInUser, Customer.class);
            model.put("customer", foundCustomer);

            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());

    }
}
