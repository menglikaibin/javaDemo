package com.demo.string;

import java.util.Arrays;
import java.util.List;

/**
 * 345,反转字符串中的元音字母
 *
 * 给你一个字符串 s ，仅反转字符串中的所有元音字母，并返回结果字符串。
 *
 * 元音字母包括 'a'、'e'、'i'、'o'、'u'，且可能以大小写两种形式出现不止一次。
 *
 * 示例 1：
 *
 * 输入：s = "hello"
 * 输出："holle"
 * 示例 2：
 *
 * 输入：s = "leetcode"
 * 输出："leotcede"
 * 提示：
 *
 * 1 <= s.length <= 3 * 10^5
 * s 由 可打印的 ASCII 字符组成
 * Related Topics
 * 双指针
 * 字符串
 */
public class ReverseVowels {

    public String reverseVowels(String s) {

        List<Character> list = Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U');

        int right = s.length() - 1;
        int left = 0;

        char[] chars = s.toCharArray();

        for (int i = left; i < right; i++) {

            if (list.contains(s.charAt(i))) {

                for (int j = right; j > left; j--) {
                    if (list.contains(s.charAt(j))) {
                        char temp = chars[i];
                        chars[i] = chars[j];
                        chars[j] = temp;

                        left = i + 1;
                        right = j - 1;
                        break;
                    }
                }

            }
        }

        return String.valueOf(chars);
    }

    public static void main(String[] args) {
        ReverseVowels reverseVowels = new ReverseVowels();
        System.out.println(reverseVowels.reverseVowels("leetcode"));
    }

}
