package store.controller;

import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import store.model.Product;

class ProductControllerTest {
    private ProductController controller;

    private String PROMOTION_NULL_MESSAGE = "promotion 필드가 null입니다.";
    private String PROMOTION_NOT_NULL_MESSAGE = "promotion 필드에 값이 있습니다..";

    @BeforeEach
    public void setUp() {
        controller = new ProductController();
        controller.init();
    }

    @Test
    public void testGetProductGroup() {
        Map<String, Product> _productGroup = controller.getProductGroup();

        for (Map.Entry<String, Product> entry : _productGroup.entrySet()) {
            Product product = entry.getValue();

            if (isPromotionNull(product) == false) {
                throw new RuntimeException(PROMOTION_NOT_NULL_MESSAGE);
            }
        }
    }

    @Test
    public void testGetPromotionProductGroup() {
        Map<String, Product> _productGroup = controller.getPromotionProductGroup();

        for (Map.Entry<String, Product> entry : _productGroup.entrySet()) {
            Product product = entry.getValue();

            if (isPromotionNull(product)) {
                throw new RuntimeException(PROMOTION_NULL_MESSAGE);
            }
        }
    }

    private Boolean isPromotionNull(Product product) {
        String promotion = product.getPromotion();
        if (promotion.equals("null") || promotion.isBlank() || promotion.isEmpty()) {

            return true;
        }
        return false;
    }
}