package build_a_matrix_with_conditions;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] input = {{1,2},{7,3},{4,3},{5,8},{7,8},{8,2},{5,8},{3,2},{1,3},{7,6},{4,3},{7,4},{4,8},{7,3},{7,5}};
        int[][] input2 = {{5,7},{2,7},{4,3},{6,7},{4,3},{2,3},{6,2}};
        int[][] ints = solution.buildMatrix(8, input, input2);
        for (int[] anInt : ints) {
            System.out.println(Arrays.toString(anInt));
        }

    }

    public int[][] buildMatrix(int k, int[][] rowConditions, int[][] colConditions) {
        List<Integer> rowOrder = topoSort(rowConditions, k);
        List<Integer> colOrder = topoSort(colConditions, k);
        if (rowOrder == null || colOrder == null) {
            return new int[0][];
        }
        Map<Integer, Integer> colIndexMap = new HashMap<>();
        for (int col = 0; col < k; col++) {
            colIndexMap.put(colOrder.get(col), col);
        }
        int[][] matrix = new int[k][k];
        for (int row = 0; row < k; row++) {
            Integer num = rowOrder.get(row);
            matrix[row][colIndexMap.get(num)] = num;
        }
        return matrix;
    }

    public List<Integer> topoSort(int[][] edges, int k) {

        Map<Integer, ArrayList<Integer>> depends = new HashMap<>();
        int[] left = new int[k];
        for (int[] edge : edges) {
            int above = edge[0] - 1;
            int below = edge[1] - 1;
            if (depends.get(above) == null) {
                depends.put(above, new ArrayList<>());
            }
            left[below]++;
            depends.get(above).add(below);
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < k; i++) {
            if (left[i] == 0) {
                queue.offer(i);
            }
        }
        List<Integer> res = new ArrayList<>();
        while (!queue.isEmpty()) {
            Integer x = queue.remove();
            res.add(x + 1);
            for (int y : depends.getOrDefault(x, new ArrayList<>())) {
                left[y]--;
                if (left[y] == 0) {
                    queue.offer(y);
                }
            }
        }
        return res.size() != k ? null : res;
    }
}
