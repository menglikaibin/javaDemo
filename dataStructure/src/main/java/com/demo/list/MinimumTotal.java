package com.demo.list;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个三角形 triangle ，找出自顶向下的最小路径和。
 *
 * 每一步只能移动到下一行中相邻的结点上。相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。也就是说，如果正位于当前行的下标 i ，那么下一步可以移动到下一行的下标 i 或 i + 1 。
 *
 *
 *
 * 示例 1：
 * 输入：triangle = [[2],[3,4],[6,5,7],[4,1,8,3]]
 * 输出：11
 * 解释：如下面简图所示：
 *    2
 *   3 4
 *  6 5 7
 * 4 1 8 3
 * 自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。
 *
 * 示例 2：
 * 输入：triangle = [[-10]]
 * 输出：-10
 */
public class MinimumTotal {

    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null || triangle.isEmpty()) {
            return 0;
        }

        // 从最后一层开始向上遍历
        for (int i = triangle.size() - 2; i >= 0; i--) {
            List<Integer> currentRow = triangle.get(i);
            List<Integer> nextRow = triangle.get(i + 1);

            // 对于每一行的每个元素,取下面两个元素中较小值加上当前元素
            for (int j = 0; j < currentRow.size(); j++) {
                Integer value = currentRow.get(j) + Math.min(nextRow.get(j + 1), nextRow.get(j));
                currentRow.set(j, value);
            }
        }

        // 最后一行的第一个元素就是最小路径和
        return triangle.get(0).get(0);
    }

    public static void main(String[] args) {
        MinimumTotal minimumTotal = new MinimumTotal();

        System.out.println(minimumTotal.minimumTotal(List.of(new ArrayList<>(List.of(1)), new ArrayList<>(List.of(2, 5)), new ArrayList<>(List.of(1, 2, 4)), new ArrayList<>(List.of(4,1,8,3)))));
    }
}
