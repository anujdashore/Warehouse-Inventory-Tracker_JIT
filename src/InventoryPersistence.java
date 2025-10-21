package src;

import java.io.*;
import java.util.Map;

public class InventoryPersistence {
    public static void save(Warehouse warehouse, String filename) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(filename))) {
            for (Map.Entry<String, Product> e : warehouseInventory(warehouse).entrySet()) {
                Product p = e.getValue();
                pw.println(p.getId() + "|" + p.getName() + "|" + p.getQuantity() + "|" + p.getReorderThreshold());
            }
            System.out.println("Inventory saved to " + filename);
        } catch (IOException ex) {
            System.out.println("Save failed: " + ex.getMessage());
        }
    }
    public static void load(Warehouse warehouse, String filename) {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split("\\|");
                if (parts.length == 4) {
                    Product p = new Product(parts[0], parts[1], Integer.parseInt(parts[2]), Integer.parseInt(parts[3]));
                    warehouse.addProduct(p);
                }
            }
            System.out.println("Inventory loaded from " + filename);
        } catch (FileNotFoundException e) {
            System.out.println("No previous file found: " + filename);
        } catch (IOException e) {
            System.out.println(" Load failed: " + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    private static java.util.Map<String, Product> warehouseInventory(Warehouse warehouse) {
        try {
            java.lang.reflect.Field f = Warehouse.class.getDeclaredField("inventory");
            f.setAccessible(true);
            return (Map<String, Product>) f.get(warehouse);
        } catch (Exception e) {
            return new java.util.HashMap<>();
        }
    }
  }
