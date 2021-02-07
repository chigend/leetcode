package design_phone_directory;

class PhoneDirectory {

    private int[] nums;

    private boolean[] used;

    private int index;

    /**
     * Initialize your data structure here
     *
     * @param maxNumbers - The maximum numbers that can be stored in the phone directory.
     */
    public PhoneDirectory(int maxNumbers) {
        nums = new int[maxNumbers];
        for (int i = 0; i < maxNumbers; i++) {
            nums[i] = i;
        }
        used = new boolean[maxNumbers];
        index = maxNumbers - 1;
    }

    /**
     * Provide a number which is not assigned to anyone.
     *
     * @return - Return an available number. Return -1 if none is available.
     */
    public int get() {
        if (index < 0) {
            return -1;
        }
        int apply = nums[index--];
        used[apply] = true;
        return apply;
    }

    /**
     * Check if a number is available or not.
     */
    public boolean check(int number) {
        return !used[number];
    }

    /**
     * Recycle or release a number.
     */
    public void release(int number) {
        if (used[number]) {
            used[number] = false;
            nums[++index] = number;
        }
    }



    public static void main(String[] args) {
        PhoneDirectory d = new PhoneDirectory(3);
        System.out.println(d.get());
        System.out.println(d.get());
        System.out.println(d.check(2));
        System.out.println(d.get());
        System.out.println(d.check(2));
        d.release(2);
        System.out.println(d.check(2));

    }
}

/**
 * Your PhoneDirectory object will be instantiated and called as such:
 * PhoneDirectory obj = new PhoneDirectory(maxNumbers);
 * int param_1 = obj.get();
 * boolean param_2 = obj.check(number);
 * obj.release(number);
 */