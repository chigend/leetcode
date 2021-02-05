package design_front_middle_back_queue;

import model.ListNode;

public class FrontMiddleBackQueue {

    private ListNode fakeHead;

    private ListNode tail;

    private ListNode middle;

    private int nodeCount;

    public FrontMiddleBackQueue() {
        fakeHead = new ListNode(-1);
        middle = fakeHead;
    }

    public void pushFront(int val) {
        ListNode node = new ListNode(val);
        node.next = fakeHead.next;
        if (nodeCount > 0) {
            fakeHead.next.previous = node;
        } else {
            tail = node;
            middle = node;
        }
        fakeHead.next = node;
        node.previous = fakeHead;

        if ((nodeCount & 1) == 1) {
            middle = middle.previous;
        }
        nodeCount++;
    }

    public void pushMiddle(int val) {
        if (nodeCount == 0) {
            pushFront(val);
        } else {
            ListNode node = new ListNode(val);
            if ((nodeCount & 1) == 0) {
                middle.next.previous = node;
                node.next = middle.next;
                node.previous = middle;
                middle.next = node;
                middle = middle.next;
            } else {
                middle.previous.next = node;
                node.previous = middle.previous;
                node.next = middle;
                middle.previous = node;
                middle = middle.previous;
            }
            nodeCount++;
        }
    }

    public void pushBack(int val) {
        if (nodeCount == 0) {
            pushFront(val);
            return;
        } else {
            ListNode node = new ListNode(val);
            tail.next = node;
            node.previous = tail;
            tail = node;
        }
        if ((nodeCount & 1) == 0) {
            middle = middle.next;
        }
        nodeCount++;

    }

    public int popFront() {
        int popValue;
        if (nodeCount == 0) {
            return -1;
        } else {
            ListNode pop = fakeHead.next;
            fakeHead.next = pop.next;
            if (nodeCount > 1) {
                pop.next.previous = fakeHead;
            } else {
                tail = null;
            }
            popValue = pop.val;
        }

        if ((nodeCount & 1) == 0) {
            middle = middle.next;
        }
        nodeCount--;
        return popValue;
    }

    public int popMiddle() {
        int popValue;

        if (nodeCount == 0) {
            return -1;
        }
        if (nodeCount == 1) {
            return popFront();
        } else {
            middle.previous.next = middle.next;
            middle.next.previous = middle.previous;
            popValue = middle.val;
            if ((nodeCount & 1) == 0) {
                middle = middle.next;
            } else {
                middle = middle.previous;
            }
        }

        nodeCount--;
        return popValue;

    }

    public int popBack() {
        int popValue;

        if (nodeCount == 0) {
            return -1;
        }
        if (nodeCount == 1) {
            return popFront();
        } else {
            ListNode pop = tail;
            tail.previous.next = null;
            tail = pop.previous;
            popValue = pop.val;
        }

        if ((nodeCount & 1) == 1) {
            middle = middle.previous;
        }
        nodeCount--;
        return popValue;

    }

    public static void main(String[] args) {
        FrontMiddleBackQueue d = new FrontMiddleBackQueue();
        d.pushMiddle(772749);
        d.pushMiddle(264112);
        d.pushFront(339812);
        System.out.println(d.popFront());
        System.out.println(d.popMiddle());
        System.out.println(d.popMiddle());
        d.pushMiddle(173630);
        d.pushMiddle(986451);
        d.pushMiddle(711423);
        d.pushFront(288691);
        d.pushMiddle(661516);
        d.pushFront(539917);
        System.out.println(d.popMiddle());
        System.out.println(d.popMiddle());
        d.pushMiddle(30316);
        System.out.println(d.popMiddle());
    }
}