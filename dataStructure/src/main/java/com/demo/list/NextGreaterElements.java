package com.demo.list;

import java.util.Arrays;
import java.util.Stack;

/**
 * 503,下一个更大元素
 *
 * 给定一个循环数组 nums （ nums[nums.length - 1] 的下一个元素是 nums[0] ），返回 nums 中每个元素的 下一个更大元素 。
 *
 * 数字 x 的 下一个更大的元素 是按数组遍历顺序，这个数字之后的第一个比它更大的数，这意味着你应该循环地搜索它的下一个更大的数。如果不存在，则输出 -1 。
 *
 * 示例 1:
 *
 * 输入: nums = [1,2,1]
 * 输出: [2,-1,2]
 * 解释: 第一个 1 的下一个更大的数是 2；
 * 数字 2 找不到下一个更大的数；
 * 第二个 1 的下一个最大的数需要循环搜索，结果也是 2。
 * 示例 2:
 *
 * 输入: nums = [1,2,3,4,3]
 * 输出: [2,3,4,-1,4]
 * 提示:
 *
 * 1 <= nums.length <= 104
 * -109 <= nums[i] <= 109
 * Related Topics
 * 栈
 * 数组
 * 单调栈
 */
public class NextGreaterElements {

    public int[] nextGreaterElements(int[] nums) {
        int length = nums.length;
        int[] result = new int[length];

        Arrays.fill(result, -1);

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < length * 2; i++) {
            while (!stack.isEmpty() && nums[i % length] > nums[stack.peek()]) {
                result[stack.peek()] = nums[i % length];
                stack.pop();
            }

            stack.push(i % length);
        }

        return result;
    }

    public static void main(String[] args) {
//        System.out.println(2 % 8);
//
//        Stack<Integer> stack = new Stack<>();
//        stack.push(1);
//        stack.push(2);
//        stack.push(3);
//        stack.push(5);
//
//        System.out.println(stack.peek());
//        System.out.println(stack.peek());
//        System.out.println(stack.peek());
//        System.out.println(stack.peek());

        NextGreaterElements nextGreaterElements = new NextGreaterElements();
        System.out.println(Arrays.toString(nextGreaterElements.nextGreaterElements(new int[]{7, 6, 5, 4, 3, 2, 1})));
    }

}
