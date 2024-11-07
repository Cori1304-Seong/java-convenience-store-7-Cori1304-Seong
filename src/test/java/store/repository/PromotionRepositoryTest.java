package store.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import store.model.Promotion;

class PromotionRepositoryTest {

    private PromotionRepository repository;
    private final List<String> promotionData = List.of(
            "Name: 탄산2+1, Buy: 2, Get: 1, Start_date: 2024-01-01, End_date: 2024-12-31",
            "Name: MD추천상품, Buy: 1, Get: 1, Start_date: 2024-01-01, End_date: 2024-12-31",
            "Name: 반짝할인, Buy: 1, Get: 1, Start_date: 2024-11-01, End_date: 2024-11-30"
    );


    @BeforeEach
    public void setUp() {
        repository = new PromotionRepository();
    }

    @Test
    public void testLoadDataFromMarkdown() {
        // TODO loadDataFromMarkdown() 파라미터 startWith 옮길지 생각하기
        List<Promotion> promotions = repository.loadDataFromMarkdown();
        int index = 0;

        assertNotNull(promotions);
        assertEquals(3, promotions.size());

        for (Promotion promotion : promotions) {
            String actual = promotion.toString();
            assertEquals(promotionData.get(index), actual,
                    "promotions.md와 다른 결과 출력");
            index++;
        }
    }

}