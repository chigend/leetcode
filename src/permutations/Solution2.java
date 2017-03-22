package permutations;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yejinbiao
 * @create 2017-03-22-下午1:19
 */

public class Solution2 {
    public static void main(String[] args) {
        int [] num = {1};
        System.out.print(permute(num));
    }

    public static List<List<Integer>> permute(int[] num) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        for (int i = 0; i < num.length; i++) {
            List<List<Integer>> new_result = new ArrayList<>();
            /**
             * insert every number at every position of the permutations that made by the number
             * before current number,example: the array is {1,2,3},  init with {{}},
             * first,when insert 1,so we insert 1 at 0 position of the only list in result,
             *  secondly, when insert 2,since the i is 1,so there are two positions as 0,1 that we
             *  can insert. so we insert 2 and generate two new list with{1,2},{2,1}, 2*1=2
             *  lastly,when insert 3,since the i is 2,so there are three positions, as 0,1,2 that we
             *  can insert ,so we insert 3 at the positions above of all the list that generated before
             *  3*2=6
             */
            for(int j = 0; j <= i; j++) {
                for (List<Integer> list : result) {
                    List<Integer> new_list = new ArrayList<>(list);
                    new_list.add(j, num[i]);
                    new_result.add(new_list);
                }
            }
            result = new_result;
        }

        return result;
    }
}
