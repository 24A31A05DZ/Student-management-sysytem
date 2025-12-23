import java.util.Scanner;
import java.util.InputMismatchException;
import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new StudentGUI().setVisible(true);
        });
    }

    private static void runConsole(Scanner sc) {
        StudentService service = new StudentService();

        while (true) {
            System.out.println("\n1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");
            System.out.print("Choose option: ");

            int choice = -1;
            try {
                choice = sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                sc.nextLine(); // clear the invalid input
                continue;
            }
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("ID: ");
                    int id = -1;
                    try {
                        id = sc.nextInt();
                    } catch (InputMismatchException e) {
                        System.out.println("Invalid ID. Please enter a number.");
                        sc.nextLine();
                        break;
                    }
                    sc.nextLine();
                    System.out.print("Name: ");
                    String name = sc.nextLine();
                    System.out.print("Year: ");
                    int year = -1;
                    try {
                        year = sc.nextInt();
                    } catch (InputMismatchException e) {
                        System.out.println("Invalid year. Please enter a number.");
                        sc.nextLine();
                        break;
                    }
                    sc.nextLine();
                    System.out.print("Department: ");
                    String dept = sc.nextLine();

                    service.addStudent(new Student(id, name, year, dept));
                    break;

                case 2:
                    service.viewStudents();
                    break;

                case 3:
                    System.out.print("Enter ID to update: ");
                    int uid = -1;
                    try {
                        uid = sc.nextInt();
                    } catch (InputMismatchException e) {
                        System.out.println("Invalid ID. Please enter a number.");
                        sc.nextLine();
                        break;
                    }
                    sc.nextLine();
                    System.out.print("New Name: ");
                    String uname = sc.nextLine();
                    System.out.print("New Year: ");
                    int uyear = -1;
                    try {
                        uyear = sc.nextInt();
                    } catch (InputMismatchException e) {
                        System.out.println("Invalid year. Please enter a number.");
                        sc.nextLine();
                        break;
                    }
                    sc.nextLine();
                    System.out.print("New Department: ");
                    String udept = sc.nextLine();

                    service.updateStudent(uid, uname, uyear, udept);
                    break;

                case 4:
                    System.out.print("Enter ID to delete: ");
                    int did = -1;
                    try {
                        did = sc.nextInt();
                    } catch (InputMismatchException e) {
                        System.out.println("Invalid ID. Please enter a number.");
                        sc.nextLine();
                        break;
                    }
                    service.deleteStudent(did);
                    break;

                case 5:
                    System.out.println("Exiting...");
                    return;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}