package SOLID.OpenClosed.src;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

class Item {
    String name;
    double weight;
    double price;

    Item(String name, double weight, double price) {
        this.name = name;
        this.weight = weight;
        this.price = price;
    }

    String getName() {
        return this.name;
    }

    double getWeight() {
        return this.weight;
    }

    double getPrice() {
        return this.price;
    }
}

// The Order class before applying the Open/Closed Principle
/*
class Order {
    List<Item> lineItems;
    String shipping;

    double getTotal() {
        // Calculate total...
    }

    double getTotalWeight() {
        // Calculate total weight...
    }

    String getShippingType() {
        return this.shipping;
    }

    Date getShippingDate() {
        // Calculate shipping date...
    }

    double getShippingCost() {
        if (shipping.equals("ground")) {
            if (getTotal() > 100) return 0;
            else return Math.max(10, getTotalWeight() * 1.5);
        }
        if (shipping.equals("air")) {
            return Math.max(10, getTotalWeight() * 3);
        }
        return 0;
    }
}
*/

// The Order class after applying the Open/Closed Principle
interface Shipping {
    double getCost(Order order);
    Date getDate(Order order);
}

class Ground implements Shipping {
    public double getCost(Order order) {
        if (order.getTotal() > 100) return 0;
        else return Math.max(10, order.getTotalWeight() * 1.5);
    }

    public Date getDate(Order order) {
        // Calculate shipping date for ground shipping...
        return order.getShippingDate();
    }
}

class Air implements Shipping {
    public double getCost(Order order) {
        return Math.max(10, order.getTotalWeight() * 3);
    }

    public Date getDate(Order order) {
        // Calculate shipping date for air shipping...
        return order.getShippingDate();
    }
}

class Order {
    List<Item> lineItems;
    Shipping shipping;

    Order(List<Item> lineItems, Shipping shipping) {
        this.lineItems = lineItems;
        this.shipping = shipping;
    }

    double getTotal() {
        // Calculate total...
        return lineItems.stream().mapToDouble(Item::getPrice).sum();
    }

    double getTotalWeight() {
        // Calculate total weight...
        return lineItems.stream().mapToDouble(Item::getWeight).sum();
    }

    double getShippingCost() {
        return shipping.getCost(this);
    }

    Date getShippingDate() {
        return shipping.getDate(this);
    }
}

public class Main {
    public static void main(String[] args) {
        // Create some items
        Item item1 = new Item("Item1", 2.5, 10);
        Item item2 = new Item("Item2", 1.5, 15);

        // Add items to a list
        List<Item> items = new ArrayList<>();
        items.add(item1);
        items.add(item2);

        // Create an order with the items and ground shipping
        Order order = new Order(items, new Ground());

        // Print the total cost and weight of the order
        System.out.println("Total cost: " + order.getTotal());
        System.out.println("Total weight: " + order.getTotalWeight());

        // Print the shipping cost
        System.out.println("Shipping cost: " + order.getShippingCost());

    }
}