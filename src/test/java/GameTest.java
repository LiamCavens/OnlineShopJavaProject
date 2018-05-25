import models.stock.Game;
import models.stock.GameGenre;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GameTest {

    Game game1;
    Game game2;

    @Before
    public void setUp() throws Exception {
        game1 = new Game("Leisure Suit Larry", "Good game", 10, 5.00, 10.00, GameGenre.CASUAL, "12345",  "https://static-cdn.jtvnw.net/ttv-boxart/Grand%20Theft%20Auto%20V.jpg", "https://www.youtube.com/watch?v=hvoD7ehZPcM");
        game2 = new Game("Metal Gear Solid", "Best Game", 10, 5.00, 10.00, GameGenre.ACTION, "12346",  "https://static-cdn.jtvnw.net/ttv-boxart/Grand%20Theft%20Auto%20V.jpg", "https://www.youtube.com/watch?v=hvoD7ehZPcM");
    }

    @Test
    public void hasKey() {
        assertEquals("12345", game1.getGameKey());
    }
}
