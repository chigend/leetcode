package tool;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import model.ListNode;

public class ListNodeTestCaseTransformer {

    public static ListNode transform(String s) {
        String[] split = s.replaceAll("\\[", "").replaceAll("\\]", "").split(",");
        List<ListNode> list = Arrays.stream(split).map(Integer::new).map(ListNode::new).collect(Collectors.toList());
        for (int i = 1; i < list.size(); i++) {
            list.get(i - 1).next = list.get(i);
        }
        return list.get(0);
    }

}
