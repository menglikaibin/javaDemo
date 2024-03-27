package com.demo.linkList;

/**
 * @author 吴凯斌
 * 创建时间 2024/3/26 13:30
 */
public class RotateRight {

    public static ListNode rotateRight(ListNode head, int k) {
        int length = 0;

        ListNode total = head;
        while (total != null) {
            total = total.next;
            length ++;
        }

        if (length == 0) {
            return head;
        }

        k = length - k % length;
        if (k == 0) {
            return head;
        }

        ListNode newHead = new ListNode(0);
        ListNode newTail = new ListNode(0);

        ListNode currentNewHead = newHead;
        ListNode currentNewTail = newTail;
        int offset = 1;

        while (head != null) {
            if (offset <= k) {
                currentNewHead.next = new ListNode(head.val);
                currentNewHead = currentNewHead.next;
            } else {
                currentNewTail.next = new ListNode(head.val);
                currentNewTail = currentNewTail.next;
            }
            offset ++;

            head = head.next;
        }

        currentNewTail.next = newHead.next;

        return newTail.next;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        ListNode fromEnd = rotateRight(listNode, 2);
        while (fromEnd != null) {
            System.out.println(fromEnd.val);
            fromEnd = fromEnd.next;
        }
    }
}
