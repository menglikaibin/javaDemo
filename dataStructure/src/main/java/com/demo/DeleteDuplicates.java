package com.demo;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 吴凯斌
 * 创建时间 2024/3/26 14:39
 */
public class DeleteDuplicates {

    public static ListNode deleteDuplicates(ListNode head) {
        List<Integer> duplicateList = new ArrayList<>();

        ListNode result = new ListNode(0);

        ListNode current = result;
        while (head != null) {
            if (!duplicateList.contains(head.val)) {
                if (head.next != null) {
                    if (head.val != head.next.val) {
                        current.next = new ListNode(head.val);

                        current = current.next;
                    } else {
                        duplicateList.add(head.val);
                    }
                } else {
                    current.next = new ListNode(head.val);

                    current = current.next;
                }

                head = head.next;
            } else {
                head = head.next;
            }
        }

        return result.next;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1, new ListNode(1, new ListNode(2, new ListNode(2, new ListNode(5)))));
        ListNode fromEnd = deleteDuplicates(listNode);
        while (fromEnd != null) {
            System.out.println(fromEnd.val);
            fromEnd = fromEnd.next;
        }
    }
}
