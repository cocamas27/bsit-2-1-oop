import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static double[] cutoffs = {90, 80, 70, 60, 0};
    static String[] grades = {"A", "B", "C", "D", "F"};

    public static String getLetter(double score) {
        for (int i = 0; i < cutoffs.length; i++) {
            if (score >= cutoffs[i]) {
                return grades[i];
            }
        }
        return "F";
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<>();

        int choice;

        do {
            System.out.println("\n===== Grade Tracker =====");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Show Average");
            System.out.println("4. Exit");
            System.out.print("Choose: ");
            choice = input.nextInt();

            if (choice == 1) {

                System.out.print("Student Name: ");
                String name = input.next();

                System.out.print("Grade: ");
                double grade = input.nextDouble();

                students.add(new Student(name, grade));

                System.out.println("Student Added!");

            } else if (choice == 2) {

                if (students.size() == 0) {
                    System.out.println("No students yet.");
                } else {
                    System.out.println("\nStudent List");
                    for (Student s : students) {
                        System.out.println(s.name + " - " + s.grade + " - " + getLetter(s.grade));
                    }
                }

            } else if (choice == 3) {

                if (students.size() == 0) {
                    System.out.println("No students yet.");
                } else {

                    double total = 0;

                    for (Student s : students) {
                        total += s.grade;
                    }

                    double average = total / students.size();

                    System.out.println("Average Grade: " + average);
                    System.out.println("Letter Grade: " + getLetter(average));
                }

            } else if (choice == 4) {

                System.out.println("Goodbye!");

            } else {

                System.out.println("Invalid choice.");

            }

        } while (choice != 4);

        input.close();
    }
}

class Student {

    String name;
    double grade;

    Student(String name, double grade) {
        this.name = name;
        this.grade = grade;
    }
}