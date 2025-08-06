import java.util.ArrayList;
import java.util.Scanner;

class Student {
    private String name;
    private double marks;
    private int id;

    public Student(String name, double marks, int id) {
        this.name = name;
        this.marks = marks;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getMarks() {
        return marks;
    }

    public void setMarks(double marks) {
        this.marks = marks;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Student [name=" + name + ", marks=" + marks + ", id=" + id + "]";
    }
}

class Main {
    static ArrayList<Student> ar = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
        System.out.println("Welcome to Student Records Management System");
        do {
            System.out.println("\n1. Add Student\n2. View Student Details\n3. Update Existing Student Details\n4. Delete Student Record\n5. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    viewStudents();
                    break;
                case 3:
                    updateDetails();
                    break;
                case 4:
                    deleteStudent();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Enter a valid input:");
                    break;
            }
        } while (choice != 5);
    }

    public static void addStudent() {
        System.out.print("Enter Student Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Student Id: ");
        int id = sc.nextInt();
        System.out.print("Enter Student Marks: ");
        double marks = sc.nextDouble();
        sc.nextLine(); // Consume the newline character

        Student st = new Student(name, marks, id);
        ar.add(st);
        System.out.println("Student details added successfully");
    }

    public static void viewStudents() {
        if (ar.isEmpty()) {
            System.out.println("No student details are available.");
        } else {
            System.out.println("Here are the details:");
            for (Student s : ar) {
                System.out.println(s); // This calls the toString() method
            }
        }
    }

    public static void updateDetails() {
        System.out.print("Enter the ID you want to update: ");
        int uid = sc.nextInt();
        sc.nextLine(); // Consume the newline character
        boolean found = false;

        for (Student s : ar) {
            if (s.getId() == uid) {
                System.out.print("Enter new Name: ");
                String name = sc.nextLine();
                System.out.print("Enter new Marks: ");
                double marks = sc.nextDouble();
                sc.nextLine(); // Consume the newline character

                s.setName(name);
                s.setMarks(marks);
                System.out.println("Student updated successfully!");
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Student with ID " + uid + " not found.");
        }
    }

    public static void deleteStudent() {
        System.out.print("Enter the ID of the student you want to delete: ");
        int id = sc.nextInt();
        sc.nextLine(); // Consume the newline character
        boolean removed = ar.removeIf(s -> s.getId() == id);

        if (removed) {
            System.out.println("Deleted successfully.");
        } else {
            System.out.println("Student with ID " + id + " not found.");
        }
    }
}