package bulls_and_cows;

/**
 * @author yejinbiao
 * @create 2017-03-07-下午10:27
 */

/**
 * a optimize solution for Solution1
 */
public class Solution2 {

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
             * if the digit count before count up(add) the digit is less than zero,it means
             * it has appear so many times in guess string,so count the cows;
             * the same way, if the digit count before count down the digit is larger
             * than zero,it means it has appear so many times in secret string,so
             * count the cows;
             */
            if (alphabet[secret.charAt(i) - '0']++ < 0){
                cows ++;
            }
            if (alphabet[guess.charAt(i) - '0']-- > 0) {
                cows++;
            }

        }

        return new StringBuilder().append(bulls).append('A').append(cows).append('B').toString();
    }

}
