package models.stock;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "consoles")
public class Console extends Stock {

    private String consoleImage;
    private Set<Game> games;

    public Console(String name, String description, int quantity, double boughtInPrice, double sellPrice, String consoleImage) {
        super(name, description, quantity, boughtInPrice, sellPrice);
        this.consoleImage = consoleImage;
        this.games = new HashSet<>();
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

    @OneToMany(mappedBy = "console")
    public Set<Game> getGames() {
        return games;
    }

    public void setGames(Set<Game> games) {
        this.games = games;
    }
}
