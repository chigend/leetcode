package lemonade_change;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        boolean correct = solution.lemonadeChange(new int[]{5,5,10,10,20});
        System.out.println(correct);
    }

    /**
     * 自己的写法
     * @param bills
     * @return
     */

    public boolean lemonadeChange(int[] bills) {
        int c5 = 0;
        int c10 = 0;
        for (int bill : bills) {
            if (bill == 5){
                c5++;
            }else if (bill == 10){
                if (c5-- == 0) {
                    return false;
                }
                c10++;
            }else {
                // pay 20, change [10,5] or[5,5,5], otherwise there is no way to change correct
                if (c10 > 0 && c5 > 0) {
                    c10--;
                    c5--;
                }else if (c5 >= 3){
                    c5 -= 3;
                }else {
                    return false;
                }
            }

        }
        return true;
    }

}
