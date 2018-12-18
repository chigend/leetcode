package ugly_number_II;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int s = solution.nthUglyNumber(1690);
        System.out.println(s);
    }

    public int nthUglyNumber(int n) {
        int[] ugly = new int[n];
        ugly[0] = 1;
        int i2 = 0, i3 = 0, i5 = 0;
        for (int i = 1; i < n; i++) {
            int next2 = ugly[i2] * 2, next3 = ugly[i3] * 3, next5 = ugly[i5] * 5;
            int min = Math.min(next2, Math.min(next3, next5));
            if (min == next2) i2++;
            if (min == next3) i3++;
            if (min == next5) i5++;
            ugly[i] = min;
        }
        return ugly[n - 1];
    }
}
