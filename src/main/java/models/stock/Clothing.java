package models.stock;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="clothing")
public class Clothing extends Stock{

    private String image;

    public Clothing(String name, String description, int quantity, double boughtInPrice, double sellPrice, String image) {
        super(name, description, quantity, boughtInPrice, sellPrice);
        this.image = image;
    }

    public Clothing(){}

    @Column(name="clothing_image")
    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
