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

    public Product getProduct() {

        return new Product(product);
    }

    public boolean getIsPromotionProduct() {

        return isPromotionProduct;
    }

    public int getCount() {

        return count;
    }

    public int getGiveawayCount() {

        return giveawayCount;
    }
}
