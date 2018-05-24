package models.Stock;

public abstract class Stock {

    private int id;
    private String name;
    private String description;
    private int quantity;
    private double boughtInPrice;
    private double sellPrice;
    private boolean available;

    public Stock(String name, String description, int quantity, double boughtInPrice, double sellPrice) {
        this.name = name;
        this.description = description;
        this.quantity = quantity;
        this.boughtInPrice = boughtInPrice;
        this.sellPrice = sellPrice;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getBoughtInPrice() {
        return boughtInPrice;
    }

    public void setBoughtInPrice(double boughtInPrice) {
        this.boughtInPrice = boughtInPrice;
    }

    public double getSellPrice() {
        return sellPrice;
    }

    public void setSellPrice(double sellPrice) {
        this.sellPrice = sellPrice;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }
}
