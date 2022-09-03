package design_an_ordered_stream;

import java.util.ArrayList;
import java.util.List;

class OrderedStream {

    private String[] values;

    private int p;

    public OrderedStream(int n) {
        values = new String[n + 1];
        p = 1;
    }

    public List<String> insert(int idKey, String value) {
        values[idKey] = value;
        List<String> res = new ArrayList<>();
        while (p < values.length && values[p] != null) {
            res.add(values[p++]);
        }
        return res;
    }

    public static void main(String[] args) {
        OrderedStream s = new OrderedStream(5);
        System.out.println(s.insert(3, "ccc"));
        System.out.println(s.insert(1, "aaa"));
        System.out.println(s.insert(2, "bbb"));
        System.out.println(s.insert(5, "eee"));
        System.out.println(s.insert(4, "ddd"));
    }
}
