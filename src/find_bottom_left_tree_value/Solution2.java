package find_bottom_left_tree_value;

import java.util.ArrayList;

import model.TreeNode;

/**
 * @author yejinbiao
 * @create 2017-03-15-上午9:20
 */

public class Solution2 {
    public static void main(String[] args) {

        TreeNode node = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);
        node.left = node2;
        node.right = node3;
//        node2.left = node4;
//        node3.left = node5;
//        node3.right = node6;
//        node5.left = node7;
//        node3.right = node4;
        int left = findBottomLeftValue(node);
        System.out.print(left);

    }
    public static int findBottomLeftValue(TreeNode root) {
        ArrayList<TreeNode> queue = new ArrayList<>();
        int bottomLeftValue = 0;
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            bottomLeftValue = queue.get(0).val;
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.remove(0);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
        }
        return bottomLeftValue;
    }
}
