class Order {
    int orderId;
    String customerName;
    double totalPrice;

    public Order(int orderId, String customerName, double totalPrice) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.totalPrice = totalPrice;
    }

    public void print() {
        System.out.println("OrderID: " + orderId + ", Customer: " + customerName + ", Rs." + totalPrice);
    }
}
