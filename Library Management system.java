import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

class LMS {
    static class Books {
        String bookName, publisher, writer, bookCategory, isbnNumber;
        int publishedYear;
        static int booksCount = 0;

        void addBook(String bookName, String writer, String publisher, String bookCategory, String isbnNumber,
                int publishedYear) {
            this.bookName = bookName;
            this.writer = writer;
            this.publisher = publisher;
            this.bookCategory = bookCategory;
            this.isbnNumber = isbnNumber;
            this.publishedYear = publishedYear;
        }
    }

    static Scanner scanner = new Scanner(System.in);
    static boolean loggedIn = false;
    static int libraryID = 100, userID;
    static String libraryPassword = "abc", password;

    static void userLogin() {
        System.out.println("LMS Login:");
        System.out.print("Enter LibraryID: ");
        try {
            userID = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Enter Password: ");
            password = scanner.next();
            scanner.nextLine();
            if (userID == libraryID && password.equals(libraryPassword)) {
                loggedIn = true;
                System.out.println("\nLogged in Successfully");
                TimeUnit.SECONDS.sleep(1);
            } else
                System.out.println("Wrong Credentials");
        } catch (InputMismatchException | InterruptedException e) {
            System.out.println("Invalid Value!");
        }
    }

    public void viewBooks(LMS.Books[] books, int j) {
        if (LMS.Books.booksCount != 0) {
            for (int i = j; i < LMS.Books.booksCount; i++) {
                System.out.println("< Book " + (i + 1) + " > : " + books[i].bookName);
            }
        } else {
            System.out.println("No books available in Library.\nTry adding some books in Library.");
        }
    }

    public void viewBooksDetailed(LMS.Books[] books) {
        if (LMS.Books.booksCount != 0) {
            for (int i = 0; i < LMS.Books.booksCount; i++) {
                System.out.println("\n< Book " + (i + 1) + " >" +
                        "\nName: \t\t\t" + books[i].bookName +
                        "\nWriter: \t\t" + books[i].writer +
                        "\nPublisher: \t\t" + books[i].publisher +
                        "\nCategory: \t\t" + books[i].bookCategory +
                        "\nISBN number: \t\t" + books[i].isbnNumber +
                        "\nPublished Year: \t" + books[i].publishedYear);
            }
        } else {
            System.out.println("No books available in Library.\nTry adding some books in Library.");
        }
    }

    public void removeBooks1(int bookNumber, LMS.Books[] books) {
        if (LMS.Books.booksCount - bookNumber >= 0)
            System.arraycopy(books, bookNumber, books, bookNumber - 1, LMS.Books.booksCount - bookNumber + 1);
    }

