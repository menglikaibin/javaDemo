package com.demo.treenode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 给你二叉树的根节点 root ，返回其节点值的 层序遍历 。 （即逐层地，从左到右访问所有节点）。
 *
 * 示例 1：
 * 输入：root = [3,9,20,null,null,15,7]
 * 输出：[[3],[9,20],[15,7]]
 *
 * 示例 2：
 * 输入：root = [1]
 * 输出：[[1]]
 *
 * 示例 3：
 * 输入：root = []
 * 输出：[]
 *
 */
public class LevelOrder {

    public List<List<Integer>> levelOrder(TreeNode root) {

        LinkedList<TreeNode> queue = new LinkedList<>();
        if (root != null) {
            queue.add(root);
        }

        List<List<Integer>> result = new ArrayList<>();
        while (!queue.isEmpty()) {
            int size = queue.size();

            List<Integer> list = new ArrayList<>();
            while (size > 0) {
                size --;
                TreeNode first = queue.getLast();
                queue.pollLast();

                list.add(first.val);
                if (first.left != null) {
                    queue.push(first.left);
                }
                if (first.right != null) {
                    queue.push(first.right);
                }
            }
            result.add(list);
        }

        return result;
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1,
                new TreeNode(2,
                        new TreeNode(3, null, null),
                        new TreeNode(4,
                                new TreeNode(5),
                                null)
                ),
                new TreeNode(6, null, null));

        LevelOrder levelOrder = new LevelOrder();
        System.out.println(levelOrder.levelOrder(treeNode));
    }
}
