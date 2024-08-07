package com.demo.list.simple;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 349,两个数组的交集
 *
 * 输入：nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出：[2]
 * 示例 2：
 *
 * 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出：[9,4]
 * 解释：[4,9] 也是可通过的
 * 提示：
 *
 * 1 <= nums1.length, nums2.length <= 1000
 * 0 <= nums1[i], nums2[i] <= 1000
 * Related Topics
 * 数组
 * 哈希表
 * 双指针
 * 二分查找
 * 排序
 */
public class Intersection {

    public int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < nums1.length; i++) {
            if (isContain(nums2, nums1[i]) && !result.contains(nums1[i])) {
                result.add(nums1[i]);
            }
        }

        return result.stream().mapToInt(Integer::intValue).toArray();
    }

    private boolean isContain(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int m = left + (right - left) / 2;
            if (nums[m] < target) {
                left = m + 1;
            } else if (nums[m] > target) {
                right = m - 1;
            } else {
                return true;
            }
        }

        return false;
    }
}
