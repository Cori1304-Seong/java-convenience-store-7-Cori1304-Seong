package store.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PlannedPurchaseTest {
    private PlannedPurchase plannedPurchase;

    @BeforeEach
    public void setUp() {
        plannedPurchase = new PlannedPurchase(new Product("컵라면", 1700, 1, "MD추천상품"), true, 1, 0);
    }

    @Test
    void testGetProduct() {
        Product product = plannedPurchase.getProduct();


        assertEquals("컵라면", product.getName());
        assertEquals(1700, product.getPrice());
        assertEquals(1, product.getQuantity());
        assertEquals("MD추천상품", product.getPromotion());
    }

    @Test
    void testIsPromotionProduct() {
        assertTrue(plannedPurchase.getIsPromotionProduct());
    }

    @Test
    void testGetCount() {

        assertEquals(1, plannedPurchase.getCount());
    }

    @Test
    void testGetGiveawayCount() {
        assertEquals(0, plannedPurchase.getGiveawayCount());
    }

    @Test
    void testProductImmutability() {

        Product retrievedProduct = plannedPurchase.getProduct();

        retrievedProduct.setName("Changed Name");

        assertEquals("컵라면", plannedPurchase.getProduct().getName());
    }

}