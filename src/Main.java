// Adonis O. Cocamas Jr.

// LAB ACTIVITY 5 — Exception Handling & Debugging
// * Program : Mini ATM (Command-Line Interface)
// * Course  : Object-Oriented Programming (Java)

import java.util.Scanner;

public class Main {

    // The account balance shared by the whole program.
    static double balance = 1000.00;

    // One Scanner for reading everything the user types.
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("=========================================");
        System.out.println("           WELCOME TO THE MINI ATM");
        System.out.println("=========================================");

        boolean running = true;
        while (running) {
            printMenu();
            String choice = input.nextLine().trim();

            switch (choice) {
                case "1":
                    deposit();
                    break;
                case "2":
                    withdraw();
                    break;
                case "3":
                    checkBalance();
                    break;
                case "4":
                    running = false;
                    System.out.println("\nThank you for using the Mini ATM. Goodbye!");
                    break;
                default:
                    // A friendly message beats a crash.
                    System.out.println("\n[!] Please choose a number from 1 to 4.\n");
            }
        }
    }

    static void printMenu() {
        System.out.println("Current options:");
        System.out.println("  [1] Deposit");
        System.out.println("  [2] Withdraw");
        System.out.println("  [3] Check balance");
        System.out.println("  [4] Exit");
        System.out.print("Enter your choice: ");
    }

    // DEPOSIT

    static void deposit() {
        System.out.print("Enter amount to deposit: ");
        String line = input.nextLine().trim();

        // Task 2: guard the parsing so bad input never crashes the program.
        // Task 3: throw InvalidAmountException for zero/negative amounts.
        // Task 4: finally block always runs, whether we succeed or fail.
        try {
            double amount = Double.parseDouble(line);

            if (amount <= 0) {
                throw new InvalidAmountException("Deposit amount must be greater than zero.");
            }

            balance += amount;
            System.out.printf("Deposited PHP %.2f. New balance: PHP %.2f%n%n", amount, balance);

        } catch (NumberFormatException e) {
            System.out.println("[!] Please enter a valid number.");
        } catch (InvalidAmountException e) {
            System.out.println("[!] " + e.getMessage());
        } finally {
            System.out.println("-- transaction finished --\n");
        }
    }

    // WITHDRAW

    static void withdraw() {
        System.out.print("Enter amount to withdraw: ");
        String line = input.nextLine().trim();

        // Task 2: guard the parsing so bad input never crashes the program.
        // Task 3: throw InvalidAmountException for zero/negative amounts, and
        //         InsufficientFundsException (carrying the shortfall) for
        //         amounts greater than the current balance.
        // Task 4: multi-catch for the two custom exceptions since they share
        //        the same handling; finally block always runs.
        try {
            double amount = Double.parseDouble(line);

            if (amount <= 0) {
                throw new InvalidAmountException("Withdrawal amount must be greater than zero.");
            }

            if (amount > balance) {
                double shortfall = amount - balance;
                throw new InsufficientFundsException(
                        String.format("Insufficient funds. You are short by PHP %.2f.", shortfall),
                        shortfall);
            }

            balance -= amount;
            System.out.printf("Withdrew PHP %.2f. New balance: PHP %.2f%n%n", amount, balance);

        } catch (NumberFormatException e) {
            System.out.println("[!] Please enter a valid number.");
        } catch (InvalidAmountException | InsufficientFundsException e) {
            System.out.println("[!] " + e.getMessage());
        } finally {
            System.out.println("-- transaction finished --\n");
        }
    }

    // CHECK BALANCE

    static void checkBalance() {
        System.out.printf("%nYour current balance is: PHP %.2f%n%n", balance);
    }
}

// Thrown when a withdrawal would exceed the current balance.
// Stores the shortfall amount so the caller can report exactly how much
// more the user needs (the "add context" best practice from the lecture).
class InsufficientFundsException extends Exception {

    private final double shortfall;

    public InsufficientFundsException(String message, double shortfall) {
        super(message);
        this.shortfall = shortfall;
    }

    public double getShortfall() {
        return shortfall;
    }
}

class InvalidAmountException extends Exception {

    public InvalidAmountException(String message) {
        super(message);
    }
}
