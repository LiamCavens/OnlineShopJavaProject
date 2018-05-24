import models.Stock.Clothing;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ClothingTest {

    Clothing clothing1;

    @Before
    public void setUp() throws Exception {
        clothing1 = new Clothing();
    }

    @Test
    public void hasName() {
        assertEquals("Leather Kilt", clothing1.getName());
    }
}
