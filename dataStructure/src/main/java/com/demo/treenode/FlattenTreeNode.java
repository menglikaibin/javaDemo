package com.demo.treenode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你二叉树的根结点 root ，请你将它展开为一个单链表：
 *
 * 展开后的单链表应该同样使用 TreeNode ，其中 right 子指针指向链表中下一个结点，而左子指针始终为 null 。
 * 展开后的单链表应该与二叉树 先序遍历 顺序相同。
 *
 *
 * 示例 1：
 * 输入：root = [1,2,5,3,4,null,6]
 * 输出：[1,null,2,null,3,null,4,null,5,null,6]
 *
 * 示例 2：
 * 输入：root = []
 * 输出：[]
 *
 * 示例 3：
 * 输入：root = [0]
 * 输出：[0]
 */
public class FlattenTreeNode {

    private List<Integer> list = new ArrayList<>();

    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        getBeforeList(root);
        if (list.size() == 0) {
            return;
        }

        root.left = null;
        TreeNode backRoot = root;
        for (int i = 1; i < list.size(); i++) {
            backRoot.right = new TreeNode(list.get(i));

            backRoot = backRoot.right;
        }
    }

    private void getBeforeList(TreeNode root) {
        if (root == null) {
            return;
        }

        list.add(root.val);
        getBeforeList(root.left);
        getBeforeList(root.right);
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1,
                new TreeNode(2,
                        new TreeNode(3, null, null),
                        new TreeNode(4, null, null)
                ),
                new TreeNode(5, null, new TreeNode(6)));

        FlattenTreeNode flattenTreeNode = new FlattenTreeNode();
        flattenTreeNode.flatten(treeNode);

        System.out.println(treeNode.val + "," + treeNode.right.val + "," + treeNode.right.right.val);
    }
}
