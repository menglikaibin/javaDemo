package com.demo.list;

import java.util.Arrays;

/**
 * 给定一个包含红色、白色和蓝色、共 n 个元素的数组 nums ，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 *
 * 我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
 *
 * 必须在不使用库内置的 sort 函数的情况下解决这个问题。
 *
 *
 *
 * 示例 1：
 * 输入：nums = [2,0,2,1,1,0]
 * 输出：[0,0,1,1,2,2]
 *
 * 示例 2：
 * 输入：nums = [2,0,1]
 * 输出：[0,1,2]
 *
 *
 * 提示：
 *
 * n == nums.length
 * 1 <= n <= 300
 * nums[i] 为 0、1 或 2
 *
 */
public class SortColors {

    public int[] sortColors(int[] nums) {
        int length = nums.length;

        int left = 0, mid = 0, right = length - 1;
        while (mid <= right) {
            switch (nums[mid]) {
                case 0:
                    swap(nums, left++, mid++);
                    break;
                case 1:
                    mid++;
                    break;
                case 2:
                    swap(nums, mid, right--);
                    break;
                default:
                    break;
            }
        }

        return nums;
    }

    public void quickSort(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }

        // 获取基准元素的下标
        int pivot = partition(nums, left, right);
        quickSort(nums, left, pivot - 1);
        quickSort(nums, pivot + 1, right);
    }

    private int partition(int[] nums, int left, int right) {
        int pivot = nums[right];

        int i = left - 1;

        for (int j = left; j < right; j++) {
            if (nums[j] <= pivot) {
                i++;
                swap(nums, i, j);
            }
        }

        swap(nums, i + 1, right);
        return i+1;
    }


    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0, 1, 0, 1, 0, 1, 2, 2, 1};
        SortColors sortColors = new SortColors();
//        System.out.println(Arrays.toString(sortColors.sortColors(new int[]{0, 1, 0, 1, 0, 1, 2, 2, 1})));

        sortColors.quickSort(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums));
    }
}
