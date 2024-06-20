package com.demo.common;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
 *
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 *
 *
 *
 * 示例 1：
 *
 * 输入：digits = "23"
 * 输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
 * 示例 2：
 *
 * 输入：digits = ""
 * 输出：[]
 * 示例 3：
 *
 * 输入：digits = "2"
 * 输出：["a","b","c"]
 * 提示：
 *
 * 0 <= digits.length <= 4
 * digits[i] 是范围 ['2', '9'] 的一个数字。
 */
public class LetterCombinations {

    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) {
            return new ArrayList<>();
        }
        List<String> result = new ArrayList<>();

        HashMap<String, List<String>> map = new HashMap<>(16);
        map.put("2", Arrays.asList("a", "b", "c"));
        map.put("3", Arrays.asList("d", "e", "f"));
        map.put("4", Arrays.asList("g", "h", "i"));
        map.put("5", Arrays.asList("j", "k", "l"));
        map.put("6", Arrays.asList("m", "n", "o"));
        map.put("7", Arrays.asList("p", "q", "r", "s"));
        map.put("8", Arrays.asList("t", "u", "v"));
        map.put("9", Arrays.asList("w", "x", "y", "z"));

        List<String> list = new ArrayList<>();
        for (int i = 0; i < digits.length(); i++) {
            list.add(String.valueOf(digits.charAt(i)));
        }

        backtrack(result, map, list, new ArrayList<>(), 0);

        return result;
    }


    private void backtrack(List<String> result, HashMap<String, List<String>> map, List<String> list, List<String> current, Integer index) {
        if (current.size() == list.size()) {
            StringBuilder data = new StringBuilder();
            for (int i = 0; i < current.size(); i++) {
                data.append(current.get(i));
            }
            result.add(data.toString());
            return;
        }

        List<String> eles = map.get(list.get(index));
        for (String ele : eles) {
            current.add(ele);
            backtrack(result, map, list, current, index + 1);
            current.remove(current.size() - 1);
        }
    }

    public static void main(String[] args) {
        LetterCombinations letterCombinations = new LetterCombinations();
        List<String> list = letterCombinations.letterCombinations("234");

        System.out.println(list);
    }
}
