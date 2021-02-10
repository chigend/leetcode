package deep_dark_fraction;

public class Solution {

    public static void main(String[] args) {

    }

    public int[] fraction(int[] cont) {
        int[] res = new int[2];
        res[0] = cont[cont.length-1];
        res[1] = 1;
        for(int i = cont.length-2; i >= 0; i--) {
            int t = res[1];
            res[1] = res[0];
            res[0] = t;

            res[0] = cont[i] * res[1]  + res[0];
        }
        return res;


    }
}
