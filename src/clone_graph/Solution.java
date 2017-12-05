package clone_graph;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        UndirectedGraphNode node0 = new UndirectedGraphNode(0);
        UndirectedGraphNode node1 = new UndirectedGraphNode(1);
        UndirectedGraphNode node2 = new UndirectedGraphNode(2);
        UndirectedGraphNode node3 = new UndirectedGraphNode(3);
        UndirectedGraphNode node4 = new UndirectedGraphNode(4);
        UndirectedGraphNode node5 = new UndirectedGraphNode(5);
        node0.neighbors = Arrays.asList(node1, node5);
        node1.neighbors = Arrays.asList(node2, node5);
        node2.neighbors.add(node3);
        node3.neighbors = Arrays.asList(node4, node4);
        node4.neighbors = Arrays.asList(node5, node5);
        UndirectedGraphNode res = cloneGraph(node0);
        System.out.println(res);
    }

    public static UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) {
            return null;
        }
        Map<Integer, UndirectedGraphNode> map = new HashMap<>();
        LinkedList<UndirectedGraphNode> nodes = new LinkedList<>();
        nodes.add(node);
        while (!nodes.isEmpty()) {
            int size = nodes.size();
            for (int i = 0; i < size; i++) {
                UndirectedGraphNode cur = nodes.removeFirst();
                UndirectedGraphNode copy = new UndirectedGraphNode(cur.label);
                map.put(copy.label, copy);
                for(UndirectedGraphNode neibor : cur.neighbors) {
                    if (!map.containsKey(neibor.label)) {
                        nodes.add(neibor);
                    }
                }
            }
        }
        nodes.add(node);
        Set<Integer> visited = new HashSet<>();
        while (!nodes.isEmpty()) {
            int size = nodes.size();
            for (int i = 0; i < size; i++) {
                UndirectedGraphNode cur = nodes.removeFirst();
                visited.add(cur.label);
                UndirectedGraphNode copy = map.get(cur.label);
                for (UndirectedGraphNode neibor : cur.neighbors) {
                    copy.neighbors.add(map.get(neibor.label));
                }
                for(UndirectedGraphNode neibor : cur.neighbors) {
                    if (visited.add(neibor.label)) {
                        nodes.add(neibor);
                    }
                }
            }
        }
        return map.get(node.label);
    }
}
