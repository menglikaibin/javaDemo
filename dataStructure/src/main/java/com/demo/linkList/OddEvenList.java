package com.demo.linkList;

/**
 * 328,奇偶链表
 *
 * 给定单链表的头节点 head ，将所有索引为奇数的节点和索引为偶数的节点分别组合在一起，然后返回重新排序的列表。
 *
 * 第一个节点的索引被认为是 奇数 ， 第二个节点的索引为 偶数 ，以此类推。
 *
 * 请注意，偶数组和奇数组内部的相对顺序应该与输入时保持一致。
 *
 * 你必须在 O(1) 的额外空间复杂度和 O(n) 的时间复杂度下解决这个问题。
 *
 * 示例 1:
 * 输入: head = [1,2,3,4,5]
 * 输出: [1,3,5,2,4]
 *
 * 示例 2:
 * 输入: head = [2,1,3,5,6,4,7]
 * 输出: [2,3,6,7,1,5,4]
 * 提示:
 *
 * n ==  链表中的节点数
 * 0 <= n <= 104
 * -106 <= Node.val <= 106
 * Related Topics
 * 链表
 */
public class OddEvenList {

    public ListNode oddEvenList(ListNode head) {
        ListNode firstList = new ListNode(0);
        ListNode first = firstList;

        ListNode secondList = new ListNode(0);
        ListNode second = secondList;

        int count = 1;
        while (head != null) {
            if (count % 2 != 0) {
                first.next = new ListNode(head.val);
                first = first.next;
            } else {
                second.next = new ListNode(head.val);
                second = second.next;
            }

            head = head.next;
            if (head == null) {
                first.next = secondList.next;
            }

            count ++;
        }

        return firstList.next;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, new ListNode(6))))));

        OddEvenList oddEvenList = new OddEvenList();
        ListNode result = oddEvenList.oddEvenList(listNode);

        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }
}