    static public void exitProgram1() {
        try {
            TimeUnit.SECONDS.sleep(1);
            System.out.print("\nWant to go to home screen? \n1. Yes\t(otherwise No)\n==> ");
            int decision = LMS.scanner.nextInt();
            if (decision == 1) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.println("\nThank you for using Library Management System");
                System.exit(0);
            }
        } catch (InterruptedException | IOException | InputMismatchException e) {
            System.out.println("Exiting the program...");
            System.exit(0);
        }
    }

    public void removeBooks(int bookNumber, LMS.Books[] books) {
        if (LMS.Books.booksCount - bookNumber >= 0)
            System.arraycopy(books, bookNumber, books, bookNumber - 1, LMS.Books.booksCount - bookNumber + 1);
    }

    static public void exitProgram() {
        try {
            TimeUnit.SECONDS.sleep(1);
            System.out.print("\nWant to go to home screen? \n1. Yes\t(otherwise No)\n==> ");
            int decision = LMS.scanner.nextInt();
            if (decision == 1) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.println("\nThank you for using Library Management System");
                System.exit(0);
            }
        } catch (InterruptedException | IOException | InputMismatchException e) {
            System.out.println("Exiting the program...");
            System.exit(0);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        int choice;
        Scanner scan = new Scanner(System.in);
        System.out.println("\nWelcome to Library Management System made by Sakshi Sonawane\n");

        System.out.print("Please Select: \n" +
                "1. Sign Up\t" +
                "2. Exit\n==> ");
        try {
            choice = scan.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Invalid Value!");
            choice = 99;
        }
        switch (choice) {
            case 1:
                System.out.print("Your libraryID is " + (++LMS.libraryID) + "\nEnter Password: ");
                LMS.libraryPassword = scan.next();
                System.out.println("System Admin created Successfully.\n\nRedirecting to Login...\n");
                TimeUnit.SECONDS.sleep(0);
                LMS.userLogin();
                break;
            case 2:
                break;
            default:
                System.out.println("Wrong value entered!");
                break;
        }

        if (loggedIn == true) {
            System.out.println("Adding books for demo...");
            TimeUnit.SECONDS.sleep(1);
        }
        LMS.Books[] books = new LMS.Books[100];
        books[LMS.Books.booksCount] = new LMS.Books();
        books[LMS.Books.booksCount].addBook("Rich Dad Poor Dad", "Robert T. Kiyosaki", "Business Plus",
                "Psychology", "0446677450", 2000);

        books[LMS.Books.booksCount + 1] = new LMS.Books();
        books[LMS.Books.booksCount + 1].addBook("Deep Learning with Python", "Francois Chollet", "Manning Publications",
                "Programming", "1617294438", 2017);

        books[LMS.Books.booksCount + 2] = new LMS.Books();
        books[LMS.Books.booksCount + 2].addBook("Fluent Python", "Luciano Ramalho", "O'Reilly Media",
                "Programming", "1491946008", 2015);

        books[LMS.Books.booksCount + 3] = new LMS.Books();
        books[LMS.Books.booksCount + 3].addBook("How To Win Friends & Influence People", "Dale Carnegie",
                "Manning Publications",
                "Education", "067142517X", 1981);

        books[LMS.Books.booksCount + 4] = new LMS.Books();
        books[LMS.Books.booksCount + 4].addBook("The Courage to be Disliked", "Ichiro Kishimi, Fumitake Koga",
                "Allen & Unwin",
                "Psychology", "1760630497", 2017);

        LMS.Books.booksCount += 5;
        while (LMS.loggedIn) {
            System.out.print("\nPlease select: \n" +
                    "1. View All Book Details\n" +
                    "2. View Books Names Only\n" +
                    "3. Add Books In Library\n" +
                    "4. Remove Books From Library \n" +
                    "5. Logout & Exit\n==> ");
            int selection;
            try {
                selection = scan.nextInt();
                scan.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("Invalid Value!");
                selection = 99;
            }
            LMS user = new LMS();
            switch (selection) {
                case 1:
                    user.viewBooksDetailed(books);
                    LMS.exitProgram1();
                    break;
                case 2:
                    user.viewBooks(books, 0);
                    LMS.exitProgram1();
                    break;
                case 3:
                    int count = 1;
                    System.out.print("How many books you want to add? => ");
                    int limit = scan.nextInt();
                    try {
                        for (int i = LMS.Books.booksCount; i < (LMS.Books.booksCount + limit); i++) {
                            scan.nextLine();
                            System.out.println("Enter Details of Book " + count + ":");
                            System.out.print("Name: ");
                            String name = scan.nextLine();
                            System.out.print("Writer: ");
                            String writer = scan.nextLine();
                            System.out.print("Publisher: ");
                            String publisher = scan.nextLine();
                            System.out.print("Category: ");
                            String category = scan.nextLine();
                            System.out.print("ISBN number: ");
                            String isbn = scan.nextLine();
                            System.out.print("Published Year: ");
                            int year = scan.nextInt();
                            books[i] = new LMS.Books();
                            books[i].addBook(name, writer, publisher, category, isbn, year);
                            count++;
                        }
                        System.out.println("\n" + limit + " Books added successfully");
                        LMS.Books.booksCount += limit;
                        System.out.println("\nAdded Books are: ");
                        user.viewBooks(books, LMS.Books.booksCount - limit);
                    } catch (NullPointerException e) {
                        System.out.println("Something went Wrong!");
                    }
                    LMS.exitProgram1();
                    break;
                case 4:
                    if (LMS.Books.booksCount != 0) {
                        user.viewBooks(books, 0);
                        System.out.print("Enter the NUMBER of book from given above to remove:\n==> ");
                        int bookNumber = scan.nextInt();
                        if (bookNumber <= LMS.Books.booksCount) {
                            user.removeBooks1(bookNumber, books);
                            System.out.println("\nBook removed successfully");
                            LMS.Books.booksCount--;
                            TimeUnit.SECONDS.sleep(1);
                            System.out.println("\nRemaining Books: ");
                            user.viewBooks(books, 0);
                        } else {
                            System.out.println("No book found with this number");
                        }
                    } else {
                        System.out.println("No books available in Library.\nTry adding some books in Library.");
                    }
                    LMS.exitProgram1();
                    break;
                case 5:
                    LMS.loggedIn = false;
                    break;
                default:
                    System.out.println("Invalid Value!");
                    break;
            }
        }
        System.out.println("\nThank you for using Library Management System");
    }
}
