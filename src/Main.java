import java.util.ArrayList;
import java.util.Scanner;


class BookItem {
    private String bookTitle;
    private String writerName;
    private boolean isAvailable;


    public BookItem(String bookTitle, String writerName) {
        this.bookTitle = bookTitle;
        this.writerName = writerName;
        this.isAvailable = true;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public String getWriterName() {
        return writerName;
    }

    public boolean checkAvailability() {
        return isAvailable;
    }

    public void setAvailability(boolean status) {
        this.isAvailable = status;
    }


    public String getDetails() {
        String statusText = isAvailable ? "Available" : "Borrowed";
        return "Title: " + bookTitle + " | Author: " + writerName + " | Status: " + statusText;
    }
}


        class Catalog {
            private ArrayList<BookItem> inventory;

            public Catalog() {
                inventory = new ArrayList<>();
            }

            public void addBook(BookItem item) {
                inventory.add(item);
                System.out.println("Book added successfully!");
            }

            public void displayAllBooks() {
                if (inventory.isEmpty()) {
                    System.out.println("No books in the library.");
                    return;
                }

                System.out.println("\n===== Library Books =====");
                int index = 1;
                for (BookItem item : inventory) {
                    System.out.println(index + ". " + item.getDetails());
                    index++;
                }
            }


            private BookItem findBookByTitle(String title) {
                for (BookItem item : inventory) {
                    if (item.getBookTitle().equalsIgnoreCase(title)) {
                        return item;
                    }
                }
                return null;
            }

            public void borrowBook(String title) {
                BookItem targetedBook = findBookByTitle(title);

                if (targetedBook == null) {
                    System.out.println("Book not found.");
                    return;
                }

                if (targetedBook.checkAvailability()) {
                    targetedBook.setAvailability(false);
                    System.out.println("Book borrowed successfully.");
                } else {
                    System.out.println("Book is already borrowed.");
                }
            }

            public void returnBook(String title) {
                BookItem targetedBook = findBookByTitle(title);

                if (targetedBook == null) {
                    System.out.println("Book not found.");
                    return;
                }

                if (!targetedBook.checkAvailability()) {
                    targetedBook.setAvailability(true);
                    System.out.println("Book returned successfully.");
                } else {
                    System.out.println("Book is already available.");
                }
            }

            public void searchBook(String title) {
                BookItem targetedBook = findBookByTitle(title);

                if (targetedBook != null) {
                    System.out.println("Book found!");
                    System.out.println(targetedBook.getDetails());
                } else {
                    System.out.println("Book not found.");
                }
            }
        }


        public class Main {
            public static void main(String[] args) {
                Scanner inputScanner = new Scanner(System.in);
                Catalog libraryCatalog = new Catalog();

                while (true) {
                    System.out.println("\n===== Library Information System =====");
                    System.out.println("1. Add a Book");
                    System.out.println("2. List All Books");
                    System.out.println("3. Borrow a Book");
                    System.out.println("4. Return a Book");
                    System.out.println("5. Search a Book");
                    System.out.println("0. Exit");
                    System.out.print("Enter your choice: ");

                    int userChoice = inputScanner.nextInt();
                    inputScanner.nextLine();

                    if (userChoice == 0) {
                        System.out.println("Thank you for using the Library Information System!");
                        break;
                    }

                    switch (userChoice) {
                        case 1:
                            System.out.print("Enter book title: ");
                            String name = inputScanner.nextLine();

                            System.out.print("Enter author: ");
                            String author = inputScanner.nextLine();

                            libraryCatalog.addBook(new BookItem(name, author));
                            break;

                        case 2:
                            libraryCatalog.displayAllBooks();
                            break;

                        case 3:
                            System.out.print("Enter title to borrow: ");
                            String borrowTitle = inputScanner.nextLine();
                            libraryCatalog.borrowBook(borrowTitle);
                            break;

                        case 4:
                            System.out.print("Enter title to return: ");
                            String returnTitle = inputScanner.nextLine();
                            libraryCatalog.returnBook(returnTitle);
                            break;

                        case 5:
                            System.out.print("Enter title to search: ");
                            String searchTitle = inputScanner.nextLine();
                            libraryCatalog.searchBook(searchTitle);
                            break;

                        default:
                            System.out.println("Invalid choice. Please try again.");
                    }
                }

                inputScanner.close();
            }
        }
