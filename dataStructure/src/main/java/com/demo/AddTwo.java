package com.demo;

/**
 * @author 吴凯斌
 * 创建时间 2024/3/25 16:40
 */
public class AddTwo {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode pre = new ListNode(0);
        ListNode cur = pre;

        // 进位值
        int carry = 0;

        while (l1 != null || l2 != null) {
            int x = l1 == null ? 0 : l1.val;
            int y = l2 == null ? 0 : l2.val;

            // 当前节点的值
            int sum = x + y + carry;

            // 更新进位值
            carry = sum >= 10 ? 1 : 0;
            // 下一个节点的值(取余)
            cur.next = new ListNode(sum % 10);

            cur = cur.next;

            // 更新两个链表的指针
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }

        // 进位值大于0,增加一个节点
        if (carry > 0) {
            cur.next = new ListNode(carry);
        }

        // 返回头节点
        return pre.next;
    }

}
