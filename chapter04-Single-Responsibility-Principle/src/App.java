import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class App {
    public static void main(String[] args) throws Exception {
        BookRepo bookRepo = new BookRepository();
        AuthorRepo authorRepo = new AuthorRepository();
        AuthorService authorService = new AuthorService(authorRepo);
        BookService bookService = new BookService(bookRepo, authorService);

        bookService.saveBook(1, "Book 1", "Publisher 1");
        bookService.saveBook(2, "Book 2", null);
        bookService.saveBook(1, "Book 3", "Publisher 3");

        Map<Integer, List<Book>> booksByAuthor = bookService.releaseBooksByAuthor(Arrays.asList(1, 2, 3));
        System.out.println(booksByAuthor);
    }
}