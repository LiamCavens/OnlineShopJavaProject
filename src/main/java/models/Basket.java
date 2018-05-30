package models;

import models.stock.Stock;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "baskets")
public class Basket {

    private int id;
    private double runningTotal;
    private Set<Stock> itemsInBasket;

    public Basket() {
        this.itemsInBasket = new HashSet<>();
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

    @ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @JoinTable(name="items_in_basket",
            inverseJoinColumns = {@JoinColumn(name = "stock_id", nullable = false, updatable = false)},
            joinColumns = {@JoinColumn(name = "basket_id", nullable = false, updatable = false)}
    )
    public Set<Stock> getItemsInBasket() {
        return itemsInBasket;
    }

    public void setItemsInBasket(Set<Stock> itemsInBasket) {
        this.itemsInBasket = itemsInBasket;
    }

    public void addToBasket(Stock stock){
        this.itemsInBasket.add(stock);
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
}
