package com.demo.treenode;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * 257,二叉树的所有路径
 *
 * 给你一个二叉树的根节点 root ，按 任意顺序 ，返回所有从根节点到叶子节点的路径。
 *
 * 叶子节点 是指没有子节点的节点。
 *
 * 示例 1：
 *
 *
 * 输入：root = [1,2,3,null,5]
 * 输出：["1->2->5","1->3"]
 * 示例 2：
 *
 * 输入：root = [1]
 * 输出：["1"]
 * 提示：
 *
 * 树中节点的数目在范围 [1, 100] 内
 * -100 <= Node.val <= 100
 * Related Topics
 * 树
 * 深度优先搜索
 * 字符串
 * 回溯
 * 二叉树
 */
public class BinaryTreePaths {

    public List<String> binaryTreePaths(TreeNode root) {
        if (root == null) {
            return null;
        }
        if (root.left == null && root.right == null) {
            return List.of(String.valueOf(root.val));
        }
        List<String> result = new ArrayList<>();

        List<Integer> data1 = new ArrayList<>();
        data1.add(root.val);
        backtracking(result, data1, root.left);

        List<Integer> data2 = new ArrayList<>();
        data2.add(root.val);
        backtracking(result, data2, root.right);

        return result;
    }


    private void backtracking(List<String> result, List<Integer> data, TreeNode node) {
        if (node == null) {
            return;
        }

        data.add(node.val);
        if (node.left == null && node.right == null) {
            String value = data.stream().map(Objects::toString).collect(Collectors.joining("->"));
            result.add(value);
            return;
        } else {
            if (node.left != null) {
                backtracking(result, data, node.left);
                data.remove(data.size() - 1);
            }
            if (node.right != null) {
                backtracking(result, data, node.right);
                data.remove(data.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(5,
                new TreeNode(3,
                        new TreeNode(2, null, null),
                        new TreeNode(4, null, null)
                ),
                new TreeNode(6, null, null));

        BinaryTreePaths binaryTreePaths = new BinaryTreePaths();
        List<String> strings = binaryTreePaths.binaryTreePaths(treeNode);
        System.out.println(strings);
    }
}
