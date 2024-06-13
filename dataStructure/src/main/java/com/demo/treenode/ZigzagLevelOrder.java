package com.demo.treenode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 给你二叉树的根节点 root ，返回其节点值的 锯齿形层序遍历 。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 *
 *
 *
 * 示例 1：
 * 输入：root = [3,9,20,null,null,15,7]
 * 输出：[[3],[20,9],[15,7]]
 *
 * 示例 2：
 * 输入：root = [1]
 * 输出：[[1]]
 *
 * 示例 3：
 * 输入：root = []
 * 输出：[]
 */
public class ZigzagLevelOrder {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        ArrayDeque<TreeNode> list = new ArrayDeque<>();
        list.push(root);

        // true向右 false向左
        boolean is = true;

        while (!list.isEmpty()) {
            int size = list.size();

            while (size > 0) {
                size --;

                if (is) {
                    TreeNode pop = list.pop();
                } else {
                    TreeNode last = list.poll();
                }
            }
        }
    }

}
