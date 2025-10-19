public class Product {
    private String id;
    private String name;
    private int quantity;
    private int reorderThreshold;

    public Product(String id, String name, int quantity, int reorderThreshold) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.reorderThreshold = reorderThreshold;
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public int getQuantity() { return quantity; }
    public int getReorderThreshold() { return reorderThreshold; }

    public void addStock(int amount) {
        if (amount > 0) quantity += amount;
    }

    public void reduceStock(int amount) {
        if (amount > 0 && amount <= quantity) quantity -= amount;
    }

    public boolean isLowStock() {
        return quantity < reorderThreshold;
    }

    @Override
    public String toString() {
        return name + " (ID: " + id + ") → Quantity: " + quantity;
    }
}