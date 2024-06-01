package com.demo.treenode;

/**
 * 给你一个二叉树的根节点 root ，判断其是否是一个有效的二叉搜索树。
 *
 * 有效 二叉搜索树定义如下：
 *
 * 节点的左
 * 子树
 * 只包含 小于 当前节点的数。
 * 节点的右子树只包含 大于 当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 *
 * 示例 1：
 * 输入：root = [2,1,3]
 * 输出：true
 *
 * 示例 2：
 * 输入：root = [5,1,4,null,null,3,6]
 * 输出：false
 * 解释：根节点的值是 5 ，但是右子节点的值是 4 。
 */
public class IsValidBST {


    public boolean isValidBST(TreeNode root) {

        return check(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean check(TreeNode root, long minVal, long maxVal) {
        if (root == null) {
            return true;
        }

        if (root.val <= minVal || root.val >= maxVal) {
            return false;
        }

        return check(root.left, minVal, root.val) && check(root.right, root.val, maxVal);
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(9,
                new TreeNode(6,
                        new TreeNode(3, null, null),
                        new TreeNode(14,
                                new TreeNode(5),
                                null)
                ),
                new TreeNode(16, null, null));

        IsValidBST isValidBST = new IsValidBST();
        System.out.println(isValidBST.isValidBST(treeNode));
    }
}
