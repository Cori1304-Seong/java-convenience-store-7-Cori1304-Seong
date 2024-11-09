package store.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.Date;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import store.model.Promotion;
import store.util.CustomFormater;

class PromotionControllerTest {
    private PromotionController controller;

    Date START_DATE = CustomFormater.convertToDate("2024-01-01");
    Date END_DATE =  CustomFormater.convertToDate("2024-12-31");

    @BeforeEach
    void set() {
        this.controller = new PromotionController();
    }

    @Test
    void testFindPromotion() {
        String PromotionName="MD추천상품";
        Promotion expected = new Promotion(PromotionName, 1, 1, START_DATE, END_DATE);
        Promotion actual = controller.findPromotionByName(PromotionName);
        assertEquals(expected.toString(), actual.toString(), "계산 결과가 다릅니다.");
    }
}