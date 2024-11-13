package store.repository;

import consts.StringConstants;
import consts.FilePath;
import store.model.Product;

public class ProductRepository extends BaseRepository<Product> {
    public ProductRepository() {
        super(FilePath.MD_PRODUCTS); // 각 리포지토리 고유의 파일 경로
    }

    // TODO 하드 코딩 제거, Product colum 추가시에도 적용할 수 있게 만들어야 함,
    @Override
    protected Product parseData(String[] data) {
        String name = data[0].trim();
        int price = Integer.parseInt(data[1].trim());
        int quantity = Integer.parseInt(data[2].trim());
        String promotion = data[3].trim();
        if (data.length < 4 || promotion.isEmpty() || promotion.isBlank() || promotion.equals(StringConstants.NULL)) {
            return new Product(name, price, quantity, "");
        }
        return new Product(name, price, quantity, promotion);
    }
}
