import models.Basket;
import models.Customer;
import models.stock.Console;
import models.stock.Game;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GameTest {

    Basket basket1;
    Console console;
    Game game1;
    Game game2;
    Customer customer1;
    Customer customer2;

    @Before
    public void setUp() throws Exception {
        customer1 = new Customer("Tupal", "Argyle Street", 25, basket1);


        console = new Console("Xbox One", "The world's most powerful console" , 20, 300.00, 450.00, "https://i1.wp.com/freepngimages.com/wp-content/uploads/2015/10/playstation-4-games-console.png?fit=624%2C365");
        game1 = new Game("Leisure Suit Larry", "Good game", 10, 5.00, 10.00, "Casual", console, "12345",  "https://static-cdn.jtvnw.net/ttv-boxart/Grand%20Theft%20Auto%20V.jpg", "https://www.youtube.com/watch?v=hvoD7ehZPcM");
        game2 = new Game("Metal Gear Solid", "Best Game", 10, 5.00, 10.00, "Action", console, "12346",  "https://static-cdn.jtvnw.net/ttv-boxart/Grand%20Theft%20Auto%20V.jpg", "https://www.youtube.com/watch?v=hvoD7ehZPcM");
    }

    @Test
    public void hasKey() {
        assertEquals("12345", game1.getGameKey());
    }

    @Test
    public void hasPEGIRating() {
        assertEquals(0, game2.getPegiRating());
        game2.setPegiRating(12);
        assertEquals(12, game2.getPegiRating());
    }

    @Test
    public void cannotBuyPEGIRatedGames() {
        customer1.setAge(12);
        game2.setPegiRating(18);
        assertEquals(false, game2.checkPegiRating(customer1));
    }

    @Test
    public void canBuyPEGIRatedGames() {
        game2.setPegiRating(18);
        assertEquals(true, game2.checkPegiRating(customer1));
    }
}
