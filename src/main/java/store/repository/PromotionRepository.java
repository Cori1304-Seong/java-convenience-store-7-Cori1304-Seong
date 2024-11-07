package store.repository;

import java.util.Date;
import store.model.Promotion;

public class PromotionRepository extends BaseRepository<Promotion> {
    public PromotionRepository() {
        // TODO 상수 적용
        super("src/main/resources/promotions.md"); // 각 리포지토리 고유의 파일 경로
    }

    @Override
    protected Promotion parseData(String[] data) {

        return new Promotion("name", 1, 0, new Date(2024, 11, 1), new Date(2024, 12, 1));
    }

}
