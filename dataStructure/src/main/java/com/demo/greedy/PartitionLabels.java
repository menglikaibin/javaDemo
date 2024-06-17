package com.demo.greedy;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个字符串 s 。我们要把这个字符串划分为尽可能多的片段，同一字母最多出现在一个片段中。
 *
 * 注意，划分结果需要满足：将所有划分结果按顺序连接，得到的字符串仍然是 s 。
 *
 * 返回一个表示每个字符串片段的长度的列表。
 *
 *
 *
 * 示例 1：
 * 输入：s = "ababcbacadefegdehijhklij"
 * 输出：[9,7,8]
 * 解释：
 * 划分结果为 "ababcbaca"、"defegde"、"hijhklij" 。
 * 每个字母最多出现在一个片段中。
 * 像 "ababcbacadefegde", "hijhklij" 这样的划分是错误的，因为划分的片段数较少。
 *
 * 示例 2：
 * 输入：s = "eccbbbbdec"
 * 输出：[10]
 */
public class PartitionLabels {

    public List<Integer> partitionLabels(String s) {

        List<Integer> result = new ArrayList<>();

        List<Character> data = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            data.add(s.charAt(i));
        }

        for (int i = 0; i < s.length(); i++) {
            int index = data.lastIndexOf(s.charAt(i));
            if (index != i) {
                for (int j = i; j < index; j++) {
                    index = Math.max(index, data.lastIndexOf(s.charAt(j)));
                }
                result.add(index - i + 1);
                i = index;
            } else {
                result.add(1);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        PartitionLabels partitionLabels = new PartitionLabels();
        System.out.println(partitionLabels.partitionLabels("qiejxqfnqceocmy").toString());
    }
}
