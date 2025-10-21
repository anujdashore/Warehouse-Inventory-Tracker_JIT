package src;

public class ErrorHandler {
    public static void invalidProduct(String productId) {
        System.out.println("Error: Invalid product ID -> " + productId);
    }

    public static void insufficientStock(String productName, int available) {
        System.out.println("Error: Insufficient stock for " + productName + 
            " (available: " + available + ")");
    }

    public static void invalidAmount(int amount) {
        System.out.println("Error: Invalid amount -> " + amount);
    }
}
