package exchange_bits;

public class Solution {

    public static void main(String[] args) {

    }

    public int exchangeBits(int num) {
        //向左移一位相当于原来的奇数位都变偶数位了, 这时保留偶数位清空奇数位
        int evenBits = (num << 1) & 0xaaaaaaaa;
        //向右移一位相当于原来的偶数位都变奇数位了, 这时保留奇数位清空偶数位
        int oddBits = (num >> 1)  & 0x55555555;
        //最后将两者按位或就是奇偶数位交换的结果了
        return evenBits | oddBits;
    }
}
