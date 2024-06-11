package com.demo.treenode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你二叉树的根节点 root 和一个整数目标和 targetSum ，找出所有 从根节点到叶子节点 路径总和等于给定目标和的路径。
 *
 * 叶子节点 是指没有子节点的节点。
 *
 * 示例 1：
 * 输入：root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
 * 输出：[[5,4,11,2],[5,8,4,5]]
 *
 * 示例 2：
 * 输入：root = [1,2,3], targetSum = 5
 * 输出：[]
 *
 * 示例 3：
 * 输入：root = [1,2], targetSum = 0
 * 输出：[]
 */
public class PathSum {

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return new ArrayList<>();
        }

        List<List<Integer>> result = new ArrayList<>();
        back(root, targetSum, result, new ArrayList<>());

        return result;
    }

    private void back(TreeNode node, int targetSum, List<List<Integer>> result, List<Integer> data) {
        data.add(node.val);
        if (node.left == null && node.right == null) {
            if (data.stream().reduce(Integer::sum).orElse(0) == targetSum) {
                result.add(new ArrayList<>(data));
            }
            return;
        }

        if (node.left != null) {
            back(node.left, targetSum, result, data);
            data.remove(data.size() - 1);
        }
        if (node.right != null) {
            back(node.right, targetSum, result, data);
            data.remove(data.size() - 1);
        }
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

        PathSum pathSum = new PathSum();
        System.out.println(pathSum.pathSum(treeNode, 7).toString());
    }
}
