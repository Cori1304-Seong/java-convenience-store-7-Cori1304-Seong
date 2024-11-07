package store.model;

import org.junit.jupiter.api.BeforeEach;

class ProductTest {
    private Product product;

    @BeforeEach
    public void setUp() {
        product = new Product("콜라", 1000, 10, "탄산2+1");
    }
}
