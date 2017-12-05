package recover_binary_search_tree;

import model.TreeNode;

/**
 * @author yejinbiao
 * @create 2017-05-11-9:20
 */

public class Solution {
    private static TreeNode previous;
    private static TreeNode first;
    private static TreeNode second;
    private static TreeNode third;
    private static TreeNode fourth;
    public static void main(String[] args) {
        TreeNode root = new TreeNode(0);
        TreeNode node2 = new TreeNode(1);
        root.left = node2;
        recoverTree(root);
        traversal2(root);

    }

    public static void recoverTree(TreeNode root) {
        traversal(root);
        /**
         * 如果third为null，这说明是相连的两个节点进行了互换，那么只要互换这两个节点的值即可
         */
        if (third == null) {

            int temp = first.val;
            first.val = second.val;
            second.val = temp;
        }else {
            /**
             * 如果不是相连的两个节点互换，那么就换第一个点和第四个点，至于为什么是第1个和第4个。
             * 当第一次出现异常的时候，一定是前面的点被换了，如果是后面的点被换了并且这个点是和之后的点互换，
             * 那么由于后面的数一定比前面的大，所以互换之后应该不会有异常。如果是后面的点被换了并且这个点是和之前的
             * 点互换，那么在遍历到之前的点的时候就已经发现有异常了。例子：
             * 1,2,3,4,5   总共5个点，这里表示序号并不表示数值，假如发现3这个点的值比2这个点的小，那么一定是2这个点被换了，
             * 因为如果是3这个点和3之后的点进行互换的话，那么由于换的点都是在2之后的，都会比2大，所以这种情况不存在，那如果3这个
             * 点是和3之前的点互换的话，比如是和1进行互换的，那么在遍历到2这个点的时候就会发现2这个点的值比1这个点的值小，所以这也是、
             * 矛盾的，所以综上所述，第一次出现异常的情况下，只有可能是前面一个点被换了，
             * 同理也可以推出当第二次出现异常的时候，只可能后面的点被换了。
             *
             * 如果没有出现第二次异常，就表明第一次的异常的两个相连点进行了互换
             */
            int temp = first.val;
            first.val = fourth.val;
            fourth.val = temp;
        }
    }
    private static void traversal(TreeNode root){

        if (root == null) return;
        traversal(root.left);
        if (previous != null) {
            /**
             * 正常情况下，每一个节点的值都是比上一个节点的值是大的，如果出现小的情况，那么当前节点或者前一个节点一定出现了
             * 对换，记录下这两个节点first，second
             */
            if (root.val < previous.val) {
                if (first == null) {
                    first = previous;
                    second = root;
                }else {
                    /**
                     * 如果first不为null  说明找到了另外一个被对换的节点，记录下这两个节点，third和forth
                     */
                    third = previous;
                    fourth = root;
                }
            }
        }
        //previous记录上一次访问的节点
        previous = root;
        traversal(root.right);
    }
    private static void traversal2(TreeNode root) {
        if (root  == null) return ;
        traversal2(root.left);
        System.out.println(root.val);
        traversal2(root.right);
    }
}
