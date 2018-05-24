import models.Shop;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class ShopTest {

    Shop shop;

    @Before
    public void setUp() {
        shop = new Shop("Dragons FG4H", 1000);
    }

    @Test
    public void shopHasName() {
        assertEquals("Dragons FG4H", shop.getShopName());
    }
}
