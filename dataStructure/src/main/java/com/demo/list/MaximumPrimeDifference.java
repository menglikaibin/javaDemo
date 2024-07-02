package com.demo.list;

/**
 * 3115. 质数的最大距离
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个整数数组 nums。
 *
 * 返回两个（不一定不同的）质数在 nums 中 下标 的 最大距离。
 *
 *
 *
 * 示例 1：
 *
 * 输入： nums = [4,2,9,5,3]
 *
 * 输出： 3
 *
 * 解释： nums[1]、nums[3] 和 nums[4] 是质数。因此答案是 |4 - 1| = 3。
 *
 * 示例 2：
 *
 * 输入： nums = [4,8,2,8]
 *
 * 输出： 0
 *
 * 解释： nums[2] 是质数。因为只有一个质数，所以答案是 |2 - 2| = 0。
 *
 *
 *
 * 提示：
 *
 * 1 <= nums.length <= 3 * 105
 * 1 <= nums[i] <= 100
 * 输入保证 nums 中至少有一个质数。
 */
public class MaximumPrimeDifference {

    public int maximumPrimeDifference(int[] nums) {
        boolean[] withinPrime = getWithinPrime(100);

        int last = -1, current = 0;
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            if (withinPrime[nums[i]]) {
                if (i == 0) {
                    last = i;
                } else {
                    if (last != -1) {
                        result = i - last;
                    } else {
                        last = i;
                    }
                }
            }
        }

        return result;
    }

    private boolean isPrime(int src) {
        double sqrt = Math.sqrt(src);

        if (src < 2) {
            return false;
        }

        if (src == 2 || src == 3) {
            return true;
        }
        if (src % 2 == 0) {
            return false;
        }

        for (int i = 3; i <= sqrt; i+=2) {
            if (src % i == 0) {
                return false;
            }
        }

        return true;
    }

    private boolean[] getWithinPrime(int value) {
        boolean[] result = new boolean[value+1];

        for (int i = 0; i <= value; i++) {
            if (isPrime(i)) {
                result[i] = true;
            } else {
                result[i] = false;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        MaximumPrimeDifference maximumPrimeDifference = new MaximumPrimeDifference();
        System.out.println(maximumPrimeDifference.maximumPrimeDifference(new int[]{4, 8, 2, 4}));
    }
}
