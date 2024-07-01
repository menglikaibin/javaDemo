package com.demo.linkList;

/**
 * @author 吴凯斌
 * 创建时间 2024/3/26 11:07
 */
public class ListNode {
    public int val;
    public ListNode next;

    ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
