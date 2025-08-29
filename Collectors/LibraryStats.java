import java.util.*;
import java.util.stream.*;

class Book {
    private String genre;
    private int pages;
    Book(String genre, int pages) { this.genre = genre; this.pages = pages; }
    public String getGenre() { return genre; }
    public int getPages() { return pages; }
}

public class LibraryStats {
    public static void main(String[] args) {
        List<Book> books = Arrays.asList(
            new Book("Fiction", 300),
            new Book("Fiction", 500),
            new Book("Science", 200),
            new Book("Science", 400)
        );
        Map<String, IntSummaryStatistics> statsByGenre = books.stream()
            .collect(Collectors.groupingBy(Book::getGenre,
                     Collectors.summarizingInt(Book::getPages)));
        System.out.println(statsByGenre);
    }
}
