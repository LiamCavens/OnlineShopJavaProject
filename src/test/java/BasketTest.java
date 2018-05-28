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
        clothing = new Clothing("I Went Outside Once The Graphics Weren't Great T-Shirt", "Looking for the perfect excuse for staying inside a lot? This tee features a disheartened looking chap looking out onto a pixelated field and sky, while the caption 'I went outside once. The graphics weren't great.' is featured alongside. Well, some things in life are just a bit disappointing.", 1, 10, 20, "https://d1x7zurbps6occ.cloudfront.net/product/xlarge/513175-150221.jpg");
        clothing2 = new Clothing("Fallout T-Shirt", "Do you dare try and escape the vault? Set in a terrifying apocalyptic world, this eerie Fallout 4 t-shirt displays the Vault Boy mascot, pictured alongside the warnings of 'Surface - Never! Vault - Forever!' Official merchandise.", 1, 10, 40, "https://d1x7zurbps6occ.cloudfront.net/product/xlarge/529473-153868.jpg");
        clothing3 = new Clothing("Doom T-Shirt", "BFG not included", 1, 10, 60, "https://images-na.ssl-images-amazon.com/images/I/41Ab4IQzDqL.jpg");
        clothing4 = new Clothing("Leather Kilt", "Pants needed", 1, 5, 10, "http://www.leatherexotica.com/wp-content/uploads/2015/06/LEMK-012.jpg");
        clothing5 = new Clothing("Cane Sword", "18th century walking implement. For using when someone steps out of line", 1, 10, 80, "https://images.duckduckgo.com/iu/?u=http%3A%2F%2Fstatic9.cdn.ubi.com%2Fresource%2Fen-CA%2Fgame%2Fassassins-creed%2Fac%2Facs-gl-weapon1.png&f=1");
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

    @Test
    public void test() {
        basket.addItemToBasket(clothing);
        basket.addItemToBasket(clothing2);
        System.out.println(basket.getItemsInBasket());
    }
}
