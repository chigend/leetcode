package power_of_four;

/**
 * @author yejinbiao
 * @create 2017-03-16-下午10:18
 */

public class Solution2 {
    public static void main(String[] args) {

    }

    /**
     * n & (n - 1) 可以判断是否为2的幂，但是4的幂的二进制数中，1总是出现在奇数位
     * 所以用0101去检查即可(也可以用1010，就是10去检查 换算成16进制就是0xaaaaaaaa)，0101就是5，补满所有位就是0x55555555
     * @param num
     * @return
     */
    public boolean isPowerOfFour(int num) {
        return num > 0 && ((num & (num - 1)) == 0) && (num & 0x55555555) != 0;
    }
}
