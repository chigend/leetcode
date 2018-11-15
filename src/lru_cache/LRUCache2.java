package lru_cache;

import java.util.HashMap;

class LRUCache2 {

    private int capacity;

    private HashMap<Integer, Node> cache;

    private Node fakeHead;

    private Node fakeTail;

    public LRUCache2(int capacity) {
        this.capacity = capacity;
        cache = new HashMap<>();
        fakeHead = new Node();
        fakeTail = new Node();
        fakeHead.next = fakeTail;
        fakeTail.prev = fakeHead;
    }

    private Node get0(int key){
        Node node = cache.get(key);
        if (node != null) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
            insertToLast(node);
        }
        return node;
    }

    private void insertToLast(Node node) {
        fakeTail.prev.next = node;
        node.prev = fakeTail.prev;
        node.next = fakeTail;
        fakeTail.prev = node;
    }

    public int get(int key) {
        Node node = get0(key);
        return node == null ? -1 : node.val;
    }

    public void put(int key, int value) {
        Node node = get0(key);
        if (node == null) {
            Node newNode = new Node(key, value);
            insertToLast(newNode);
            cache.put(key, newNode);
        }else {
            node.val = value;
        }

        if (cache.size() > capacity) {
            Node evict = fakeHead.next;
            fakeHead.next = evict.next;
            evict.next.prev = fakeHead;
            cache.remove(evict.key);
        }
    }
}


