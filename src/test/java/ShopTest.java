import models.Shop;
import models.Stock.CDKey;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class ShopTest {

    Shop shop;
    CDKey cdKey;

    @Before
    public void setUp() {
        shop = new Shop("Dragon Games", 1000);
        cdKey = new CDKey("GTAV", "Gud game", 1, 5, 25, "3456-BGDS-FCSA");
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
        shop.addStockToInventory(cdKey);
        assertEquals(1, shop.getInventory().size());
        assertEquals(995.0, shop.getTill(), 0.1);
    }
}
