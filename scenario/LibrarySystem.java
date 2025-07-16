import java.util.*;

class Book {
    String title;
    String author;

    Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Book)) return false;
        Book b = (Book) o;
        return title.equals(b.title) && author.equals(b.author);
    }

    public int hashCode() {
        return Objects.hash(title, author);
    }

    public String toString() {
        return "\"" + title + "\" by " + author;
    }
}

class BookShelf {
    Map<String, LinkedList<Book>> genreMap = new HashMap<>();
    Map<String, Set<Book>> genreBookSet = new HashMap<>();

    public void addBook(String genre, Book book) {
        genreMap.putIfAbsent(genre, new LinkedList<>());
        genreBookSet.putIfAbsent(genre, new HashSet<>());

        if (!genreBookSet.get(genre).contains(book)) {
            genreMap.get(genre).add(book);
            genreBookSet.get(genre).add(book);
        }
    }

    public void borrowBook(String genre, Book book) {
        if (genreMap.containsKey(genre) && genreMap.get(genre).remove(book)) {
            genreBookSet.get(genre).remove(book);
            System.out.println("Borrowed: " + book);
        } else {
            System.out.println("Book not found.");
        }
    }

    public void returnBook(String genre, Book book) {
        addBook(genre, book);
        System.out.println("Returned: " + book);
    }

    public void displayCatalog() {
        for (String genre : genreMap.keySet()) {
            System.out.println("Genre: " + genre);
            for (Book book : genreMap.get(genre)) {
                System.out.println(" - " + book);
            }
        }
    }
}

public class LibrarySystem {
    public static void main(String[] args) {
        BookShelf shelf = new BookShelf();

        shelf.addBook("Fiction", new Book("1984", "George Orwell"));
        shelf.addBook("Fiction", new Book("Brave New World", "Aldous Huxley"));
        shelf.addBook("Science", new Book("A Brief History of Time", "Stephen Hawking"));

        shelf.displayCatalog();

        shelf.borrowBook("Fiction", new Book("1984", "George Orwell"));
        shelf.returnBook("Fiction", new Book("1984", "George Orwell"));

        shelf.displayCatalog();
    }
}
