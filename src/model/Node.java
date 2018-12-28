package model;

import java.util.List;

public class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;

    public List<Node> children;

    public Node() {}

    public Node(int _val,List<Node> _children) {
        val = _val;
        children = _children;
    }

    public Node(int val) {
        this.val = val;
    }
};