package serialize_and_deserialize_binary_tree;

import model.TreeNode;

public class Solution {
    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
                node.left = node2;
                node.right = node3;
                node2.left = node4;
                node2.right = node5;
        node.left = node2;
        node.right = node3;
        Codec2 codec = new Codec2();
        String serial = codec.serialize(node);
        TreeNode root = codec.deserialize(serial);
        System.out.println(root);
    }


}
