package models;

import models.Stock.Stock;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="shops")
public class Shop {

    private int id;
    private String shopName;
    private double till;
    private Set<Stock> shopStock;

    public Shop() {
    }

    public Shop(String shopName, double till) {
        this.shopName = shopName;
        this.till = till;
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
    public Set<Stock> getShopStock() {
        return shopStock;
    }

    public void setShopStock(Set<Stock> shopStock) {
        this.shopStock = shopStock;
    }

    public void addStockToShop(Stock item){
        this.shopStock.add(item);
        this.till -= item.getBoughtInPrice();
    }
}
