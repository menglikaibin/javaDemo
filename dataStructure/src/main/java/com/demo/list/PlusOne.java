package com.demo.list;

import java.util.Arrays;

/**
 * 66.加一
 *
 * 给定一个由 整数 组成的 非空 数组所表示的非负整数，在该数的基础上加一。
 *
 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 *
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 *
 * 示例 1：
 * 输入：digits = [1,2,3]
 * 输出：[1,2,4]
 * 解释：输入数组表示数字 123。
 *
 * 示例 2：
 * 输入：digits = [4,3,2,1]
 * 输出：[4,3,2,2]
 * 解释：输入数组表示数字 4321。
 *
 * 示例 3：
 * 输入：digits = [0]
 * 输出：[1]
 * 提示：
 *
 * 1 <= digits.length <= 100
 * 0 <= digits[i] <= 9
 * Related Topics
 * 数组
 * 数学
 */
public class PlusOne {

    public int[] plusOne(int[] digits) {
        int length = digits.length;

        int index = length - 1;
        while (true) {
            if (digits[index] != 9) {
                digits[index] = digits[index] + 1;
                return digits;
            } else {
                if (index == 0) {
                    digits[0] = 0;
                    int[] ints = new int[length + 1];
                    ints[0] = 1;
                    return ints;
                } else {
                    digits[index] = 0;
                    index -= 1;
                }
            }

        }
    }

    public static void main(String[] args) {
        int[] ints = {9, 9, 9, 9};

        PlusOne plusOne = new PlusOne();

        System.out.println(Arrays.toString(plusOne.plusOne(ints)));
    }
}
