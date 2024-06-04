package com.demo.treenode;

/**
 * 给定两个整数数组 preorder 和 inorder ，其中 preorder 是二叉树的先序遍历， inorder 是同一棵树的中序遍历，请构造二叉树并返回其根节点。
 *
 * 示例 1:
 * 输入: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
 * 输出: [3,9,20,null,null,15,7]
 *
 * 示例 2:
 * 输入: preorder = [-1], inorder = [-1]
 * 输出: [-1]
 *
 *
 * 提示:
 * 1 <= preorder.length <= 3000
 * inorder.length == preorder.length
 * -3000 <= preorder[i], inorder[i] <= 3000
 * preorder 和 inorder 均无重复元素
 * inorder 均出现在 preorder
 * preorder 保证 为二叉树的前序遍历序列
 * inorder 保证 为二叉树的中序遍历序列
 */
public class BuildTree {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null || preorder.length != inorder.length) {
            return null;
        }
        return constructTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    /**
     * 1.找到根节点：根节点在先序遍历中始终是第一个元素，记为rootValue。
     * 2.找到中序遍历中的根节点：
     * 遍历中序遍历数组，找到第一个值等于rootValue的元素，它的索引记为rootIndex。这个索引将中序遍历数组划分为两部分：左侧是左子树的中序遍历，右侧是右子树的中序遍历。
     * 3.确定子树的边界：
     * 左子树的中序遍历范围是inStart到rootIndex - 1。
     * 右子树的中序遍历范围是rootIndex + 1到inEnd。
     * 4.确定先序遍历的子树边界：
     * 对于左子树，先序遍历的范围是preStart + 1到preStart + (rootIndex - inStart)。因为先序遍历中，根节点之后的元素属于左子树。
     * 对于右子树，先序遍历的范围是preStart + (rootIndex - inStart) + 1到preEnd。根节点之后的剩余元素属于右子树。
     * 5.递归构建子树：
     * 递归调用constructTree（或其他类似方法）来构建左子树，传入相应的先序和中序遍历的子序列。
     * 接着递归调用构建右子树，传入剩余的先序和中序遍历的子序列。
     */
    private TreeNode constructTree(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {
        if (preStart > preEnd) {
            return null;
        }

        // 前序遍历的第一个结点就是当前子树的根节点
        int rootVal = preorder[preStart];
        TreeNode root = new TreeNode(rootVal);

        // 在中序遍历中定位根节点,以此划分左右子树
        int index = 0;
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == rootVal) {
                index = i;
                break;
            }
        }

        root.left = constructTree(preorder, preStart + 1, preStart + index - inStart, inorder, inStart, index - 1);
        root.right = constructTree(preorder, preStart + index - inStart + 1, preEnd, inorder, index + 1, inEnd);

        return root;
    }
}
