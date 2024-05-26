package com.demo.list;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
 *
 * 请你设计并实现时间复杂度为 O(n) 的算法解决此问题。
 *
 * 示例 1：
 * 输入：nums = [100,4,200,1,3,2]
 * 输出：4
 * 解释：最长数字连续序列是 [1, 2, 3, 4]。它的长度为 4。
 *
 * 示例 2：
 * 输入：nums = [0,3,7,2,5,8,4,6,0,1]
 * 输出：9
 *
 */
public class LongestConsecutive {

    public int longestConsecutive(int[] nums) {
        if (nums.length <= 1) {
            return nums.length;
        }

        Arrays.sort(nums);

        Map<Integer, Integer> map = new HashMap<>();
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (map.get(num - 1) != null) {
                map.put(num, map.get(num - 1) + 1);
                if (max < map.get(num - 1) + 1) {
                    max = map.get(num - 1) + 1;
                }
            } else {
                map.put(num, 1);
                if (max == 0) {
                    max = 1;
                }
            }
        }

        return max;
    }

}
