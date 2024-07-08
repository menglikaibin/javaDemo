package com.demo.backtracking;

import java.util.*;

/**
 * 40,数组总和
 *
 * 给定一个候选人编号的集合 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 *
 * candidates 中的每个数字在每个组合中只能使用 一次 。
 *
 * 注意：解集不能包含重复的组合。
 *
 * 示例 1:
 *
 * 输入: candidates = [10,1,2,7,6,1,5], target = 8,
 * 输出:
 * [
 * [1,1,6],
 * [1,2,5],
 * [1,7],
 * [2,6]
 * ]
 * 示例 2:
 *
 * 输入: candidates = [2,5,2,1,2], target = 5,
 * 输出:
 * [
 * [1,2,2],
 * [5]
 * ]
 * 提示:
 *
 * 1 <= candidates.length <= 100
 * 1 <= candidates[i] <= 50
 * 1 <= target <= 30
 * Related Topics
 * 数组
 * 回溯
 */
public class CombinationSum2 {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);

        Set<List<Integer>> result = new HashSet<>();

        backtracking(result, new ArrayList<>(), candidates, target, new boolean[candidates.length], 0);

        return new ArrayList<>(result);
    }

    public void backtracking(Set<List<Integer>> result, List<Integer> data, int[] candidates, int target, boolean[] used, int index) {
        if (data.stream().mapToInt(Integer::intValue).sum() > target) {
            data = new ArrayList<>();
            return;
        }
        if (data.stream().mapToInt(Integer::intValue).sum() == target) {
            result.add(new ArrayList<>(data));
            data = new ArrayList<>();
            return;
        }

        for (int i = index; i < candidates.length; i++) {
            if (used[i]) {
                continue;
            }
            if (i > index && candidates[i] == candidates[i - 1] && !used[i - 1]) {
                continue;
            }
            data.add(candidates[i]);
            used[i] = true;
            backtracking(result, data, candidates, target, used, i + 1);
            data.remove(data.size() - 1);
            used[i] = false;
        }
    }

    public static void main(String[] args) {
        CombinationSum2 combinationSum2 = new CombinationSum2();
        System.out.println(combinationSum2.combinationSum2(new int[]{10, 1, 2, 7, 6, 1, 5}, 8));
    }
}
