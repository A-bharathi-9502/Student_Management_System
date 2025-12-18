import java.util.ArrayList;
import java.util.Scanner;

class Student {
    private int rollNumber;
    private String name;
    private int age;
    private String course;
    private int year;
    private double cgpa;

    public Student(int rollNumber, String name, int age, String course, int year, double cgpa) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.age = age;
        this.course = course;
        this.year = year;
        this.cgpa = cgpa;
    }

    public int getRollNumber() {
        return rollNumber;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setCgpa(double cgpa) {
        this.cgpa = cgpa;
    }

    @Override
    public String toString() {
        return "Roll No: " + rollNumber +
               ", Name: " + name +
               ", Age: " + age +
               ", Course: " + course +
               ", Year: " + year +
               ", CGPA: " + cgpa;
    }
}

public class Students {
    private static ArrayList<Student> studentList = new ArrayList<>();
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("\n--- Student Management System ---");
            System.out.println("1. Add Student");
            System.out.println("2. Update Student");
            System.out.println("3. Delete Student");
            System.out.println("4. Display All Students");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();

            switch (choice) {
                case 1 -> addStudent();
                case 2 -> updateStudent();
                case 3 -> deleteStudent();
                case 4 -> displayStudents();
                case 5 -> System.out.println("Exiting the program...");
                default -> System.out.println("Invalid choice! Please try again.");
            }
        } while (choice != 5);
    }

    private static void addStudent() {
        System.out.print("Enter Roll Number: ");
        int roll = sc.nextInt();

        for (Student s : studentList) {
            if (s.getRollNumber() == roll) {
                System.out.println("Student with this roll number already exists.");
                return;
            }
        }

        sc.nextLine(); // consume newline
        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Age: ");
        int age = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Course: ");
        String course = sc.nextLine();

        System.out.print("Enter Year: ");
        int year = sc.nextInt();

        System.out.print("Enter CGPA: ");
        double cgpa = sc.nextDouble();

        studentList.add(new Student(roll, name, age, course, year, cgpa));
        System.out.println("Student added successfully!");
    }

    private static void updateStudent() {
        System.out.print("Enter Roll Number of student to update: ");
        int roll = sc.nextInt();
        boolean found = false;

        for (Student s : studentList) {
            if (s.getRollNumber() == roll) {
                sc.nextLine();
                System.out.print("Enter new Name: ");
                String name = sc.nextLine();

                System.out.print("Enter new Age: ");
                int age = sc.nextInt();
                sc.nextLine();

                System.out.print("Enter new Course: ");
                String course = sc.nextLine();

                System.out.print("Enter new Year: ");
                int year = sc.nextInt();

                System.out.print("Enter new CGPA: ");
                double cgpa = sc.nextDouble();

                s.setName(name);
                s.setAge(age);
                s.setCourse(course);
                s.setYear(year);
                s.setCgpa(cgpa);

                System.out.println("Student record updated successfully!");
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Student with roll number " + roll + " not found.");
        }
    }

    private static void deleteStudent() {
        System.out.print("Enter Roll Number of student to delete: ");
        int roll = sc.nextInt();
        boolean removed = false;

        for (int i = 0; i < studentList.size(); i++) {
            if (studentList.get(i).getRollNumber() == roll) {
                studentList.remove(i);
                System.out.println("Student deleted successfully!");
                removed = true;
                break;
            }
        }

        if (!removed) {
            System.out.println("Student with roll number " + roll + " not found.");
        }
    }

    private static void displayStudents() {
        if (studentList.isEmpty()) {
            System.out.println("No student records available.");
        } else {
            System.out.println("\n--- Student Records ---");
            for (Student s : studentList) {
                System.out.println(s);
            }
        }
    }
}
