package Percobaan3;

public class Main {
    public static void main(String[] args) {
        try {
            // Inisialisasi BookRepo
            BookRepo bookRepo = new BookRepo();

            // Inisialisasi layanan BookSummaryService
            BookSummaryService service = new BookSummaryService(bookRepo);

            // Membuat permintaan ringkasan buku
            BookReq req = new BookReq();
            req.setGrouping("category"); // Pilihan pengelompokan (bisa diganti dengan "dateReleased" atau "author")

            // Mencetak ringkasan buku
            service.printSummary(req);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
