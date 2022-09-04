package chuan_di_xin_xi;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

import tool.ArrayTestCaseTransformer;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][]d = {{0,2},{2,1},{3,4},{2,3},{1,4},{2,0},{0,4}};
        System.out.println(solution.numWays(5, d, 3));
    }

    /**
     * 朴素写法
     * @param n
     * @param relation
     * @param k
     * @return
     */
    public int numWays(int n, int[][] relation, int k) {
        Map<Integer, List<Integer>> hash = new HashMap<>();
        for(int[] edge: relation){
            if(hash.get(edge[0]) == null) {
                hash.put(edge[0], new ArrayList<>());
            }
            hash.get(edge[0]).add(edge[1]);
        }
        Queue<Integer> q = new LinkedList<>();
        q.offer(0);

        int res = 0;
        while(k > 0 && !q.isEmpty()) {
            int size = q.size();
            k--;
            for (int i = 0; i < size; i++) {
                int t = q.remove();
                if(hash.get(t) != null) {
                    for(int to : hash.get(t)) {
                        if(k == 0 && to == n - 1) {
                            res += 1;
                        }
                        q.offer(to);
                    }
                }
            }
        }
        return res;
    }
}
