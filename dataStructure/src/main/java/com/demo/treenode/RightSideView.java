package com.demo.treenode;

import java.util.*;

/**
 * 给定一个二叉树的 根节点 root，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
 * 示例 1:
 * 输入: [1,2,3,null,5,null,4]
 * 输出: [1,3,4]
 *
 * 示例 2:
 * 输入: [1,null,3]
 * 输出: [1,3]
 *
 * 示例 3:
 * 输入: []
 * 输出: []
 */
public class RightSideView {

    private List<Integer> result = new ArrayList<>();

    public List<Integer> rightSideView(TreeNode root) {
        LinkedList<TreeNode> nodes = new LinkedList<>();

        nodes.add(root);
        while (!nodes.isEmpty()) {
            int size = nodes.size();

            while (size > 0) {
                TreeNode first = nodes.pop();
                if (first != null) {
                    if (size == 1) {
                        result.add(first.val);
                    }
                    if (first.left != null) {
                        nodes.add(first.left);
                    }
                    if (first.right != null) {
                        nodes.add(first.right);
                    }
                }
                size --;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(5,
                new TreeNode(3,
                        new TreeNode(2, null, null),
                        new TreeNode(4, null, null)
                ),
                new TreeNode(6, null, null));

        RightSideView rightSideView = new RightSideView();
        List<Integer> result = rightSideView.rightSideView(treeNode);
        System.out.println(Arrays.toString(result.toArray()));
    }

}
