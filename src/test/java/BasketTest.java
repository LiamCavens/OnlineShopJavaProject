import models.Basket;
import models.stock.Clothing;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BasketTest {

    Basket basket;
    Clothing clothing;
    Clothing clothing2;
    Clothing clothing3;
    Clothing clothing4;
    Clothing clothing5;

    @Before
    public void setUp() {
        basket = new Basket();
        clothing = new Clothing("JockStrap", "Worn by jocks", 1, 10, 20);
        clothing2 = new Clothing("Jacket", "Has a hood", 1, 10, 40);
        clothing3 = new Clothing("Socks", "leather socks", 1, 10, 60);
        clothing4 = new Clothing("Leather Kilt", "pants needed", 1, 5, 10);
        clothing5 = new Clothing("Cane", "for using when someone steps out of line", 1, 10, 80);
    }

    @Test
    public void basketHasTotal() {
        basket.addItemToBasket(clothing5);
        assertEquals(80, basket.getRunningTotal(), 0.1);
    }

    @Test
    public void threeItemsDiscount() {
        basket.addItemToBasket(clothing4);
        basket.addItemToBasket(clothing4);
        basket.addItemToBasket(clothing5);
        assertEquals(95, basket.getRunningTotal(), 0.1);
    }

    @Test
    public void fiveItemDiscount() {
        basket.addItemToBasket(clothing);
        basket.addItemToBasket(clothing);
        basket.addItemToBasket(clothing);
        basket.addItemToBasket(clothing);
        basket.addItemToBasket(clothing);
        assertEquals(85, basket.getRunningTotal(), 0.1);
    }
}
