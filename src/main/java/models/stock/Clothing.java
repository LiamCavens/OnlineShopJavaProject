package models.stock;

import behaviors.Sellable;

public class Clothing extends Stock{

    public Clothing(String name, String description, int quantity, double boughtInPrice, double sellPrice) {
        super(name, description, quantity, boughtInPrice, sellPrice);
    }

}
