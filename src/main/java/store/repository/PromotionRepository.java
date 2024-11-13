package store.repository;

import consts.FilePath;
import java.util.Date;
import store.model.Promotion;
import store.util.CustomFormater;

public class PromotionRepository extends BaseRepository<Promotion> {
    public PromotionRepository() {
        // TODO 상수 적용
        super(FilePath.MD_PROMOTIONS); // 각 리포지토리 고유의 파일 경로
    }
    // TODO 하드 코딩 제거, 좀 더 생각하기
    @Override
    protected Promotion parseData(String[] data) {
        String name = data[0].trim();
        int buyCount = Integer.parseInt(data[1].trim());
        int getCount = Integer.parseInt(data[2].trim());
        Date startDate = CustomFormater.convertToDate(data[3].trim());
        Date endDate = CustomFormater.convertToDate(data[4].trim());

        return new Promotion(name, buyCount, getCount, startDate, endDate);
    }

}
