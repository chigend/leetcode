package print_binary_tree;

import java.util.ArrayList;
import java.util.List;

import com.sun.org.apache.xpath.internal.WhitespaceStrippingElementMatcher;

import model.TreeNode;

public class Solution {
    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(4);
        node.left = node2;
        node.right = node3;
        node2.left = node4;
        node4.left = node5;
        List<List<String>> result = printTree(node);
        System.out.println(result);
    }

    public static List<List<String>> printTree(TreeNode root) {
        int depth = calculateDepth(root);
        int size = calculateSize(depth);
        List<List<String>> result = new ArrayList<>();
        printTree(root, 0, size, 0, size - 1, result);
        return result;
    }

    private static void printTree(TreeNode root,int level, int size, int begin, int end, List<List<String>> result) {
        if (root == null) {
            return;
        }
        if (result.size() == level) {
            result.add(generateList(size));
        }
        int med = (begin + end) >>> 1;
        result.get(level).set(med, String.valueOf(root.val));
        printTree(root.left, level + 1, size, begin, med - 1, result);
        printTree(root.right, level + 1, size, med + 1,  end, result);
    }
    private static int calculateDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int l = calculateDepth(root.left);
        int r = calculateDepth(root.right);
        return Math.max(l, r) + 1;
    }

    //init empty list with size
    private static List<String> generateList(int size) {
        List<String> list = new ArrayList<>();
        while (size-- > 0) {
            list.add("");
        }
        return list;
    }

    //cal size with max depth of tree, once depth increase by 1, size = 2 * (size of last depth) + 1;
    private static int calculateSize(int depth) {
        int size = 1;
        while (--depth > 0) {
            size = 2 * size + 1;
        }
        return size;
    }
}
