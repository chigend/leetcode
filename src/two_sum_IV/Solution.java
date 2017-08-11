package two_sum_IV;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.Stack;

import model.TreeNode;

/**
 * @author yejinbiao
 * @create 2017-08-11-9:43
 */

public class Solution {
    public static void main(String[] args) {

    }

    public boolean findTarget(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        Set<Integer> values = new HashSet<>();
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            if (!stack.isEmpty()) {
                TreeNode node = stack.pop();
                values.add(node.val);
                root = node.right;
            }
        }
        for (Iterator<Integer> it = values.iterator(); it.hasNext();) {
            int a = it.next();
            if (k-a != a && values.contains(k - a)) {
                return true;
            }
        }
        return false;
    }
}
