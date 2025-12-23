public class Student {
    private int id;
    private String name;
    private int year;
    private String department;

    public Student(int id, String name, int year, String department) {
        this.id = id;
        this.name = name;
        this.year = year;
        this.department = department;
    }

    // Getters and Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getYear() { return year; }
    public void setYear(int year) { this.year = year; }

    public String getDepartment() { return department; }
    public void setDepartment(String department) { this.department = department; }

    @Override
    public String toString() {
        return id + " | " + name + " | " + year + " | " + department;
    }
}