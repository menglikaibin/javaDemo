package com.demo.hash;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串的长度。
 *
 * 示例 1:
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 *
 * 示例 2:
 * 输入: s = "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 *
 * 示例 3:
 * 输入: s = "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 */
public class LengthOfLongestSubstring {


    public int lengthOfLongestSubstring(String s) {
        int length = s.length();
        if (length <= 1) {
            return length;
        }

        int max = 0;
        for (int i = 0; i < length; i++) {

            Set<Character> set = new HashSet<>();
            set.add(s.charAt(i));
            for (int j = i + 1; j < length; j++) {
                int size = set.size();
                set.add(s.charAt(j));
                if (set.size() == size) {
                    max = Math.max(max, set.size());
                    break;
                } else {
                    max = Math.max(max, set.size());
                }
            }
        }

        return max;
    }

    public int lengthOfLongestSubstring2(String s) {
        if (s.length() <= 1) {
            return s.length();
        }

        int max = 0;
        Map<Character, Integer> map = new HashMap<>();
        int left = 0;

        for (int right = 0; right < s.length(); right++) {
            char currentChar = s.charAt(right);
            if (map.containsKey(currentChar) && map.get(currentChar) >= left) {
                left = map.get(currentChar) + 1;
            }
            map.put(currentChar, right);
            max = Math.max(max, right - left + 1);
        }

        return max;
    }

    public static void main(String[] args) {
        LengthOfLongestSubstring lengthOfLongestSubstring = new LengthOfLongestSubstring();
        System.out.println(lengthOfLongestSubstring.lengthOfLongestSubstring2("auaxdtsza"));
    }
}
