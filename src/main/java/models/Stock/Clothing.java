package models.Stock;

import behaviors.Sellable;

public class Clothing extends Stock implements Sellable {

    public Clothing(String name, String description, int quantity, double boughtInPrice, double sellPrice) {
        super(name, description, quantity, boughtInPrice, sellPrice);
    }

    public double calculateMarkUp(){
        Double result = this.getSellPrice() - this.getBoughtInPrice();
        return result;
    }
}
