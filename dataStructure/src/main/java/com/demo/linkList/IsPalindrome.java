package com.demo.linkList;


import java.util.ArrayList;
import java.util.Objects;

/**
 * 234.给你一个单链表的头节点 head ，请你判断该链表是否为
 * 回文链表
 * 。如果是，返回 true ；否则，返回 false 。
 *
 *
 *
 * 示例 1：
 *
 *
 * 输入：head = [1,2,2,1]
 * 输出：true
 * 示例 2：
 *
 *
 * 输入：head = [1,2]
 * 输出：false
 *
 *
 * 提示：
 *
 * 链表中节点数目在范围[1, 105] 内
 * 0 <= Node.val <= 9
 */
public class IsPalindrome {

    public boolean isPalindrome(ListNode head) {

        ArrayList<Integer> list = new ArrayList<>();
        list.add(head.val);

        while (head.next != null) {
            head = head.next;

            list.add(head.val);
        }

        for (int i = 0; i < list.size() / 2; i++) {
            if (!Objects.equals(list.get(i), list.get(list.size() - i - 1))) {
                return false;
            }
        }

        return true;

    }

}
