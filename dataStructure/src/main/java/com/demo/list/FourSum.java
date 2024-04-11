package com.demo.list;

import java.util.*;

/**
 * 给你一个由 n 个整数组成的数组 nums ，和一个目标值 target 。请你找出并返回满足下述全部条件且不重复的四元组 [nums[a], nums[b], nums[c], nums[d]] （若两个四元组元素一一对应，则认为两个四元组重复）：
 *
 * 0 <= a, b, c, d < n
 * a、b、c 和 d 互不相同
 * nums[a] + nums[b] + nums[c] + nums[d] == target
 * 你可以按 任意顺序 返回答案 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [1,0,-1,0,-2,2], target = 0
 * 输出：[[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
 * 示例 2：
 *
 * 输入：nums = [2,2,2,2,2], target = 8
 * 输出：[[2,2,2,2]]
 *
 *
 * 提示：
 *
 * 1 <= nums.length <= 200
 * -109 <= nums[i] <= 109
 * -109 <= target <= 109
 */
public class FourSum {

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        int length = nums.length;
        Arrays.sort(nums);
        if (length < 4) {
            return new ArrayList<>();
        }

        List<List<Integer>> result = new ArrayList<>();
        Set<String> uniqueSet = new HashSet<>();
        for (int i = 0; i < length - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            List<List<Integer>> threeSumSubsets = findThreeSumSubsets(nums, i + 1, target - nums[i]);

            if (threeSumSubsets.size() > 0) {
                for (List<Integer> subset : threeSumSubsets) {
                    List<Integer> newSubset = new ArrayList<>(subset);
                    newSubset.add(0, nums[i]);
                    String string = newSubset.toString();
                    if (!uniqueSet.contains(string)) {
                        result.add(newSubset);
                        uniqueSet.add(string);
                    }
                }
            }
        }

        return result;
    }

    private static List<List<Integer>> findThreeSumSubsets(int[] nums, int index, int target) {
        List<List<Integer>> result = new ArrayList<>();

        for (int i = index; i < nums.length - 2; i++) {
            if (i > index && nums[i] == nums[i - 1]) {
                continue;
            }

            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                if (sum == target) {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }
                    left ++;
                    right --;
                } else if (sum < target) {
                    left ++;
                } else {
                    right --;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(fourSum(new int[]{999999999,1000000000,1000000000,1000000000}, -294967296));
    }
}
