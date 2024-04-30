public class User {
    public String nama;
    public String email;
    public String alamat;
    public String noHP;
    public int umur;
    public String password;

    void getnama(){
        System.out.println(this.nama);
    }
    void hashpass(){
        System.out.println(this.password);
    }
}
class Mahasiswa extends User{
    public String NIM;
    void getNIM(){
        System.out.println(this.NIM);
    }
}
class Dosen extends User{
    public String NIP;
    public String NIDN;
    void getNIP(){
        System.out.println(this.NIP);
    }
}