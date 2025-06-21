public class EmployeeManagementSystem {
    Employee[] employees;
    int count;

    public EmployeeManagementSystem(int capacity) {
        employees = new Employee[capacity];
        count = 0;
    }
    public void addEmployee(Employee e) {
        if (count < employees.length) {
            employees[count++] = e;
            System.out.println("Employee added successfully.");
        } else {
            System.out.println("Array is full. Cannot add employee.");
        }
    }
    public Employee searchEmployee(int id) {
        for (int i = 0; i < count; i++) {
            if (employees[i].employeeId == id) {
                return employees[i];
            }
        }
        return null;
    }
    public void displayAll() {
        for (int i = 0; i < count; i++) {
            employees[i].display();
        }
    }
    public boolean deleteEmployee(int id) {
        for (int i = 0; i < count; i++) {
            if (employees[i].employeeId == id) {
                for (int j = i; j < count - 1; j++) {
                    employees[j] = employees[j + 1];
                }
                employees[--count] = null; 
                System.out.println("Employee deleted successfully.");
                return true;
            }
        }
        System.out.println("Employee not found.");
        return false;
    }
}
