package letter_combinations_of_a_phone_number;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        List<String> result = solution.letterCombinations("2345");
        System.out.println(result);
    }

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits.length() == 0) {
            return result;
        }
        String[] digitLetters = new String[]{"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        backtrace(0, digits.toCharArray(), "", digitLetters, result);
        return result;
    }

    private void backtrace(int n, char[] digits, String combination, String[] digitLetters, List<String> result) {
        if (n == digits.length) {
            result.add(combination);
            return;
        }
        String letters = digitLetters[digits[n] - '0' - 2];
        for (int i = 0; i < letters.length(); i++) {
            backtrace(n + 1, digits, combination + letters.charAt(i), digitLetters, result);
        }
    }
}
