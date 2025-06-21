import java.util.Arrays;

public class Library {

    public static Book linearSearch(Book[] books, String targetTitle) {
        for (Book book : books) {
            if (book.title.equalsIgnoreCase(targetTitle)) {
                return book;
            }
        }
        return null;
    }

    public static Book binarySearch(Book[] books, String targetTitle) {
        int low = 0, high = books.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            int result = books[mid].title.compareToIgnoreCase(targetTitle);
            if (result == 0) return books[mid];
            else if (result < 0) low = mid + 1;
            else high = mid - 1;
        }
        return null;
    }

    public static void sortBooksByTitle(Book[] books) {
        Arrays.sort(books, (a, b) -> a.title.compareToIgnoreCase(b.title));
    }

    public static void main(String[] args) {
        Book[] books = new Book[] {
                new Book(1, "Java Programming", "James Gosling"),
                new Book(2, "C++ Primer", "Stanley Lippman"),
                new Book(3, "Python Crash Course", "Eric Matthes"),
                new Book(4, "Algorithms", "Robert Sedgewick")
        };

        // Linear Search
        System.out.println("Linear Search for 'C++ Primer':");
        Book found1 = linearSearch(books, "C++ Primer");
        if (found1 != null) found1.display();
        else System.out.println("Book not found.");

        // Binary Search
        System.out.println("\nSorting books for Binary Search...");
        sortBooksByTitle(books);

        System.out.println("Binary Search for 'Algorithms':");
        Book found2 = binarySearch(books, "Algorithms");
        if (found2 != null) found2.display();
        else System.out.println("Book not found.");
    }
}

