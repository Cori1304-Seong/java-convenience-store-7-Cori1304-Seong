package store.model;

public class Product {
    private String name;
    private int price;
    private int quantity;
    private String promotion; //TODO Enum 변경 고려하기

    public Product(String name, int price, int quantity, String promotion) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.promotion = promotion;
    }

    public Product(Product product) {
        this.name = product.name;
        this.price = product.price;
        this.quantity = product.quantity;
        this.promotion = product.promotion;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getPromotion() {
        return promotion;
    }

    public void setPromotion(String promotion) {
        this.promotion = promotion;
    }

    public String toString() {
        String result = "Name: " + name + ", Price: " + price + ", Quantity: " + quantity + ", Promotion: " + promotion;

        return result;
    }
}
