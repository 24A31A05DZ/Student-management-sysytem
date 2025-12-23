import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StudentGUI extends JFrame {
    private StudentService service;
    private JTextField idField, nameField, ageField, deptField;
    private JTextArea outputArea;
    private JButton addButton, viewButton, updateButton, deleteButton;

    public StudentGUI() {
        service = new StudentService();
        initializeUI();
    }

    private void initializeUI() {
        setTitle("Student Management System");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Input panel
        JPanel inputPanel = new JPanel(new GridLayout(4, 2));
        inputPanel.add(new JLabel("ID:"));
        idField = new JTextField();
        inputPanel.add(idField);

        inputPanel.add(new JLabel("Name:"));
        nameField = new JTextField();
        inputPanel.add(nameField);

        inputPanel.add(new JLabel("Year:"));
        ageField = new JTextField();
        inputPanel.add(ageField);

        inputPanel.add(new JLabel("Department:"));
        deptField = new JTextField();
        inputPanel.add(deptField);

        add(inputPanel, BorderLayout.NORTH);

        // Button panel
        JPanel buttonPanel = new JPanel(new FlowLayout());
        addButton = new JButton("Add Student");
        viewButton = new JButton("View Students");
        updateButton = new JButton("Update Student");
        deleteButton = new JButton("Delete Student");

        buttonPanel.add(addButton);
        buttonPanel.add(viewButton);
        buttonPanel.add(updateButton);
        buttonPanel.add(deleteButton);

        add(buttonPanel, BorderLayout.CENTER);

        // Output area
        outputArea = new JTextArea();
        outputArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(outputArea);
        add(scrollPane, BorderLayout.SOUTH);

        // Action listeners
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addStudent();
            }
        });

        viewButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                viewStudents();
            }
        });

        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateStudent();
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteStudent();
            }
        });
    }

    private void addStudent() {
        try {
            int id = Integer.parseInt(idField.getText());
            String name = nameField.getText();
            int year = Integer.parseInt(ageField.getText());
            String dept = deptField.getText();

            Student student = new Student(id, name, year, dept);
            service.addStudent(student);
            outputArea.append("Student added successfully.\n");
            clearFields();
        } catch (NumberFormatException e) {
            outputArea.append("Invalid input. Please enter valid numbers for ID and Year.\n");
        }
    }

    private void viewStudents() {
        outputArea.setText(service.getStudentsAsString());
    }

    private void updateStudent() {
        try {
            int id = Integer.parseInt(idField.getText());
            String name = nameField.getText();
            int year = Integer.parseInt(ageField.getText());
            String dept = deptField.getText();

            service.updateStudent(id, name, year, dept);
            outputArea.append("Student updated successfully.\n");
            clearFields();
        } catch (NumberFormatException e) {
            outputArea.append("Invalid input. Please enter valid numbers for ID and Year.\n");
        }
    }

    private void deleteStudent() {
        try {
            int id = Integer.parseInt(idField.getText());
            service.deleteStudent(id);
            outputArea.append("Student deleted successfully.\n");
            clearFields();
        } catch (NumberFormatException e) {
            outputArea.append("Invalid input. Please enter a valid number for ID.\n");
        }
    }

    private void clearFields() {
        idField.setText("");
        nameField.setText("");
        ageField.setText("");
        deptField.setText("");
    }
}