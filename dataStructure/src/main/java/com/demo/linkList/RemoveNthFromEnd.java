package com.demo.linkList;

/**
 * @author 吴凯斌
 * 创建时间 2024/3/26 10:27
 */
public class RemoveNthFromEnd {

    public static ListNode removeNthFromEnd(ListNode head, int n)
    {
        ListNode total = head;
        int size = 0;
        while (total != null) {
            size ++;
            total = total.next;
        }

        int index = size - n;

        ListNode result = new ListNode(0);

        ListNode current = result;
        int cur = 0;
        while (head != null) {
            if (cur == index) {
                cur ++;
                head = head.next;
                continue;
            }
            cur ++;
            current.next = new ListNode(head.val);

            current = current.next;

            head = head.next;
        }

        return result.next;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))));
        ListNode fromEnd = removeNthFromEnd(listNode, 2);
        while (fromEnd != null) {
            System.out.println(fromEnd.val);
            fromEnd = fromEnd.next;
        }
    }
}
