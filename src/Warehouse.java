package src;

import java.util.*;

public class Warehouse {
    private Map<String, Product> inventory = new HashMap<>();
    private List<StockObserver> observers = new ArrayList<>();

    public void addObserver(StockObserver observer) {
        if (observer != null && !observers.contains(observer)) observers.add(observer);
    }

    public void removeObserver(StockObserver observer) {
        observers.remove(observer);
    }

    private void notifyLowStock(Product product) {
        for (StockObserver obs : observers) {
            obs.onLowStock(product);
        }
    }
    public void addProduct(Product product) {
        if (product == null) {
            System.out.println(" Cannot add null product.");
            return;
        }
        inventory.put(product.getId(), product);
        System.out.println("Product added: " + product);
    }

    public void receiveShipment(String productId, int amount) {
        Product p = inventory.get(productId);
        if (p == null) {
            System.out.println(" receiveShipment: Invalid product ID: " + productId);
            return;
        }
        if (amount <= 0) {
            System.out.println(" receiveShipment: Invalid amount: " + amount);
            return;
        }
        p.addStock(amount);
        System.out.println("Received " + amount + " units of " + p.getName()
            + " (new qty: " + p.getQuantity() + ")");
    }

    public void fulfillOrder(String productId, int amount) {
        Product p = inventory.get(productId);
        if (p == null) {
            System.out.println(" fulfillOrder: Invalid product ID: " + productId);
            return;
        }
        if (amount <= 0) {
            System.out.println("fulfillOrder: Invalid order amount: " + amount);
            return;
        }
        boolean ok = p.reduceStock(amount);
        if (!ok) {
            System.out.println("fulfillOrder: Insufficient stock for " + p.getName() 
                + " (available: " + p.getQuantity() + ")");
            return;
        }
        System.out.println(" Fulfilled " + amount + " units of " + p.getName()
            + " (left: " + p.getQuantity() + ")");
        if (p.isLowStock()) notifyLowStock(p);
    }

    public void showInventory() {
        System.out.println("\n Current Inventory:");
        if (inventory.isEmpty()) {
            System.out.println("  (empty)");
            return;
        }
        for (Product p : inventory.values()) {
            System.out.println("  - " + p);
        }
    }
    public boolean hasProduct(String productId) {
        return inventory.containsKey(productId);
    }
                         }
