package find_smallest_letter_greater_than_target;

public class Solution {
    public static void main(String[] args) {
        char[] letters = {'c','f','j'};
        char target = 'k';
        char res = nextGreatestLetter(letters, target);
        System.out.print(res);
    }

    public static char nextGreatestLetter(char[] letters, char target) {
        boolean[] exists = new boolean[26];
        for (int i = 0; i < letters.length; i++) {
            int index = letters[i] - 'a';
            exists[index] = true;
        }
        int start = target - 'a';
        for (int i = start + 1; i < exists.length; i++) {
            if (exists[i]) {
                return (char)('a'+i);
            }
        }
        for (int i = 0; i < start; i++) {
            if (exists[i]) {
                return (char)('a'+i);
            }
        }
        return target;
    }
}
