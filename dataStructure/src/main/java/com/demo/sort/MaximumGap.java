package com.demo.sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 164,最大间距
 *
 * 给定一个无序的数组 nums，返回 数组在排序之后，相邻元素之间最大的差值 。如果数组元素个数小于 2，则返回 0 。
 *
 * 您必须编写一个在「线性时间」内运行并使用「线性额外空间」的算法。
 *
 * 示例 1:
 *
 * 输入: nums = [3,6,9,1]
 * 输出: 3
 * 解释: 排序后的数组是 [1,3,6,9], 其中相邻元素 (3,6) 和 (6,9) 之间都存在最大差值 3。
 * 示例 2:
 *
 * 输入: nums = [10]
 * 输出: 0
 * 解释: 数组元素个数小于 2，因此返回 0。
 * 提示:
 *
 * 1 <= nums.length <= 105
 * 0 <= nums[i] <= 109
 * Related Topics
 * 数组
 * 桶排序
 * 基数排序
 * 排序
 */
public class MaximumGap {

    public int maximumGap(int[] nums) {
        if (nums.length < 2) {
            return 0;
        }

        int k = nums.length / 2;

        List<List<Integer>> buckets = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            buckets.add(new ArrayList<>());
        }

        // 将元素分配到各个桶
        for (int num : nums) {
            int i = num % k;
            buckets.get(i).add(num);
        }

        for (List<Integer> bucket : buckets) {
            Collections.sort(bucket);
        }

        int i = 0;
        for (List<Integer> bucket : buckets) {
            for (Integer num : bucket) {
                nums[i++] = num;
            }
        }

        int max = 0;
        for (int j = 0; j < nums.length; j++) {
            if (j > 0) {
                max = Math.max(nums[j] - nums[j-1], max);
            }
        }

        return max;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 0, 10, 12, 19};

        MaximumGap maximumGap = new MaximumGap();
        System.out.println(maximumGap.maximumGap(nums));
    }
}
