package com.demo.treenode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

/**
 * 给你二叉树的根节点 root ，返回其节点值的 锯齿形层序遍历 。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 *
 *
 *
 * 示例 1：
 * 输入：root = [3,9,20,null,null,15,7]
 * 输出：[[3],[20,9],[15,7]]
 *
 * 示例 2：
 * 输入：root = [1]
 * 输出：[[1]]
 *
 * 示例 3：
 * 输入：root = []
 * 输出：[]
 */
public class ZigzagLevelOrder {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        List<List<Integer>> result = new ArrayList<>();

        ArrayDeque<TreeNode> list = new ArrayDeque<>();
        list.push(root);

        // true向右 false向左
        boolean is = true;

        while (!list.isEmpty()) {
            int size = list.size();

            List<Integer> data = new ArrayList<>();
            while (size > 0) {
                size --;

                if (is) {
                    TreeNode node = list.pollLast();
                    data.add(node.val);
                    if (node.left != null) {
                        list.push(node.left);
                    }
                    if (node.right != null) {
                        list.push(node.right);
                    }
                } else {
                    TreeNode node = list.pollLast();
                    data.add(0, node.val);
                    if (node.left != null) {
                        list.push(node.left);
                    }
                    if (node.right != null) {
                        list.push(node.right);
                    }
                }
            }
            result.add(data);

            is = !is;
        }

        return result;
    }

    public static void main(String[] args) {
//        ArrayDeque<Integer> deque = new ArrayDeque<>();
//        deque.push(1);
//        deque.push(2);
//        deque.push(3);
//        deque.push(4);
//        deque.push(5);
//
//        System.out.println(deque.pollLast());
//        System.out.println(deque.pollLast());
//        System.out.println(deque.pollLast());
//        System.out.println(deque.pollLast());
//        System.out.println(deque.pollLast());

        TreeNode treeNode = new TreeNode(1,
                new TreeNode(2,
                        new TreeNode(3, null, null),
                        new TreeNode(4,
                                new TreeNode(5),
                                null)
                ),
                new TreeNode(6,
                        new TreeNode(8,
                                new TreeNode(10),
                                null),
                        new TreeNode(9))
        );

        ZigzagLevelOrder zigzagLevelOrder = new ZigzagLevelOrder();
        List<List<Integer>> lists = zigzagLevelOrder.zigzagLevelOrder(treeNode);
        System.out.println(lists.toString());
    }
}
