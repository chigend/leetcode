package LFU_cache;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 2016/11/25
 */
public class LFUCache {
    private Map<Integer,Data> hashtable;

    private int capacity;

    private Set<Integer> leastFrequencyKey;

    private int leastFrequency;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        hashtable = new HashMap<Integer,Data>();
    }

    public int get(int key) {
        if(!hashtable.containsKey(key)){
            return -1;
        }
        Data data = hashtable.get(key);
        data.setFrequency(data.getFrequency()+1);
        hashtable.put(key,data);
        return data.getValue();
    }

    public void set(int key, int value) {
        if(hashtable.size() == capacity){

        }
    }
}

class Data{
    private int frequency;
    private Date insertTime;
    private int value;

    public int getFrequency() {
        return frequency;
    }

    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }

    public Date getInsertTime() {
        return insertTime;
    }

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
