package store.controller;

import java.util.ArrayList;
import java.util.List;
import store.model.PlannedPurchase;
import store.view.PlannedPurchaseView;

public class PlannedPurchaseController {
    private List<PlannedPurchase> plannedPurchases;
    private PlannedPurchaseView view;

    public PlannedPurchaseController() {
        this.view = new PlannedPurchaseView();
        this.plannedPurchases = new ArrayList<>();
    }

    public void addPlannedPurchase(PlannedPurchase plannedPurchase) {

        plannedPurchases.add(plannedPurchase);
    }

    //TODO s 붙이기
    public List<PlannedPurchase> getPlannedPurchases() {

        return new ArrayList<>(plannedPurchases);
    }

    public boolean requestPromotionPrompt(String productName, int count) {

        return view.requestPromotionPrompt(productName, count);
    }

    public boolean requestPromotionWaring(String productName, int count) {

        return view.requestPromotionWaring(productName, count);
    }

}
