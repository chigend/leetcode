package best_time_to_buy_and_sell_stock_II;

/**
 * @author yejinbiao
 * @create 2017-03-12-下午6:10
 */

public class Solution {
    public static void main(String[] args) {
        int [] prices = {3,2,1};
        int maxProfit = maxProfit(prices);
        System.out.println(maxProfit);
    }


    public static int maxProfit(int[] prices) {
        if (prices.length <= 1) {
            return 0;
        }
        int totalProfit = 0;
        int min = prices[0];
        int max = prices[0];
        for (int i = 1; i < prices.length; i++) {
            int price = prices[i];
            /**
             * since the price is going to fall,so sold it
             */
            if (price < max) {
                /**
                 * if prices is descending, so there is no profit.
                 * since the max = min,so in this case(descending),max-min will
                 * always be 0.
                 */
                totalProfit += max - min;
                min = price;
                max = price;
            }else if (price < min) {
                //record the min price
                min = price;
            }else  if (price > max){
                //record the max price,once the price is less than max,sell it
                max = price;
            }
        }
        //if prices ends with ascending prices,add the last profix
        return totalProfit + max - min;
    }
}
