package min_stack;

import java.util.Stack;

/**
 * @author yejinbiao
 * @create 2017-03-14-下午2:19
 */

public class MinStack {
    private Stack<Integer> data;
    private Stack<Integer> minValues;
    private int min = Integer.MAX_VALUE;

    public MinStack() {
        data = new Stack<>();
        minValues = new Stack<>();
    }

    public void push(int x) {
        if (x <= min) {
            minValues.push(min);
            min = x;
        }
        data.push(x);
    }

    public void pop() {
        if (data.size() == 0) {
            return;
        }
        min = data.pop() == min ? minValues.pop() : min;
    }

    public int top() {
        return data.size() == 0 ? -1:data.peek();
    }

    public int getMin() {
        return min;
    }
}
