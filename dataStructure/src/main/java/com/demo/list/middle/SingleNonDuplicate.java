package com.demo.list.middle;

/**
 * 540,有序数组中的单一元素
 *
 * 给你一个仅由整数组成的有序数组，其中每个元素都会出现两次，唯有一个数只会出现一次。
 *
 * 请你找出并返回只出现一次的那个数。
 *
 * 你设计的解决方案必须满足 O(log n) 时间复杂度和 O(1) 空间复杂度。
 *
 * 示例 1:
 *
 * 输入: nums = [1,1,2,3,3,4,4,8,8]
 * 输出: 2
 * 示例 2:
 *
 * 输入: nums =  [3,3,7,10,10,11,11]
 * 输出: 10
 * 提示:
 *
 * 1 <= nums.length <= 105
 * 0 <= nums[i] <= 105
 * Related Topics
 * 数组
 * 二分查找
 */
public class SingleNonDuplicate {

    public int singleNonDuplicate(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = (right - left) / 2 + left;
            if (nums[mid] == nums[mid ^ 1]) {
                left = left + 1;
            } else {
                right = mid;
            }
        }

        return nums[left];
    }

    public static void main(String[] args) {
        System.out.println(1 ^ 1);
        System.out.println(2 ^ 1);
        System.out.println(3 ^ 1);
        System.out.println(4 ^ 1);

//        SingleNonDuplicate singleNonDuplicate = new SingleNonDuplicate();
//        System.out.println(singleNonDuplicate.singleNonDuplicate(new int[]{1,1,2,3,3,4,4,8,8}));
    }

}
