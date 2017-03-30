package nim_game;

/**
 * @author yejinbiao
 * @create 2017-03-30-16:32
 */

public class Solution {
    public static void main(String[] args) {
        boolean canWin = canWinNim(7);
        System.out.print(canWin);
    }

    public static boolean canWinNim(int n) {
        return n % 4 != 0;
    }
}
