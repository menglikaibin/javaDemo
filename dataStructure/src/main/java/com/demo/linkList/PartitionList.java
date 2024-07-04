package com.demo.linkList;

/**
 * 86. 分隔链表
 * 中等
 * 相关标签
 * 相关企业
 * 给你一个链表的头节点 head 和一个特定值 x ，请你对链表进行分隔，使得所有 小于 x 的节点都出现在 大于或等于 x 的节点之前。
 *
 * 你应当 保留 两个分区中每个节点的初始相对位置。
 *
 *
 *
 * 示例 1：
 *
 *
 * 输入：head = [1,4,3,2,5,2], x = 3
 * 输出：[1,2,2,4,3,5]
 *
 * 示例 2：
 * 输入：head = [2,1], x = 2
 * 输出：[1,2]
 *
 *
 * 提示：
 *
 * 链表中节点的数目在范围 [0, 200] 内
 * -100 <= Node.val <= 100
 * -200 <= x <= 200
 */
public class PartitionList {

    public ListNode partition(ListNode head, int x) {
        ListNode result = new ListNode(0);
        ListNode result2 = new ListNode(0);

        ListNode newHead1 = result;
        ListNode newHead2 = result2;

        while (head != null) {
            if (head.val < x) {
                newHead1.next = new ListNode(head.val);
                newHead1 = newHead1.next;
                head = head.next;
            } else {
                newHead2.next = new ListNode(head.val);
                newHead2 = newHead2.next;
                head = head.next;
            }
        }

        ListNode lastHead = result;
        while (true) {
            if (lastHead.next == null) {
                lastHead.next = result2.next;
                return result.next;
            } else {
                lastHead = lastHead.next;
            }
        }

    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(2, new ListNode(2, new ListNode(1))))));


        PartitionList partitionList = new PartitionList();
        ListNode partition = partitionList.partition(listNode, 2);

        while (partition != null) {
            System.out.println(partition.val);
            partition = partition.next;
        }
    }
}
