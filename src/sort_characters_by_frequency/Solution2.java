package sort_characters_by_frequency;

import java.util.HashMap;
import java.util.Map;

/**
 * max-heap solution
 */
public class Solution2 {
    public static void main(String[] args) {
        String result = frequencySort("Aabb");
        System.out.println(result);
    }

    public  static String frequencySort(String s) {
        char[] chs = s.toCharArray();
        Map<Character, Integer> countMap = new HashMap<>();
        for (char c : chs) {
            countMap.put(c, countMap.getOrDefault(c, 0) + 1);
        }
        MaxHeap maxHeap = new MaxHeap(countMap.size());
        for (Map.Entry entry : countMap.entrySet()) {
            maxHeap.add(entry);
        }
        return maxHeap.getSortResult();
    }

    static class MaxHeap{
        private Map.Entry<Character, Integer>[]heap;
        private int size;

        public MaxHeap(int n) {
            heap = new Map.Entry[n];
        }

        public void add(Map.Entry entry) {
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
            Map.Entry entry = heap[i];
            heap[i] = heap[j];
            heap[j] = entry;
        }

        public String getSortResult(){
            StringBuilder sb = new StringBuilder();
            for (int i = size - 1; i >=0; i-- ) {
                Map.Entry<Character, Integer> entry = heap[0];
                for (int j = 0; j < entry.getValue(); j++) {
                    sb.append(entry.getKey());
                }
                swap(0, size - 1);
                size--;
                siftDown(0);
            }
            return sb.toString();
        }
    }
}
