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

}
