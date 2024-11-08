package store.repository;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import store.model.Product;

class ProductRepositoryTest {
    private final List<String> productData = List.of(
            "Name: 콜라, Price: 1000, Quantity: 10, Promotion: 탄산2+1",
            "Name: 콜라, Price: 1000, Quantity: 10, Promotion:",
            "Name: 사이다, Price: 1000, Quantity: 8, Promotion: 탄산2+1",
            "Name: 사이다, Price: 1000, Quantity: 7, Promotion:",
            "Name: 오렌지주스, Price: 1800, Quantity: 9, Promotion: MD추천상품",
            "Name: 탄산수, Price: 1200, Quantity: 5, Promotion: 탄산2+1",
            "Name: 물, Price: 500, Quantity: 10, Promotion:",
            "Name: 비타민워터, Price: 1500, Quantity: 6, Promotion: null",
            "Name: 감자칩, Price: 1500, Quantity: 5, Promotion: 반짝할인",
            "Name: 감자칩, Price: 1500, Quantity: 5, Promotion:",
            "Name: 초코바, Price: 1200, Quantity: 5, Promotion: MD추천상품",
            "Name: 초코바, Price: 1200, Quantity: 5, Promotion:",
            "Name: 에너지바, Price: 2000, Quantity: 5, Promotion:",
            "Name: 정식도시락, Price: 6400, Quantity: 8, Promotion:",
            "Name: 컵라면, Price: 1700, Quantity: 1, Promotion: MD추천상품",
            "Name: 컵라면, Price: 1700, Quantity: 10, Promotion:");


    private ProductRepository repository;

    @BeforeEach
    public void setUp() {
        repository = new ProductRepository();
    }

    @Test
    public void testLoadDataFromMarkdown() {
        // TODO loadDataFromMarkdown() 파라미터 startWith 옮길지 생각하기
        List<Product> products = repository.loadDataFromMarkdown();
        int index = 0;

        // 결과가 null이 아니고, 예상한 개수인지 확인
        assertNotNull(products);
        assertEquals(16, products.size());

        for (Product product : products) {
            String actual = product.toString();
            assertEquals(productData.get(index), actual,
                    "product.md와 내용이 다릅니다.");
            index++;
        }
    }
}