public class MVCPattern {
    public static void main(String[] args) {
        Student student = new Student("Tharun", "101", "A");
        StudentView view = new StudentView();
        StudentController controller = new StudentController(student, view);
        controller.updateView();
        controller.setStudentName("Vignesh");
        controller.setStudentGrade("A+");
        controller.updateView();
    }
}
