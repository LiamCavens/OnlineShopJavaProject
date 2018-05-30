package controllers;

import db.DBCustomer;
import db.DBHelper;
import models.Customer;
import models.stock.Clothing;
import models.stock.Stock;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static spark.Spark.get;

public class StockController {

    public StockController() {
        this.setupEndpoints();
    }

    private void setupEndpoints() {

        get("/stock", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            List<Stock> inventory = DBHelper.getAll(Stock.class);
            String loggedInUser = LoginController.getLoggedInUserName(req, res);
            Customer foundCustomer = DBCustomer.findByUsername(loggedInUser, Customer.class);
            model.put("customer", foundCustomer);
            model.put("inventory", inventory);
            model.put("template", "templates/stock/index.vtl");
            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());

    }
}