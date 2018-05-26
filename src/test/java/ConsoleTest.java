import models.stock.Console;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ConsoleTest {

    Console console1;

    @Before
    public void setUp() throws Exception {
       console1 = new Console("Xbox One", "The world's most powerful console" , 20, 300.00, 450.00, "https://i1.wp.com/freepngimages.com/wp-content/uploads/2015/10/playstation-4-games-console.png?fit=624%2C365");
    }

    @Test
    public void hasName() {
        assertEquals("Xbox One", console1.getName());
    }
}
