package store.controller;

import java.util.ArrayList;
import java.util.List;
import store.model.PlannedPurchase;

public class PlannedPurchaseController {
    private List<PlannedPurchase> plannedPurchases = new ArrayList<>();


    public void addPlannedPurchase(PlannedPurchase plannedPurchase) {

        plannedPurchases.add(plannedPurchase);
    }

    public List<PlannedPurchase> getPlannedPurchase() {

        return new ArrayList<>(plannedPurchases);
    }

}
