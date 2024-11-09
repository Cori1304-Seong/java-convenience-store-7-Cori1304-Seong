package store.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import store.model.Product;
import store.repository.ProductRepository;
import store.view.ProductView;

public class ProductController {
    ProductRepository repository = new ProductRepository();
    ProductView productView = new ProductView();
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
        Product product = productGroup.get(productName);

        confirmProductQuantity(product, quantity);
        product.setQuantity(product.getQuantity() - quantity);
    }

    // TODO 수량이 0이되며 제거 로직 추가
    public void minusPromotionProduct(String productName, int quantity) {
        Product product = promotionProductGroup.get(productName);

        confirmPromotionProductQuantity(product, quantity);
        product.setQuantity(product.getQuantity() - quantity);
    }

    public int getRemainingProductQuantity(String productName, int requestQuantity) {
        if (isContainsProductByName(productName)) {
            throw new RuntimeException("프로모션 재고중에 " + productName + " 제품은 없습니다. "); //TODO 하드코딩 수정
        }
        Product product = productGroup.get(productName);
        return product.getQuantity() - requestQuantity;
    }

    public int getRemainingPromotionProductQuantity(String productName, int requestQuantity) {
        if (isContainsPromotionProductByName(productName)) {
            throw new RuntimeException("프로모션 재고중에 " + productName + " 제품은 없습니다. "); //TODO 하드코딩 수정
        }
        Product product = promotionProductGroup.get(productName);
        return product.getQuantity() - requestQuantity;
    }


    public void showAvailableProducts() {
        productView.showProducts(products);

    }

    void initProductData() {
        for (Product product : products) {
            groupProduct(product);
        }
    }

    void groupProduct(Product product) {
        String promotion = product.getPromotion();
        if (promotion.isEmpty()) {
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

    boolean isContainsProductByName(String productName) {
        if (!productGroup.containsKey(productName)) {
            System.out.println(productName + " 제품은 없습니다."); // TODO 물품 예외 요구사항으롭 변경 예정
            return false;
        }
        return true;
    }

    boolean isContainsPromotionProductByName(String productName) {
        if (!promotionProductGroup.containsKey(productName)) {
            System.out.println(productName + " 제품은 없습니다."); // TODO 물품 예외 요구사항으롭 변경 예정
            return false;
        }
        return true;
    }


    void confirmProductQuantity(Product product, int quantity) {
        if (getRemainingProductQuantity(product.getName(), quantity) < 0) {
            throw new IllegalArgumentException( //TODO 물품 수량 예외 요구사항으롭 변경 예정
                    product.getName() + " 제품은 개수: " + product.getQuantity() + "요청 개수: " + quantity);
        }
    }

    void confirmPromotionProductQuantity(Product product, int quantity) {
        if (getRemainingPromotionProductQuantity(product.getName(), quantity) < 0) {
            throw new IllegalArgumentException( //TODO 물품 수량 예외 요구사항으롭 변경 예정
                    product.getName() + " 제품은 개수: " + product.getQuantity() + "요청 개수: " + quantity);
        }
    }
}
