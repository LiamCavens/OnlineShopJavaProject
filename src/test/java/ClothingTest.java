import models.stock.Clothing;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ClothingTest {

    Clothing clothing1;

    @Before
    public void setUp() throws Exception {
        clothing1 = new Clothing("Leather Kilt", "This leather kilt is kind of a traditional style. Made from lamb leather this leather kilt is also pleated with stud buttons and this leather kilt is paneled with pocket back. Available in all colors and style this leather kilt is truly awesome and stylish. Get this unique leather kilt today and make your style.",
                2, 250.00, 350.00);
    }

    @Test
    public void hasName() {
        assertEquals("Leather Kilt", clothing1.getName());
    }

    @Test
    public void hasBoughtInPrice() {
        assertEquals(250, clothing1.getBoughtInPrice(), 0.1);
    }

    @Test
    public void canCalculateMarkupPrice() {
        assertEquals(100.00, clothing1.calculateMarkUp(), 0.1);
    }
}
