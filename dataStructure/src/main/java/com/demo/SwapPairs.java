package com.demo;

/**
 * @author 吴凯斌
 * 创建时间 2024/3/26 11:08
 */
public class SwapPairs {

    public static ListNode swapPairs(ListNode head) {
        if (head == null) {
            return null;
        }

        if (head.next == null) {
            return head;
        }

        ListNode result = new ListNode(0);
        ListNode current = result;

        while (head != null) {
            if (head.next != null) {
                current.next = new ListNode(head.next.val);
                current.next.next = new ListNode(head.val);

                head = head.next.next;
                current = current.next.next;
            } else {
                current.next = new ListNode(head.val);

                head = null;
            }
        }

        return result.next;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))));
        ListNode fromEnd = swapPairs(listNode);
        while (fromEnd != null) {
            System.out.println(fromEnd.val);
            fromEnd = fromEnd.next;
        }
    }

}
