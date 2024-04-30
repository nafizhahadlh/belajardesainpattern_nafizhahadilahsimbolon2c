package Percobaan2;
public class Main {
    public static void main(String[] args) {
        // Membuat subjek (StockSystem) dan beberapa observer (Customer)
        StockSystem stockSystem = new StockSystem("Buku Java", 10);
        StockObserver customer1 = new Customer("Andi");
        StockObserver customer2 = new Customer("Budi");

        // Pelanggan mendaftar sebagai pengamat
        stockSystem.registerObserver(customer1);
        stockSystem.registerObserver(customer2);

        // Mengubah jumlah stok, ini akan memberi tahu pelanggan yang berlangganan
        stockSystem.setStockQuantity(8);
    }
}