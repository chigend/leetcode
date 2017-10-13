package top_k_frequent_words;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * follow up 1,solve in O(nlgnk) time and O(n) space
 */
public class Solution2 {
    public static void main(String[] args) {
        String[] words = {"i", "love", "leetcode", "i", "love", "coding"};
        System.out.println(topKFrequent(words, 2));

    }

    public static List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> countMap = new HashMap<>();
        for (String word : words) {
            int count = countMap.getOrDefault(word, 0);
            countMap.put(word, ++count);
        }
        MaxHeap heap = new MaxHeap(countMap.size());
        for (Map.Entry entry : countMap.entrySet()) {
            heap.add(entry);
        }
        return heap.getTopK(k);
    }

    /**
     * 堆化的过程可以是全部元素塞到数组后，再对size／2-1之前的元素都进行siftDown操作
     * 也可以添加一个元素就进行一次siftUp操作.
     */
    static class MaxHeap {
        private Map.Entry<String, Integer>[] heap;

        public MaxHeap(int n) {
            this.heap = new Map.Entry[n];
        }

        private Comparator<Map.Entry<String, Integer>> comparator = new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                int temp = o2.getValue() - o1.getValue();
                return temp == 0 ? o1.getKey().compareTo(o2.getKey()) : temp;
            }
        };

        private int size = 0;

        public MaxHeap(Set<Map.Entry<String, Integer>> entries) {
            this.heap = new Map.Entry[entries.size()];
            for (Map.Entry entry : entries) {
                heap[size++] = entry;
            }
            bulidMaxHeap();
        }

        private void bulidMaxHeap() {
            for (int i = size / 2 - 1; i >= 0; i--) {
                siftDown(i);
            }
        }

        public void add(Map.Entry entry) {
            heap[size++] = entry;
            siftUp(size - 1);
        }

        private void siftUp(int i) {
            if (i > 0) {
                int parent = (i - 1) / 2;
                if (comparator.compare(heap[i], heap[parent]) < 0) {
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
            if (r < size && comparator.compare(heap[r], heap[l]) < 0) {
                l = r;
            }
            if (comparator.compare(heap[i], heap[l]) > 0) {
                swap(i, l);
                siftDown(l);
            }
        }

        private void swap(int i, int j) {
            Map.Entry temp = heap[i];
            heap[i] = heap[j];
            heap[j] = temp;
        }

        public List<String> getTopK(int k) {
            List<String> result = new ArrayList<>();
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
