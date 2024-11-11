package store.controller;

import java.util.Date;
import java.util.List;
import store.model.Promotion;
import store.model.GiveWayCount;

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

//    public GiveWayCount calculatePromotionAmount(int requestAmount, int buyCount, int getCount) {
//
//        // 행사 적용된 세트 계산
//        int promotionSets = requestAmount / (buyCount + getCount);
//        int remainingItems = requestAmount % (buyCount + getCount);
//
//        // 가격이 측정된 상품 수와 증정품 수 계산
//        int paidItems = promotionSets * buyCount + Math.min(remainingItems, buyCount);
//        int totalGiveWayCount = requestAmount - paidItems;
//
//        int ZERO = 0;
//        int remainder = requestAmount % (buyCount + getCount);
//
//        if (remainder == buyCount) {
//            return new  GiveWayCount (paidItems, totalGiveWayCount, getCount);
//        }
//        return new GiveWayCount(paidItems, totalGiveWayCount, ZERO);
//    }

    public GiveWayCount calculatePromotionAmount(int requestAmount, int buyCount, int getCount) {
        int promotionSets = calculatePromotionSets(requestAmount, buyCount, getCount);
        int remainingItems = calculateRemainingItems(requestAmount, buyCount, getCount);

        int paidItems = calculatePaidItems(promotionSets, buyCount, remainingItems);
        int totalGiveWayCount = calculateTotalGiveWayCount(requestAmount, paidItems);

        int unmetCount = calculateAdditionalGiveaway(remainingItems, buyCount, getCount);
        return new GiveWayCount(paidItems, totalGiveWayCount+unmetCount, unmetCount);
    }

    private int calculatePromotionSets(int requestAmount, int buyCount, int getCount) {
        return requestAmount / (buyCount + getCount);
    }

    private int calculateRemainingItems(int requestAmount, int buyCount, int getCount) {
        return requestAmount % (buyCount + getCount);
    }

    private int calculatePaidItems(int promotionSets, int buyCount, int remainingItems) {
        return promotionSets * buyCount + Math.min(remainingItems, buyCount);
    }

    private int calculateTotalGiveWayCount(int requestAmount, int paidItems) {
        return requestAmount - paidItems;
    }

    private int calculateAdditionalGiveaway(int remainingItems, int buyCount, int getCount) {
        if (remainingItems == buyCount) {
            return getCount;
        }
        return 0;
    }
}
