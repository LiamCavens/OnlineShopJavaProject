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
        customer = new Customer("Tupal", "Argyle Street", 25, basket);
    }

    @Test
    public void customerHasUsername() {
        assertEquals("Tupal", customer.getUsername());
    }

    @Test
    public void customerHasAddress() {
        assertEquals("Argyle Street", customer.getAddress());
    }

    @Test
    public void customerHasAge() {
        assertEquals(25, customer.getAge());
    }
}
