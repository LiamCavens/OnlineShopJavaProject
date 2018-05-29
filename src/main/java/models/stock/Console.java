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

    private Set<Game> games;
    private String image;

    public Console(String name, String description, int quantity, double boughtInPrice, double sellPrice, String image) {
        super(name, description, quantity, boughtInPrice, sellPrice);
        this.games = new HashSet<>();
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

    @OneToMany(mappedBy = "console")
    public Set<Game> getGames() {
        return games;
    }

    public void setGames(Set<Game> games) {
        this.games = games;
    }
}
