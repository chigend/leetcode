package count_odd_numbers_in_an_interval_range;

public class Solution {

    public static void main(String[] args) {

    }

    public int countOdds(int low, int high) {
        int count = (high - low) >> 1;
        if(low % 2 == 1 || high %2==1) {
            count ++;
        }
        return count;
    }
}

