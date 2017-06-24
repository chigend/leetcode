package can_place_flowers;

/**
 * @author yejinbiao
 * @create 2017-06-24-15:57
 */

public class Solution {
    public static void main(String[] args) {
        int[] nums = {0,0,0,0,0};
        boolean can = canPlaceFlowers(nums,4);
        System.out.println(can);
    }
    public static boolean canPlaceFlowers(int[] flowerbed, int n) {
        //a mark to indicate how many empty spots have appeared before,since the first spot can
        //plant flower except the next spot hasn't been planted,so init variable 'empty' with 1
        int empty = 1;
        int flowers = 0;
        for (int i = 0; i < flowerbed.length ; i++) {
            int num = flowerbed[i];
            if (num == 1) {
                //if the spot has been planted, reset the empty to zero
                empty = 0;
            }else if (empty == 1) {
                //it is  need to judge if the next spot has been planted except the last spot
                int next = i == flowerbed.length - 1 ? 0 : flowerbed[i+1];
                if (next == 0) {
                    flowers++;
                    empty = 0;
                }
            }else {
                empty++;
            }

        }

        return flowers >= n;
    }
}
