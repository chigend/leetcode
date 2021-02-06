package check_if_two_string_arrays_are_equivalent;

public class Solution {

    public static void main(String[] args) {

    }

    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        return formString(word1).equals(formString(word2));
    }

    public static String formString(String[] words) {
        StringBuilder sb = new StringBuilder();
        for (String word : words) {
            sb.append(word);
        }
        return sb.toString();
    }
}
