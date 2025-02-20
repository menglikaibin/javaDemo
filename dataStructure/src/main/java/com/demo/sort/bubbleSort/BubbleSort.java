package com.demo.sort.bubbleSort;

import java.util.Arrays;

public class BubbleSort {

    public static void main(String[] args) {
        int[] nums = {1, 3, 11, 2, 6, 4};

        System.out.println(Arrays.toString(sort(nums)));
    }

    public static int[] sort(int[] nums) {
        for (int i = nums.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (nums[j] > nums[j + 1]) {
                    int tmp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = tmp;
                }
            }
        }

        return nums;
    }

}
