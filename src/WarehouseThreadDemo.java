package src;

public class WarehouseThreadDemo {
    public static void main(String[] args) {
        Warehouse warehouse = new Warehouse();
        AlertService alert = new AlertService();
        warehouse.addObserver(alert);

        Product phone = new Product("P002", "Phone", 20, 5);
        warehouse.addProduct(phone);

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                warehouse.fulfillOrder("P002", 2);
                try { Thread.sleep(200); } catch (InterruptedException e) {}
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                warehouse.receiveShipment("P002", 3);
                try { Thread.sleep(450); } catch (InterruptedException e) {}
            }
        });

        t1.start();
        t2.start();
        try { t1.join(); t2.join(); } catch (InterruptedException e) {}
        warehouse.showInventory();
    }
}
