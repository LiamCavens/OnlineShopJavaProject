package models.stock;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "games")
public class Game extends Stock {

    private String genre;
    private String gameKey;
    private String image;
    private String gameTrailer;

    public Game(String name, String description, int quantity, double boughtInPrice, double sellPrice, String genre, String gameKey, String image, String gameTrailer) {
        super(name, description, quantity, boughtInPrice, sellPrice);
        this.genre = genre;
        this.gameKey = gameKey;
        this.image = image;
        this.gameTrailer = gameTrailer;
    }

    public Game() {
    }

    @Column(name = "game_key")
    public String getGameKey() {
        return gameKey;
    }

    public void setGameKey(String gameKey) {
        this.gameKey = gameKey;
    }

    @Column(name = "game_image")
    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Column(name = "game_trailer")
    public String getGameTrailer() {
        return gameTrailer;
    }

    public void setGameTrailer(String gameTrailer) {
        this.gameTrailer = gameTrailer;
    }

    @Column(name = "genre")
    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}
