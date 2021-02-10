package unique_number_of_occurrences;

import tool.ArrayTestCaseTransformer;

public class Solution {

    public static void main(String[] args) {
        System.out.println(uniqueOccurrences(ArrayTestCaseTransformer.transform("[1,2,2,1,1,3]")));
    }

    public static boolean uniqueOccurrences(int[] arr) {
        int[] counts = new int[2001];
        for(int num : arr) {
            counts[num+1000]++;
        }
        int[] counts2 = new int[1000];



        for(int count : counts) {
            if (count !=0) {

                counts2[count]++;
            }
        }

        for(int count : counts2) {
            if(count > 1) {
                return false;
            }
        }
        return true;
    }
}
