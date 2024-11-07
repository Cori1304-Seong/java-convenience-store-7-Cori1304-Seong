package store.repository;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import store.model.Promotion;

public class PromotionRepository extends BaseRepository<Promotion> {
    public PromotionRepository() {
        // TODO 상수 적용
        super("src/main/resources/promotions.md"); // 각 리포지토리 고유의 파일 경로
    }
    // TODO 하드 코딩 제거, 좀 더 생각하기
    @Override
    protected Promotion parseData(String[] data) {
        String name = data[0].trim();
        int buyCount = Integer.parseInt(data[1].trim());
        int getCount = Integer.parseInt(data[2].trim());
        Date startDate = convertToDate(data[3].trim());
        Date endDate = convertToDate(data[4].trim());

        return new Promotion(name, buyCount, getCount, startDate, endDate);
    }

    // TODO "yyyy-MM-dd" 상수로 바꾸기,  따로 변화시키기
    private Date convertToDate(String source) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date result = new Date();
        try {
            result = formatter.parse(source);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return result;
    }

}
