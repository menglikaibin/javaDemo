package com.demo.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * 491,非递减子序列
 *
 * 给你一个整数数组 nums ，找出并返回所有该数组中不同的递增子序列，递增子序列中 至少有两个元素 。你可以按 任意顺序 返回答案。
 *
 * 数组中可能含有重复元素，如出现两个整数相等，也可以视作递增序列的一种特殊情况。
 *
 * 示例 1：
 *
 * 输入：nums = [4,6,7,7]
 * 输出：[[4,6],[4,6,7],[4,6,7,7],[4,7],[4,7,7],[6,7],[6,7,7],[7,7]]
 * 示例 2：
 *
 * 输入：nums = [4,4,3,2,1]
 * 输出：[[4,4]]
 * 提示：
 *
 * 1 <= nums.length <= 15
 * -100 <= nums[i] <= 100
 * Related Topics
 * 位运算
 * 数组
 * 哈希表
 * 回溯
 */
public class FindSubsequences {

    public List<List<Integer>> findSubsequences(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        backtracking(result, new ArrayList<>(), nums, 0);

        return result;
    }

    private void backtracking(List<List<Integer>> result, List<Integer> data, int[] nums, int index) {
        if (index >= nums.length) {
            return;
        }
        if (data.size() >= 1 && nums[index] >= data.get(data.size() - 1)) {
            data.add(nums[index]);
            result.add(new ArrayList<>(data));
            return;
        }

        for (int i = index; i < nums.length; i++) {
            data.add(nums[index]);

            index++;
            backtracking(result, data, nums, index);
            index--;

            data.remove(data.size() - 1);

        }
    }

    public static void main(String[] args) {
        FindSubsequences findSubsequences = new FindSubsequences();
        System.out.println(findSubsequences.findSubsequences(new int[]{4, 6, 7, 7}));
    }

}
