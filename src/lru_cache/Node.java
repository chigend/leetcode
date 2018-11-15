package lru_cache;

public class Node{
    int val;
    int key;
    Node next;
    Node prev;

    public Node() {
    }

    public Node(int key, int val) {
        this.key = key;
        this.val = val;
    }
}