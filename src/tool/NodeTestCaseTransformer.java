package tool;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import model.ListNode;
import model.Node;

public class NodeTestCaseTransformer {

    public static Node transform(String s) {
        String[] split = s.replaceAll("\\[", "").replaceAll("\\]", "").split(",");
        List<Node> list = Arrays.stream(split).map(Integer::new).map(Node::new).collect(Collectors.toList());
        for (int i = 1; i < list.size(); i++) {
            list.get(i - 1).next = list.get(i);
        }
        list.get(list.size() - 1).next = list.get(0);
        return list.get(0);
    }

}
