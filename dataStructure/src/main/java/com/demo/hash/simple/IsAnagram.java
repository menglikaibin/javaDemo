package com.demo.hash.simple;

import java.util.HashMap;
import java.util.Map;

/**
 * 242,有效的字母异位词
 *
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 *
 * 字母异位词 是通过重新排列不同单词或短语的字母而形成的单词或短语，通常只使用所有原始字母一次。
 *
 * 示例 1:
 *
 * 输入: s = "anagram", t = "nagaram"
 * 输出: true
 * 示例 2:
 *
 * 输入: s = "rat", t = "car"
 * 输出: false
 * 提示:
 *
 * 1 <= s.length, t.length <= 5 * 10^4
 * s 和 t 仅包含小写字母
 * 进阶: 如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？
 *
 * Related Topics
 * 哈希表
 * 字符串
 * 排序
 */
public class IsAnagram {

    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        Map<Character, Integer> map = new HashMap<>(s.length());

        for (int i = 0; i < s.length(); i++) {
            Integer count = map.getOrDefault(s.charAt(i), 0);
            map.put(s.charAt(i), count + 1);
        }

        for (int i = 0; i < t.length(); i++) {
            Integer count = map.getOrDefault(t.charAt(i), 0);
            if (count == 0) {
                return false;
            }
            map.put(t.charAt(i), count - 1);
        }

        for (Character character : map.keySet()) {
            Integer integer = map.get(character);
            if (integer != 0) {
                return false;
            }
        }

        return true;
    }

}
