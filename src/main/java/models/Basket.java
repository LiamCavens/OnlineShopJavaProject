package models;

import models.Stock.Stock;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "baskets")
public class Basket {

    private int id;
    private double runningTotal;
    private Set<Stock> itemsInBasket;

    public Basket() {
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
        if (itemsInBasket.size() <= 2) {
            return runningTotal;
        }
        return applyDiscount();
    }

    public void setRunningTotal(double runningTotal) {
        this.runningTotal = runningTotal;
    }

    @OneToMany(mappedBy = "basket")
    public Set<Stock> getItemsInBasket() {
        return itemsInBasket;
    }

    public void setItemsInBasket(Set<Stock> itemsInBasket) {
        this.itemsInBasket = itemsInBasket;
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
