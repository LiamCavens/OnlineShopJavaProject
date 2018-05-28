package models.stock;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "consoles")
public class Console extends Stock {

    private String image;

    public Console(String name, String description, int quantity, double boughtInPrice, double sellPrice, String image) {
        super(name, description, quantity, boughtInPrice, sellPrice);
        this.image = image;
    }

    public Console() {
    }

    @Column(name = "console_image")
    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
