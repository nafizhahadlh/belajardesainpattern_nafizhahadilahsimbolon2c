package Percobaan2;

public class App {
    public static void main(String[] args) throws Exception {
        BookRepo bookRepo = new BookRepository();
        AuthorRepo authorRepo = new AuthorRepository();
        AuthorService authorService = new AuthorService(authorRepo);
        BookService bookService = new BookService(bookRepo, authorService);
        BookSummaryService bookSummaryService = new BookSummaryService(bookRepo);

        // Save some books
        authorService.saveAuthor(1, "Author 1");
        authorService.saveAuthor(2, "Author 2");

        bookService.saveBook(1, "Book 1", "Publisher 1");
        bookService.saveBook(2, "Book 2", "Publisher 2");
        bookService.saveBook(1, "Book 3", "Publisher 3");

        // Print summary
        BookReq req = new BookReq();
        req.setGrouping("author");
        bookSummaryService.printSummary(req);
    }
}
