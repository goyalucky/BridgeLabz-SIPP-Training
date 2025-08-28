import java.util.*;

class Movie {
    String title;
    double rating;
    int releaseYear;
    Movie(String title, double rating, int releaseYear) {
        this.title = title;
        this.rating = rating;
        this.releaseYear = releaseYear;
    }
}

public class TopTrendingMovies {
    public static void main(String[] args) {
        List<Movie> movies = Arrays.asList(
            new Movie("Movie A", 8.9, 2024),
            new Movie("Movie B", 9.1, 2023),
            new Movie("Movie C", 8.5, 2022),
            new Movie("Movie D", 9.5, 2024),
            new Movie("Movie E", 8.7, 2024),
            new Movie("Movie F", 9.3, 2023)
        );

        System.out.println("Top 5 Trending Movies:");
        movies.stream()
            .sorted(Comparator.comparingDouble((Movie m) -> m.rating)
                    .thenComparingInt(m -> m.releaseYear).reversed())
            .limit(5)
            .forEach(m -> System.out.println(m.title + " (" + m.rating + ", " + m.releaseYear + ")"));
    }
}
