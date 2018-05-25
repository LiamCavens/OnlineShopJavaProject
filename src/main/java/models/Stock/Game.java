package models.Stock;

import behaviors.Sellable;
import models.Customer;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "games")
public class Game extends Stock {

    private GameGenre genre;
    private String gameKey;
    private String gameImage;
    private String gameTrailer;
    private int pegiRating;

    public Game(String name, String description, int quantity, double boughtInPrice, double sellPrice, GameGenre genre, String gameKey) {
        super(name, description, quantity, boughtInPrice, sellPrice);
        this.genre = genre;
        this.gameKey = gameKey;
        this.gameImage = gameImage;
        this.gameTrailer = gameTrailer;
        this.pegiRating = pegiRating;
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
    public String getGameImage() {
        return gameImage;
    }

    public void setGameImage(String gameImage) {
        this.gameImage = gameImage;
    }

    @Column(name = "game_trailer")
    public String getGameTrailer() {
        return gameTrailer;
    }

    public void setGameTrailer(String gameTrailer) {
        this.gameTrailer = gameTrailer;
    }

    @Column(name = "genre")
    public GameGenre getGenre() {
        return genre;
    }

    public void setGenre(GameGenre genre) {
        this.genre = genre;
    }

    @Column(name="rating")
    public int getPegiRating() {
        return pegiRating;
    }

    public void setPegiRating(int pegiRating) {
        this.pegiRating = pegiRating;
    }


    public boolean checkPegiRating(Customer customer1) {
        boolean result = true;
        if (customer1.getAge() < this.getPegiRating()){
            result = false;
        }
        return result;
    }
}
