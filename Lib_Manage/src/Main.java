import com.example.entity.Book;
import com.example.entity.User;
import com.example.service.BookService;
import com.example.service.BookServiceImpl;
import com.example.service.UserService;
import com.example.service.UserServiceImpl;
import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final BookService bookService = new BookServiceImpl();
    private static final UserService userService = new UserServiceImpl();

    public static void main(String[] args) {
        int choice;
        do {
            printMainMenu();
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    handleBookMenu();
                    break;
                case 2:
                    handleUserMenu();
                    break;
                case 99:
                    System.out.println("Exiting application. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 99);
    }

    private static void printMainMenu() {
        System.out.println("\n--- Library Management System ---");
        System.out.println("1. Manage Books");
        System.out.println("2. Manage Users");
        System.out.println("99. Exit");
        System.out.print("Enter your choice: ");
    }

    private static void handleBookMenu() {
        int choice;
        do {
            printBookMenu();
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addBook();
                    break;
                case 2:
                    updateBook();
                    break;
                case 3:
                    deleteBookById();
                    break;
                case 4:
                    deleteBookByTitle();
                    break;
                case 5:
                    searchBookById();
                    break;
                case 6:
                    searchBookByTitle();
                    break;
                case 7:
                    listAllBooks();
                    break;
                case 99:
                    System.out.println("Returning to main menu.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 99);
    }

    private static void printBookMenu() {
        System.out.println("\n--- Book Management ---");
        System.out.println("1. Add Book");
        System.out.println("2. Update Book Details");
        System.out.println("3. Delete Book by ID");
        System.out.println("4. Delete Book by Title");
        System.out.println("5. Search Book by ID");
        System.out.println("6. Search Book by Title");
        System.out.println("7. List All Books");
        System.out.println("99. Go Back");
        System.out.print("Enter your choice: ");
    }

    private static void addBook() {
        System.out.print("Enter title: ");
        String title = scanner.nextLine();
        System.out.print("Enter description: ");
        String description = scanner.nextLine();
        System.out.print("Enter price: ");
        double price = scanner.nextDouble();
        scanner.nextLine(); 
        System.out.print("Enter author: ");
        String author = scanner.nextLine();
        System.out.print("Enter publisher: ");
        String publisher = scanner.nextLine();
        System.out.print("Enter quantity: ");
        int quantity = scanner.nextInt();
        scanner.nextLine();

        Book book = new Book();
        book.setTitle(title);
        book.setDescription(description);
        book.setPrice(price);
        book.setAuthor(author);
        book.setPublisher(publisher);
        book.setQuantity(quantity);

        bookService.addBook(book);
    }

    private static void updateBook() {
        System.out.print("Enter book ID to update: ");
        long id = scanner.nextLong();
        scanner.nextLine();

        Book existingBook = bookService.findBookById(id);
        if (existingBook != null) {
            System.out.println("Current Book Details: " + existingBook);
            System.out.print("Enter new title (press enter to skip): ");
            String newTitle = scanner.nextLine();
            if (!newTitle.isEmpty()) {
                existingBook.setTitle(newTitle);
            }
            
            System.out.print("Enter new description (press enter to skip): ");
            String newDescription = scanner.nextLine();
            if (!newDescription.isEmpty()) {
                existingBook.setDescription(newDescription);
            }
            
            System.out.print("Enter new price (press 0 or a non-numeric value to skip): ");
            if (scanner.hasNextDouble()) {
                double newPrice = scanner.nextDouble();
                existingBook.setPrice(newPrice);
            }
            scanner.nextLine();

 
            bookService.updateBook(existingBook);

        } else {
            System.out.println("Book with ID " + id + " not found.");
        }
    }

    private static void deleteBookById() {
        System.out.print("Enter book ID to delete: ");
        long id = scanner.nextLong();
        scanner.nextLine();
        bookService.deleteBookById(id);
    }

    private static void deleteBookByTitle() {
        System.out.print("Enter book title to delete: ");
        String title = scanner.nextLine();
        bookService.deleteBookByTitle(title);
    }

    private static void searchBookById() {
        System.out.print("Enter book ID to search: ");
        long id = scanner.nextLong();
        scanner.nextLine();
        Book book = bookService.findBookById(id);
        if (book != null) {
            System.out.println("Book Found: " + book);
        } else {
            System.out.println("Book with ID " + id + " not found.");
        }
    }

    private static void searchBookByTitle() {
        System.out.print("Enter book title to search: ");
        String title = scanner.nextLine();
        Book book = bookService.findBookByTitle(title);
        if (book != null) {
            System.out.println("Book Found: " + book);
        } else {
            System.out.println("Book with title '" + title + "' not found.");
        }
    }

    private static void listAllBooks() {
        System.out.println("\n--- All Books in the Library ---");
        bookService.listAllBooks().forEach(System.out::println);
    }

    // User Management Methods
    private static void handleUserMenu() {
        int choice;
        do {
            printUserMenu();
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    addUser();
                    break;
                case 2:
                    updateUser();
                    break;
                case 3:
                    deleteUserById();
                    break;
                case 4:
                    deleteUserByUsername();
                    break;
                case 5:
                    searchUserByUsername();
                    break;
                case 6:
                    listAllUsers();
                    break;
                case 99:
                    System.out.println("Returning to main menu.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 99);
    }

    private static void printUserMenu() {
        System.out.println("\n--- User Management ---");
        System.out.println("1. Add User");
        System.out.println("2. Update User Details");
        System.out.println("3. Delete User by ID");
        System.out.println("4. Delete User by Username");
        System.out.println("5. Search User by Username");
        System.out.println("6. List All Users");
        System.out.println("99. Go Back");
        System.out.print("Enter your choice: ");
    }

    private static void addUser() {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter full name: ");
        String fullName = scanner.nextLine();
        System.out.print("Enter contact number: ");
        String contactNo = scanner.nextLine();
        System.out.print("Enter email: ");
        String email = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();
        System.out.print("Enter role (e.g., Member, Admin): ");
        String role = scanner.nextLine();
        System.out.print("Enter date of birth (YYYY-MM-DD): ");
        String dob = scanner.nextLine();

        User user = new User();
        user.setUsername(username);
        user.setFullName(fullName);
        user.setContactNo(contactNo);
        user.setEmail(email);
        user.setPassword(password);
        user.setRole(role);
        user.setDob(dob);

        userService.addUser(user);
    }

    private static void updateUser() {
        System.out.print("Enter user ID to update: ");
        long id = scanner.nextLong();
        scanner.nextLine();

        User existingUser = userService.findUserById(id);
        if (existingUser != null) {
            System.out.println("Current User Details: " + existingUser);
            System.out.print("Enter new full name (press enter to skip): ");
            String newFullName = scanner.nextLine();
            if (!newFullName.isEmpty()) {
                existingUser.setFullName(newFullName);
            }

            userService.updateUser(existingUser);
        } else {
            System.out.println("User with ID " + id + " not found.");
        }
    }

    private static void deleteUserById() {
        System.out.print("Enter user ID to delete: ");
        long id = scanner.nextLong();
        scanner.nextLine();
        userService.deleteUserById(id);
    }

    private static void deleteUserByUsername() {
        System.out.print("Enter username to delete: ");
        String username = scanner.nextLine();
        userService.deleteUserByUsername(username);
    }

    private static void searchUserByUsername() {
        System.out.print("Enter username to search: ");
        String username = scanner.nextLine();
        User user = userService.findUserByUsername(username);
        if (user != null) {
            System.out.println("User Found: " + user);
        } else {
            System.out.println("User with username '" + username + "' not found.");
        }
    }

    private static void listAllUsers() {
        System.out.println("\n--- All Users in the System ---");
        userService.listAllUsers().forEach(System.out::println);
    }
}
