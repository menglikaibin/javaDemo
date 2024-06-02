package com.demo.treenode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个二叉搜索树的根节点 root ，和一个整数 k ，请你设计一个算法查找其中第 k 个最小元素（从 1 开始计数）。
 *
 * 示例 1：
 * 输入：root = [3,1,4,null,2], k = 1
 * 输出：1
 *
 * 示例 2：
 * 输入：root = [5,3,6,2,4,null,null,1], k = 3
 * 输出：3
 */
public class KthSmallest {

    private List<Integer> list = new ArrayList<>();

    public int kthSmallest(TreeNode root, int k) {
        add(root);

        return list.get(k-1);
    }

    private void add(TreeNode node) {
        if (node == null) {
            return;
        }

        add(node.left);
        list.add(node.val);
        add(node.right);
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(5,
                new TreeNode(3,
                        new TreeNode(2, null, null),
                        new TreeNode(4, null, null)
                ),
                new TreeNode(6, null, null));

        KthSmallest kthSmallest = new KthSmallest();
        System.out.println(kthSmallest.kthSmallest(treeNode, 3));
    }
}
