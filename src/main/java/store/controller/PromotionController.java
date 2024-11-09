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

}
