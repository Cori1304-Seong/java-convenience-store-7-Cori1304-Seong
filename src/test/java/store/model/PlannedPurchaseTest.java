package store.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;

class PlannedPurchaseTest {
    private PlannedPurchase plannedPurchase;

    @BeforeEach
    public void setUp() {
        plannedPurchase = new PlannedPurchase(new Product("컵라면", 1700, 1, "MD추천상품"), true, 1, 0);
    }

}