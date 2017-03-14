package min_stack;

/**
 * @author yejinbiao
 * @create 2017-03-14-下午2:34
 */

public class Main {
    public static void main(String[] args) {
        MinStack stack = new MinStack();
        stack.push(-2);
        stack.push(0);
        stack.push(-3);
        stack.getMin();
        stack.pop();
        stack.top();
        stack.getMin();
    }
}
