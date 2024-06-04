package com.demo.treenode;

/**
 * 给定两个整数数组 inorder 和 postorder ，其中 inorder 是二叉树的中序遍历， postorder 是同一棵树的后序遍历，请你构造并返回这颗 二叉树 。
 *
 * 示例 1:
 * 输入：inorder = [9,3,15,20,7], postorder = [9,15,7,20,3]
 * 输出：[3,9,20,null,null,15,7]
 *
 * 示例 2:
 * 输入：inorder = [-1], postorder = [-1]
 * 输出：[-1]
 *
 * 提示:
 * 1 <= inorder.length <= 3000
 * postorder.length == inorder.length
 * -3000 <= inorder[i], postorder[i] <= 3000
 * inorder 和 postorder 都由 不同 的值组成
 * postorder 中每一个值都在 inorder 中
 * inorder 保证是树的中序遍历
 * postorder 保证是树的后序遍历
 */
public class BuildTree2 {

    /**
     * 思路
     * 1.后续数组为0,空节点
     * 2.后续数组最后一个元素为节点元素
     * 3.寻找中序数组位置作为切割点
     * 4.切中序数组
     * 5.切后序数组
     * 6.递归处理左区间,右区间
     */
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return build(inorder, 0, inorder.length-1, postorder, 0, postorder.length - 1);
    }

    private TreeNode build(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart, int postEnd) {
        if (inStart > inEnd || postEnd < postStart) {
            return null;
        }

        TreeNode root = new TreeNode(postorder[postEnd]);

        // 在中序遍历获取中间节点,划分左右子树
        int index = 0;
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == root.val) {
                index = i;
                break;
            }
        }

        // 获取中序数组左区间的大小
        int leftSize = index - inStart;
        // 后序数组的左区间为  postStart->postStart + leftSize - 1
        // 后序数组的右区间为  postStart + leftSize -> postEnd - 1
        root.left = build(inorder, inStart, index - 1, postorder, postStart, postStart + leftSize - 1);
        root.right = build(inorder, index + 1, inEnd, postorder, postStart + leftSize, postEnd - 1);

        return root;
    }
}
