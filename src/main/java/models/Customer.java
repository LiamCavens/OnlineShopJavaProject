package models;

import models.Stock.Stock;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Set;

@Entity
@Table(name = "customers")
public class Customer {

    private int id;
    private String username;
    private String address;
    private int age;
    private Basket basket;
    private ArrayList<Stock> purchases;

    public Customer() {
    }

    public Customer(String username, String address, int age, Basket basket) {
        this.username = username;
        this.address = address;
        this.age = age;
        this.basket = basket;
        this.purchases = new ArrayList<>();
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

    @Column(name = "username")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Column(name = "address")
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Column(name = "age")
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Basket getBasket() {
        return basket;
    }

    public void setBasket(Basket basket) {
        this.basket = basket;
    }

    public ArrayList<Stock> getPurchases() {
        return purchases;
    }

    public void setPurchases(ArrayList<Stock> purchases) {
        this.purchases = purchases;
    }

    public void addPurchase(Stock stock){
        this.purchases.add(stock);
    }
}
