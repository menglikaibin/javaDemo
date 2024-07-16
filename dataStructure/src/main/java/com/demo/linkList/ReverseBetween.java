package com.demo.linkList;

/**
 * 92,反转链表2
 * 给你单链表的头指针 head 和两个整数 left 和 right ，其中 left <= right 。请你反转从位置 left 到位置 right 的链表节点，返回 反转后的链表 。
 *
 * 示例 1：
 *
 *
 * 输入：head = [1,2,3,4,5], left = 2, right = 4
 * 输出：[1,4,3,2,5]
 * 示例 2：
 *
 * 输入：head = [5], left = 1, right = 1
 * 输出：[5]
 * 提示：
 *
 * 链表中节点数目为 n
 * 1 <= n <= 500
 * -500 <= Node.val <= 500
 * 1 <= left <= right <= n
 */
public class ReverseBetween {

    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || head.next == null || left == right) {
            return head;
        }

        ListNode data = new ListNode(0);

        data.next = head;
        ListNode pre = data;

        for (int i = 1; i < left; i++) {
            // 定位pre节点到第一个需要交换的节点的上一个节点
            pre = pre.next;
        }

        // 定义cur节点为第一个节点
        // 1->2->3->4->5->6
        // 1->3->2->4->5->6
        // 1->4->3->2->5->6
        ListNode cur = pre.next;
        for (int i = left; i < right; i++) {
            // 第1次循环 获取cur的next节点:3节点
            // 第2次循环 获取cur的next节点:4节点
            ListNode next = cur.next;

            // 第1次循环 设置2节点->4节点
            // 第2次循环 设置2节点->5节点
            cur.next = next.next;
            // 第1次循环 设置3节点->2节点
            // 第2次循环 设置4节点->3节点
            next.next = pre.next;

            // 第1次循环 设置1节点->3节点
            // 第2次循环 设置1节点->4节点
            pre.next = next;
        }

        return data.next;
    }

    public static void main(String[] args) {
        ReverseBetween reverseList = new ReverseBetween();

        ListNode listNode = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, new ListNode(6))))));
        ListNode node = reverseList.reverseBetween(listNode, 2, 4);

        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }

}
