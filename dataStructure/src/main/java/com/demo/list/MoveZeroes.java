package com.demo.list;

import java.util.Arrays;

/**
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 *
 * 请注意 ，必须在不复制数组的情况下原地对数组进行操作。
 *
 *
 *
 * 示例 1:
 * 输入: nums = [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 *
 * 示例 2:
 * 输入: nums = [0]
 * 输出: [0]
 */
public class MoveZeroes {

    public void moveZeroes(int[] nums) {
        int[] result = new int[nums.length];

        int left = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                result[left] = nums[i];
                left ++;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            nums[i] = result[i];
        }
    }

    public static void main(String[] args) {
        int[] ints = {1, 2, 0, 3, 5, 5, 0, 0, 11, 2};
        MoveZeroes moveZeroes = new MoveZeroes();
        moveZeroes.moveZeroes(ints);

        System.out.println(Arrays.toString(ints));
    }

}
