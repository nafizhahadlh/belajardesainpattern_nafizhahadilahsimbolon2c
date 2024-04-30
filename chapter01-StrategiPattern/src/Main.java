//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Mahasiswa mahasiswa = new Mahasiswa();
        mahasiswa.nama = "Nafizhah";
        mahasiswa.NIM = "2022573010071";
        System.out.println("Nama Mahasiswa :"+mahasiswa.nama);
        System.out.println("NIM Mahasiswa :"+mahasiswa.NIM);

        Dosen dosen = new Dosen();
        dosen.nama = "Sarah";
        dosen.NIP = "1990172210390";
        System.out.println("Nama Dosen :"+dosen.nama);
        System.out.println("NIP Dosen :"+dosen.NIP);

        Pinguin pinguin = new Pinguin();
        pinguin.nama = "Lala";
        pinguin.warna = "Putih";

        System.out.println("Nama Pinguin: " + pinguin.nama);
        System.out.println("Warna Pinguin: " + pinguin.warna);
        pinguin.swim();
        System.out.println();

        Elang elang = new Elang();
        elang.nama = "Max";
        elang.warna = "Hitam";

        System.out.println("Nama Elang: " + elang.nama);
        System.out.println("Warna Elang: " + elang.warna);
        elang.terbang();

        Sepeda Sepeda = new Sepeda();
        System.out.println("Sepeda");
        Sepeda.bergerak();
        Sepeda.berhenti();

        System.out.println();
        System.out.println("Gerakan: " + Sepeda.bergerak);
        System.out.println("Cara Berhenti: " + Sepeda.berhenti);

    }
}