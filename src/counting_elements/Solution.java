package counting_elements;

public class Solution {

    public static void main(String[] args) {

    }

    public int countElements(int[] arr) {
        int[] counts = new int[1001];
        for(int i = 0; i < arr.length; i++) {
            counts[arr[i]]++;
        }

        int count = 0;
        for(int i =0; i < 1000; i++) {
            if(counts[i] > 0 && counts[i+1]>0) {
                count += counts[i];
            }
        }
        return count;
    }
}
