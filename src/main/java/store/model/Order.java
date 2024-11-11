package store.model;

public class Order {

    public final String name;
    private int count;

    public Order(String name, int count) {
        this.name = name;
        this.count = count;

    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

//    public boolean minusCount(int count) {
//        int result = this.count - count;
//        if (result < 0) {
//            return false;
//        }
//        this.count = result;
//        return true;
//    }

}
