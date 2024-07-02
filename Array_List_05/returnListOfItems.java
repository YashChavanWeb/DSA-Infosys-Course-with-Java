package Array_List_05;

import java.util.ArrayList;
import java.util.List;

/*
 A restaurant keeps a track of all the orders using an ArrayList and a class Order.

The class Order is implemented and provided to you.

You need to retrieve and return the list of items present in all the orders. Implement the logic inside getItems() method.

Test the functionalities using the main() method of the Tester class.
 */

 
class Order {
    private int orderId;
    private List<String> itemNames;
    private boolean cashOnDelivery;

    public Order(int orderId, List<String> itemNames, boolean cashOnDelivery) {
        this.orderId = orderId;
        this.itemNames = itemNames;
        this.cashOnDelivery = cashOnDelivery;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public List<String> getItemNames() {
        return itemNames;
    }

    public void setItemNames(List<String> itemNames) {
        this.itemNames = itemNames;
    }

    public boolean isCashOnDelivery() {
        return cashOnDelivery;
    }

    public void setCashOnDelivery(boolean cashOnDelivery) {
        this.cashOnDelivery = cashOnDelivery;
    }

    @Override
    public String toString() {
        return "Order Id: " + getOrderId() + ", Item names: " + getItemNames() + ", Cash on delivery: "
                + isCashOnDelivery();
    }
}

public class ReturnListOfItems {

    public static List<String> getItems(List<Order> orders) {
        List<String> uniqueItems = new ArrayList<>();

        for (Order order : orders) {
            List<String> items = order.getItemNames();
            for (String item : items) {
                if (!uniqueItems.contains(item)) {
                    uniqueItems.add(item);
                }
            }
        }

        return uniqueItems;
    }

    public static void main(String[] args) {
        List<Order> orders = new ArrayList<>();

        List<String> items1 = new ArrayList<>();
        items1.add("FriedRice");
        items1.add("Pasta");
        items1.add("Tortilla");
        orders.add(new Order(101, items1, true));

        List<String> items2 = new ArrayList<>();
        items2.add("Pizza");
        items2.add("Pasta");
        orders.add(new Order(102, items2, true));

        List<String> items3 = new ArrayList<>();
        items3.add("Burger");
        items3.add("Sandwich");
        items3.add("Pizza");
        orders.add(new Order(103, items3, true));

        List<String> items = getItems(orders);
        System.out.println("List of Items:");
        for (String item : items) {
            System.out.println(item);
        }
    }
}
