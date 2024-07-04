package com.demo.linkList;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 82.删除链表重复元素2
 *
 * 给定一个已排序的链表的头 head ， 删除原始链表中所有重复数字的节点，只留下不同的数字 。返回 已排序的链表 。
 *
 * 示例 1：
 *
 *
 * 输入：head = [1,2,3,3,4,4,5]
 * 输出：[1,2,5]
 * 示例 2：
 *
 *
 * 输入：head = [1,1,1,2,3]
 * 输出：[2,3]
 * 提示：
 *
 * 链表中节点数目在范围 [0, 300] 内
 * -100 <= Node.val <= 100
 * 题目数据保证链表已经按升序 排列
 * Related Topics
 * 链表
 * 双指针
 */
public class DeleteDuplicates {

    public static ListNode deleteDuplicates2(ListNode head) {
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

    /**
     * 给定一个已排序的链表的头 head ， 删除所有重复的元素，使每个元素只出现一次 。返回 已排序的链表 。
     *
     * 示例 1：
     * 输入：head = [1,1,2]
     * 输出：[1,2]
     *
     * 示例 2：
     * 输入：head = [1,1,2,3,3]
     * 输出：[1,2,3]
     * 提示：
     *
     * 链表中节点数目在范围 [0, 300] 内
     * -100 <= Node.val <= 100
     * 题目数据保证链表已经按升序 排列
     * Related Topics
     * 链表
     */
    public ListNode deleteDuplicates1(ListNode head) {
        ListNode result = new ListNode(0);
        ListNode newHead = result;

        Map<Integer, Integer> map = new HashMap<>(300);

        while (head != null) {
            if (map.get(head.val) == null) {
                newHead.next = new ListNode(head.val);
                newHead = newHead.next;
                map.put(head.val, head.val);
            }
            head = head.next;
        }

        return result.next;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1, new ListNode(1, new ListNode(2, new ListNode(2, new ListNode(5)))));
        ListNode fromEnd = deleteDuplicates2(listNode);
        while (fromEnd != null) {
            System.out.println(fromEnd.val);
            fromEnd = fromEnd.next;
        }
    }
}
