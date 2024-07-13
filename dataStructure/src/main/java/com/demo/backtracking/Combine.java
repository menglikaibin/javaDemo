package com.demo.backtracking;

import java.util.*;

/**
 * 77,组合
 * 给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。
 *
 * 你可以按 任何顺序 返回答案。
 *
 * 示例 1：
 *
 * 输入：n = 4, k = 2
 * 输出：
 * [
 *   [2,4],
 *   [3,4],
 *   [2,3],
 *   [1,2],
 *   [1,3],
 *   [1,4],
 * ]
 * 示例 2：
 *
 * 输入：n = 1, k = 1
 * 输出：[[1]]
 * 提示：
 *
 * 1 <= n <= 20
 * 1 <= k <= n
 * Related Topics
 * 回溯
 */
public class Combine {

    public List<List<Integer>> combine(int n, int k) {
        int[] ints = new int[n];
        for (int i = 1; i <= n; i++) {
            ints[i - 1] = i;
        }

        Set<List<Integer>> result = new HashSet<>();

        boolean[] booleans = new boolean[n];
        backtracking(result, new ArrayList<>(), ints, k, 0, booleans);

        return new ArrayList<>(result);
    }

    public void backtracking(Set<List<Integer>> result, List<Integer> data, int[] nums, int k, int start, boolean[] booleans) {
        if (data.size() == k) {
            result.add(new ArrayList<>(data));
            return;
        }

        for (int i = start; i < nums.length; i++) {
            if (booleans[i]) {
                continue;
            }
            data.add(nums[i]);
            booleans[i] = true;

            backtracking(result, data, nums, k, i + 1, booleans);

            data.remove(data.size() - 1);
            booleans[i] = false;
        }
    }

    public static void main(String[] args) {
        Combine combine = new Combine();
        List<List<Integer>> lists = combine.combine(4, 2);
        System.out.println(new ArrayList<>(lists));
    }
}
