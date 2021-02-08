package average_salary_excluding_the_minimum_and_maximum_salary;

import tool.ArrayTestCaseTransformer;

public class Solution {

    public static void main(String[] args) {
        System.out.println(average(ArrayTestCaseTransformer.transform("[4000,3000,1000,2000]")));
    }

    public static double average(int[] salary) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < salary.length; i++) {
            sum += salary[i];
            min = Math.min(min, salary[i]);
            max = Math.max(max, salary[i]);
        }
        return (double) (sum - min - max) / (salary.length - 2);
    }
}
