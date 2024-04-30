public class Unggas {
        public String nama;
        public String warna;

        void display(){
            System.out.println(this.nama);
            System.out.println(this.warna);
        }
    }
    class Pinguin extends Unggas{
        void swim(){
            System.out.println("Berenang");
        }
    }
    class Elang extends Unggas{
        void terbang(){
            System.out.println ("Terbang");
        }
    }
