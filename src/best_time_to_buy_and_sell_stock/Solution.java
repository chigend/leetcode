package best_time_to_buy_and_sell_stock;

public class Solution {
	public static void main(String[] args) {
		int[] array = new int[] { 5, 8, 6, 10, 1 };
		int max = maxProfit(array);
		System.out.println(max);
	}

	public static int maxProfit(int[] prices) {
		if(prices.length < 2){
			return 0;
		}
		int curMin = prices[0];
		int maxProfit = 0;
		for(int i=1;i<prices.length;i++){
			curMin = curMin < prices[i]?curMin:prices[i];
			maxProfit = maxProfit > prices[i] - curMin?maxProfit:prices[i] - curMin;
		}
		return maxProfit;

	}

	private void maxProfit(int[] prices, int[] profit) {
		// TODO Auto-generated method stub

	}

}
