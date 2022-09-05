package special_array_with_x_elements_greater_than_or_equal_x;

class Solution {
    public int specialArray(int[] nums) {
        int[] count = new int[1001];
        for(int num : nums) count[num]++;
        int res = 0;
        for(int x = 1000; x >=0; x--) {
            res += count[x];
            if(res == x) {
                return x;
            }
        }
        return -1;

    }
}