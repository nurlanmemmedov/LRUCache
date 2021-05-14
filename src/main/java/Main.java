public class Main {
    public static void main(String[] args) {
        LRUCache<Integer> cache = new LRUCache<>(2);
        cache.addElement(5);
        cache.addElement(6);
        cache.addElement(7);
        cache.addElement(8);
        cache.addElement(9);

        cache.printAll();
    }
}