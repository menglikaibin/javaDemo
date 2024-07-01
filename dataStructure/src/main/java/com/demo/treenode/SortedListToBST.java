package com.demo.treenode;

import com.demo.linkList.ListNode;

/**
 * 109
 * 给定一个单链表的头节点 head ，其中的元素 按升序排序 ，将其转换为 平衡 二叉搜索树。
 *
 * 示例 1:
 * 输入: head = [-10,-3,0,5,9]
 * 输出: [0,-3,9,-10,null,5]
 * 解释: 一个可能的答案是[0，-3,9，-10,null,5]，它表示所示的高度平衡的二叉搜索树。
 *
 * 示例 2:
 * 输入: head = []
 * 输出: []
 * 提示:
 *
 * head 中的节点数在[0, 2 * 104] 范围内
 * -105 <= Node.val <= 105
 * Related Topics
 * 树
 * 二叉搜索树
 * 链表
 * 分治
 * 二叉树
 */
public class SortedListToBST {

    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }

        // 寻找链表的中点
        ListNode mid = findMiddle(head);

        // 构建根节点
        TreeNode root = new TreeNode(mid.val);

        // 递归左侧节点
        if (head != mid) {
            root.left = sortedListToBST(head);
        }

        root.right = sortedListToBST(mid.next);

        return root;
    }

    private ListNode findMiddle(ListNode head) {
        ListNode slow = head, fast = head, prev = null;
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        if (prev != null) {
            prev.next = null;
        }

        return slow;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, new ListNode(6))))));


        SortedListToBST sortedListToBST = new SortedListToBST();
        TreeNode root = sortedListToBST.sortedListToBST(listNode);

        System.out.println(root);
    }
}
