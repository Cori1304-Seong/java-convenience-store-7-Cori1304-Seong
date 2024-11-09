package store.view;

import consts.StringConstants;
import java.util.List;
import store.model.Product;

public class ProductView {
    private final String PRODUCT_FORMAT = "- %s %,1d원 %d개%s\n";

    public void showProducts(List<Product> products) {
        for (Product product : products) {
            printProductToFormat(product.getName(), product.getPrice(), product.getQuantity(), product.getPromotion());
        }
    }

    private void printProductToFormat(String name, int price, int quantity, String promotion) {
        if (!promotion.isEmpty()) {
            promotion = StringConstants.SPACE + promotion;
        }
        System.out.printf(PRODUCT_FORMAT, name, price, quantity, promotion);
    }
}
