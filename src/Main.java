import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        int[] ids = new int[5];
        String[] names = new String[5];
        double[] grades = new double[5];
        int count = 0;

        int choice;


        do {
            System.out.println ("====  STUDENT INFORMATION SYSTEM  ====");
            System.out.println("\n1. Add Student  2. View All  3. Search  4. Exit");
            System.out.print("Choice: ");
            choice = sc.nextInt();


            switch (choice) {

                case 1:
                    if (count < 5) {
                        System.out.print("ID: ");
                        ids[count] = sc.nextInt();

                        System.out.print("Name: ");
                        names[count] = sc.next();

                        System.out.print("Grade: ");
                        grades[count] = sc.nextDouble();

                        count++;
                    } else {
                        System.out.println("List is full!");
                    }
                    break;

                case 2:
                    for (int i = 0; i < count; i++) {
                        String standing;
                        if (grades[i] >= 90) {
                            standing = "Dean's Lister";
                        } else if (grades[i] >= 75) {
                            standing = "Passed";
                        } else {
                            standing = "Failed";
                        }
                        System.out.println ( "ID / NAME / GRADE / STANDING " );
                        System.out.println(ids[i] + " / " + names[i] + " / " + grades[i] + " / " + standing);
                    }
                    break;

                case 3:
                    System.out.print("Enter ID: ");
                    int searchId = sc.nextInt();
                    boolean found = false;

                    for (int i = 0; i < count; i++) {
                        if (ids[i] == searchId) {
                            System.out.println("Found: " + names[i] + " - " + grades[i]);
                            found = true;
                        }
                    }
                    if (!found) {
                        System.out.println("Not found.");
                    }
                    break;



                case 5:
                    System.out.println("Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 5);

        sc.close();
    }
}
