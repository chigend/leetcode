package convert_a_number_to_hexadecimal;

/**
 * @author yejinbiao
 * @create 2017-03-16-下午8:58
 */

public class Solution {
    public static void main(String[] args) {
        System.out.print(toHex(26));
    }


    public static String toHex(int num) {
        if (num == 0) {
            return "0";
        }
        char [] hexes = {'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f'};
        StringBuilder sb = new StringBuilder();
        while (num != 0) {
            int hex = num & 15;
            num >>>= 4;
            sb.insert(0,hexes[hex]);
        }
        return sb.toString();
    }
}
