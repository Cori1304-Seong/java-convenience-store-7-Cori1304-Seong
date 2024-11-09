package store.controller;

import java.util.Date;
import java.util.List;
import store.model.Promotion;
import store.repository.PromotionRepository;

public class PromotionController {
    private final PromotionRepository promotionRepository = new PromotionRepository();
    private final List<Promotion> promotions;

    public PromotionController() {
        this.promotions = promotionRepository.loadDataFromMarkdown();
    }

    public Promotion findPromotionByName(String name) {
        for (Promotion promotion : promotions) {
            if (promotion.getName().equals(name)) {
                return promotion;
            }
        }
        //TODO 반환 값 다른 것으로 변경 고려
        return new Promotion("", 0, 0, new Date(), new Date());
    }

    public int calculatePromotionAmount(int requestAmount, int buyCount, int getCount) {
        int ZERO = 0;
        int remainder = requestAmount % (buyCount + getCount);

        if (remainder == buyCount) {
            return getCount;
        }
        return ZERO;
    }
}
