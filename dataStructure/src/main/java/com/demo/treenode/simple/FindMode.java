package com.demo.treenode.simple;

import com.demo.treenode.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 501,二叉搜索树中的众数
 *
 * 给你一个含重复值的二叉搜索树（BST）的根节点 root ，找出并返回 BST 中的所有 众数（即，出现频率最高的元素）。
 *
 * 如果树中有不止一个众数，可以按 任意顺序 返回。
 *
 * 假定 BST 满足如下定义：
 *
 * 结点左子树中所含节点的值 小于等于 当前节点的值
 * 结点右子树中所含节点的值 大于等于 当前节点的值
 * 左子树和右子树都是二叉搜索树
 *
 * 示例 1：
 * 输入：root = [1,null,2,2]
 * 输出：[2]
 *
 * 示例 2：
 * 输入：root = [0]
 * 输出：[0]
 * 提示：
 *
 * 树中节点的数目在范围 [1, 10^4] 内
 * -10^5 <= Node.val <= 10^5
 * 进阶：你可以不使用额外的空间吗？（假设由递归产生的隐式调用栈的开销不被计算在内）
 *
 * Related Topics
 * 树
 * 深度优先搜索
 * 二叉搜索树
 * 二叉树
 */
public class FindMode {

    private Map<Integer, Integer> countMap = new HashMap<>();

    private int maxCount = 1;

    public int[] findMode(TreeNode root) {
        countMap.put(root.val, 1);

        add(root.left);
        add(root.right);

        List<Integer> result = new ArrayList<>();
        for (Integer key : countMap.keySet()) {
            if (countMap.get(key) == maxCount) {
                result.add(key);
            }
        }

        return result.stream().mapToInt(Integer::intValue).toArray();
    }

    private void add(TreeNode node) {
        if (node == null) {
            return;
        }

        Integer count = countMap.getOrDefault(node.val, 0);
        if (count == 0) {
            countMap.put(node.val, 1);
        } else {
            if (count + 1 > maxCount) {
                maxCount = count + 1;
            }
            countMap.put(node.val, count + 1);
        }

        add(node.left);
        add(node.right);
    }

}
