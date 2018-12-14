package maximize_distance_to_closest_person;

public class Solution {
    public static void main(String [] args) {
        Solution solution = new Solution();
        int max = solution.maxDistToClosest(new int[]{1,0,0,1,0,1,0,1});
        System.out.println(max);
    }
    public int maxDistToClosest(int[] seats) {
        int max = 0;
        int start = 0;
        int end = seats.length - 1;
        while(seats[start] == 0) {
            start++;
        }
        while(seats[end] == 0) {
            end--;
        }
        max = Math.max(start, seats.length - 1 - end);
        int distance = 0;
        for (int i = start; i <= end; i++ ) {
            if (seats[i] == 0) {
                distance ++;
            }else {
                max = Math.max(max, (distance + 1)/2);
                distance = 0;
            }
        }
        return max;
    }
}
