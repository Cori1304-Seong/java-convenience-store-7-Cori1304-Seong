package store.controller;

import java.util.ArrayList;
import java.util.List;
import store.model.Product;
import store.view.InputView;

public class MainController {
    ProductController productController;
    PromotionController promotionController;
    List<Product> shoppingCart = new ArrayList<>();
    InputView inputView;

    public MainController() {
        this.inputView = new InputView();
        this.productController = new ProductController();
        this.promotionController = new PromotionController();
    }
}
