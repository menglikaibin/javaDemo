package com.demo.dp;

/**
 * @author 吴凯斌
 * 创建时间 2024/3/28 20:32
 */
public class MinCostClimbingStairs {

    /**
     * 转移方程
     * 假设数组cost长度为n,则n个阶梯分别对应下标0到n-1,楼层顶部对应下标n
     * 等价于计算达到下标n的最小花费
     *
     * 创建长度为n+1的数组dp,dp[i]表示到达下标i的最小花费
     *
     * 两种方案
     * 1: 从下标i-1使用cost[i-1]的花费到达下标i
     * 2: 从下标i-2使用cost[i-2]的花费到达下标i
     */
    public static int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        if (n == 0) {
            return 0;
        }
        if (n <= 2) {
            return Math.min(cost[0], cost[1]);
        }

        int[] dp = new int[n+1];
        dp[0] = dp[1] = 0;
        for (int i = 2; i <= n; i++) {
            dp[i] = Math.min(dp[i-1] + cost[i-1], dp[i-2] + cost[i-2]);
        }

        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(minCostClimbingStairs(new int[]{1, 100, 1, 1, 1, 100, 1, 1, 100, 1}));
    }

}
