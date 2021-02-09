package calculate_money_in_leetcode_bank;

public class Solution {

    public static void main(String[] args) {
        System.out.println(totalMoney(20));
    }

    public static int totalMoney(int n) {
        int w = n / 7;
        int d = n % 7;

        int money = (28 + (28 + (w - 1) * 7)) * w / 2;

        money += (w + 1 + (w + 1 + (d - 1))) * d / 2;

        return money;

    }
}

