package first_unique_character_in_a_string;

/**
 * a two pointer solution
 */

public class Solution2 {
    public static void main(String[] args) {
        int first = firstUniqChar("ee");
        System.out.println(first);
    }

    public static int firstUniqChar(String s) {
        if (s.length() == 0) {
            return -1;
        }
        int len = s.length();
        int[] alphabet = new int[26];
        char [] chars = s.toCharArray();
        int slow = 0;//define a slow pointer which trach the first unique character
        int fast = 0;//define a fast pointer which scan the string
        while (fast < len) {
            alphabet[chars[fast] - 'a']++;//count the character while fast pointer scan the string
            /**
             * while the character count at slow pointer > 1 ,it means the character is
             * not unique,and move down the slow pointer
             */
            while (slow < len && alphabet[chars[slow] - 'a'] > 1) {
                slow++;
            }
            /**
             * if slow == s.length,it means there is not exist unique as the max index of s
             * is s.length - 1
             */
            if (slow == len) {
                return -1;
            }
            /**
             * if the character count at slow pointer = 0,reset the fast to slow position,
             * since there is fast++, so we reset the fast pointer to slow - 1
             */
            if (alphabet[chars[slow] - 'a'] == 0) {
                fast = slow - 1;
            }
            fast++;
        }
        return slow;
    }
}
