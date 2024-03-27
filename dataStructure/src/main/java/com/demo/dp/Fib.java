package com.demo.dp;

/**
 * @author 吴凯斌
 * 创建时间 2024/3/27 10:53
 */
public class Fib {

    public static int fib(int n) {
        if (n == 1 || n == 2) {
            return 1;
        }
        return fib(n - 1) + fib(n - 2);
    }

    public static void main(String[] args) {
        System.out.println(fib(100));
    }
}
