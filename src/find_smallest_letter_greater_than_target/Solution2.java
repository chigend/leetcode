package find_smallest_letter_greater_than_target;

/**
 * binary search solution
 */
public class Solution2 {
    public static void main(String[] args) {
        char[] letters = {'c'};
        char target = 'd';
        char c = nextGreatestLetter(letters, target);
        System.out.print(c);
    }

    public static char nextGreatestLetter(char[] letters, char target) {
        char previous = target;
        int low = 0;
        int high = letters.length - 1;
        while (low <= high) {
            int med = (low + high) >> 1;
            if (letters[med] > target) {
                previous = letters[med];
                high = med - 1;
            } else if (letters[med] <= target) {
                low = med + 1;
                if (low > letters.length - 1) {
                    return letters[0];
                }
            }
        }
        return previous;
    }
}
