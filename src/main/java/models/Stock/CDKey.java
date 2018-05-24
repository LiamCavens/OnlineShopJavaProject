package models.Stock;

import behaviors.Sellable;

public class CDKey extends Stock implements Sellable{

    private String gameKey;

    public CDKey(String name, String description, int quantity, double boughtInPrice, double sellPrice, String key) {
        super(name, description, quantity, boughtInPrice, sellPrice);
        this.gameKey = key;
    }

    public String getGameKey() {
        return gameKey;
    }

    public void setGameKey(String gameKey) {
        this.gameKey = gameKey;
    }

    public double calculateMarkUp(){
        Double result = this.getSellPrice() - this.getBoughtInPrice();
        return result;
    }
}
