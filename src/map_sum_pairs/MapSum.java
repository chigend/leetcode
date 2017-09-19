package map_sum_pairs;

import java.util.HashMap;
import java.util.Map;

public class MapSum {

    private Node root;

    private Map<String, Integer> map;
    public MapSum() {
        root = new Node();
        map = new HashMap<>();
    }

    public void insert(String key, int val) {
        Integer previous = map.getOrDefault(key, 0);
        map.put(key, val);
        insert0(key.toCharArray(), root, previous, val);
    }

    private void insert0(char[]chars, Node root,int previous, int val) {
        for (int i = 0; i < chars.length; i++) {
            int index = chars[i] - 'a';
            Node child = root.childs[index];
            if (child == null) {
                root.childs[index] = new Node(val);
            }else {
                child.sum += -previous + val;
            }
            root = root.childs[index];
        }
    }

    public int sum(String prefix) {
        return search(root, prefix.toCharArray());
    }

    private int search(Node root, char[]chars) {
        for (int i = 0; i < chars.length; i++) {
            int index = chars[i] - 'a';
            Node child = root.childs[index];
            if (child == null) {
                return 0;
            }
            root = child;
        }
        return root.sum;
    }
    class Node{
        int sum;
        Node[] childs;

        public Node() {
            this.childs = new Node[26];
        }

        public Node(int sum) {
            this();
            this.sum = sum;
        }
    }
}
