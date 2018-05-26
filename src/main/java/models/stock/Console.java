package models.stock;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "consoles")
public class Console extends Stock {

    private String consoleImage;

    public Console(String name, String description, int quantity, double boughtInPrice, double sellPrice, String consoleImage) {
        super(name, description, quantity, boughtInPrice, sellPrice);
        this.consoleImage = consoleImage;
    }

    public Console() {
    }

    @Column(name = "console_image")
    public String getConsoleImage() {
        return consoleImage;
    }

    public void setConsoleImage(String consoleImage) {
        this.consoleImage = consoleImage;
    }
}
