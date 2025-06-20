public class Main {
    public static void main(String[] args) {
        Computer basicComputer = new Computer.Builder("Intel i5", "8GB").build();

        Computer gamingComputer = new Computer.Builder("Intel i9", "32GB")
            .setStorage("1TB SSD")
            .setGraphicsCard("NVIDIA RTX 4080")
            .setOperatingSystem("Windows 11")
            .build();

        Computer developerLaptop = new Computer.Builder("AMD Ryzen 7", "16GB")
            .setStorage("512GB SSD")
            .setOperatingSystem("Ubuntu 22.04")
            .build();

        System.out.println("=== Basic Computer ===");
        basicComputer.displayConfiguration();

        System.out.println("\n=== Gaming Computer ===");
        gamingComputer.displayConfiguration();

        System.out.println("\n=== Developer Laptop ===");
        developerLaptop.displayConfiguration();
    }
}
