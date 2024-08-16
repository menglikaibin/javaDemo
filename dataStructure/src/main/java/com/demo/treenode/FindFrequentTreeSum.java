package com.demo.treenode;


import java.util.*;

/**
 * 508,出现次数最多的子树元素和
 *
 * 给你一个二叉树的根结点 root ，请返回出现次数最多的子树元素和。如果有多个元素出现的次数相同，返回所有出现次数最多的子树元素和（不限顺序）。
 *
 * 一个结点的 「子树元素和」 定义为以该结点为根的二叉树上所有结点的元素之和（包括结点本身）。
 *
 * 示例 1：
 *
 *
 *
 * 输入: root = [5,2,-3]
 * 输出: [2,-3,4]
 * 示例 2：
 *
 *
 *
 * 输入: root = [5,2,-5]
 * 输出: [2]
 * 提示:
 *
 * 节点数在 [1, 104] 范围内
 * -105 <= Node.val <= 105
 * Related Topics
 * 树
 * 深度优先搜索
 * 哈希表
 * 二叉树
 */
public class FindFrequentTreeSum {

    private Map<Integer, Integer> map = new HashMap<>();

    private int max = 1;

    public int[] findFrequentTreeSum(TreeNode root) {
        get(root);

        ArrayList<Integer> list = new ArrayList<>();
        for (Integer key : map.keySet()) {
            if (map.get(key) == max) {
                list.add(key);
            }
        }

        return list.stream().mapToInt(Integer::intValue).toArray();
    }

    private int get(TreeNode node) {

        if (node == null) {
            return 0;
        }

        int left = get(node.left);
        int right = get(node.right);

        // 自底向上
        int sum = left + right + node.val;

        map.put(sum, map.getOrDefault(sum, 0) + 1);
        max = Math.max(max, map.get(sum));

        return sum;
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(5,
                new TreeNode(2),
                new TreeNode(-5)
        );

        FindFrequentTreeSum findFrequentTreeSum = new FindFrequentTreeSum();
        System.out.println(Arrays.toString(findFrequentTreeSum.findFrequentTreeSum(treeNode)));
    }


}
