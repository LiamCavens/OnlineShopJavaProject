package controllers;

import db.DBHelper;
import models.Basket;
import models.stock.Clothing;
import models.stock.Stock;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static spark.Spark.get;
import static spark.Spark.post;

public class BasketController {

    public BasketController(){
        this.setupEndpoints();
    }

    private void setupEndpoints() {




    }
}
