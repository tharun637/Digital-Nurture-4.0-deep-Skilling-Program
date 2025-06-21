public class TaskManagementSystem {
    private TaskNode head;

    public void addTask(Task task) {
        TaskNode newNode = new TaskNode(task);
        if (head == null) {
            head = newNode;
        } else {
            TaskNode temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
        System.out.println("Task added: " + task.taskName);
    }

    public Task searchTask(int id) {
        TaskNode temp = head;
        while (temp != null) {
            if (temp.task.taskId == id) {
                return temp.task;
            }
            temp = temp.next;
        }
        return null;
    }

    public boolean deleteTask(int id) {
        if (head == null) return false;

        if (head.task.taskId == id) {
            head = head.next;
            return true;
        }

        TaskNode temp = head;
        while (temp.next != null) {
            if (temp.next.task.taskId == id) {
                temp.next = temp.next.next;
                return true;
            }
            temp = temp.next;
        }
        return false;
    }

    public void displayAll() {
        TaskNode temp = head;
        while (temp != null) {
            temp.task.display();
            temp = temp.next;
        }
    }
}
