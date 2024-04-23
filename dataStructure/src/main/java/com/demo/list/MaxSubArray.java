package com.demo.list;

import java.util.*;

/**
 * 给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * <p>
 * 子数组
 * 是数组中的一个连续部分。
 * <p>
 * 示例 1：
 * 输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
 * 输出：6
 * 解释：连续子数组 [4,-1,2,1] 的和最大，为 6
 * <p>
 * 示例 2：
 * 输入：nums = [1]
 * 输出：1
 * <p>
 * 示例 3：
 * 输入：nums = [5,4,-1,7,8]
 * 输出：23
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 105
 * -104 <= nums[i] <= 104
 */
public class MaxSubArray {

    public static int maxSubArray(int[] nums) {
        int length = nums.length;

        if (length == 1) {
            return nums[0];
        }

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i <= length - 1; i++) {
            List<Integer> sumList = new ArrayList<>();
            sumList.add(nums[i]);
            int value = nums[i];
            for (int j = i + 1; j <= length - 1; j++) {
                value += nums[j];
                sumList.add(value);
            }

            list.add(Collections.max(sumList));
        }

        return Collections.max(list);
    }

    public static int maxSubArray2(int[] nums) {
        int length = nums.length;

        if (length == 1) {
            return nums[0];
        }

        int maxValue = nums[0];
        int newMaxValue = nums[0];

        for (int i = 1; i < length; i++) {
            maxValue = Math.max(nums[i], maxValue + nums[i]);
            newMaxValue = Math.max(maxValue, newMaxValue);
        }

        return newMaxValue;
    }

    public static void main(String[] args) {
        System.out.println((maxSubArray2(new int[]{5, 4, -1, 7, 8})));
    }
}
