package com.demo.treenode;

/**
 * 129,根节点到叶子节点数字之和
 *
 * 给你一个二叉树的根节点 root ，树中每个节点都存放有一个 0 到 9 之间的数字。
 *
 * 每条从根节点到叶节点的路径都代表一个数字：
 *
 * 例如，从根节点到叶节点的路径 1 -> 2 -> 3 表示数字 123 。
 * 计算从根节点到叶节点生成的 所有数字之和 。
 *
 * 叶节点 是指没有子节点的节点。
 *
 * 示例 1：
 * 输入：root = [1,2,3]
 * 输出：25
 * 解释：
 * 从根到叶子节点路径 1->2 代表数字 12
 * 从根到叶子节点路径 1->3 代表数字 13
 * 因此，数字总和 = 12 + 13 = 25
 *
 * 示例 2：
 * 输入：root = [4,9,0,5,1]
 * 输出：1026
 * 解释：
 * 从根到叶子节点路径 4->9->5 代表数字 495
 * 从根到叶子节点路径 4->9->1 代表数字 491
 * 从根到叶子节点路径 4->0 代表数字 40
 * 因此，数字总和 = 495 + 491 + 40 = 1026
 * 提示：
 *
 * 树中节点的数目在范围 [1, 1000] 内
 * 0 <= Node.val <= 9
 * 树的深度不超过 10
 * Related Topics
 * 树
 * 深度优先搜索
 * 二叉树
 */
public class SumNumbers {

    private int sum = 0;

    public int sumNumbers(TreeNode root) {
        if (root.left != null) {
            getSum(root.left, root.val);
        }
        if (root.right != null) {
            getSum(root.right, root.val);
        }
        if (root.left == null && root.right == null) {
            return root.val;
        }

        return sum;
    }

    private void getSum(TreeNode node, int val) {
        val = val*10 + node.val;
        if (node.left == null && node.right == null) {
            sum += val;
            return;
        }

        if (node.left != null) {
            getSum(node.left, val);
        }
        if (node.right != null) {
            getSum(node.right, val);
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

        SumNumbers sumNumbers = new SumNumbers();
        System.out.println(sumNumbers.sumNumbers(treeNode));

        System.out.println(123 + 1245 + 16);
    }
}
