package serialize_and_deserialize_bst;

import model.TreeNode;

/**
 * @author yejinbiao
 * @create 2017-03-23-上午10:47
 */

public class Main {
    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
//        node.left = node2;
//        node.right = node3;
//        node2.left = node4;
//        node2.right = node5;
        node.left = node2;
        node.right = node3;
        Codec codec = new Codec();
        String serial = codec.serialize(node);
        TreeNode t = codec.deserialize(serial);
        System.out.print(t);
////        System.out.print(serial);
//        String s = "4,5,2,3,12";
//        String s1 = "4,2,5,12,3";
//        int index = s.lastIndexOf(',');
//        String str = s.substring(index+1);
//        int index2 = s1.indexOf(str);
//        String inorder_left = s1.substring(0, index2 - 1);
//        String inorder_right = s1.substring(index2+str.length()+1);
//        System.out.println(s.substring(0,inorder_left.length()));
//        System.out.println(s.substring(inorder_left.length()+1, index));

    }
}
