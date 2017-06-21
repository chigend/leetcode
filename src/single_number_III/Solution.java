package single_number_III;

import java.util.Arrays;

/**
 * @author yejinbiao
 * @create 2017-06-21-11:40
 */

public class Solution {
    public static void main(String[] args) {
        int[] nums = new int[]{1,1,3,3,5,6,5,6,4,7,5,7,5,6};

        System.out.println(Arrays.toString(singleNumber(nums)));

    }

    public static int[] singleNumber(int[] nums) {

        //assume  the number which appear only once to be a and b;
        int xor = 0;
        for (int num : nums)
            xor ^= num;
        //since the other numbers appear twice,so variable 'xor' come out to be the xor of a and b

        //since a!=b, there is at least one bit is 1 in xor,so find arbitrary one bit that is 1
//        int oneBit = Integer.highestOneBit(xor);//here find the highest bit
        int oneBit = xor & -xor;//here find the lowest bit

        //the numbers must be grouped into two groups,one group which the corresponding bit
        //(here it indicate the lowest bit)is 1 contains number a(maybe the group contains a only),the other group which the corresponding bit is 0 contains
        //number b(maybe the group contains b only)
        int a = 0;
        for (int num : nums) {
            if ((oneBit & num) == 0) {
                //since the numbers except a in the group which contains a appear twice,so xor of
                //each element in the group will remain to be a;
                a ^= num;
            }
        }
        int b = xor ^ a;
        return new int[]{a,b};
    }
}
