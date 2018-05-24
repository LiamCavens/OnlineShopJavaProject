import models.Shop;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class ShopTest {

    Shop shop;

    @Before
    public void setUp() {
        shop = new Shop("Dragon Games", 1000);
    }

    @Test
    public void shopHasName() {
        assertEquals("Dragon Games", shop.getShopName());
    }

    @Test
    public void shopHasFunds() {
        assertEquals(1000.0, shop.getTill());
    }
}
