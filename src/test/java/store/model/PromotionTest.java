package store.model;

import java.util.Date;
import org.junit.jupiter.api.BeforeEach;

class PromotionTest {

    private Promotion promotion;

    @BeforeEach
    public void setUp() {
        Date _startData = new Date(2024, 11, 1);
        Date _endData = new Date(2024, 12, 1);
        promotion = new Promotion("반짝할인", 3, 1, _startData, _endData);
    }
}