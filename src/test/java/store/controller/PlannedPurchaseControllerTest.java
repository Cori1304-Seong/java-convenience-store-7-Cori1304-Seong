package store.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import store.model.PlannedPurchase;
import store.model.Product;

class PlannedPurchaseControllerTest {

    private PlannedPurchaseController controller;

    @BeforeEach
    public void set() {
        controller = new PlannedPurchaseController();
    }

    @Test
    void testAddPlannedPurchase() {
        PlannedPurchase plannedPurchase = new PlannedPurchase(new Product("컵라면", 1700, 1, "MD추천상품"), true, 1, 0);

        controller.addPlannedPurchase(plannedPurchase);

        List<PlannedPurchase> plannedPurchases = controller.getPlannedPurchase();
        assertEquals(1, plannedPurchases.size());
        assertEquals("컵라면", plannedPurchases.get(0).getProduct().getName());
    }

    @Test
    void testGetPlannedPurchaseReturnsCopy() {
        PlannedPurchase plannedPurchase = new PlannedPurchase(new Product("컵라면", 1700, 1, "MD추천상품"), true, 1, 0);
        controller.addPlannedPurchase(plannedPurchase);

        List<PlannedPurchase> retrievedList = controller.getPlannedPurchase();
        retrievedList.add(new PlannedPurchase(new Product("새 제품", 2000, 1, "추천상품"), false, 2, 1));

        assertEquals(1, controller.getPlannedPurchase().size());
    }

}