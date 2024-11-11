package store.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import store.model.Order;
import store.util.SplitLogic;

public class OrderController {

    public final Map<String, Order> orderGroup;
    public final List<Order> orders;

    public OrderController() {
        this.orderGroup = new HashMap<>();
        this.orders = new ArrayList<>();
    }

    public void buildOrderData(List<String> inputOrders) {
        for (String inputOrder : inputOrders) {
            String[] splitData = SplitLogic.splitPurchaseFormat(inputOrder);
            Order order = new Order(splitData[0], Integer.valueOf(splitData[1]));
            buildOrdersGroup(order);
        }
        buildOrders();
    }

    public boolean minusOrderCount(String name, int count) {
        Order order = orderGroup.get(name);
        int result = order.getCount() - count;
        if (result < 0) {
            return false;
        }
        order.setCount(result);
        return true;
    }


    private void buildOrdersGroup(Order order) {
        if (orderGroup.containsKey(order.name)) {
            Order _order = orderGroup.get(order.name);
            int newCount = order.getCount() + _order.getCount();

            orderGroup.replace(order.name, new Order(order.name, newCount));
            return;
        }
        orderGroup.put(order.name, order);
    }

    private void buildOrders() {
        Set<String> keys = orderGroup.keySet();
        for (String key : keys) {
            orders.add(orderGroup.get(key));
        }
    }
}
