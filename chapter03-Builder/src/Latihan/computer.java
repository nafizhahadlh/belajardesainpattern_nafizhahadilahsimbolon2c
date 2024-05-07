package Latihan;
class Main {
    public static void main(String[] args) {
        // Membuat sebuah objek Computer
        Computer computer = new Computer("KomputerSaya", "Intel", "8GB RAM", "512GB SSD");

        // Membuat sebuah objek ComputerSetBuilder\
        ComputerSetBuilder builder = new ComputerSetBuilder();

        // Mengatur komponen-komponen menggunakan builder
        builder.computer(computer);
        builder.keyboard("Keyboard Mekanik");
        builder.mouse("Mouse Wireless");
        builder.speaker("Sistem Suara Surround 5.1");
        builder.monitor("Monitor 27 inci 4K");

        // Mendapatkan ComputerSet yang dihasilkan
        ComputerSet computerSet = builder.getResult();

        // Mendapatkan Computer dari ComputerSet
        Computer computerInSet = computerSet.getComputer();

        // Print out the details of the ComputerSet
        System.out.println("Detail Set Komputer:");
        System.out.println("Komputer:");
        System.out.println("  Nama: " + computerInSet.getName());
        System.out.println("  Processor: " + computerInSet.getProcessor());
        System.out.println("  Memory: " + computerInSet.getMemory());
        System.out.println("  Storage: " + computerInSet.getStorage());
        System.out.println("Keyboard: " + computerSet.getKeyboard());
        System.out.println("Mouse: " + computerSet.getMouse());
        System.out.println("Speaker: " + computerSet.getSpeaker());
        System.out.println("Monitor: " + computerSet.getMonitor());
    }
}

class Computer {
    private String name;
    private String processor;
    private String memory;
    private String storage;

    public Computer(String name, String processor, String memory, String storage) {
        this.name = name;
        this.processor = processor;
        this.memory = memory;
        this.storage = storage;
    }

    public String getName() {
        return name;
    }

    public String getProcessor() {
        return processor;
    }

    public String getMemory() {
        return memory;
    }

    public String getStorage() {
        return storage;
    }
}

class ComputerSetBuilder {
    private ComputerSet computerSet;

    public ComputerSetBuilder() {
        this(new ComputerSet());
    }

    public ComputerSetBuilder(ComputerSet computerSet) {
        this.computerSet = computerSet;
    }

    public void computer(Computer computer) {
        computerSet.setComputer(computer);
    }

    public void keyboard(String keyboard) {
        computerSet.setKeyboard(keyboard);
    }

    public void mouse(String mouse) {
        computerSet.setMouse(mouse);
    }

    public void speaker(String speaker) {
        computerSet.setSpeaker(speaker);
    }

    public void monitor(String monitor) {
        computerSet.setMonitor(monitor);
    }

    public ComputerSet getResult() {
        return computerSet;
    }

    public void resetBuilder() {
        computerSet = new ComputerSet();
    }
}

class ComputerSet {
    private Computer computer;
    private String keyboard, mouse, speaker, monitor;

    public Computer getComputer() {
        return computer;
    }

    public void setComputer(Computer computer) {
        this.computer = computer;
    }

    public String getKeyboard() {
        return keyboard;
    }

    public void setKeyboard(String keyboard) {
        this.keyboard = keyboard;
    }

    public String getMouse() {
        return mouse;
    }

    public void setMouse(String mouse) {
        this.mouse = mouse;
    }

    public String getSpeaker() {
        return speaker;
    }

    public void setSpeaker(String speaker) {
        this.speaker = speaker;
    }

    public String getMonitor() {
        return monitor;
    }

    public void setMonitor(String monitor) {
        this.monitor = monitor;
    }
}