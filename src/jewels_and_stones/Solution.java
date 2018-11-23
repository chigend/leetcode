package jewels_and_stones;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        int count = numJewelsInStones("z", "ZZ");
        System.out.println(count);
    }

    public static int numJewelsInStones(String J, String S) {
        char [] jewels = J.toCharArray();
        char [] stones = S.toCharArray();
        int count = 0;
        Set<Character> isJewel = new HashSet<>();
        for (char j : jewels) {
            isJewel.add(j);
        }
        for (char s : stones) {
            if (isJewel.contains(s)){
                count++;
            }
        }
        return count;
    }
}
