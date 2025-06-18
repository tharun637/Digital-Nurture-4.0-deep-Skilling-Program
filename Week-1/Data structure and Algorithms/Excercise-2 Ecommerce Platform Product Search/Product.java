public class Product {
      int productid;
      String productName;
      String Category;
      public Product(int id,String Name,String Category){
          this.productid=id;
          this.productName=Name;
          this.Category=Category;
      }
      public String toString(){
          return "Product ID: " + productid + ", Name: " + productName + ", Category: " + Category;
      }
}
