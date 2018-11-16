package design_linked_list;

class MyLinkedList {

    private Node head;

    private Node tail;

    private int size;

    /** Initialize your data structure here. */
    public MyLinkedList() {

    }

    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        Node node = get0(index);
        return node == null ? -1 : node.val;
    }

    private Node get0(int index) {
        if (index >= size) {
            return null;
        }
        Node node = head;
        while (index-- > 0) {
            node = node.next;
        }
        return node;
    }

    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        Node newHead = new Node(val);
        if (tail == null) {
            tail = newHead;
        }
        newHead.next = head;
        head = newHead;
        size++;
    }

    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        Node newTail = new Node(val);
        if (tail == null) {
            head = newTail;
        }else {
            tail.next = newTail;
        }
        tail = newTail;
        size++;
    }

    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        if (index > size) {
            return;
        }
        if (index == 0) {
            addAtHead(val);
        }else if (index == size) {
            addAtTail(val);
        }else {
            Node node = head;
            //find the node before index-th node
            while (--index > 0) {
                node = node.next;
            }
            Node newNode = new Node(val);
            newNode.next = node.next;
            node.next = newNode;
            size++;
        }
    }

    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        if (index >= size) {
            return;
        }
        if (index == 0) {
            head = head.next;
            tail = head == null ? null : tail;
        }else {
            Node node = head;
            while (--index > 0) {
                node = node.next;
            }
            if (tail == node.next) {
                tail = node;
            }
            node.next = node.next.next;

        }
        size--;
    }

    class Node{
        int val;
        Node next;

        public Node() {
        }

        public Node(int val) {
            this.val = val;
        }
    }
}


/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */