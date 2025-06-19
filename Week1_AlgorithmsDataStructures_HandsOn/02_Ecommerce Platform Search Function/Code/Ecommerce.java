import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Ecommerce {
    public void LinearSearch(Product[] products,String targetName){
        for(Product product:products){
            if(product.productName.equalsIgnoreCase(targetName)){
                System.out.println(product);
                return;
            }
        }
        System.out.println("product not found");
    }
    public void BinarySearch(Product[] products, String targetName) {
        Arrays.sort(products, Comparator.comparing(p -> p.productName.toLowerCase()));
        int left = 0;
        int right = products.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            int data = products[mid].productName.compareToIgnoreCase(targetName);
            if (data == 0) {
                System.out.println(products[mid]);
                return;
            } else if (data < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        System.out.println("Product not found");
    }
    public static void main(String[] args) {
          Product[] products={
                  new Product(11,"laptop","electronics"),
                  new Product(102, "Shoes", "Footwear"),
                  new Product(103, "Watch", "Accessories"),
                  new Product(104, "Camera", "Electronics"),
                  new Product(105, "T-shirt", "Clothing")
          };
          Scanner S=new Scanner(System.in);
        System.out.println("Enter the Product name to Search:");
        String Name=S.nextLine();
        System.out.println("Using Linear Search:");
        Ecommerce e=new Ecommerce();
        e.LinearSearch(products,Name);
        System.out.println("Using Binary Search:");
        e.BinarySearch(products,Name);
    }
}
