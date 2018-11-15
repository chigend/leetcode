package lru_cache;

import java.util.HashMap;

class LRUCache {

    private int capacity;

    private HashMap<Integer, Node> cache;

    private Node fakeHead;

    private Node tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        cache = new HashMap<>();
        fakeHead = new Node();
        tail = fakeHead;
    }

    private Node get0(int key){
        Node node = cache.get(key);
        if (node != null && tail != node) {
            node.prev.next = node.next;
            if (node.next != null) {
                node.next.prev = node.prev;
            }
            tail.next = node;
            node.prev = tail;
            tail = node;
            node.next = null;
        }
        return node;
    }

    public int get(int key) {
        Node node = get0(key);
        return node == null ? -1 : node.val;
    }

    public void put(int key, int value) {
        Node node = get0(key);
        if (node == null) {
            Node newNode = new Node(key, value);
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
            cache.put(key, newNode);
        }else {
            node.val = value;
        }

        if (cache.size() > capacity) {
            Node evict = fakeHead.next;
            fakeHead.next = evict.next;
            if (evict.next != null) {
                evict.next.prev = fakeHead;
            }
            cache.remove(evict.key);
            tail = tail == evict ? evict.prev : tail;
        }
    }
}

