public class Main {
    public static void main(String[] args) {
        TaskManagementSystem tms = new TaskManagementSystem();

        tms.addTask(new Task(1, "Design UI", "Pending"));
        tms.addTask(new Task(2, "Write Backend", "In Progress"));
        tms.addTask(new Task(3, "Testing", "Pending"));

        System.out.println("\nAll Tasks:");
        tms.displayAll();

        System.out.println("\nSearching for Task ID 2:");
        Task found = tms.searchTask(2);
        if (found != null) found.display();
        else System.out.println("Task not found.");

        System.out.println("\nDeleting Task ID 2:");
        boolean deleted = tms.deleteTask(2);
        System.out.println(deleted ? "Deleted Successfully" : "Task not found");

        System.out.println("\nAll Tasks after deletion:");
        tms.displayAll();
    }
}
