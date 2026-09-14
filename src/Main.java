import java.util.Scanner;

public class Main {
    private static int nextId = 1004;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PaymentGateway gateway = new PaymentGateway();


        gateway.add(new GCashPayment(1001, "Ana", 1500.00, "0917-555-0134"));
        gateway.add(new MayaPayment(1002, "Jerome", 899.50, "jerome@liceo.edu.ph"));
        gateway.add(new CashPayment(1003, "Liza", 250.00));

        while (true) {
            printBanner();
            printMenu();
            System.out.print("Select an option: ");

            int choice = -1;
            try {
                choice = Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
                continue;
            }

            System.out.println();
            switch (choice) {
                case 1:
                    makePayment(scanner, gateway);
                    break;
                case 2:
                    System.out.println("--- ALL RECEIPTS ---");
                    gateway.processAll();
                    break;
                case 3:
                    findPayment(scanner, gateway);
                    break;
                case 4:
                    System.out.printf("Total Collected: PHP %.2f%n", gateway.totalCollected());
                    break;
                case 5:
                    System.out.println("Refunding every payment that can be refunded:");
                    gateway.refundAll();
                    break;
                case 6:
                    System.out.println("Service fees (the two serviceFee methods):");
                    gateway.showServiceFees();
                    break;
                case 0:
                    System.out.println("Thank you for using LICEO PAY. Goodbye!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
            System.out.println();
        }
    }

    private static void printBanner() {
        System.out.println("========================================");
        System.out.println("              LICEO PAY                 ");
        System.out.println("========================================");
    }

    private static void printMenu() {
        System.out.println("[1] Make Payment");
        System.out.println("[2] Process All Receipts");
        System.out.println("[3] Find Payment by ID");
        System.out.println("[4] Show Total Collected");
        System.out.println("[5] Refund All Eligible Payments");
        System.out.println("[6] Show Service Fees");
        System.out.println("[0] Exit");
    }

    private static void makePayment(Scanner scanner, PaymentGateway gateway) {
        System.out.println("--- MAKE A PAYMENT ---");
        System.out.println("[1] GCash");
        System.out.println("[2] Maya");
        System.out.println("[3] Cash");
        System.out.print("Choose payment type: ");

        int type = 0;
        try {
            type = Integer.parseInt(scanner.nextLine().trim());
        } catch (NumberFormatException e) {
            System.out.println("Invalid selection. Aborting payment.");
            return;
        }

        if (type < 1 || type > 3) {
            System.out.println("Invalid payment type selected.");
            return;
        }

        System.out.print("Enter Payer Name: ");
        String name = scanner.nextLine().trim();

        System.out.print("Enter Amount: ");
        double amount = 0.0;
        try {
            amount = Double.parseDouble(scanner.nextLine().trim());
        } catch (NumberFormatException e) {
            System.out.println("Invalid amount entered. Aborting payment.");
            return;
        }

        Payment payment = null;
        int currentId = nextId++;

        if (type == 1) {
            System.out.print("Enter Mobile Number: ");
            String mobile = scanner.nextLine().trim();
            payment = new GCashPayment(currentId, name, amount, mobile);
        } else if (type == 2) {
            System.out.print("Enter Email Address: ");
            String email = scanner.nextLine().trim();
            payment = new MayaPayment(currentId, name, amount, email);
        } else if (type == 3) {
            payment = new CashPayment(currentId, name, amount);
        }

        if (payment != null) {
            gateway.add(payment);
            System.out.println("\n--- PAYMENT CONFIRMATION ---");
            payment.printReceipt();
            payment.printThankYou();
        }
    }

    private static void findPayment(Scanner scanner, PaymentGateway gateway) {
        System.out.print("Enter Payment ID to find: ");
        try {
            int searchId = Integer.parseInt(scanner.nextLine().trim());
            Payment p = gateway.findById(searchId);
            if (p != null) {
                System.out.println("Payment Found:");
                p.printReceipt();
                p.printThankYou();
            } else {
                System.out.println("No payment found with ID " + searchId);
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid ID format.");
        }
    }
}