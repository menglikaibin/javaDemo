package com.demo.stack;

import com.demo.linkList.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 143. 重排链表
 * 中等
 * 相关标签
 * 相关企业
 * 给定一个单链表 L 的头节点 head ，单链表 L 表示为：
 *
 * L0 → L1 → … → Ln - 1 → Ln
 * 请将其重新排列后变为：
 *
 * L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
 * 不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 *
 *
 *
 * 示例 1：
 *
 *
 *
 * 输入：head = [1,2,3,4]
 * 输出：[1,4,2,3]
 * 示例 2：
 *
 *
 *
 * 输入：head = [1,2,3,4,5]
 * 输出：[1,5,2,4,3]
 *
 *
 * 提示：
 *
 * 链表的长度范围为 [1, 5 * 104]
 * 1 <= node.val <= 1000
 */
public class ReorderList {

    public void reorderList(ListNode head) {
        List<ListNode> list = new ArrayList<>();
        while (head != null) {
            list.add(head);
            head = head.next;
        }

        ListNode result = new ListNode();
        ListNode newHead = result;
        for (int i = 0; i < list.size(); i++) {
            if (i % 2 == 0) {
                ListNode listNode = list.get(i / 2);
                listNode.next = null;
                newHead.next = listNode;
                newHead = newHead.next;
            } else {
                ListNode listNode = list.get(list.size() - 1 - (i / 2));
                listNode.next = null;
                newHead.next = listNode;
                newHead = newHead.next;
            }
        }

        head = result.next;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));

        ReorderList reorderList = new ReorderList();
        reorderList.reorderList(listNode);

        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }
}
