package models.stock;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "consoles")
public class Console extends Stock {

    public Console(String name, String description, int quantity, double boughtInPrice, double sellPrice) {
        super(name, description, quantity, boughtInPrice, sellPrice);
    }

    public Console() {
    }

}
