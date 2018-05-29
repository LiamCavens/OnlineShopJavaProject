package models.stock;

import behaviors.Sellable;
import models.Basket;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "stock")
public abstract class Stock implements Sellable {

    private int id;
    private String name;
    private String description;
    private int quantity;
    private double boughtInPrice;
    private double sellPrice;
    private boolean available;
    private Set<Basket> baskets;

    public Stock(String name, String description, int quantity, double boughtInPrice, double sellPrice) {
        this.name = name;
        this.description = description;
        this.quantity = quantity;
        this.boughtInPrice = boughtInPrice;
        this.sellPrice = sellPrice;
        this.baskets = new HashSet<>();
    }

    public Stock() {
    }

    @Id
    @GeneratedValue
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Column(name = "quantity")
    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Column(name = "bought_in_price")
    public double getBoughtInPrice() {
        return boughtInPrice;
    }

    public void setBoughtInPrice(double boughtInPrice) {
        this.boughtInPrice = boughtInPrice;
    }

    @Column(name = "sell_price")
    public double getSellPrice() {
        return sellPrice;
    }

    public void setSellPrice(double sellPrice) {
        this.sellPrice = sellPrice;
    }

    @Column(name = "available")
    public boolean getAvailable() {
        if (getQuantity() >= 1){
           return true;
        } else
        return false;
    }

    public void setAvailable(boolean available) {
        this.available = getAvailable();
    }

    public double calculateMarkUp(){
        Double result = this.getSellPrice() - this.getBoughtInPrice();
        return result;
    }

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name="items_in_basket",
            inverseJoinColumns = {@JoinColumn(name = "basket_id", nullable = false, updatable = false)},
            joinColumns = {@JoinColumn(name = "stock_id", nullable = false, updatable = false)}
    )
    public Set<Basket> getBaskets() {
        return baskets;
    }

    public void setBaskets(Set<Basket> baskets) {
        this.baskets = baskets;
    }
}
