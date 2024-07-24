package com.demo.treenode;

import java.util.ArrayList;
import java.util.List;

/**
 * 95,不同的二叉搜索树
 *
 * 给你一个整数 n ，请你生成并返回所有由 n 个节点组成且节点值从 1 到 n 互不相同的不同 二叉搜索树 。可以按 任意顺序 返回答案。
 *
 * 示例 1：
 *
 *
 * 输入：n = 3
 * 输出：[[1,null,2,null,3],[1,null,3,2],[2,1,3],[3,1,null,null,2],[3,2,null,1]]
 * 示例 2：
 *
 * 输入：n = 1
 * 输出：[[1]]
 * 提示：
 *
 * 1 <= n <= 8
 * Related Topics
 * 树
 * 二叉搜索树
 * 动态规划
 * 回溯
 * 二叉树
 */
public class GenerateTrees {

    /**
     * 如果 n 为 0，则返回一个空树列表。
     * 对于 n 的每个可能值 i (1 到 n)，选择它作为根节点。
     * 递归地为根节点左侧的值生成所有可能的左子树。
     * 递归地为根节点右侧的值生成所有可能的右子树。
     * 对于每一种可能的左子树和右子树组合，创建一个新的节点，将其作为根节点，并设置左右子树。
     * 将所有这些组合加入最终的结果列表。
     */
    public List<TreeNode> generateTrees(int n) {
        if (n < 1) {
            return new ArrayList<>();
        }

        return build(1, n);
    }

    public List<TreeNode> build(int l, int r) {
        List<TreeNode> allNodes = new ArrayList<>();

        if (l > r) {
            allNodes.add(null);
            return allNodes;
        }

        for (int i = l; i <= r; i++) {
            List<TreeNode> leftNodes = build(l, i - 1);
            List<TreeNode> rightNodes = build(i + 1, r);

            for (TreeNode left : leftNodes) {
                for (TreeNode right : rightNodes) {
                    TreeNode treeNode = new TreeNode(i);
                    treeNode.left = left;
                    treeNode.right = right;
                    allNodes.add(treeNode);
                }
            }
        }

        return allNodes;
    }

}
