package tool;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.stream.Stream;

import model.TreeNode;

public class TreeNodeTestCaseTransformer {

    public static void main(String[] args) {
        TreeNode transform = TreeNodeTestCaseTransformer.transformTreeNode("[1,null,1,1,1,null,null,1,1,null,1,null,null,null,1,null,1]");
        System.out.println(transform);
    }

    public static TreeNode transformTreeNode(String s) {
        String substring = s.substring(1, s.length() - 1);
        String[] svalues = substring.split(",");
        Integer[] values = new Integer[svalues.length];

        for (int i = 0; i < values.length; i++) {
            if ("null".equals(svalues[i])) {
                values[i] = null;
            } else {
                values[i] = Integer.parseInt(svalues[i]);
            }
        }

        if (values.length == 0) {
            return null;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(values[0]);
        queue.offer(root);
        int index = 1;
        while (index < values.length && !queue.isEmpty()) {
            TreeNode treeNode = queue.removeFirst();
            Integer value = values[index++];
            if (value != null) {
                treeNode.left = new TreeNode(value);
                queue.offer(treeNode.left);
            }
            value = values[index++];
            if (value != null) {
                treeNode.right = new TreeNode(value);
                queue.offer(treeNode.right);
            }
        }
        return root;

    }
}
