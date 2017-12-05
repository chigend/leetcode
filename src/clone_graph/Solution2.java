package clone_graph;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution2 {
    public static Map<Integer, UndirectedGraphNode> map;

    public static void main(String[] args) {
        UndirectedGraphNode node0 = new UndirectedGraphNode(0);
        UndirectedGraphNode node1 = new UndirectedGraphNode(1);
        UndirectedGraphNode node2 = new UndirectedGraphNode(2);
        UndirectedGraphNode node3 = new UndirectedGraphNode(3);
        UndirectedGraphNode node4 = new UndirectedGraphNode(4);
        UndirectedGraphNode node5 = new UndirectedGraphNode(5);
        node0.neighbors = Arrays.asList(node0, node0);
        //        node1.neighbors = Arrays.asList(node2, node5);
        //        node2.neighbors.add(node3);
        //        node3.neighbors = Arrays.asList(node4, node4);
        //        node4.neighbors = Arrays.asList(node5, node5);
        UndirectedGraphNode res = cloneGraph(node0);
        System.out.println(res);
    }

    public static UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) {
            return null;
        }
        map = new HashMap<>();
        return cloneGraph0(node);
    }

    public static UndirectedGraphNode cloneGraph0(UndirectedGraphNode node) {
        if (map.containsKey(node.label)) {
            return map.get(node.label);
        }
        UndirectedGraphNode copy = new UndirectedGraphNode(node.label);
        map.put(node.label, copy);
        for (UndirectedGraphNode neibor : node.neighbors) {
            UndirectedGraphNode copyNeibor = cloneGraph0(neibor);
            copy.neighbors.add(copyNeibor);
        }
        return copy;
    }
}
