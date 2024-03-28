package com.demo.dp;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 吴凯斌
 * 创建时间 2024/3/28 13:39
 */
public class NumWays {

    private static final Map<Integer, Integer> tempMap = new HashMap();

    public int climbStairs(int n) {
        if (n == 1 || n == 2) {
            return n;
        }

        return climbStairs(n - 1) + climbStairs(n - 2);
    }

    public static int climbStairs2(int n) {
        if (n == 1 || n == 2) {
            return n;
        }

        if (tempMap.containsKey(n)) {
            return tempMap.get(n);
        } else {
            tempMap.put(n, (climbStairs2(n - 1) + climbStairs2(n - 2)));
            return tempMap.get(n);
        }
    }


    public static void main(String[] args) {
        System.out.println(climbStairs2(45));
    }

}
