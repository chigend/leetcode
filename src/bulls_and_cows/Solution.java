package bulls_and_cows;

/**
 * @author yejinbiao
 * @create 2017-03-07-下午9:45
 */

public class Solution {
    public static void main(String[] args) {
        String secret = "1807";
        String guess = "7810";
        String hint = getHint(secret, guess);
        System.out.println(hint);
    }

    public static String getHint(String secret, String guess) {
        int[] alphabet = new int[10];
        int bulls = 0;
        int cows = 0;
        for (int i = 0; i < secret.length(); i++) {
            /**
             * if both position and digit match ,count the bulls,and ignore it not to count the
             * digit
             */
            if (guess.charAt(i) == secret.charAt(i)) {
                bulls++;
                continue;
            }
            /**
             * count every digit except bulls(which is both position and digit match)
             */
            alphabet[secret.charAt(i) - '0']++;

        }
        for (int i = 0; i < secret.length(); i++) {
            if (guess.charAt(i) == secret.charAt(i)) {
                continue;
            }
            /**
             * if the digit count before count down
             * is larger than zero when count down the digit count ,it means
             * it has appear so many times in the secret string,so count the cows
             */
            if (alphabet[guess.charAt(i) - '0']-- > 0) {
                cows++;
            }
        }
        return new StringBuilder().append(bulls).append('A').append(cows).append('B').toString();
    }

}
