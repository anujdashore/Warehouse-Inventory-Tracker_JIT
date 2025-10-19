package src;

public class AlertService implements StockObserver {
    @Override
    public void onLowStock(Product product) {
        System.out.println(" Low stock for " + product.getName()
            + " (ID:" + product.getId() + ") — only " + product.getQuantity() + " left");
    }
}
