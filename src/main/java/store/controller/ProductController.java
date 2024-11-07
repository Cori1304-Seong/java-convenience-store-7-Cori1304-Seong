package store.controller;

import java.util.HashMap;
import java.util.Map;
import store.model.Product;
import store.repository.ProductRepository;

public class ProductController {
    ProductRepository repository = new ProductRepository();
    Map<String, Product> productGroup = new HashMap<>();
    Map<String, Product> promotionProductGroup = new HashMap<>();

    public void init() {
    // TODO 데이터 저장 로직 & 재고 관리 로직을 실행하기 위해서 초기에 실행될 기능 추가
    }
}
