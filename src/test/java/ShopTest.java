import models.Shop;
import models.stock.Game;
import models.stock.GameGenre;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class ShopTest {

    Shop shop;
    Game game;

    @Before
    public void setUp() {
        shop = new Shop("Dragon Games", 1000);
        game = new Game("GTAV", "Gud game", 1, 5, 25, GameGenre.ACTION, "3456-BGDS-FCSA");
    }

    @Test
    public void shopHasName() {
        assertEquals("Dragon Games", shop.getShopName());
    }

    @Test
    public void shopHasFunds() {
        assertEquals(1000.0, shop.getTill());
    }

    @Test
    public void getsStock() {
        shop.addStockToInventory(game);
        assertEquals(1, shop.getInventory().size());
        assertEquals(995.0, shop.getTill(), 0.1);
    }
}
