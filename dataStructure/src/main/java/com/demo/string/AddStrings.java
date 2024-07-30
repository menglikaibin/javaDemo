package com.demo.string;

/**
 * 415,字符串相加
 *
 * 给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和并同样以字符串形式返回。
 *
 * 你不能使用任何內建的用于处理大整数的库（比如 BigInteger）， 也不能直接将输入的字符串转换为整数形式。
 *
 * 示例 1：
 *
 * 输入：num1 = "11", num2 = "123"
 * 输出："134"
 * 示例 2：
 *
 * 输入：num1 = "456", num2 = "77"
 * 输出："533"
 * 示例 3：
 *
 * 输入：num1 = "0", num2 = "0"
 * 输出："0"
 * 提示：
 *
 * 1 <= num1.length, num2.length <= 104
 * num1 和num2 都只包含数字 0-9
 * num1 和num2 都不包含任何前导零
 * Related Topics
 * 数学
 * 字符串
 * 模拟
 */
public class AddStrings {

    public String addStrings(String num1, String num2) {
        int n = num1.length() - 1;
        int m = num2.length() - 1;
        // 进位
        int add = 0;

        StringBuilder ans = new StringBuilder();
        while (n >= 0 || m >= 0 || add != 0) {
            int x = n >= 0 ? num1.charAt(n) - '0' : 0;
            int y = m >= 0 ? num2.charAt(m) - '0' : 0;

            int result = x + y + add;
            ans.append(result % 10);
            add = result / 10;
            n --;
            m --;
        }

        ans.reverse();
        return ans.toString();
    }

}
