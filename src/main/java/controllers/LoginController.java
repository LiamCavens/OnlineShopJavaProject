package controllers;

import db.DBCustomer;
import db.DBHelper;
import models.Basket;
import models.Customer;
import models.stock.Game;
import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.template.velocity.VelocityTemplateEngine;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static spark.Spark.get;
import static spark.Spark.post;

public class LoginController {


    public LoginController(){
        this.setupEndPoints();
    }

    private void setupEndPoints(){

        post("/login", (req, res) -> {
            String inputtedUsername = req.queryParams("username");
            req.session().attribute("username", inputtedUsername);
            res.redirect("/");
            return null;
        }, new VelocityTemplateEngine());

        get("/login", (req, res) -> {
            String username = req.session().attribute("username");
            if (username == null || username.isEmpty()){
                Map<String, Object> model = new HashMap<>();
                model.put("template", "templates/login.vtl");
                return new ModelAndView(model, "templates/layout.vtl");
            }
            else {

                Customer customer = DBCustomer.findByUsername(username, Customer.class);
                int result = customer.getId();
                res.redirect("/customer/" + result);
                return null;
            }
        }, new VelocityTemplateEngine());

        get("/logout", (req, res) -> {
            req.session().removeAttribute("username");
            res.redirect("/");
            return null;
        }, new VelocityTemplateEngine());

        get("/login/signup", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            List<Customer> customers = DBHelper.getAll(Customer.class);
            model.put("customers", customers);
            model.put("template", "templates/signup.vtl");
            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());


        post("/customer", (req, res) -> {
            String username = req.queryParams("username");
            String address = req.queryParams("address");
            int intAge = Integer.parseInt(req.queryParams("age"));
            Basket basket = new Basket();
            Customer customer = new Customer(username, address, intAge, basket);
            DBHelper.saveOrUpdate(basket);
            DBHelper.saveOrUpdate(customer);
            res.redirect("/");
            return null;
        }, new VelocityTemplateEngine());

    }

    public static String getLoggedInUserName(Request req, Response res) {
        String username = req.session().attribute("username");
        if (username == null || username.isEmpty()){
            res.redirect("/login");
        }
        return username;
    }

    public static Boolean userExists(Request req, Response res) {
        Boolean result = false;
        String username = req.session().attribute("username");
        Customer customer = DBCustomer.findByUsername(username, Customer.class);
        if (customer.getId() != 0){
            result = true;
            res.redirect("/login");
        }
        return result;
    }
}
