public class Main {
    public static void main(String[] args) {
        EmployeeManagementSystem system = new EmployeeManagementSystem(5);

        system.addEmployee(new Employee(101, "Tharun", "Manager", 75000));
        system.addEmployee(new Employee(102, "Vignesh", "Developer", 60000));
        system.addEmployee(new Employee(103, "Thivakar", "Designer", 50000));

        System.out.println("\nAll Employees:");
        system.displayAll();

        System.out.println("\nSearching for Employee with ID 102:");
        Employee found = system.searchEmployee(102);
        if (found != null) found.display();
        else System.out.println("Employee not found.");

        System.out.println("\nDeleting Employee with ID 102:");
        system.deleteEmployee(102);

        System.out.println("\nAll Employees after deletion:");
        system.displayAll();
    }
}
