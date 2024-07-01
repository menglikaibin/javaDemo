package com.demo.quickSort;

import java.util.Arrays;

/**
 * 75.颜色分类
 * 给定一个包含红色、白色和蓝色、共 n 个元素的数组 nums ，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 *
 * 我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
 *
 * 必须在不使用库内置的 sort 函数的情况下解决这个问题。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [2,0,2,1,1,0]
 * 输出：[0,0,1,1,2,2]
 * 示例 2：
 *
 * 输入：nums = [2,0,1]
 * 输出：[0,1,2]
 *
 *
 * 提示：
 *
 * n == nums.length
 * 1 <= n <= 300
 * nums[i] 为 0、1 或 2
 */
public class SortColors {

    public void sortColors(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    /**
     * 1.选取数组最左端元素作为基准数，初始化两个指针 i 和 j 分别指向数组的两端。
     * 2.设置一个循环，在每轮中使用 i（j）分别寻找第一个比基准数大（小）的元素，然后交换这两个元素。
     * 3.循环执行步骤 2. ，直到 i 和 j 相遇时停止，最后将基准数交换至两个子数组的分界线。
     */
    private int partition(int[] nums, int left, int right) {
        int i = left, j = right;
        while (i < j) {
            while (i < j && nums[j] >= nums[left]) {
                j --;
            }
            while (i < j && nums[i] <= nums[left]) {
                i ++;
            }
            swap(nums, i, j);
        }
        swap(nums, i, left);
        return i;
    }

    private void quickSort(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }

        int pivot = partition(nums, left, right);
        quickSort(nums, left, pivot - 1);
        quickSort(nums, pivot + 1, right);
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0, 1, 0, 1, 0, 1, 2, 2, 1};
        SortColors sortColors = new SortColors();
//        System.out.println(Arrays.toString(sortColors.sortColors(new int[]{0, 1, 0, 1, 0, 1, 2, 2, 1})));

        sortColors.sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }
}
