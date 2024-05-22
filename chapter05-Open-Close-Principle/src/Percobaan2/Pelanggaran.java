package Percobaan2;

import java.util.*;
import java.time.LocalDate;

// Interfaces
interface BookRepo {
    Book findByAuthorIdAndBookName(int authorId, String bookName);
    void save(Book book);
    List<Book> findByBookIds(List<Integer> bookIds);
    long countBookGroupByCategory(BookReq req);
    long sumBookPriceGroupByCategory(BookReq req);
    long countBookGroupByAuthor(BookReq req);
    long sumBookPriceGroupByAuthor(BookReq req);
    long countBookGroupByDateReleased(BookReq req);
    long sumBookPriceGroupByDateReleased(BookReq req);
}

interface AuthorRepo {
    boolean checkAuthorId(int authorId);
    Author save(Author author);
}

interface BookGroupStrategy {
    BookSummary getBookSummary(BookReq req);
}

// Entities
class Book {
    private int id;
    private int authorId;
    private String name;
    private String publisherName;
    private LocalDate released;

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public int getAuthorId() { return authorId; }
    public void setAuthorId(int authorId) { this.authorId = authorId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getPublisherName() { return publisherName; }
    public void setPublisherName(String publisherName) { this.publisherName = publisherName; }

    public LocalDate getReleased() { return released; }
    public void setReleased(LocalDate released) { this.released = released; }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", authorId=" + authorId +
                ", name='" + name + '\'' +
                ", publisherName='" + publisherName + '\'' +
                ", released=" + released +
                '}';
    }
}

class Author {
    private int authorId;
    private String name;

    public int getAuthorId() { return authorId; }
    public void setAuthorId(int authorId) { this.authorId = authorId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
}

class BookReq {
    private String grouping;

    public String getGrouping() { return grouping; }
    public void setGrouping(String grouping) { this.grouping = grouping; }
}

class BookSummary {
    private String groupName;
    private long totalBook;
    private long sumBookPrice;

    public static Builder builder() { return new Builder(); }

    public String getGroupName() { return groupName; }
    public long getTotalBook() { return totalBook; }
    public long getSumBookPrice() { return sumBookPrice; }

    public static class Builder {
        private String groupName;
        private long totalBook;
        private long sumBookPrice;

        public Builder groupName(String groupName) {
            this.groupName = groupName;
            return this;
        }

        public Builder totalBook(long totalBook) {
            this.totalBook = totalBook;
            return this;
        }

        public Builder sumBookPrice(long sumBookPrice) {
            this.sumBookPrice = sumBookPrice;
            return this;
        }

        public BookSummary build() {
            BookSummary summary = new BookSummary();
            summary.groupName = this.groupName;
            summary.totalBook = this.totalBook;
            summary.sumBookPrice = this.sumBookPrice;
            return summary;
        }
    }
}

// Repositories
class BookRepository implements BookRepo {
    private Map<Integer, Book> books = new HashMap<>();
    private static int counter = 0;

    @Override
    public Book findByAuthorIdAndBookName(int authorId, String bookName) {
        for (Book book : books.values()) {
            if (book.getAuthorId() == authorId && book.getName().equals(bookName)) {
                return book;
            }
        }
        return null;
    }

    @Override
    public void save(Book book) {
        int id = generateUniqueId();
        book.setId(id);
        books.put(id, book);
    }

    @Override
    public List<Book> findByBookIds(List<Integer> bookIds) {
        List<Book> foundBooks = new ArrayList<>();
        for (Integer bookId : bookIds) {
            Book book = books.get(bookId);
            if (book != null) {
                foundBooks.add(book);
            }
        }
        return foundBooks;
    }

    private int generateUniqueId() {
        return ++counter;
    }

    @Override
    public long countBookGroupByCategory(BookReq req) {
        // Implementasi logika untuk menghitung buku berdasarkan kategori
        return 0;
    }

    @Override
    public long sumBookPriceGroupByCategory(BookReq req) {
        // Implementasi logika untuk menjumlahkan harga buku berdasarkan kategori
        return 0;
    }

    @Override
    public long countBookGroupByAuthor(BookReq req) {
        // Implementasi logika untuk menghitung buku berdasarkan penulis
        return 0;
    }

    @Override
    public long sumBookPriceGroupByAuthor(BookReq req) {
        // Implementasi logika untuk menjumlahkan harga buku berdasarkan penulis
        return 0;
    }

