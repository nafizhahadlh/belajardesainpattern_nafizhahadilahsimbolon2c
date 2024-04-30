package Percobaan2;
import java.util.ArrayList;
import java.util.List;

// Subject interface
interface StockSubject {
    void registerObserver(StockObserver observer);
    void removeObserver(StockObserver observer);
    void notifyObservers();
}

// Concrete subject
class StockSystem implements StockSubject {
    private List<StockObserver> observers;
    private String productName;
    private int stockQuantity;

    public StockSystem(String productName, int initialQuantity) {
        this.observers = new ArrayList<>();
        this.productName = productName;
        this.stockQuantity = initialQuantity;
    }

    public void setStockQuantity(int newQuantity) {
        this.stockQuantity = newQuantity;
        notifyObservers();
    }

    @Override
    public void registerObserver(StockObserver observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(StockObserver observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (StockObserver observer : observers) {
            observer.update(productName, stockQuantity);
        }
    }
}

// Observer interface
interface StockObserver {
    void update(String productName, int stockQuantity);
}

// Concrete observer
class Customer implements StockObserver {
    private String name;

    public Customer(String name) {
        this.name = name;
    }

    @Override
    public void update(String productName, int stockQuantity) {
        System.out.println(name + ", produk " + productName + " tersedia dalam jumlah " + stockQuantity);
    }
}