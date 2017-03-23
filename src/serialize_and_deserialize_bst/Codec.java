package serialize_and_deserialize_bst;

import model.TreeNode;

/**
 * @author yejinbiao
 * @create 2017-03-23-下午1:10
 */


public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        inorderTraversal(root, sb);
        sb.setCharAt(sb.length() - 1, ';');
        postorderTraversal(root, sb);
        return sb.deleteCharAt(sb.length() - 1).toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.length() == 0) {
            return null;
        }
        int index = data.indexOf(';');
        String inorder = data.substring(0, index);
        String postorder = data.substring(index + 1);
        return constructTree(inorder, postorder);
    }

    private void inorderTraversal(TreeNode root, StringBuilder sb) {
        if (root == null) return;
        inorderTraversal(root.left, sb);
        sb.append(root.val).append(',');
        inorderTraversal(root.right, sb);
    }
    private void postorderTraversal(TreeNode root, StringBuilder sb) {
        if (root == null) return;
        postorderTraversal(root.left, sb);
        postorderTraversal(root.right, sb);
        sb.append(root.val).append(',');
    }
    private TreeNode constructTree(String inorder, String postorder) {
        if (inorder.length() == 0) {
            return null;
        }
        /**
         * find the last number in postorder
         */
        int postorderIndex = postorder.lastIndexOf(',');
        if (postorderIndex == -1) {
            TreeNode node = new TreeNode(Integer.valueOf(postorder));
            node.left = null;
            node.right = null;
            return node;
        }
        /**
         * todo
         */
        String valStr = postorder.substring(postorderIndex + 1);
        TreeNode node = new TreeNode(Integer.valueOf(valStr));
        int inorderIndex = inorder.indexOf(valStr);
        int inorderLeftEnd = inorderIndex == 0 ? 0 : inorderIndex - 1;
        int endIndex = inorderIndex + valStr.length();
        int inorderRightStart = endIndex == inorder.length()  ? endIndex : endIndex + 1;
        String inorder_leftsub = inorder.substring(0, inorderLeftEnd);
        String inorder_rightsub = inorder.substring(inorderRightStart);
        String postorder_leftsub = postorder.substring(0, inorder_leftsub.length());
        int postorderRightStart = inorder_leftsub.length() == 0 ? 0:inorder_leftsub.length() + 1;
        int postorderRightEnd = endIndex == inorder.length() ? postorderRightStart : postorderIndex;
        String postorder_rightsub = postorder.substring(postorderRightStart, postorderRightEnd);
        node.left = constructTree(inorder_leftsub, postorder_leftsub);
        node.right = constructTree(inorder_rightsub, postorder_rightsub);
        return node;
    }
}