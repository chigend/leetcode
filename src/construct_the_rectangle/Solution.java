package construct_the_rectangle;

import java.util.Arrays;

/**
 * @author yejinbiao
 * @create 2017-03-09-下午4:43
 */

public class Solution {
    public static void main(String[] args) {
        int [] arr = constructRectangle(10000000);
        System.out.print(Arrays.toString(arr));
    }

    public static int[] constructRectangle(int area) {
        int[] result = new int[2];
        if(area == 0){
            return result;
        }
        int width = (int)Math.sqrt(area);
        while(area%width != 0){
            width--;
        }
        int length = area/width;
        result[0] = length;
        result[1] = width;
        return result;
    }
}
