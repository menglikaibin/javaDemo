package com.demo.dp;

/**
 * @author 吴凯斌
 * 创建时间 2024/3/28 17:52
 */
public class LenLongestList {

    public static int lenLongestList(int[] nums) {
        int length = nums.length;
        if (length == 0) {
            return 0;
        }
        if (length == 1) {
            return 1;
        }

        int[] dp = new int[length];
        dp[0] = 1;
        int maxans = 1;
        for (int i = 1; i < length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                int num = nums[j];
                int num2 = nums[i];
                if (num < num2) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            maxans = Math.max(maxans, dp[i]);
        }

        return maxans;
    }


    public static void main(String[] args) {
        System.out.println(lenLongestList(new int[]{2, 1, 2}));
    }
}
