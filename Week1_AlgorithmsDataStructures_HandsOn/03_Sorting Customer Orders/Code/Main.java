public class Main {
    public static void main(String[] args) {
        Order[] orders = {
            new Order(101, "Alice", 4500),
            new Order(102, "Bob", 2500),
            new Order(103, "Charlie", 8000),
            new Order(104, "Diana", 3000)
        };

        System.out.println("Original Orders:");
        for (Order o : orders) o.print();

        System.out.println("\nSorted Orders by Bubble Sort:");
        OrderSorting.bubbleSort(orders);
        for (Order o : orders) o.print();

         System.out.println("\nSorted Orders by Quick Sort:");
        OrderSorting.quickSort(orders, 0, orders.length - 1);
        for (Order o : orders) o.print();
    }
}

