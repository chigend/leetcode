package reconstruct_original_digits_from_english;

/**
 * @author yejinbiao
 * @create 2017-03-22-下午8:47
 */

public class Solution {
    public static void main(String[] args) {

    }

    public static String originalDigits(String s) {
        int[]alphabets = new int[26+'a'];
        for (int i = 0; i < s.length(); i++) {
            alphabets[s.charAt(i)] ++;
        }
        int [] count = new int[10];
        count[0] = alphabets['z'];
        count[4] = alphabets['u'];
        count[6] = alphabets['x'];
        count[5] = alphabets['f'] - count[4];
        count[3] = alphabets['r'] - count[4] - count[0];
        count[7] = alphabets['s'] - count[6];
        count[8] = alphabets['g'];
        count[2] = alphabets['w'];
        count[1] = alphabets['o'] - count[2] - count[4] - count[0];
        count[9] = alphabets['i'] - count[5] - count[6] - count[8];
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count.length; i++) {
            for (int k = 0; k < count[i]; k++) {
                sb.append(i);
            }
        }
        return sb.toString();
    }
}
