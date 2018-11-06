package binary_gap;

public class Solution {
    public static void main(String[]args){
//        int s = Integer.parseInt("10000000000000000000000000000000", 2);
        System.out.println(binaryGap(Integer.MIN_VALUE+1));
    }

    public static int binaryGap(int N) {
        int distance = -32;
        int maxDistance = 0;
        int mask = Integer.MIN_VALUE;
         while (mask != 0){
            distance++;
            if ((N & mask) == mask) {
                maxDistance = Math.max(distance, maxDistance);
                distance = 0;
            }
            mask >>>= 1;
        }
        return maxDistance;
    }
}
