package com.demo.treenode;

/**
 * @link {https://leetcode.cn/problems/diameter-of-binary-tree/?envType=study-plan-v2&envId=top-100-liked}
 * 给你一棵二叉树的根节点，返回该树的 直径 。
 *
 * 二叉树的 直径 是指树中任意两个节点之间最长路径的 长度 。这条路径可能经过也可能不经过根节点 root 。
 *
 * 两节点之间路径的 长度 由它们之间边数表示。
 *
 *
 *
 * 示例 1：
 * 输入：root = [1,2,3,4,5]
 * 输出：3
 * 解释：3 ，取路径 [4,2,1,3] 或 [5,2,1,3] 的长度。
 *
 * 示例 2：
 * 输入：root = [1,2]
 * 输出：1
 */
public class DiameterOfBinaryTree {

    int max = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        depth(root);

        return max;
    }

    private int depth(TreeNode root) {
        if (root == null)
            return 0;

        int leftDepth = depth(root.left);
        int rightDepth = depth(root.right);

        max = Math.max(max, leftDepth + rightDepth);

        return Math.max(leftDepth, rightDepth) + 1;
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1, new TreeNode(2, null, null), new TreeNode(3, new TreeNode(4, null, null), null));

        DiameterOfBinaryTree diameterOfBinaryTree = new DiameterOfBinaryTree();
        System.out.println(diameterOfBinaryTree.diameterOfBinaryTree(treeNode));
    }
}
