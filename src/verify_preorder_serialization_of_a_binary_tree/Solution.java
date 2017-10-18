package verify_preorder_serialization_of_a_binary_tree;

import java.util.Stack;

public class Solution {
    public static void main(String[] args) {
        boolean valid = isValidSerialization("#") ;
        System.out.println(valid);
    }

    public static boolean isValidSerialization(String preorder) {
        String[] nodes = preorder.split(",");
        if (nodes.length == 0) {
            return true;
        }
        if (nodes.length == 1 && "#".equals(nodes[0])){
            return true;
        }
        if ("#".equals(nodes[0]) && nodes.length > 1) {
            return false;
        }
        MyStack stack = new MyStack();
        stack.add(nodes[0]);
        for (int i = 1; i < nodes.length; i++) {
            if (!stack.push(nodes[i])) {
                return false;
            }
        }
        return stack.isEmpty();

    }
    static class MyStack{
        Stack<String> stack;

        public MyStack() {
            stack = new Stack<>();
        }
        public boolean push(String e) {
            if (stack.isEmpty()) {
                return false;
            }
            if ("#".equals(e) && "#".equals(stack.peek())) {
                stack.pop();
                stack.pop();
                if (!stack.isEmpty() & !push(e)){
                    return false;
                }
            }else {
                stack.push(e);
            }
            return true;
        }

        public void add(String e) {
            stack.push(e);
        }

        public boolean isEmpty(){
            return stack.isEmpty();
        }
    }
}
