package top_k_frequent_elements;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution2 {
    public static void main(String[] args) {
        int[] nums = {1,1,1,2,2,3};
        System.out.println(topKFrequent(nums, 2));
    }

    public static List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int num : nums) countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        MaxHeap maxHeap = new MaxHeap(countMap.size());
        for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            maxHeap.add(entry);
        }
        return maxHeap.getTopK(k);
    }

    static class MaxHeap{
        private Map.Entry<Integer, Integer> [] heap;
        private int size;

        public MaxHeap(int n) {
            this.heap = new Map.Entry[n];
        }

        public void add(Map.Entry<Integer, Integer> entry) {
            heap[size++] = entry;
            siftUp(size - 1);
        }

        private void siftUp(int i) {
            if (i > 0) {
                int parent = (i - 1) >>> 1;
                if (heap[i].getValue() > heap[parent].getValue()) {
                    swap(i, parent);
                    siftUp(parent);
                }
            }
        }

        private void siftDown(int i) {
            int l = 2 * i + 1;
            int r = 2 * i + 2;
            if (l >= size) {
                return;
            }
            if (r < size && heap[r].getValue() > heap[l].getValue()) {
                l = r;
            }
            if (heap[i].getValue() < heap[l].getValue()) {
                swap(i, l);
                siftDown(l);
            }

        }
        private void swap(int i, int j) {
            Map.Entry temp = heap[i];
            heap[i] = heap[j];
            heap[j] = temp;
        }

        public List<Integer> getTopK(int k) {
            List<Integer> result = new ArrayList<>();
            for (int i = 0; i < k; i++) {
                result.add(heap[0].getKey());
                swap(0, size - 1);
                size--;
                siftDown(0);
            }
            return result;
        }
    }
}
