package design_circular_deque;

class MyCircularDeque {

    private class Node{
        int val;

        Node next;

        Node prev;

        private Node(int val){
            this.val = val;
        }
    }

    private int capacity;
    private int size;
    private Node fakeHead;
    private Node fakeTail;
    public MyCircularDeque(int k) {
        this.capacity = k;
        this.size = 0;
        this.fakeHead = new Node(-1);
        this.fakeTail = new Node(-1);
        this.fakeHead.next = this.fakeTail;
        this.fakeTail.prev = this.fakeHead;
    }

    public boolean insertFront(int value) {
        if(size >= this.capacity) {
            return false;
        }
        Node after = fakeHead.next;
        Node insert = new Node(value);
        fakeHead.next = insert;
        insert.prev = fakeHead;

        insert.next = after;
        after.prev = insert;
        this.size ++;
        return true;
    }

    public boolean insertLast(int value) {
        if(size >= this.capacity) {
            return false;
        }
        Node before = fakeTail.prev;
        Node insert  = new Node(value);
        before.next = insert;
        insert.prev = before;

        insert.next = fakeTail;
        fakeTail.prev = insert;
        this.size ++;
        return true;
    }

    public boolean deleteFront() {
        if(this.size == 0) {
            return false;
        }

        fakeHead.next.next.prev = fakeHead;
        fakeHead.next = fakeHead.next.next;
        this.size--;
        return true;
    }

    public boolean deleteLast() {
        if(this.size == 0) {
            return false;
        }

        fakeTail.prev.prev.next = fakeTail;
        fakeTail.prev = fakeTail.prev.prev;

        this.size--;
        return true;
    }


    public int getFront() {
        return this.size == 0 ? -1 : fakeHead.next.val;
    }

    public int getRear() {
        return this.size == 0?-1: fakeTail.prev.val;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public boolean isFull() {
        return this.capacity == this.size;
    }

    public static void main(String[] args) {
        MyCircularDeque deque = new MyCircularDeque(3);
        deque.insertLast(1);
        deque.insertLast(2);
        deque.insertFront(3);
        deque.insertFront(4);
        System.out.println(deque.getRear());

    }
}