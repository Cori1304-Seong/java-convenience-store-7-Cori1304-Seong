package store.controller;

import org.junit.jupiter.api.BeforeEach;

class ProductControllerTest {
    private ProductController controller;

    @BeforeEach
    public void setUp() {
        controller = new ProductController();
        controller.init();
    }

}