package group_the_people_given_the_group_size_they_belong_to;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {

    }

    public List<List<Integer>> groupThePeople(int[] groupSizes) {

        List [] bucket = new List[501];
        List<List<Integer>> res = new ArrayList<>();

        for(int i = 0 ; i <  groupSizes.length; i++) {
            int groupSize = groupSizes[i];
            if (bucket[groupSize] == null) {
                bucket[groupSize] = new ArrayList<>();
            }
            bucket[groupSize].add(i);
            if(bucket[groupSize].size() == groupSize) {
                res.add(bucket[groupSize]);
                bucket[groupSize] = null;
            }
        }


        return res;

    }
}
