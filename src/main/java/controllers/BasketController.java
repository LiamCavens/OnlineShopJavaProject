package controllers;

import db.DBBasket;
import db.DBCustomer;
import db.DBHelper;
import models.Basket;
import models.Customer;
import models.stock.Clothing;
import models.stock.Stock;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static spark.Spark.get;
import static spark.Spark.modelAndView;
import static spark.Spark.post;

public class BasketController {

    public BasketController(){
        this.setupEndpoints();
    }

    private void setupEndpoints() {

        get("/basket/:customer_id", (req, res) -> {

            int custId = Integer.parseInt(req.params("customer_id"));
            Customer customer = DBHelper.find(custId ,Customer.class);
            Basket basket = DBBasket.getbasketForCustomer(customer);

            HashMap<String, Object> model = new HashMap<>();
            List<Stock> itemsInBasket = DBBasket.getStockFromBasket(basket);
            String loggedInUser = LoginController.getLoggedInUserName(req, res);
            Customer foundCustomer = DBCustomer.findByUsername(loggedInUser, Customer.class);
            model.put("customer", foundCustomer);
            model.put("itemsInBasket", itemsInBasket);
            model.put("template", "templates/basket/index.vtl");
            return modelAndView(model, "templates/layout.vtl");
        },  new VelocityTemplateEngine());

    }
}
