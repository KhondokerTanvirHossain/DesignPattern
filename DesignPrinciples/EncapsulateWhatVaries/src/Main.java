package DesignPrinciples.EncapsulateWhatVaries.src;

import java.util.Arrays;
import java.util.List;

class LineItem {
    double price;
    int quantity;
    Product product;

    // Constructor, getters, and setters omitted for brevity
}

class Product {
    // Product properties omitted for brevity
}

class TaxCalculator {
    double getTaxRate(String country, String state, Product product) {
        if ("US".equals(country)) {
            return getUSTax(state);
        } else if ("EU".equals(country)) {
            return getEUTax(state);
        } else if ("China".equals(country)) {
            return getChineseTax(product);
        } else {
            return 0;
        }
    }

    double getUSTax(String state) {
        // Implementation
        return getStateTaxRate(state); // Example value
    }

    double getEUTax(String country) {
        // Implementation
        return getTaxRate(country);
    }

    double getChineseTax(Product product) {
        // Implementation
        return 0.3; // Example value
    }

    double getTaxRate(String country) {
        if (country == "Finland") {
            return 0.07; 
        } else if (country == "Italy") {
            return 0.20; 
        } else {
            return 0;
        }
    }

    double getStateTaxRate(String state) {
        if (state == "NYC") {
            return 0.07; 
        } else if (state == "CA") {
            return 0.20; 
        } else {
            return 0;
        }
    }
}

class Order {
    TaxCalculator taxCalculator;
    List<LineItem> lineItems;
    String country;
    String state;
    String city;

    double getOrderTotal() {
        double total = 0;
        for (LineItem item : lineItems) {
            double subtotal = item.price * item.quantity;
            total += subtotal * taxCalculator.getTaxRate(country, state, item.product);
        }
        return total;
    }

    // Constructor, getters, and setters omitted for brevity
}

public class Main {
    public static void main(String[] args) {
        TaxCalculator taxCalculator = new TaxCalculator();
        Product product = new Product();
        LineItem lineItem = new LineItem();
        lineItem.price = 100;
        lineItem.quantity = 2;
        lineItem.product = product;

        Order order = new Order();
        order.taxCalculator = taxCalculator;
        order.lineItems = Arrays.asList(lineItem);
        order.country = "US";
        order.state = "CA";

        double total = order.getOrderTotal();
        System.out.println("Order total: " + total);
    }
}