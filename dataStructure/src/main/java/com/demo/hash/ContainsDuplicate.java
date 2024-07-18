package com.demo.hash;

import java.util.Arrays;

/**
 * 217,存在重复元素
 * 给你一个整数数组 nums 。如果任一值在数组中出现 至少两次 ，返回 true ；如果数组中每个元素互不相同，返回 false 。
 *
 * 示例 1：
 *
 * 输入：nums = [1,2,3,1]
 * 输出：true
 * 示例 2：
 *
 * 输入：nums = [1,2,3,4]
 * 输出：false
 * 示例 3：
 *
 * 输入：nums = [1,1,1,3,3,4,3,2,4,2]
 * 输出：true
 * 提示：
 *
 * 1 <= nums.length <= 105
 * -109 <= nums[i] <= 109
 * Related Topics
 * 数组
 * 哈希表
 * 排序
 */
public class ContainsDuplicate {

    public boolean containsDuplicate(int[] nums) {
        if (nums.length == 2) {
            return nums[0] == nums[1];
        }
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            if (i >= 1) {
                if (i + 1 < nums.length) {
                    if (nums[i] == nums[i - 1] || nums[i] == nums[i + 1]) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

}
