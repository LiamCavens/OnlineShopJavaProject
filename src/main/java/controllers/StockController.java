package controllers;

import db.DBHelper;
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

        get("/stock", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            List<Stock> stock = DBHelper.getAll(Stock.class);
            model.put("stock", stock);
            model.put("template", "templates/stock/index.vtl");
            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());
    }
}
