package com.demo.treenode;

/**
 * 623,在二叉树中增加一行
 *
 * 给定一个二叉树的根 root 和两个整数 val 和 depth ，在给定的深度 depth 处添加一个值为 val 的节点行。
 *
 * 注意，根节点 root 位于深度 1 。
 *
 * 加法规则如下:
 *
 * 给定整数 depth，对于深度为 depth - 1 的每个非空树节点 cur ，创建两个值为 val 的树节点作为 cur 的左子树根和右子树根。
 * cur 原来的左子树应该是新的左子树根的左子树。
 * cur 原来的右子树应该是新的右子树根的右子树。
 * 如果 depth == 1 意味着 depth - 1 根本没有深度，那么创建一个树节点，值 val 作为整个原始树的新根，而原始树就是新根的左子树。
 * 示例 1:
 * 输入: root = [4,2,6,3,1,5], val = 1, depth = 2
 * 输出: [4,1,1,2,null,null,6,3,1,5]
 *
 * 示例 2:
 * 输入: root = [4,2,null,3,1], val = 1, depth = 3
 * 输出:  [4,2,null,1,1,3,null,null,1]
 *
 * 提示:
 * 节点数在 [1, 104] 范围内
 * 树的深度在 [1, 104]范围内
 * -100 <= Node.val <= 100
 * -105 <= val <= 105
 * 1 <= depth <= the depth of tree + 1
 * Related Topics
 * 树
 * 深度优先搜索
 * 广度优先搜索
 * 二叉树
 */
public class AddOneRow {

    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if (depth == 1) {
            TreeNode treeNode = new TreeNode(val);
            treeNode.left = root;

            return treeNode;
        } else if (root != null && depth > 1) {
            // 否则递归地处理左右子树
            if (depth - 1 == 1) {
                // 当前层是需要插入新节点的父节点
                TreeNode tempLeft = root.left;
                TreeNode tempRight = root.right;

                root.left = new TreeNode(val);
                root.left.left = tempLeft;

                root.right = new TreeNode(val);
                root.right.right = tempRight;
            } else {
                // 继续向下遍历
                root.left = addOneRow(root.left, val, depth - 1);
                root.right = addOneRow(root.right, val, depth - 1);
            }
        }

        return root;
    }

    public static void main(String[] args) {

        TreeNode treeNode = new TreeNode(1,
                new TreeNode(2,
                        new TreeNode(4, null, null),
                        null
                ),
                new TreeNode(3));

        AddOneRow addOneRow = new AddOneRow();
        TreeNode x = addOneRow.addOneRow(treeNode, 5, 4);
        System.out.println(x);
    }

}
