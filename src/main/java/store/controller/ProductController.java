package store.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import store.model.Product;
import store.repository.ProductRepository;

public class ProductController {
    ProductRepository repository = new ProductRepository();
    List<Product> products;
    Map<String, Product> productGroup = new HashMap<>();
    Map<String, Product> promotionProductGroup = new HashMap<>();

    public ProductController() {
        this.products = repository.loadDataFromMarkdown();
    }

    public void init() {
        initProductData();
    }

    public List<Product> getProducts() {
        return new ArrayList<>(products);
    }

    //TODO  new HashMap<> 반환 추가 (깊은 복사)
    public Map<String, Product> getProductGroup() {
        return productGroup;
    }

    //TODO  new HashMap<> 반환 추가 (깊은 복사)
    public Map<String, Product> getPromotionProductGroup() {
        return promotionProductGroup;
    }

    // TODO 수량이 0이되며 제거 로직 추가
    public void minusProduct(String productName, int quantity) {
        checkContainsProductName(productName, productGroup);
        Product product = productGroup.get(productName);

        confirmQuantity(productName, product.getQuantity(), quantity);
        product.setQuantity(product.getQuantity() - quantity);
    }

    // TODO 수량이 0이되며 제거 로직 추가
    public void minusPromotionProduct(String productName, int quantity) {
        checkContainsProductName(productName, promotionProductGroup);
        Product product = promotionProductGroup.get(productName);

        confirmQuantity(productName, product.getQuantity(), quantity);
        product.setQuantity(product.getQuantity() - quantity);
    }

    void initProductData() {
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

    void checkContainsProductName(String productName, Map<String, Product> group) {
        if (!group.containsKey(productName)) {
            throw new IllegalArgumentException(productName + " 제품은 없습니다."); // TODO 물품 예외 요구사항으롭 변경 예정
        }
    }

    void confirmQuantity(String productName, int currentQuantity, int requestQuantity) {
        if (currentQuantity - requestQuantity < 0) {
            throw new IllegalArgumentException( //TODO 물품 수량 예외 요구사항으롭 변경 예정
                    productName + " 제품은 개수: " + currentQuantity + "요청 개수: " + requestQuantity);
        }
    }
}
