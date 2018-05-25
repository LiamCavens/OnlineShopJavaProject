package models.stock;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "consoles")
public class Console extends Stock {

    private ConsoleSystem system;

    public Console(String name, String description, int quantity, double boughtInPrice, double sellPrice, ConsoleSystem system) {
        super(name, description, quantity, boughtInPrice, sellPrice);
        this.system = system;
    }

    public Console() {
    }

    @Column(name = "system")
    public ConsoleSystem getSystem() {
        return system;
    }

    public void setSystem(ConsoleSystem system) {
        this.system = system;
    }
}
