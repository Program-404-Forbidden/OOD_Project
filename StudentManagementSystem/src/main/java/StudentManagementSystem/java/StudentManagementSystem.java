package StudentManagementSystem.java;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

class Student {
    String name;
    int rollNumber;
    double grades;

    public Student(String name, int rollNumber, double grades) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.grades = grades;
    }

    public String getName() {
        return name;
    }

    public int getRollNumber() {
        return rollNumber;
    }

    public double getGrades() {
        return grades;
    }

    public String toString() {
        return "Student{name='" + name + "', rollNumber=" + rollNumber + ", grades=" + grades + '}';
    }
}

public class StudentManagementSystem {
    private static ArrayList<Student> students = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("1. Add Student");
            System.out.println("2. Update Student");
            System.out.println("3. Delete Student");
            System.out.println("4. Display Students");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            if (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter a number between 1 and 7.");
                scanner.next(); 
                continue;
            }

            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    updateStudent();
                    break;
                case 3:
                    deleteStudent();
                    break;
                case 4:
                    displayStudents();
                    break;
                case 5:
                    System.out.println("Exiting... Goodbye!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void addStudent() {
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        System.out.print("Enter roll number: ");

        while (!scanner.hasNextInt()) {
            System.out.println("Invalid input. Roll number must be an integer.");
            scanner.next(); 
        }

        int rollNumber = scanner.nextInt();
        System.out.print("Enter grades: ");

        while (!scanner.hasNextDouble()) {
            System.out.println("Invalid input. Grades must be a decimal or integer.");
            scanner.next(); 
        }

        double grades = scanner.nextDouble();
        scanner.nextLine();
        
        students.add(new Student(name, rollNumber, grades));
        System.out.println("Student added successfully.");
    }

    private static void updateStudent() {
        System.out.print("Enter roll number of student to update: ");

        while (!scanner.hasNextInt()) {
            System.out.println("Invalid input. Roll number must be an integer.");
            scanner.next();
        }

        int rollNumber = scanner.nextInt();
        scanner.nextLine();

        for (Student student : students) {
            if (student.getRollNumber() == rollNumber) {
                System.out.print("Enter new name: ");
                student.name = scanner.nextLine();
                System.out.print("Enter new grades: ");

                while (!scanner.hasNextDouble()) {
                    System.out.println("Invalid input. Grades must be a decimal or integer.");
                    scanner.next(); 
                }

                student.grades = scanner.nextDouble();
                scanner.nextLine(); 
                System.out.println("Student updated successfully.");
                return;
            }
        }

        System.out.println("Student not found.");
    }

    private static void deleteStudent() {
        System.out.print("Enter roll number of student to delete: ");

        while (!scanner.hasNextInt()) {
            System.out.println("Invalid input. Roll number must be an integer.");
            scanner.next();
        }

        int rollNumber = scanner.nextInt();
        scanner.nextLine(); 

        Student studentToRemove = null;
        for (Student student : students) {
            if (student.getRollNumber() == rollNumber) {
                studentToRemove = student;
                break;
            }
        }

        if (studentToRemove != null) {
            students.remove(studentToRemove);
            System.out.println("Student deleted successfully.");
        } else {
            System.out.println("Student not found.");
        }
    }

    private static void displayStudents() {
        if (students.isEmpty()) {
            System.out.println("No students to display.");
            return;
        }

        for (Student student : students) {
            System.out.println(student);
        }
    }
}
