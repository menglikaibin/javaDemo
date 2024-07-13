package com.demo.backtracking;

import java.util.*;

/**
 * 90. 子集 II
 * 中等
 * 相关标签
 * 相关企业
 * 给你一个整数数组 nums ，其中可能包含重复元素，请你返回该数组所有可能的
 * 子集
 * （幂集）。
 *
 * 解集 不能 包含重复的子集。返回的解集中，子集可以按 任意顺序 排列。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [1,2,2]
 * 输出：[[],[1],[1,2],[1,2,2],[2],[2,2]]
 * 示例 2：
 *
 * 输入：nums = [0]
 * 输出：[[],[0]]
 *
 *
 * 提示：
 *
 * 1 <= nums.length <= 10
 * -10 <= nums[i] <= 10
 */
public class SubsetsWithDup {

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);

        Set<List<Integer>> result = new HashSet<>();
        result.add(new ArrayList<>());

        for (int i = 1; i <= nums.length; i++) {
            boolean[] booleans = new boolean[nums.length];
            backtracking(result, new ArrayList<>(), nums, i, booleans, 0);
        }

        return new ArrayList<>(result);
    }

    public void backtracking(Set<List<Integer>> result, List<Integer> data, int[] nums, int length, boolean[] booleans, int start) {
        if (data.size() == length) {
            result.add(new ArrayList<>(data));
            return;
        }

        for (int i = start; i < nums.length; i++) {
            if (booleans[i]) {
                continue;
            }
            data.add(nums[i]);

            booleans[i] = true;
            backtracking(result, data, nums, length, booleans, i+1);

            data.remove(data.size() - 1);
            booleans[i] = false;
        }
    }

    public static void main(String[] args) {
        SubsetsWithDup subsetsWithDup = new SubsetsWithDup();

        int[] nums = {1,2,2};
        System.out.println(new ArrayList<>(subsetsWithDup.subsetsWithDup(nums)));
    }

}
