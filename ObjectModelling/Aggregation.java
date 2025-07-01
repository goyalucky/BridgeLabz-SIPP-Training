package ObjectModelling;
import java.util.*;

class Book {
    String title;
    String author;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    public void displayBook() {
        System.out.println("Title: " + title + ", Author: " + author);
    }
}

class Library {
    String name;
    List<Book> books;

    public Library(String name) {
        this.name = name;
        this.books = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void displayLibrary() {
        System.out.println("Library: " + name);
        for (Book b : books) {
            b.displayBook();
        }
        System.out.println();
    }
}

public class Aggregation {
    public static void main(String[] args) {
        Book book1 = new Book("Clean Code", "Robert C. Martin");
        Book book2 = new Book("Effective Java", "Joshua Bloch");
        Book book3 = new Book("Head First Java", "Kathy Sierra");

        Library library1 = new Library("City Library");
        Library library2 = new Library("College Library");

        library1.addBook(book1);
        library1.addBook(book2);

        library2.addBook(book2);
        library2.addBook(book3);

        library1.displayLibrary();
        library2.displayLibrary();
    }
}
