package Percobaan1;

public class BookSummaryService{
    private final BookRepo bookRepo;

    public BookSummaryService(BookRepo bookRepo){
        this.bookRepo = bookRepo;
    }

    public void printSummary(BookReq req) throws Exception{
        BookSummary books;
        if("category".equals(req.getGrouping())){
            long total = bookRepo.countBookGroupByCategory(req);
            long sum = bookRepo.sumBookPriceGroupByCategory(req);
            //another huge logic about book group by category
            //...
            //
            books = BookSummary.builder()
                    .groupName("By Category")
                    .sumBookPrice(sum)
                    .totalBook(total)
                    .build();
        } else if("dateReleased".equals(req.getGrouping())){
            long total = bookRepo.countBookGroupByDateReleased(req);
            long sum = bookRepo.sumBookPriceGroupByDateReleased(req);
            //another huge logic about book group by dateReleased
            //...
            //
            books = BookSummary.builder()
                    .groupName("By Release Date")
                    .sumBookPrice(sum)
                    .totalBook(total)
                    .build();
        } else if("author".equals(req.getGrouping())){
            long total = bookRepo.countBookGroupByAuthor(req);
            long sum = bookRepo.sumBookPriceGroupByAuthor(req);
            //another huge logic about book group by author
            //...
            //
            books = BookSummary.builder()
                    .groupName("By Author")
                    .sumBookPrice(sum)
                    .totalBook(total)
                    .build();
        } else {
            throw new Exception("No grouping found");
        }

        System.out.println("groupName = " + books.getGroupName());
        System.out.println("total = " + books.getTotalBook());
        System.out.println("sum price = " + books.getSumBookPrice());
    }
}