import models.Stock.CDKey;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CDKeyTest {

    CDKey game1;
    CDKey game2;

    @Before
    public void setUp() throws Exception {
        game1 = new CDKey("Leisure Suit Larry", "Puzzle adventure game", 10, 5.00, 10.00, "12345");
        game2 = new CDKey("Metal Gear Solid", "Platformer", 10, 5.00, 10.00, "12346");
    }

    @Test
    public void hasKey() {
        assertEquals("12345", game1.getGameKey());
    }
}
