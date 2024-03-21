package BookShop;

import BookShop.models.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main {
    static Scanner scanner = new Scanner(System.in);
    static List<Book> books = new ArrayList<>();
    static List<Order> orders = new ArrayList<>();
    static List<Customer> customers = new ArrayList<>();
    static List<Employee> employees = new ArrayList<>();

    public static void main(String[] args) {
        initData();
        System.out.println(getBookById(7));
        System.out.println("Введіть айді книги: ");
        Book findBook = getBookById(scanner.nextInt());
        if (findBook != null) {
            System.out.println("Знайдена книга: " + findBook.getTitle());
        } else {
            System.out.println("Книга не знайдена");
        }


        System.out.println("Загальна кількість проданних книг: " + getTotalSoldBooks());


        System.out.println("Введіть айді книги: ");
        Book findBook2 = getBookById(scanner.nextInt());
        if (findBook2 != null) {
            System.out.println("Вартість цієї книги: " + findBook2.getPrice());
        } else {
            System.out.println("Книга не знайдена");
        }

        double totalPrice = getTotalPrice();
        System.out.println("Вартість всіх проданих книг: " + totalPrice);
    }
    public static double getTotalPrice() {
        double totalPrice = 0;
        for (Order order : orders) {
            for (int bookId : order.getBooks()) {
                Book book = getBookById(bookId);
                if (book != null) {
                    totalPrice += book.getPrice();
                }
            }
        }
        return totalPrice;
    }

    public static int getTotalSoldBooks() {
        int totalSoldBooks = 0;
        for (Order order : orders) {
            totalSoldBooks += order.getBooks().length;
        }
        return totalSoldBooks;
    }

    public static Book getBookById(int id) {
        Book current = null;
        for (Book book:books) {
            if (book.getId() == id) {
                current = book;
                break;
            }
        }
        return current;
    }
    public static void initData() {
        //employees
        employees.add(new Employee(1,"Vasya", 26));
        employees.add(new Employee(2,"Tolik", 30));
        employees.add(new Employee(3,"Oleg", 19));

        //customers
        customers.add(new Customer(1,"Alik", 20));
        customers.add(new Customer(2,"Anton", 21));
        customers.add(new Customer(3,"Zhenya", 26));
        customers.add(new Customer(4,"Vitya", 18));
        customers.add(new Customer(5,"Sveta", 29));

        //Books
        books.add(new Book(1, "The Shining", "Stephen King",360, BookGenre.HORROR));
        books.add(new Book(2, "Dracula", "Brem Stocker",399.99, BookGenre.HORROR));

        books.add(new Book(3, "Adrenalin", "Zlatan Ibragimovich",699.99, BookGenre.SPORT));
        books.add(new Book(4, "Беззаперечна правда", "Mike Tyson",459.99, BookGenre.SPORT));

        books.add(new Book(5, "Short history of art", "Susi Hodge",299.99, BookGenre.SCIENCE));
        books.add(new Book(6, "Info Rock", "Ernesto Asante",159.99, BookGenre.SCIENCE));

        books.add(new Book(7, "The Lord of The Rings", "John Tolkien",999.99, BookGenre.FANTASY));
        books.add(new Book(8, "The Witcher", "Andrzej Sapkowski",1159.99, BookGenre.FANTASY));

        //orders
        orders.add(new Order(1, 1, 1, new int[]{4, 2}));
        orders.add(new Order(2, 1, 2, new int[]{1, 8}));

        orders.add(new Order(3, 2, 3, new int[]{7, 3, 4}));
        orders.add(new Order(4, 2, 4, new int[]{1, 7, 6}));

        orders.add(new Order(5, 3, 5, new int[]{7}));
    }
}
