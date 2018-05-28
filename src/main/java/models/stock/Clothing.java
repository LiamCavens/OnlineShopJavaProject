package models.stock;

import behaviors.Sellable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="clothing")
public class Clothing extends Stock{

    private String clothingImage;

    public Clothing(String name, String description, int quantity, double boughtInPrice, double sellPrice, String clothingImage) {
        super(name, description, quantity, boughtInPrice, sellPrice);
        this.clothingImage = clothingImage;
    }

    public Clothing(){}

    @Column(name="clothing_image")
    public String getClothingImage() {
        return clothingImage;
    }

    public void setClothingImage(String clothingImage) {
        this.clothingImage = clothingImage;
    }
}
