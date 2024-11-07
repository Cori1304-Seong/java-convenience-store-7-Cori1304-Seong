package store.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ProductTest {
    private Product product;

    @BeforeEach
    public void setUp() {
        product = new Product("콜라", 1000, 10, "탄산2+1");
    }

    @Test
    public void testGetName() {
        assertEquals("콜라", product.getName());
    }

    @Test
    public void testSetName() {
        product.setName("사이다");
        assertEquals("사이다", product.getName());
    }

    @Test
    public void testGetPrice() {
        assertEquals(1000, product.getPrice());
    }

    @Test
    public void testSetPrice() {
        product.setPrice(1200);
        assertEquals(1200, product.getPrice());
    }

    @Test
    public void testGetQuantity() {
        assertEquals(10, product.getQuantity());
    }

    @Test
    public void testSetQuantity() {
        product.setQuantity(15);
        assertEquals(15, product.getQuantity());
    }

    @Test
    public void testGetPromotion() {
        assertEquals("탄산2+1", product.getPromotion());
    }

    @Test
    public void testSetPromotion() {
        product.setPromotion("null");
        assertEquals("null", product.getPromotion());
    }

    @Test
    public void testToString() {
        String expected = "Name: 콜라, Price: 1000, Quantity: 10, Promotion: 탄산2+1";
        assertEquals(expected, product.toString());
    }
}
