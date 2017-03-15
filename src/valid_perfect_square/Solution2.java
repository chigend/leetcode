package valid_perfect_square;

/**
 * @author yejinbiao
 * @create 2017-03-15-下午8:07
 */

public class Solution2 {
    public static void main(String[] args) {

    }

    /**
     * since the perfect square is ths sum of odd number
     * 1 = 1
     * 4 = 1 + 3
     * 9 = 1 + 3 +5
     * 16 = 1 + 3 + 5 + 7
     * 25 = 1 +3 + 5 + 7 + 9
     * @param num
     * @return
     */
    public  boolean isPerfectSquare(int num) {
        int odd = 1;
        while (num > 0) {
            num -= odd;
            odd += 2;
        }
        return num == 0;
    }
}
