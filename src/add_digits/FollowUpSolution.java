package add_digits;

/**
 * @author yejinbiao
 * @create 2017-03-06-下午2:20
 */

/**
 * follow up solution without any loop/recursion in O(1) runtime
 */
public class FollowUpSolution {
    public static void main(String [] args) {

    }

    public static int addDigits(int num) {
        if (num == 0) {
            return 0;
        }
        int mod = num % 9;
        return  mod == 0 ? 9 : mod;
    }
}
