import models.Basket;
import models.Customer;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class CustomerTest {

    Basket basket;
    Customer customer;

    @Before
    public void setUp() {
        Basket basket = new Basket();
        customer = new Customer("BigDaddyKanePain", "69 Wood Street", 25, basket);
    }

    @Test
    public void customerHasUsername() {
        assertEquals("BigDaddyKanePain", customer.getUsername());
    }

    @Test
    public void customerHasAddress() {
        assertEquals("69 Wood Street", customer.getAddress());
    }

    @Test
    public void customerHasAge() {
        assertEquals(25, customer.getAge());
    }
}