    @Override
    public long countBookGroupByDateReleased(BookReq req) {
        // Implementasi logika untuk menghitung buku berdasarkan tanggal rilis
        return 0;
    }

    @Override
    public long sumBookPriceGroupByDateReleased(BookReq req) {
        // Implementasi logika untuk menjumlahkan harga buku berdasarkan tanggal rilis
        return 0;
    }
}

class AuthorRepository implements AuthorRepo {
    private Map<Integer, Author> authors = new HashMap<>();

    @Override
    public boolean checkAuthorId(int authorId) {
        return authors.containsKey(authorId);
    }

    @Override
    public Author save(Author author) {
        authors.put(author.getAuthorId(), author);
        return author;
    }
}

// Implementations of strategies
class BookSummaryByCategory implements BookGroupStrategy {
    private final BookRepo bookRepo;

    public BookSummaryByCategory(BookRepo bookRepo) {
        this.bookRepo = bookRepo;
    }

    @Override
    public BookSummary getBookSummary(BookReq req) {
        long total = bookRepo.countBookGroupByCategory(req);
        long sum = bookRepo.sumBookPriceGroupByCategory(req);
        return BookSummary.builder()
                .groupName("By Category")
                .sumBookPrice(sum)
                .totalBook(total)
                .build();
    }
}

class BookSummaryByAuthor implements BookGroupStrategy {
    private final BookRepo bookRepo;

    public BookSummaryByAuthor(BookRepo bookRepo) {
        this.bookRepo = bookRepo;
    }

    @Override
    public BookSummary getBookSummary(BookReq req) {
        long total = bookRepo.countBookGroupByAuthor(req);
        long sum = bookRepo.sumBookPriceGroupByAuthor(req);
        return BookSummary.builder()
                .groupName("By Author")
                .sumBookPrice(sum)
                .totalBook(total)
                .build();
    }
}

class BookSummaryByReleasedDate implements BookGroupStrategy {
    private final BookRepo bookRepo;

    public BookSummaryByReleasedDate(BookRepo bookRepo) {
        this.bookRepo = bookRepo;
    }

    @Override
    public BookSummary getBookSummary(BookReq req) {
        long total = bookRepo.countBookGroupByDateReleased(req);
        long sum = bookRepo.sumBookPriceGroupByDateReleased(req);
        return BookSummary.builder()
                .groupName("By Release Date")
                .sumBookPrice(sum)
                .totalBook(total)
                .build();
    }
}

// Services
class BookSummaryService {
    private final BookRepo bookRepo;

    public BookSummaryService(BookRepo bookRepo) {
        this.bookRepo = bookRepo;
    }

    public void printSummary(BookReq req) throws Exception {
        BookGroupStrategy strategy;
        switch (req.getGrouping()) {
            case "category":
                strategy = new BookSummaryByCategory(bookRepo);
                break;
            case "dateReleased":
                strategy = new BookSummaryByReleasedDate(bookRepo);
                break;
            case "author":
                strategy = new BookSummaryByAuthor(bookRepo);
                break;
            default:
                throw new Exception("No grouping found");
        }

        BookSummary books = strategy.getBookSummary(req);
        System.out.println("groupName = " + books.getGroupName());
        System.out.println("total = " + books.getTotalBook());
        System.out.println("sum price = " + books.getSumBookPrice());
    }
}

// Main class
class AuthorService {
    private final AuthorRepo authorRepo;

    public AuthorService(AuthorRepo authorRepo) {
        this.authorRepo = authorRepo;
    }

    public void saveAuthor(int authorId, String name) {
        Author author = new Author();
        author.setAuthorId(authorId);
        author.setName(name);
        authorRepo.save(author);
    }

    public boolean isAuthorExist(int authorId) {
        return authorRepo.checkAuthorId(authorId);
    }
}

class BookService {
    private final BookRepo bookRepo;
    private final AuthorService authorService;

    public BookService(BookRepo bookRepo, AuthorService authorService) {
        this.bookRepo = bookRepo;
        this.authorService = authorService;
    }

    public void saveBook(int authorId, String bookName, String publisherName) {
        if (!authorService.isAuthorExist(authorId)) {
            throw new IllegalArgumentException("Author with ID " + authorId + " does not exist.");
        }

        Book book = new Book();
        book.setAuthorId(authorId);
        book.setName(bookName);
        book.setPublisherName(publisherName);
        bookRepo.save(book);
    }

    public List<Book> findBooks(List<Integer> bookIds) {
        return bookRepo.findByBookIds(bookIds);
    }
}
