package com.demo.treenode;

/**
 * 给定一个二叉树，判断它是否是 平衡二叉树
 *
 * 示例 1：
 * 输入：root = [3,9,20,null,null,15,7]
 * 输出：true
 *
 * 示例 2：
 * 输入：root = [1,2,2,3,3,null,null,4,4]
 * 输出：false
 *
 * 示例 3：
 * 输入：root = []
 * 输出：true
 * 提示：
 *
 * 树中的节点数在范围 [0, 5000] 内
 * -104 <= Node.val <= 104
 * Related Topics
 * 树
 * 深度优先搜索
 * 二叉树
 */
public class IsBalanced {


    private boolean balance = true;

    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }

        countHeight(root);

        return balance;
    }

    private int countHeight(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int leftHeight = countHeight(node.left);
        int rightHeight = countHeight(node.right);

        if (Math.abs(leftHeight - rightHeight) > 1) {
            balance = false;
        }

        return 1 + Math.max(leftHeight, rightHeight);
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(3,
                new TreeNode(9),
                new TreeNode(20,
                        new TreeNode(15),
                        new TreeNode(7)
                )
        );

        IsBalanced isBalanced = new IsBalanced();
        System.out.println(isBalanced.isBalanced(treeNode));
    }

}
