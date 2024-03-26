public class Main {
    public static void main(String[] args) {
        // Membuat objek MallardDuck
        MallardDuck mallardDuck = new MallardDuck();
        System.out.println("Mallard Duck:");
        mallardDuck.sound(); // Memanggil metode bersuara MallardDuck
        mallardDuck.fly();   // Memanggil metode terbang MallardDuck

        // Membuat objek RedheadDuck
        RedheadDuck redheadDuck = new RedheadDuck();
        System.out.println("Redhead Duck:");
        redheadDuck.sound(); // Memanggil metode bersuara RedheadDuck
        redheadDuck.fly();   // Memanggil metode terbang RedheadDuck
    }
}
