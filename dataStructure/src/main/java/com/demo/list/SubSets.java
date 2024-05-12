package com.demo.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的
 * 子集
 * （幂集）。
 *
 * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [1,2,3]
 * 输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 * 示例 2：
 *
 * 输入：nums = [0]
 * 输出：[[],[0]]
 *
 */
public class SubSets {
    public List<List<Integer>> subsets(int[] nums) {
        if (nums.length == 0) {
            return new ArrayList<>();
        }


        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        for (int i = 1; i < nums.length; i++) {
            backtracking(result, new ArrayList<>(), nums, i, 0);
        }
        result.add(Arrays.stream(nums).boxed().collect(Collectors.toList()));

        return result;
    }

    private void backtracking(List<List<Integer>> result, List<Integer> data, int[] nums, int num, int startIndex) {
        if (data.size() == num) {
            result.add(new ArrayList<>(data));
            return;
        }

        for (int i = startIndex; i < nums.length; i++) {
            data.add(nums[i]);
            backtracking(result, data, nums, num, i+1);
            data.remove(data.size()-1);
        }
    }

    public static void main(String[] args) {
        SubSets subSets = new SubSets();
        System.out.println(subSets.subsets(new int[]{1, 2, 3, 4}));
    }
}
