package store.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import store.model.Product;
import store.repository.ProductRepository;

public class ProductController {
    ProductRepository repository = new ProductRepository();
    Map<String, Product> productGroup = new HashMap<>();
    Map<String, Product> promotionProductGroup = new HashMap<>();

    public void init() {
        initProductData();
    }

    public Map<String, Product> getProductGroup() {
        return productGroup;
    }

    public Map<String, Product> getPromotionProductGroup() {
        return promotionProductGroup;
    }

    void initProductData() {
        List<Product> products = repository.loadDataFromMarkdown();

        for (Product product : products) {
            groupProduct(product);
        }
    }

    void groupProduct(Product product) {
        String promotion = product.getPromotion();
        if (promotion.isEmpty() || promotion.isBlank() || promotion.equals("null")) {
            addProduct(product);
            return;
        }
        addPromotionProduct(product);
    }

    void addProduct(Product product) {
        productGroup.put(product.getName(), product);
    }

    void addPromotionProduct(Product product) {
        promotionProductGroup.put(product.getName(), product);
    }
}
