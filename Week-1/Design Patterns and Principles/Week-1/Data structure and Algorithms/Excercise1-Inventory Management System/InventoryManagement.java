import java.util.*;
public class InventoryManagement{
   private ArrayList<Product> inventory=new ArrayList<>();

    public void addproduct(Product p){
      inventory.add(p);
        System.out.println("Product added successfully");
    }
    public void updateproduct(int productid,int quantity,double price){
        for(Product p:inventory){
           if(p.productid==productid) {
               p.quantity = quantity;
               p.price = price;
               System.out.println("Product updated");
               return;
           }
        }
        System.out.println("Product not found");
    }
    public void delete(int productid){
        Iterator<Product> iterator=inventory.iterator();
        while(iterator.hasNext()){
            Product p=iterator.next();
            if(p.productid==productid){
                iterator.remove();
                System.out.println("Product deleted");
                return;
            }
        }
        System.out.println("product not found");
    }
    public void inventorydisplay(){
        if(inventory.isEmpty()){
            System.out.println("Product is Empty");
        }
        for(Product p:inventory){
            p.display();
        }
    }
    public static void main(String[] args) {
        InventoryManagement manager = new InventoryManagement();
        Scanner S = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n=== Inventory Menu ===");
            System.out.println("1. Add Product");
            System.out.println("2. Update Product");
            System.out.println("3. Delete Product");
            System.out.println("4. Display Inventory");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = S.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter Product ID: ");
                    int id = S.nextInt();
                    S.nextLine(); // consume newline
                    System.out.print("Enter Product Name: ");
                    String name = S.nextLine();
                    System.out.print("Enter Quantity: ");
                    int qty = S.nextInt();
                    System.out.print("Enter Price: ");
                    double price = S.nextDouble();
                    manager.addproduct(new Product(id, name, qty, price));
                    break;

                case 2:
                    System.out.print("Enter Product ID to update: ");
                    int upId = S.nextInt();
                    System.out.print("Enter new Quantity: ");
                    int upQty = S.nextInt();
                    System.out.print("Enter new Price: ");
                    double upPrice = S.nextDouble();
                    manager.updateproduct(upId, upQty, upPrice);
                    break;

                case 3:
                    System.out.print("Enter Product ID to delete: ");
                    int delId = S.nextInt();
                    manager.delete(delId);
                    break;

                case 4:
                    manager.inventorydisplay();
                    break;

                case 5:
                    System.out.println("Exiting... Thank you!");
                    break;

                default:
                    System.out.println("Invalid choice. Try again.");
            }

        } while (choice != 5);
    }
}