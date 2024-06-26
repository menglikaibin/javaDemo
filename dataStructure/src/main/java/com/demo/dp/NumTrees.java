package com.demo.dp;

/**
 * 给你一个整数 n ，求恰由 n 个节点组成且节点值从 1 到 n 互不相同的 二叉搜索树 有多少种？返回满足题意的二叉搜索树的种数。
 *
 *
 *
 * 示例 1：
 * 输入：n = 3
 * 输出：5
 *
 * 示例 2：
 * 输入：n = 1
 * 输出：1
 *
 *
 * 提示：
 *
 * 1 <= n <= 19
 */
public class NumTrees {

    /**
     * 对于数值是 n 的二叉搜索树的个数，等于 以 1-n 的数值为头结点的个数相加。这一步相信大家都没啥问题。那么后面对于每一个头结点，该怎样去算呢？
     *  举例，n 为 7，那么当头结点是 5 的时候，将 1,2,3,4,6,7 这几个数字放进去，根据二叉搜索树定义，左子树小右子树大，那么 1,2,3,4只能在左子树，6,7在右子树中
     *  也就是说 左子树由四个数构成一颗二叉搜索树，右子树有两个数构成一颗二叉搜索树，这里右子树的 6,7 可以看成 1,2，因为把头结点 5 不看的话，1,2 构成的二叉搜索树和 6,7 构成的二叉搜索树的个数是一样的。
     *  这也是为什么只要布局相似即可。那么再看 方程 dp【i】 += dp【j - 1】 * dp【i - j】，把  i = 7，j = 5 带入，其实就是 dp【4】 * dp【2】 , 这里的 4 是个数，2 也是个数。
     */
    public int numTrees(int n) {
        if (n <= 1) {
            return 1;
        }
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i] += dp[j-1] * dp[i-j];
            }
        }

        return dp[n];
    }

}
