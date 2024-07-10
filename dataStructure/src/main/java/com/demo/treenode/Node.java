package com.demo.treenode;

/**
 * @author wukaibin
 */
public class Node {

    int val;
    Node left;
    Node right;
    Node next;

    Node(int val) { this.val = val; }
    Node(int val, Node left, Node right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
