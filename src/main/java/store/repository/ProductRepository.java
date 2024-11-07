package store.repository;

import consts.FilePath;
import store.model.Product;

public class ProductRepository extends BaseRepository <Product> {
    public ProductRepository() {
        super(FilePath.MD_PRODUCTS); // 각 리포지토리 고유의 파일 경로
    }

    @Override
    protected Product parseData(String[] data) {

        return new Product("name", 1, 0, "test");
    }
}
