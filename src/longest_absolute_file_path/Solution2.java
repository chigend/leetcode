package longest_absolute_file_path;

import java.util.Stack;

public class Solution2 {

    public static void main(String[] args) {
        String s = "dir\n        file.ext";
        System.out.println(s);
        int longest = lengthLongestPath(s);
        System.out.println(longest);
    }

    public static int lengthLongestPath(String input) {
        if (input.indexOf('.') == -1) {
            return 0;
        }
        int index = input.indexOf('\n');
        if (index == -1) {
            return input.length();
        }
        int longest = 0;
        int cur = index;
        int i = index + 1;
        Stack<Integer> stack = new Stack<>();
        while (i < input.length()) {
            int level = 0;
            while (input.charAt(i) == '\t') {
                i++;
                level++;
            }
            if (level == 0) {
                return Math.max(lengthLongestPath(input.substring(i)), longest);
            }
            index = input.indexOf('\n', i);

            if (index == -1) {
                index = input.length();
            }
            String path = input.substring(i, index);
            while (cur > 0 && stack.size() >= level) {
                cur -= stack.pop() + 1;
            }
            cur += path.length() + 1;
            if (path.lastIndexOf('.') != -1) {
                longest = Math.max(longest, cur);
            }
            stack.push(path.length());

            i = index + 1;
        }
        return longest;
    }
}
