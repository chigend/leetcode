package kids_with_the_greatest_number_of_candies;

import java.util.ArrayList;
import java.util.List;

import tool.ArrayTestCaseTransformer;

public class Solution {

    public static void main(String[] args) {
        int[] transform = ArrayTestCaseTransformer.transform("[4,2,1,1,2]");
        List<Boolean> booleans = kidsWithCandies(transform, 1);
        System.out.println(booleans);
    }

    public static List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> list = new ArrayList<>();

        int max = 0;
        for (int candy : candies) {
            max = Math.max(max, candy);
        }

        for (int candy : candies) {
            list.add(candy + extraCandies >= max);
        }
        return list;
    }
}
