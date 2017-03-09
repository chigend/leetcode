package LFU_cache;

import java.util.*;

/**
 * 2016/11/25
 */
public class LFUCache {
    private Map<Integer, Data> hashtable;

    private int capacity;

    private Frequency leastFrequency = null;

    private Stack<Frequency> leastFrequencys = new Stack<>();
    private List<Integer> leastUseKeys = new ArrayList<>();

    public LFUCache(int capacity) {
        this.capacity = capacity;
        hashtable = new HashMap<Integer, Data>();
    }

    public int get(int key) {
        Data data = hashtable.get(key);
        if (data == null) {
            return -1;
        }
        increaseUseFrequency(data.getFrequency());
        refreshKeyUsed(key);
        return data.getValue();
    }

    private void increaseUseFrequency(Frequency frequency) {
        frequency.setValue(frequency.getValue() + 1);
        if (leastUseKeys.size() > 1 && frequency == leastFrequency) {
            leastFrequency = leastFrequencys.size() == 0 ? null : leastFrequencys.pop();
        }
    }

    private void refreshKeyUsed(Integer key) {
        leastUseKeys.remove(key);
        leastUseKeys.add(key);
    }

    public void put(int key, int value) {
        if (capacity == 0) {
            return;
        }

        Data data = hashtable.get(key);
        if (data == null) {
            if (hashtable.size() == capacity) {
                Integer leastRecentKey = leastUseKeys.get(0);
                Data data1 = hashtable.get(leastRecentKey);
                if (data1.getFrequency().getValue() == leastFrequency.getValue()) {
                    System.out.println("evict leastRecent key:" + leastRecentKey);
                    if (data1.getFrequency() == leastFrequency) {
                        leastFrequency = leastFrequencys.size() == 0 ? null : leastFrequencys.pop();
                    }
                    leastUseKeys.remove(0);
                    hashtable.remove(leastRecentKey);
                } else {
                    Integer leastFrequencyKey = leastFrequency.getKey();
                    System.out.println("evict leastFrequecy key:" + leastFrequencyKey);
                    leastUseKeys.remove(leastFrequencyKey);
                    leastFrequency = leastFrequencys.pop();
                    hashtable.remove(leastFrequencyKey);
                }
            }
            Frequency frequency = new Frequency(0, key);
            if (leastFrequency != null) {
                leastFrequencys.push(leastFrequency);
            }
            data = new Data(value, frequency);
            leastFrequency = frequency;
            leastUseKeys.add(key);
        } else {
            increaseUseFrequency(data.getFrequency());
            refreshKeyUsed(key);
            data.setValue(value);
        }
        hashtable.put(key, data);
    }


    class Data {
        private Integer value;
        private Frequency frequency;


        public Data(Integer value, Frequency frequency) {
            this.value = value;
            this.frequency = frequency;
        }

        public Integer getValue() {
            return value;
        }

        public void setValue(Integer value) {
            this.value = value;
        }

        public Frequency getFrequency() {
            return frequency;
        }

        public void setFrequency(Frequency frequency) {
            this.frequency = frequency;
        }
    }

    class Frequency {
        private int value;

        private int key;

        public Frequency(int value, int key) {
            this.value = value;
            this.key = key;
        }

        public int getKey() {
            return key;
        }

        public void setKey(int key) {
            this.key = key;
        }

        public Frequency(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }
    }

}
