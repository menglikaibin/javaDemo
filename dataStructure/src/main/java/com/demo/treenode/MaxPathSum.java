package com.demo.treenode;

/**
 * 二叉树中的 路径 被定义为一条节点序列，序列中每对相邻节点之间都存在一条边。同一个节点在一条路径序列中 至多出现一次 。该路径 至少包含一个 节点，且不一定经过根节点。
 * 路径和 是路径中各节点值的总和。
 * 给你一个二叉树的根节点 root ，返回其 最大路径和 。
 *
 * 示例 1：
 * 输入：root = [1,2,3]
 * 输出：6
 * 解释：最优路径是 2 -> 1 -> 3 ，路径和为 2 + 1 + 3 = 6
 *
 * 示例 2：
 * 输入：root = [-10,9,20,null,null,15,7]
 * 输出：42
 * 解释：最优路径是 15 -> 20 -> 7 ，路径和为 15 + 20 + 7 = 42
 *
 *
 * 提示：
 *
 * 树中节点数目范围是 [1, 3 * 104]
 * -1000 <= Node.val <= 1000
 */
public class MaxPathSum {

    int maxSum = Integer.MIN_VALUE;

    /**
     * 场景
     * 1、根
     * 2、根+左
     * 3、根+右
     * 4、根+左+右
     *
     * 求解
     * 1、遍历树的每个节点
     * 2、在每个节点考虑上述四种情况，求一个最大值
     * 3、自底向上，传递下方链路的最大值
     */
    public int maxPathSum(TreeNode root) {
        findPathSum(root);

        return maxSum;
    }

    public int findPathSum(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int left = findPathSum(node.left);
        int right = findPathSum(node.right);

        maxSum  = Math.max(maxSum, node.val);
        maxSum  = Math.max(maxSum, node.val + left);
        maxSum  = Math.max(maxSum, node.val + right);
        maxSum  = Math.max(maxSum, node.val + left + right);

        // 返回下层节点最大值与0比较的更大值
        return node.val + Math.max(0, Math.max(left, right));
    }
}
