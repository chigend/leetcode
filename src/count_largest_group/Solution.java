package count_largest_group;

public class Solution {

    public static void main(String[] args) {

    }

    public int countLargestGroup(int n) {
        int[] count = new int[37];
        for(int i = 1; i<=n; i++) {
            int sum = 0;
            int d = i;
            while( d > 0) {
                sum += d % 10;
                d /= 10;
            }
            count[sum] ++;
        }

        int max = 0;
        for(int i = 0; i < count.length;i++){
            max = Math.max(max, count[i]);
        }
        int c = 0;
        for(int i = 0; i < count.length;i++){
            if(count[i] == max) {
                c++;
            }
        }
        return c;
    }
}
