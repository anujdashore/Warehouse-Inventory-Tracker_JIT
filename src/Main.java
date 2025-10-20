package src;

public class Main {
    public static void main(String[] args) {
        Warehouse warehouse = new Warehouse();
        AlertService alerts = new AlertService();
        warehouse.addObserver(alerts);

        Product laptop = new Product("P001", "Laptop", 0, 5);
        warehouse.addProduct(laptop);

        
        warehouse.receiveShipment("P001", 10);   
        warehouse.showInventory();

        warehouse.fulfillOrder("P001", 6);       
        warehouse.showInventory();

        
        warehouse.fulfillOrder("P001", 100);    
        warehouse.receiveShipment("P002", 5);    
    }
}
