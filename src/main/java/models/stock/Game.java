package models.stock;

import javax.persistence.*;

@Entity
@Table(name = "games")
public class Game extends Stock {

    private String genre;
    private Console console;
    private String gameKey;
    private String image;
    private String gameTrailer;

    public Game(String name, String description, int quantity, double boughtInPrice, double sellPrice, String genre, Console console, String gameKey, String gameImage, String gameTrailer) {

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

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "console_id")
    public Console getConsole() {
        return console;
    }

    public void setConsole(Console console) {
        this.console = console;
    }
}
