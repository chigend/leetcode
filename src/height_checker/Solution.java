package height_checker;

public class Solution {

    public static void main(String[] args) {
        int i = heightChecker(new int[]{1,2,3,4,5});
        System.out.println(i);
    }

    public static int heightChecker(int[] heights) {
        int[] counts = new  int[100];
        for (int height : heights) {
            counts[height - 1]++;
        }
        int[] sorted = new int[heights.length];
        int index = 0;
        for (int i = 0; i < counts.length; i++) {
            int num = i + 1;
            int count = counts[i];
            while (count > 0) {
                sorted[index++] = num;
                count--;
            }
        }
        int diff = 0;
        for (int i = 0; i < heights.length; i++) {
            if (heights[i] != sorted[i]) {
                diff++;
            }
        }
        return diff;
    }
}
