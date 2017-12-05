package peeking_iterator;

import java.util.Iterator;

public class PeekingIterator implements Iterator<Integer> {
    private Integer next;
    private boolean peekEleConsumed;
    private Iterator<Integer> iterator;
    public PeekingIterator(Iterator<Integer> iterator) {
        // initialize any member here.
        this.iterator = iterator;
        peekEleConsumed = true;
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        if (next != null) {
            return next;
        }
        next = iterator.next();
        peekEleConsumed = false;
        return next;
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
        if (peekEleConsumed) {
            return iterator.next();
        }else {
            Integer result = next;
            peekEleConsumed = true;
            next = null;
            return result;
        }
    }

    @Override
    public boolean hasNext() {
        return !peekEleConsumed || iterator.hasNext();
    }
}
