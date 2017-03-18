package same_tree;

import model.TreeNode;

/**
 * @author yejinbiao
 * @create 2017-03-18-下午8:30
 */

public class Solution {
    public static void main(String[] args) {

    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        return p.val == q.val && (isSameTree(p.left, q.left) && isSameTree(p.right, q.right));
    }
}
