package non_decreasing_array;

public class Solution {
    public static void main(String[] args) {
        boolean possiable = checkPossibility(new int[]{2,3,3,2,4});
        System.out.println(possiable);
    }

    public static boolean checkPossibility(int[] nums) {
        //the array used as a stack
        int[] stack = new int[nums.length];
        //the pointer which indicate the current position in the stack
        int curor = 0;
        //push the first element into the stack
        stack[0] = nums[0];
        int count = 0;
        for (int i = 1; i < nums.length; i++) {
            //once there exist nums[i] < num[i-1], it means the current number or the previous
            // number is wrong,we should set it to appropriate number,and count the modification
            //once the modify time is greater than 1,it is invalid non-decreasing array
            if (nums[i] < stack[curor]) {
                //the hardest part is to determine which one(current num or previous num) is wrong
                //now cursor means the current position in stack, there means the previous num
                //if we want to set the previous number to the current number and find the number before
                // the previous number(cursor-1) now will be larger than the previous number,it is invalid
                // because there are two modifications,so in this case, we modify the current num to be previous
                //number
                //look at the example
                // position 0 1 2 3 4
                // elements 2 3 3 2 3
                //when we reach the second 2 at position 3, we should decide to modify the previous number (3 at position 2)
                //or current number at position 3,if we set the previous number (3 at position 2) to be the current num,
                //we find the number before the previous number(3 at position 1) will be large than 2,so in this case, it
                //is invalid.so we are going to modify the current num(2 at position 3),we set it the previous num 3
                //and the number 3 at position 4 is greater or equal to 3,so we just modify once,and it is valid.

                if (curor > 0 && stack[curor - 1] > nums[i]) {
                    nums[i] = stack[curor];
                }else {
                    //another case when we should modify the previous number other than the current num
                    //if the stack has only one element,so there is not exist the number before previous num
                    //and there it goes,or when we set the previous number to current number , and it is also
                    //greater or equal than the previous num(the num before previous num),in these two case,
                    //we should set the previous num to current num.
                    //look at example:
                    //position  0  1 2 3
                    //elements -1  4 2 3

                    //when we reach the number 2 at position 2,if we set the previous num 4 at position 1
                    //it is also greater than the number before(-1 at position 0) so it is a valid modification
                    stack[curor] = nums[i];
                }
                if (++count > 1) {
                    return false;
                }
            }
            //every time we push the current num into the stack;
            stack[++curor] = nums[i];
        }
        return true;
    }
}
