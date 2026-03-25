package Java.SmartBox;

public class SmartBox<T> {

    private T element;

    public SmartBox(T element) {
        this.element = element;
    }

    public T getItem() {
        return element;
    }

    public void setItem(T element) {
        this.element = element;
    }

    public boolean compareType(T element) {
        return element.getClass().equals(this.element.getClass());
    }

    public static void printDetails(SmartBox<?> box) {
        System.out.println(box.getItem() + " " + box.getClass());
    }

}
