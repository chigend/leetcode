package mini_parser;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import flatten_nested_list_iterator.NestedInteger;

public class Solution {
    public static void main(String[] args) {
        NestedInteger s = deserialize("[123,[456,[789]]]");
        System.out.println(s);
    }

    public static NestedInteger deserialize(String s) {
        if (s.indexOf('[') == -1) {
            return new NestedInteger(Integer.valueOf(s));
        }
        Stack<NestedInteger> stack = new Stack();
        int start = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '[') {
                start++;
                stack.push(null);
            }else if (c == ',') {
                stack.push(new NestedInteger(Integer.valueOf(s.substring(start, i))));
                start = i + 1;
            }else if (c == ']') {
                if (start != i) {
                    stack.push(new NestedInteger(Integer.valueOf(s.substring(start, i))));
                }
                start = i + 1;
                NestedInteger list = new NestedInteger();
                Stack<NestedInteger> array = new Stack<>();
                while (stack.peek() != null) {
                    array.push(stack.pop());
                }
                while (!array.isEmpty()) {
                    list.add(array.pop());
                }
                stack.pop();
                stack.push(list);
            }
        }
        return stack.pop();
    }



    static class NestedInteger {
        // Constructor initializes an empty nested list.
        public NestedInteger() {}

        // Constructor initializes a single integer.
        public NestedInteger(int value) {}

        // @return true if this NestedInteger holds a single integer, rather than a nested list.
        public boolean isInteger() {
            return true;
        }

        // @return the single integer that this NestedInteger holds, if it holds a single integer
        // Return null if this NestedInteger holds a nested list
        public Integer getInteger() {
            return null;
        }

        // Set this NestedInteger to hold a single integer.
        public void setInteger(int value) {}

        // Set this NestedInteger to hold a nested list and adds a nested integer to it.
        public void add(NestedInteger ni) {}

        // @return the nested list that this NestedInteger holds, if it holds a nested list
        // Return null if this NestedInteger holds a single integer
        public List<NestedInteger> getList() {
            return null;
        }
    }
}
