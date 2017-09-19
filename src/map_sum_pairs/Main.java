package map_sum_pairs;

public class Main {
    public static void main(String[] args) {
        MapSum pairs = new MapSum();
        pairs.insert("apple", 3);
        System.out.println(pairs.sum("app"));
        pairs.insert("app", 2);
        pairs.insert("apple", 4);
        System.out.println(pairs.sum("appl"));

    }
}
