package com.demo.treenode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

/**
 * 给你二叉树的根节点 root ，返回其节点值 自底向上的层序遍历 。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
 *
 * 示例 1：
 * 输入：root = [3,9,20,null,null,15,7]
 * 输出：[[15,7],[9,20],[3]]
 *
 * 示例 2：
 * 输入：root = [1]
 * 输出：[[1]]
 *
 * 示例 3：
 * 输入：root = []
 * 输出：[]
 *
 *
 * 提示：
 *
 * 树中节点数目在范围 [0, 2000] 内
 * -1000 <= Node.val <= 1000
 */
public class LevelOrderBottom {

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> result = new ArrayList<>();

        ArrayDeque<TreeNode> list = new ArrayDeque<>();
        list.add(root);

        while (!list.isEmpty()) {
            int size = list.size();

            List<Integer> data = new ArrayList<>();
            while (size > 0) {
                size --;

                TreeNode treeNode = list.pollLast();
                data.add(treeNode.val);

                if (treeNode.left != null) {
                    list.push(treeNode.left);
                }
                if (treeNode.right != null) {
                    list.push(treeNode.right);
                }
            }

            result.add(data);
        }

        List<List<Integer>> newResult = new ArrayList<>();
        for (int i = result.size() - 1; i >= 0; i--) {
            newResult.add(result.get(i));
        }

        return newResult;
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

        LevelOrderBottom levelOrderBottom = new LevelOrderBottom();
        System.out.println(levelOrderBottom.levelOrderBottom(treeNode).toString());
    }
}
