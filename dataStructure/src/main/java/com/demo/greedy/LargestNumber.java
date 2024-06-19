package com.demo.greedy;

import java.util.Arrays;

/**
 * 给定一组非负整数 nums，重新排列每个数的顺序（每个数不可拆分）使之组成一个最大的整数。
 *
 * 注意：输出结果可能非常大，所以你需要返回一个字符串而不是整数。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [10,2]
 * 输出："210"
 * 示例 2：
 *
 * 输入：nums = [3,30,34,5,9]
 * 输出："9534330"
 *
 *
 * 提示：
 *
 * 1 <= nums.length <= 100
 * 0 <= nums[i] <= 109
 */
public class LargestNumber {

    public String largestNumber(int[] nums) {
        int length = nums.length;

        String[] strings = new String[nums.length];
        for (int i = 0; i < length; i++) {
            strings[i] = String.valueOf(nums[i]);
        }

        Arrays.sort(strings, (o1, o2) -> {
            String order1 = o1 + o2;
            String order2 = o2 + o1;

            return order2.compareTo(order1);
        });

        if (strings[0].charAt(0) == '0') {
            return "0";
        }

        StringBuilder result = new StringBuilder();
        for (String string : strings) {
            result.append(string);
        }

        return result.toString();
    }


    public static void main(String[] args) {
        int[] ints = {10, 0, 0, 0, 0};
        LargestNumber largestNumber = new LargestNumber();
        String s = largestNumber.largestNumber(ints);

        System.out.println(s);
    }
}
