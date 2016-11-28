package number_of_1bit;

/**
 * 2016/11/25
 */
public class Solution {
    public static void main(String[] args) {

    }

    public int hammingWeight(int n) {
        int count = 0;
        if (n == 0) {
            return 0;
        }
        for (int i=0;i<32;i++){
            if((n & (1<<i)) == 1){
                count++;
            }
        }
        return count;
    }
}
