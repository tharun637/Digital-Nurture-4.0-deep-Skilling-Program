public class Product {
        int productid;
        String productname;
        int quantity;
        double price;
        Product(int productid,String productname,int quantity,double price){
            this.productid=productid;
            this.productname=productname;
            this.quantity=quantity;
            this.price=price;
        }
        void display(){
            System.out.println("*----------------------------------------------------------------------------------------*");
            System.out.println("Product id: "+productid+"Product name: "+productname+"quantity: "+quantity+"price: "+price);
            System.out.println("*----------------------------------------------------------------------------------------*");
        }
    }

