package com.demo.dp;

/**
 * @author 吴凯斌
 * 创建时间 2024/4/8 19:50
 */
public class Rob {

    /**
     * 假设有n户,最大值为 Max(dp[n-1]+dp[n-3])
     */
    public static int rob(int[] nums) {
        int length = nums.length;

        if (length == 0) {
            return 0;
        }

        if (length == 1) {
            return nums[0];
        }

        if (length == 2) {
            return Math.max(nums[0], nums[1]);
        }

        if (length == 3) {
            return Math.max(nums[0]+nums[2], nums[1]);
        }

        int[] dp = new int[length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < length; i++) {
            dp[i] = Math.max(dp[i-2] + nums[i], dp[i-1]);
        }

        return dp[length - 1];
    }

    public static void main(String[] args) {
        System.out.println(rob(new int[]{1, 34, 89, 54, 1, 2}));
    }
}
