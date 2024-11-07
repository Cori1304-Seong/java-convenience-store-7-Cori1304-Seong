package store.repository;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;

class ProductRepositoryTest {
    private ProductRepository repository;

    @BeforeEach
    public void setUp() {
        repository = new ProductRepository();
    }

}