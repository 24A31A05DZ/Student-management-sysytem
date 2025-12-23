import java.util.ArrayList;

public class StudentService {
    private ArrayList<Student> students = new ArrayList<>();

    public void addStudent(Student student) {
        if (student.getId() <= 0) {
            System.out.println("ID must be a positive number.");
            return;
        }
        if (student.getYear() <= 0 || student.getYear() > 4) {
            System.out.println("Year must be between 1 and 4.");
            return;
        }
        if (findStudentById(student.getId()) != null) {
            System.out.println("Student with this ID already exists.");
            return;
        }
        students.add(student);
        System.out.println("Student added successfully.");
    }

    public void viewStudents() {
        System.out.println("Total students: " + students.size());
        if (students.isEmpty()) {
            System.out.println("No students found.");
            return;
        }
        for (Student s : students) {
            System.out.println(s);
        }
    }

    public String getStudentsAsString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Total students: ").append(students.size()).append("\n");
        if (students.isEmpty()) {
            sb.append("No students found.");
        } else {
            for (Student s : students) {
                sb.append(s).append("\n");
            }
        }
        return sb.toString();
    }

    public Student findStudentById(int id) {
        for (Student s : students) {
            if (s.getId() == id) {
                return s;
            }
        }
        return null;
    }

    public void updateStudent(int id, String name, int year, String department) {
        if (year <= 0 || year > 4) {
            System.out.println("Year must be between 1 and 4.");
            return;
        }
        Student s = findStudentById(id);
        if (s != null) {
            s.setName(name);
            s.setYear(year);
            s.setDepartment(department);
            System.out.println("Student updated successfully.");
        } else {
            System.out.println("Student not found.");
        }
    }

    public void deleteStudent(int id) {
        Student s = findStudentById(id);
        if (s != null) {
            students.remove(s);
            System.out.println("Student deleted successfully.");
        } else {
            System.out.println("Student not found.");
        }
    }
}