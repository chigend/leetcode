package serialize_and_deserialize_binary_tree;

import java.util.LinkedList;
import java.util.List;

import model.TreeNode;

public class Codec {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        List<TreeNode> nodes = new LinkedList<>();
        nodes.add(root);
        StringBuilder sb = new StringBuilder();
        while (!nodes.isEmpty()) {
            int size = nodes.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = nodes.remove(0);
                if (node == null) {
                    sb.append('#');
                } else {
                    sb.append(node.val);
                    nodes.add(node.left);
                    nodes.add(node.right);
                }
                sb.append(',');
            }
        }
        return sb.deleteCharAt(sb.length() - 1).toString();

    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] values = data.split(",");
        TreeNode root = null;
        if (!values[0].equals("#")) {
            root = new TreeNode(Integer.valueOf(values[0]));
        }
        int cursor = 1;
        List<TreeNode> nodes = new LinkedList<>();
        nodes.add(root);
        while (!nodes.isEmpty()) {
            int size = nodes.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = nodes.remove(0);
                if (node != null) {
                    if (!values[cursor].equals("#")) {
                        node.left = new TreeNode(Integer.valueOf(values[cursor++]));
                        nodes.add(node.left);
                    }
                    if (!values[cursor].equals("#")) {
                        node.right = new TreeNode(Integer.valueOf(values[cursor++]));
                        nodes.add(node.right);
                    }

                }
            }
        }
        return root;
    }
}
