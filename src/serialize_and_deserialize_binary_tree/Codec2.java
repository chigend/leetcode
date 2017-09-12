package serialize_and_deserialize_binary_tree;

import model.TreeNode;

public class Codec2 {

    public int cursor = -1;
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serialize0(root, sb);
        return sb.deleteCharAt(sb.length() - 1).toString();
    }

    private void serialize0(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append('#').append(",");
            return;
        }
        sb.append(root.val).append(",");
        serialize0(root.left, sb);
        serialize0(root.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] values = data.split(",");
        return deserialize0(values);
    }
    public TreeNode deserialize0(String[] data) {
        if (data[++cursor].equals("#")) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.valueOf(data[cursor]));
        root.left = deserialize0(data);
        root.right = deserialize0(data);
        return root;
    }
}
