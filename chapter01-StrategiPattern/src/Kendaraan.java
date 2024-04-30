public interface Kendaraan {
    public void bergerak();
    public void berhenti();
}
class Sepeda implements Kendaraan{

    @Override
    public void bergerak() {
        System.out.println("Loncat lalu bergelinding");
    }

    @Override
    public void berhenti() {
        System.out.println("Diharapkan memakai sendal yang tebal agar dapat mengerem dengan kencang");
    }
}

