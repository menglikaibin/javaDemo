package com.demo.treenode;


/**
 * 给定一个二叉树，找出其最小深度。
 *
 * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 *
 * 说明：叶子节点是指没有子节点的节点。
 *
 *
 *
 * 示例 1：
 * 输入：root = [3,9,20,null,null,15,7]
 * 输出：2
 *
 * 示例 2：
 * 输入：root = [2,null,3,null,4,null,5,null,6]
 * 输出：5
 *
 *
 * 提示：
 *
 * 树中节点数的范围在 [0, 105] 内
 * -1000 <= Node.val <= 1000
 */
public class MinDepth {

    public int minDepth(TreeNode root) {
         return getHeight(root);
    }

    private int getHeight(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int leftHeight = getHeight(node.left);
        int rightHeight = getHeight(node.right);

        if (node.left == null && node.right != null) {
            return 1 + rightHeight;
        }

        if (node.left != null && node.right == null) {
            return 1 + leftHeight;
        }

        return 1 + Math.min(leftHeight, rightHeight);
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(5,
                new TreeNode(3,
                        new TreeNode(2, null, null),
                        new TreeNode(4, null, null)
                ),
                new TreeNode(6, null, null));

        MinDepth minDepth = new MinDepth();
        System.out.println(minDepth.minDepth(treeNode));
    }
}
