package models;

import models.Stock.Stock;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Set;

@Entity
@Table(name="shops")
public class Shop {

    private int id;
    private String shopName;
    private double till;
    private ArrayList<Stock> inventory;

    public Shop() {
    }

    public Shop(String shopName, double till) {
        this.shopName = shopName;
        this.till = till;
        this.inventory = new ArrayList<>();
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

    @Column(name = "shop_name")
    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    @Column(name = "till")
    public double getTill() {
        return till;
    }

    public void setTill(double till) {
        this.till = till;
    }

    @OneToMany(mappedBy = "shop")
    public ArrayList<Stock> getInventory() {
        return inventory;
    }

    public void setInventory(ArrayList<Stock> inventory) {
        this.inventory = inventory;
    }

    public void addStockToInventory(Stock stock){
        this.inventory.add(stock);
        this.till -= stock.getBoughtInPrice();
    }

    public void sellStock(Stock stock){
        this.inventory.remove(stock);
        this.till += stock.getSellPrice();
    }
}
