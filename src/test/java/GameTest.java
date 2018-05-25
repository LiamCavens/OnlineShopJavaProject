import models.Basket;
import models.Customer;
import models.Stock.Game;
import models.Stock.GameGenre;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GameTest {

    Basket basket1;
    Game game1;
    Game game2;
    Customer customer1;
    Customer customer2;

    @Before
    public void setUp() throws Exception {
        game1 = new Game("Leisure Suit Larry", "Good game", 10, 5.00, 10.00, GameGenre.CASUAL, "12345");
        game2 = new Game("Metal Gear Solid", "Best Game", 10, 5.00, 10.00, GameGenre.ACTION, "12346");
        customer1 = new Customer("Tupal", "Argyle Street", 25, basket1);

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
