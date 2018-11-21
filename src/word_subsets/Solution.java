package word_subsets;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        List<String> result = solution.wordSubsets(new String[]{"amazon","apple","facebook","google","leetcode"},
                new String[]{"ec","oc","eco"});
        System.out.println(result);

    }

    public List<String> wordSubsets(String[] A, String[] B) {
        int[] mergecount = count("");
        List<String> result = new ArrayList<>();
        for (int i = 0; i < B.length; i++) {
            int[] count = count(B[i]);
            for (int j = 0; j < count.length; j++) {
                mergecount[j] = Math.max(mergecount[j], count[j]);
            }
        }
        for (int i = 0; i < A.length; i++) {
            int[] count = count(A[i]);
            if (isSubset(count, mergecount)) {
                result.add(A[i]);
            }
        }
        return result;
    }

    private boolean isSubset(int[] ACount, int[] BCount){
        for (int i = 0; i < ACount.length; i++) {
            if (ACount[i] < BCount[i]) {
                return false;
            }
        }
        return true;
    }

    private int[] count(String word) {
        int[] count = new int[26];
        for (char c : word.toCharArray()) {
            count[c - 'a'] ++;
        }
        return count;
    }
}
