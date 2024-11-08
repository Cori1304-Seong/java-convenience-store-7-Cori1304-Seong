package store.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import store.model.Product;

class ProductControllerTest {
    private ProductController controller;

    private String PROMOTION_NULL_MESSAGE = "promotion 필드가 null입니다.";
    private String PROMOTION_NOT_NULL_MESSAGE = "promotion 필드에 값이 있습니다..";

    List<String> productRequests = new ArrayList<>(List.of("콜라-5", "사이다-7", "물-5"));

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

    @Test
    public void minusProduct() {
        List<Integer> expected = getMinusProductExpected(controller.getProductGroup());

        for (String request : productRequests) {
            String[] _split = request.split("-");
            controller.minusProduct(_split[0], Integer.valueOf(_split[1]));
        }

        List<Integer> actual = getMinusProductActual(controller.getProductGroup());
        assertEquals(expected, actual);
    }

    @Test
    public void minusPromotionProduct() {
        List<Integer> expected = getMinusProductExpected(controller.getPromotionProductGroup());

        for (String request : productRequests) {
            String[] _split = request.split("-");
            controller.minusPromotionProduct(_split[0], Integer.valueOf(_split[1]));
        }

        List<Integer> actual = getMinusProductActual(controller.getPromotionProductGroup());
        assertEquals(expected, actual);
    }

    private Boolean isPromotionNull(Product product) {
        String promotion = product.getPromotion();
        if (promotion.equals("null") || promotion.isBlank() || promotion.isEmpty()) {

            return true;
        }
        return false;
    }

    List<Integer> getMinusProductExpected(Map<String, Product> productGroup) {
        List<Integer> expected = new ArrayList<>();

        try {
            for (String request : productRequests) {
                String[] _split = request.split("-");
                Product _product = productGroup.get(_split[0]);
                expected.add(_product.getQuantity() - Integer.valueOf(_split[1]));

            }
        } catch (Exception e) {
            System.out.println("[Error] getMinusProductExpected() : " + e);

        }
        return expected;
    }

    List<Integer> getMinusProductActual(Map<String, Product> productGroup) {
        List<Integer> actual = new ArrayList<>();

        try {
            for (String request : productRequests) {
                String[] _split = request.split("-");
                Product _product = productGroup.get(_split[0]);
                actual.add(_product.getQuantity());

            }
        } catch (Exception e) {
            System.out.println("[테스트 에러!!] getMinusProductActual(): " + e);
        }
        return actual;
    }
}