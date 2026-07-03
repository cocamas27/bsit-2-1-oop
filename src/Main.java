import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("=== Student Information System ===");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Search by ID");
            System.out.println("4. View Statistics");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1: System.out.println("Add Student selected"); break;
                case 2: System.out.println("View All Students selected"); break;
                case 3: System.out.println("Search by ID selected"); break;
                case 4: System.out.println("View Statistics selected"); break;
                case 5: System.out.println("Exiting..."); break;
                default: System.out.println("Invalid choice");
            }
        } while (choice != 5);

        scanner.close();
    }
}