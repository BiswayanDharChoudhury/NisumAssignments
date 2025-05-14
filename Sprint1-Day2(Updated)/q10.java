import java.util.*;

class Movie {
    String title;
    String director;
    String genre;
    int releaseYear;
    double rating;

    public Movie(String title, String director, String genre, int releaseYear, double rating) {
        this.title = title;
        this.director = director;
        this.genre = genre;
        this.releaseYear = releaseYear;
        this.rating = rating;
    }

    @Override
    public String toString() {
        return String.format("| %-25s | %-15s | %-10s | %-12d | %-6.1f |", title, director, genre, releaseYear, rating);
    }
}

public class q10 {
    private static final ArrayList<Movie> movieCollection = new ArrayList<>();

    // Add a new movie to the collection
    public static void addMovie(String title, String director, String genre, int releaseYear, double rating) {
        Movie movie = new Movie(title, director, genre, releaseYear, rating);
        movieCollection.add(movie);
        System.out.println("Movie added successfully.");
    }

    // Remove a movie from the collection
    public static void removeMovie(String title) {
        movieCollection.removeIf(movie -> movie.title.equalsIgnoreCase(title));
        System.out.println("Movie removed successfully.");
    }

    // Filter movies by genre
    public static void filterByGenre(String genre) {
        System.out.println("\nMovies of genre: " + genre);
        for (Movie movie : movieCollection) {
            if (movie.genre.equalsIgnoreCase(genre)) {
                System.out.println(movie);
            }
        }
    }

    // Filter movies by director
    public static void filterByDirector(String director) {
        System.out.println("\nMovies directed by: " + director);
        for (Movie movie : movieCollection) {
            if (movie.director.equalsIgnoreCase(director)) {
                System.out.println(movie);
            }
        }
    }

    // Filter movies by release year
    public static void filterByReleaseYear(int year) {
        System.out.println("\nMovies released in " + year + ":");
        for (Movie movie : movieCollection) {
            if (movie.releaseYear == year) {
                System.out.println(movie);
            }
        }
    }

    // Sort movies by title
    public static void sortByTitle() {
        movieCollection.sort(Comparator.comparing(movie -> movie.title));
        displayMovies();
    }

    // Sort movies by release year
    public static void sortByYear() {
        movieCollection.sort(Comparator.comparingInt(movie -> movie.releaseYear));
        displayMovies();
    }

    // Sort movies by rating
    public static void sortByRating() {
        movieCollection.sort(Comparator.comparingDouble(movie -> movie.rating));
        displayMovies();
    }

    // Display all movies in a formatted table
    public static void displayMovies() {
        System.out.println("\n--- Movie Collection ---");
        System.out.println("| Title                   | Director       | Genre     | Year        | Rating |");
        System.out.println("|-------------------------|----------------|-----------|-------------|--------|");
        for (Movie movie : movieCollection) {
            System.out.println(movie);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int option;

        do {
            System.out.println("\n--- Movie Collection Manager ---");
            System.out.println("1. Add Movie");
            System.out.println("2. Remove Movie");
            System.out.println("3. Display All Movies");
            System.out.println("4. Filter by Genre");
            System.out.println("5. Filter by Director");
            System.out.println("6. Filter by Release Year");
            System.out.println("7. Sort by Title");
            System.out.println("8. Sort by Year");
            System.out.println("9. Sort by Rating");
            System.out.println("10. Exit");
            System.out.print("Choose an option (1-10): ");
            option = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (option) {
                case 1:
                    System.out.print("Enter movie title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter director name: ");
                    String director = scanner.nextLine();
                    System.out.print("Enter genre: ");
                    String genre = scanner.nextLine();
                    System.out.print("Enter release year: ");
                    int releaseYear = scanner.nextInt();
                    System.out.print("Enter rating (0.0 to 10.0): ");
                    double rating = scanner.nextDouble();
                    addMovie(title, director, genre, releaseYear, rating);
                    break;

                case 2:
                    System.out.print("Enter movie title to remove: ");
                    String removeTitle = scanner.nextLine();
                    removeMovie(removeTitle);
                    break;

                case 3:
                    displayMovies();
                    break;

                case 4:
                    System.out.print("Enter genre to filter by: ");
                    String filterGenre = scanner.nextLine();
                    filterByGenre(filterGenre);
                    break;

                case 5:
                    System.out.print("Enter director name to filter by: ");
                    String filterDirector = scanner.nextLine();
                    filterByDirector(filterDirector);
                    break;

                case 6:
                    System.out.print("Enter release year to filter by: ");
                    int filterYear = scanner.nextInt();
                    filterByReleaseYear(filterYear);
                    break;

                case 7:
                    sortByTitle();
                    break;

                case 8:
                    sortByYear();
                    break;

                case 9:
                    sortByRating();
                    break;

                case 10:
                    System.out.println("Exiting Movie Collection Manager.");
                    break;

                default:
                    System.out.println("Invalid option. Please choose between 1 and 10.");
            }
        } while (option != 10);

        scanner.close();
    }
}
