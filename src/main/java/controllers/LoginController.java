package controllers;

import db.DBCustomer;
import db.DBHelper;
import models.Customer;
import models.stock.Game;
import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.template.velocity.VelocityTemplateEngine;

import java.util.HashMap;
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

        // TODO check session username against all Customer.class username to get the id to redirect to /customer/:id
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
    }



    public static String getLoggedInUserName(Request req, Response res) {
        String username = req.session().attribute("username");
        if (username == null || username.isEmpty()){
            res.redirect("/login");
        }
        return username;
    }
}
