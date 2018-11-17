package letter_case_permutation;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution2 {
    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();
        List<String> result = solution2.letterCasePermutation(null);
        System.out.println(result);
    }

    public List<String> letterCasePermutation(String S) {
        Queue<String> queue = new LinkedList<>();
        queue.offer(S);
        for (int i = 0; i <  S.length(); i++) {
            if (Character.isLetter(S.charAt(i))) {
                int size = queue.size();
                for (int j = 0; j < size; j++) {
                    String s = queue.poll();
                    char[]chs = s.toCharArray();
                    chs[i] = Character.toLowerCase(chs[i]);
                    queue.offer(new String(chs));
                    chs[i] = Character.toUpperCase(chs[i]);
                    queue.offer(new String(chs));
                }
            }
        }
        return new ArrayList<>(queue);
    }
}
