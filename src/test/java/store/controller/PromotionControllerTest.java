package store.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import store.model.GiveWayCount;
import store.model.Promotion;
import store.util.CustomFormater;

class PromotionControllerTest {
    private PromotionController controller;

    Date START_DATE = CustomFormater.convertToDate("2024-01-01");
    Date END_DATE =  CustomFormater.convertToDate("2024-12-31");

    List<int[]> calculateAmountData = List.of(
            new int[]{3, 2, 1},
            new int[]{3, 3, 1},
            new int[]{4, 3, 1},
            new int[]{5, 2, 1},
            new int[]{6, 3, 2},
            new int[]{7, 3, 1}
    );

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

    @Test
    void testCalculatePromotionAmount() {
        List<Integer> expected = new ArrayList<>(List.of(0, 1, 0, 1, 0, 1));
        List<Integer> actual = new ArrayList<>();
        for (int[] numbers : calculateAmountData) {
            GiveWayCount count = controller.calculatePromotionAmount(numbers[0], numbers[1], numbers[2]);
            actual.add(count.unmetCount);
        }
        System.out.println("정답: " + expected);
        System.out.println("제출: " + actual);
        assertEquals(expected, actual, "계산 결과가 다릅니다.");
    }
}