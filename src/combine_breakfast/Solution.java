package combine_breakfast;

import tool.ArrayTestCaseTransformer;

public class Solution {

    public static void main(String[] args) {
            breakfastNumber(ArrayTestCaseTransformer.transform("[10,20,5]"),ArrayTestCaseTransformer.transform("[5,5,2]"),15);
    }

    public static int breakfastNumber(int[] staple, int[] drinks, int x) {

        long count = 0;
        int[] countStaple = new int[100001];
        int[] countDrinks = new int[100001];
        for(int s : staple) {
            countStaple[s]++;
        }

        for(int d : drinks) {
            countDrinks[d]++;
        }
        int[] dp = new int[countDrinks.length];
        for(int i = 1; i < dp.length; i++) {
            dp[i] = dp[i - 1] + countDrinks[i];
        }
        for(int i = 0; i < countStaple.length; i++) {
            if(countStaple[i] > 0 && x - i > 0) {
                count += countStaple[i] * dp[x - i];
            }
        }
        return (int)(count % 1000000007);
    }
}
