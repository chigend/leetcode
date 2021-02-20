package binode;

import model.TreeNode;

public class Solution2 {

    public TreeNode previous;

    public  TreeNode convertBiNode(TreeNode root) {
        TreeNode fake = new TreeNode(-1);
        previous = fake;
        convertBiNode0(root);
        previous.left = null;
        return fake.right;
    }

    public  void convertBiNode0(TreeNode root) {
        if(root == null) {
            return ;
        }
        convertBiNode0(root.left);
        previous.left = null;
        previous.right = root;
        previous = root;
        convertBiNode0(root.right);
    }
}
