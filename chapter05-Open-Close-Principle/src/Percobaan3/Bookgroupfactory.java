package Percobaan3;

// Interface for the strategy pattern
interface BookGroupStrategy {
    BookSummary getBookSummary(BookReq req) throws Exception;
}

// Example classes implementing BookGroupStrategy
class BookSummaryByCategory implements BookGroupStrategy {
    private final BookRepo bookRepo;

    public BookSummaryByCategory(BookRepo bookRepo) {
        this.bookRepo = bookRepo;
    }

    @Override
    public BookSummary getBookSummary(BookReq req) throws Exception {
        // Implementation for getting book summary by category
        return bookRepo.getSummaryByCategory(req);
    }
}

class BookSummaryByReleasedDate implements BookGroupStrategy {
    private final BookRepo bookRepo;

    public BookSummaryByReleasedDate(BookRepo bookRepo) {
        this.bookRepo = bookRepo;
    }

    @Override
    public BookSummary getBookSummary(BookReq req) throws Exception {
        // Implementation for getting book summary by released date
        return bookRepo.getSummaryByReleasedDate(req);
    }
}

class BookSummaryByAuthor implements BookGroupStrategy {
    private final BookRepo bookRepo;

    public BookSummaryByAuthor(BookRepo bookRepo) {
        this.bookRepo = bookRepo;
    }

    @Override
    public BookSummary getBookSummary(BookReq req) throws Exception {
        // Implementation for getting book summary by author
        return bookRepo.getSummaryByAuthor(req);
    }
}

// BookGroupFactory class
class BookGroupFactory {
    private final BookRepo bookRepo;

    public BookGroupFactory(BookRepo bookRepo) {
        this.bookRepo = bookRepo;
    }

    public BookGroupStrategy buildStrategy(String grouping) throws Exception {
        switch (grouping) {
            case "category":
                return new BookSummaryByCategory(bookRepo);
            case "dateReleased":
                return new BookSummaryByReleasedDate(bookRepo);
            case "author":
                return new BookSummaryByAuthor(bookRepo);
            default:
                throw new Exception("No grouping found");
        }
    }
}

// BookSummaryService class
class BookSummaryService {
    private final BookRepo bookRepo;

    public BookSummaryService(BookRepo bookRepo) {
        this.bookRepo = bookRepo;
    }

    public void printSummary(BookReq req) throws Exception {
        BookGroupFactory bookGroupFactory = new BookGroupFactory(bookRepo);
        BookGroupStrategy strategy = bookGroupFactory.buildStrategy(req.getGrouping());

        BookSummary books = strategy.getBookSummary(req);
        System.out.println("groupName = " + books.getGroupName());
        System.out.println("total = " + books.getTotalBook());
        System.out.println("sum price = " + books.getSumBookPrice());
    }
}

// Example classes to support the main functionality (these would need proper implementation)
class BookRepo {
    public BookSummary getSummaryByCategory(BookReq req) {
        // Dummy implementation
        return new BookSummary("category", 100, 2000.0);
    }

    public BookSummary getSummaryByReleasedDate(BookReq req) {
        // Dummy implementation
        return new BookSummary("dateReleased", 50, 1500.0);
    }

    public BookSummary getSummaryByAuthor(BookReq req) {
        // Dummy implementation
        return new BookSummary("author", 30, 1000.0);
    }
}

class BookReq {
    private String grouping;

    public String getGrouping() {
        return grouping;
    }

    public void setGrouping(String grouping) {
        this.grouping = grouping;
    }
}

class BookSummary {
    private String groupName;
    private int totalBook;
    private double sumBookPrice;

    public BookSummary(String groupName, int totalBook, double sumBookPrice) {
        this.groupName = groupName;
        this.totalBook = totalBook;
        this.sumBookPrice = sumBookPrice;
    }

    public String getGroupName() {
        return groupName;
    }

    public int getTotalBook() {
        return totalBook;
    }

    public double getSumBookPrice() {
        return sumBookPrice;
    }
}
