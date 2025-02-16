package com.demo.dp;

import java.util.Scanner;

/**
 * 题目描述
 * 小明每周上班都会拿到自己的工作清单，工作清单内包含 n 项工作，每项工作都有对应的耗时时间（单位 h）和报酬，工作的总报酬为所有已完成工作的报酬之和，那么请你帮小明安排一下工作，保证小明在指定的工作时间内工作收入最大化。
 *
 * 输入描述
 * 输入的第一行为两个正整数 T，n。
 * T 代表工作时长（单位 h， 0 < T < 1000000），
 * n 代表工作数量（ 1 < n ≤ 3000）。
 * 接下来是 n 行，每行包含两个整数 t，w。
 * t 代表该工作消耗的时长（单位 h， t > 0），w 代表该项工作的报酬。
 *
 * 输出描述
 * 输出小明指定工作时长内工作可获得的最大报酬。
 * 输入
 * 40 3
 * 20 10
 * 20 20
 * 20 5
 * 输出	30
 * 说明	无
 */
public class Beibao {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        int n = sc.nextInt();

        int[][] work = new int[n+1][2];

        for (int i = 1; i <= n; i++) {
            work[i][0] = sc.nextInt();
            work[i][1] = sc.nextInt();
        }

        System.out.println(getResult(n, T, work));
    }

    public static int getResult(int n, int T, int[][] work) {
        int[][] dp = new int[n + 1][T + 1];

        for (int i = 1; i <= n; i++) {
            int t = work[i][0]; // 工作时长
            int w = work[i][1]; // 工作价值

            for (int j = 1; j <= T; j++) {
                if (j < t) {
                    // 如果当前时长小于工作时长，则取上一行同一列的值
                    dp[i][j] = dp[i-1][j];
                } else {
                    // 如果要选择的工作的权重 <= 当前背包权重
                    // 则我们有两种选择
                    // 1、不进行该工作，则最大价值继承自上一行该列值
                    // 2、进行该工作，则纳入该工作的价值w，加上+ 剩余权重，在不进行该工作的范围内，可得的最大价值dp[i - 1][j - t]
                    dp[i][j] = Math.max(dp[i-1][j], w + dp[i-1][j-t]);
                }
            }
        }

        return dp[n][T];
    }

}
