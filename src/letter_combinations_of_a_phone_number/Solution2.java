package letter_combinations_of_a_phone_number;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


public class Solution2 {
    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        List<String> result = solution.letterCombinations("24");
        System.out.println(result);
    }

    public List<String> letterCombinations(String digits) {
        LinkedList<String> queue = new LinkedList<>();
        if (digits.length() == 0) {
            return queue;
        }
        String[] digitLetters = new String[]{"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        queue.offer("");
        char[] chs = digits.toCharArray();
        for (int i = 0; i < chs.length; i++) {
            String letter = digitLetters[chs[i] - '0' - 2];
            int size = queue.size();
            for (int j = 0; j < size; j++) {
                String combination = queue.poll();
                for (int k = 0; k < letter.length(); k++) {
                    queue.offer(combination + letter.charAt(k));
                }
            }
        }
        return queue;
    }


}
