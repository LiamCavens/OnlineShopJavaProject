package models.Stock;

import behaviors.Sellable;

public class Game extends Stock implements Sellable{

    private GameGenre genre;
    private String gameKey;
    private String gameImage;
    private String gameTrailer;

    public Game(String name, String description, int quantity, double boughtInPrice, double sellPrice, GameGenre genre, String gameKey) {
        super(name, description, quantity, boughtInPrice, sellPrice);
        this.genre = genre;
        this.gameKey = gameKey;
        this.gameImage = gameImage;
        this.gameTrailer = gameTrailer;
    }

    public String getGameKey() {
        return gameKey;
    }

    public void setGameKey(String gameKey) {
        this.gameKey = gameKey;
    }

    public double calculateMarkUp(){
        Double result = this.getSellPrice() - this.getBoughtInPrice();
        return result;
    }

    public String getGameImage() {
        return gameImage;
    }

    public void setGameImage(String gameImage) {
        this.gameImage = gameImage;
    }

    public String getGameTrailer() {
        return gameTrailer;
    }

    public void setGameTrailer(String gameTrailer) {
        this.gameTrailer = gameTrailer;
    }

    public GameGenre getGenre() {
        return genre;
    }

    public void setGenre(GameGenre genre) {
        this.genre = genre;
    }
}
