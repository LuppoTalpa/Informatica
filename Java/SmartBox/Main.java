package Java.SmartBox;

public class Main {
    public static void main(String[] args) {
        SmartBox<Integer> box = new SmartBox<>(42);
//        System.out.println(box.compareType("Ciao")); // Dovrebbe stampare false
        System.out.println(box.compareType(100));    // Dovrebbe stampare true
        SmartBox.printDetails(box);
    }
}
