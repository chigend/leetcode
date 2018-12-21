package verifying_an_alien_dictionary;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        boolean sorted = solution.isAlienSorted(new String[]{"app", "apple","app"},"abcdefghijklmnopqrstuvwxyz");
        System.out.println(sorted);
    }

    public boolean isAlienSorted(String[] words, String order) {
        char[] alphabet = order.toCharArray();
        int[] orders = new int[26];//store every character's lexicographical order
        for(int i = 0; i < alphabet.length; i++) orders[alphabet[i] - 'a'] = i;
        for (int i = 1; i < words.length; i++) {
            if (!isIncreasingLexical(words[i - 1], words[i], orders)) {
                return false;
            }
        }
        return true;
    }

    private boolean isIncreasingLexical(String s1, String s2, int[] orders) {
        char[] chs1 = s1.toCharArray();
        char[] chs2 = s2.toCharArray();
        int i = 0, j = 0;
        while (i < chs1.length && j < chs2.length) {
            int order1 = orders[chs1[i++] - 'a'];
            int order2 = orders[chs2[j++] - 'a'];
            if (order1 != order2) {
                return order1 < order2;
            }
        }
        //if s1 or s2 has reached the end of string, it should be s1, since 'app' is lexicographically smaller than 'apple'
        return i == chs1.length;
    }
}
