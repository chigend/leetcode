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

    /**
     *
     if(area == 0){
     return result;
     }
     int length = (int)(Math.ceil(Math.sqrt(area)));
     while(area%length != 0){
     length++;
     }
     int width = area/length;
     result[0] = length;
     result[1] = width;
     return result;
     *  why increasing the length costs 90ms ,but decreasing the width just costs 5ms
     *
     *  think the area is a very large prime number ,e.g. 1111111111,the width should be 1
     *  and length should be 1111111111, so increase length from sqrt(area) will cost more
     *  than decrease width from sqrt(area)
     */
    //todo
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
