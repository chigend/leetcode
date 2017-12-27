package shortest_completing_word;

public class Solution {
    public static void main(String[] args) {
        String word = shortestCompletingWord("1s3 456", new String[]{"looks", "pest", "stew", "show"});
        System.out.println(word);

    }

    public static String shortestCompletingWord(String licensePlate, String[] words) {
        licensePlate = licensePlate.toLowerCase();
        int[] alphabet = new int[26];
        char[] chars = licensePlate.toCharArray();
        for (int i = 0; i < licensePlate.length(); i++) {
            char c = chars[i];
            if (Character.isLetter(c)) {
                alphabet[c - 'a']++;
            }
        }
        int len = Integer.MAX_VALUE;
        String min = "";
        for (String word : words) {
            int[] count = new int[26];
            for (int i = 0; i < word.length(); i++) {
                count[word.charAt(i) - 'a']++;
            }
            if (isComplete(alphabet, count) && word.length() < len) {
                len = word.length();
                min = word;
            }
        }
        return min;

    }
    public static boolean isComplete(int[] alphabet, int[] count) {
        for (int i = 0; i < alphabet.length; i++) {
            if (count[i] < alphabet[i]) {
                return false;
            }
        }
        return true;
    }
}
