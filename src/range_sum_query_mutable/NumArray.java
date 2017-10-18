package range_sum_query_mutable;

class NumArray {
    private int[] nums;

    private Node[] segment;

    public NumArray(int[] nums) {
        if (nums.length == 0) {
            return;
        }
        this.nums = nums;
        segment = new Node[4 * nums.length];
        build(0, 0, nums.length - 1);
    }

    public void update(int i, int val) {
        update(i, 0, val);
    }

    private void update(int i, int node, int val) {
        int l = segment[node].l;
        int r = segment[node].r;
        if (i < l || i > r) {
            return;
        }
        if (l == r) {
            segment[node].sum = val;
        } else {
            int med = (l + r) >>> 1;
            if (i <= med) {
                update(i, 2 * node + 1, val);
            } else {
                update(i, 2 * node + 2, val);
            }
            segment[node].sum = segment[2 * node + 1].sum + segment[2 * node + 2].sum;
        }
    }

    public int sumRange(int i, int j) {
        return query(0, i, j);
    }

    private int query(int node, int begin, int end) {
        int l = segment[node].l;
        int r = segment[node].r;
        if (end < l || begin > r) {
            return 0;
        }
        if (begin <= l && end >= r) {
            return segment[node].sum;
        }
        int lSum = query(2 * node + 1, begin, end);
        int rSum = query(2 * node + 2, begin, end);
        return lSum + rSum;
    }

    private void build(int i, int begin, int end) {
        if (begin == end) {
            segment[i] = new Node(nums[begin], begin, begin);
        } else {
            int med = (begin + end) >>> 1;
            build(2 * i + 1, begin, med);
            build(2 * i + 2, med + 1, end);
            segment[i] = new Node(segment[2 * i + 1].sum + segment[2 * i + 2].sum, begin, end);
        }
    }

    class Node {
        int sum;
        int l;
        int r;

        public Node(int sum, int l, int r) {
            this.sum = sum;
            this.l = l;
            this.r = r;
        }
    }
}