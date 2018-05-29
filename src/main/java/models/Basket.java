package models;

import models.stock.Stock;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "baskets")
public class Basket {

    private int id;
    private double runningTotal;
    private ArrayList<Stock> itemsInBasket;
    private Customer customer;

    public Basket() {
        this.itemsInBasket = new ArrayList<>();
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

    @Column(name= "running_total")
    public double getRunningTotal() {
        for(Stock stock : itemsInBasket){
            this.runningTotal += stock.getSellPrice();
        }
        if (itemsInBasket.size() <= 2) {
            return runningTotal;
        }
        return applyDiscount();
    }

    public void setRunningTotal(double runningTotal) {
        this.runningTotal = runningTotal;
    }

    @Column(name = "items_in_basket")
    public ArrayList<Stock> getItemsInBasket() {
        return itemsInBasket;
    }

    public void setItemsInBasket(ArrayList<Stock> itemsInBasket) {
        this.itemsInBasket = itemsInBasket;
    }

    public void addItemToBasket(Stock stock){
        this.itemsInBasket.add(stock);
        stock.setQuantity((stock.getQuantity() - 1));
    }

    public double applyDiscount(){
        if (itemsInBasket.size() == 3){
            return this.runningTotal * 0.95;
        }  else if (itemsInBasket.size() == 4){
                return this.runningTotal * 0.90;
            } else if (itemsInBasket.size() >= 5){
                    return this.runningTotal * 0.85;
                }
        return runningTotal;
    }

    @OneToOne(cascade = CascadeType.PERSIST)
    @PrimaryKeyJoinColumn
    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
