package com.demo.treenode;

import java.util.ArrayList;
import java.util.List;

/**
 *
 代码
 测试用例
 测试结果
 测试结果
 145. 二叉树的后序遍历
 简单
 相关标签
 相关企业
 给你一棵二叉树的根节点 root ，返回其节点值的 后序遍历 。



 示例 1：


 输入：root = [1,null,2,3]
 输出：[3,2,1]
 示例 2：

 输入：root = []
 输出：[]
 示例 3：

 输入：root = [1]
 输出：[1]


 提示：

 树中节点的数目在范围 [0, 100] 内
 -100 <= Node.val <= 100
 */
public class PostorderTraversal {

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        getPost(root, result);

        return result;
    }

    private void getPost(TreeNode node, List<Integer> result) {
        if (node == null) {
            return;
        }

        getPost(node.left, result);
        getPost(node.right, result);

        result.add(node.val);
    }
}
