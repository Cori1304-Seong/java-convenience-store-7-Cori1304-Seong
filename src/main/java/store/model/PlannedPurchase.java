package store.model;

public class PlannedPurchase {

    private Product product;
    private boolean isPromotionProduct;
    private int count;
    private int giveawayCount;

    public PlannedPurchase(Product product, boolean isPromotionProduct, int count, int giveawayCount) {
        this.product = product;
        this.isPromotionProduct = isPromotionProduct;
        this.count = count;
        this.giveawayCount = giveawayCount;
    }
}
