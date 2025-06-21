import java.util.*;

public class DSExercise1{

    public static void main(String[] args) {
        Inventory inv = new Inventory();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n==== Inventory Menu ====");
            System.out.println("1. Add Product");
            System.out.println("2. Update Product");
            System.out.println("3. Delete Product");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter Product ID: ");
                    int id = sc.nextInt();
                    sc.nextLine(); // consume newline
                    System.out.print("Enter Product Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Quantity: ");
                    int quantity = sc.nextInt();
                    System.out.print("Enter Price: ");
                    double price = sc.nextDouble();

                    Product newProduct = new Product(id, name, quantity, price);
                    inv.add(newProduct);
                    System.out.println("Product added.");
                    break;

                case 2:
                    System.out.print("Enter Product ID to update: ");
                    int updateId = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter New Product Name: ");
                    String newName = sc.nextLine();
                    System.out.print("Enter New Quantity: ");
                    int newQty = sc.nextInt();
                    System.out.print("Enter New Price: ");
                    double newPrice = sc.nextDouble();

                    inv.update(updateId, newName, newQty, newPrice);
                    break;

                case 3:
                    System.out.print("Enter Product ID to delete: ");
                    int delId = sc.nextInt();
                    inv.delete(delId);
                    System.out.println("Product deleted if it existed.");
                    break;

                case 4:
                    System.out.println("Exiting program...");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}

class Inventory{
    Map<Integer, Product> inventory=new HashMap<>();

    public void add(Product product){
        inventory.put(product.getProductId(), product);
    }

    public void update(int productId, String productName, int quantity, double price){
        if (inventory.containsKey(productId)) {
            Product p = inventory.get(productId);
            p.setProductName(productName);
            p.setQuantity(quantity);
            p.setPrice(price);
            System.out.println("Product updated.");
        } else {
            System.out.println("Product not found.");
        }
    }


    public void delete(int productId){
        inventory.remove(productId);
    }

    public void displayInventory() {
        if (inventory.isEmpty()) {
            System.out.println("Inventory is empty.");
            return;
        }
        for (Product product : inventory.values()) {
            product.display();
        }
    }

}

class Product{
    private int productId;
    private String productName;
    private int quantity;
    private double price;

    public Product(int productId, String productName, int quantity, double price){
        this.productId=productId;
        this.productName=productName;
        this.quantity=quantity;
        this.price=price;
    }

    public void display(){
        System.out.println("ID: " + productId + ", Name: " + productName +
                ", Quantity: " + quantity + ", Price: $" + price);
    }
    public int getProductId(){
        return this.productId;
    }
    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setPrice(double price) {
        this.price = price;
    }

}