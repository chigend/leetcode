package letter_case_permutation;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        List<String> result = solution.letterCasePermutation(null);
        System.out.println(result);
    }

    public List<String> letterCasePermutation(String S) {
        List<String> reulst = new ArrayList<>();
        permutaion(0, S.toCharArray(), reulst);
        return reulst;
    }

    public void permutaion(int index, char[] chs, List<String> result) {
        if (index < chs.length) {
            if (Character.isLetter(chs[index])) {
                chs[index] = Character.toLowerCase(chs[index]);
                permutaion(index + 1, chs, result);
                chs[index] = Character.toUpperCase(chs[index]);
                permutaion(index + 1, chs, result);
            }else {
                permutaion(index + 1, chs, result);
            }
        }else {
            result.add(new String(chs));
        }
    }
}
