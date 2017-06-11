package design_compressed_string_iterator;

/**
 * @author yejinbiao
 * @create 2017-06-11-17:09
 */

public class Solution {
    public static void main(String[] args) {
        StringIterator iterator = new StringIterator("L1e2t1C1o1d1e1");

        iterator.next(); // return 'L'
        iterator.next(); // return 'e'
        iterator.next(); // return 'e'
        iterator.next(); // return 't'
        iterator.next(); // return 'C'
        iterator.next(); // return 'o'
        iterator.next(); // return 'd'
        iterator.hasNext(); // return true
        iterator.next(); // return 'e'
        iterator.hasNext(); // return false
        iterator.next(); // return ' '

    }

}
