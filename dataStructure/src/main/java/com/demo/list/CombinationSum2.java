package com.demo.list;

import java.util.*;

/**
 * 给定一个候选人编号的集合 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 *
 * candidates 中的每个数字在每个组合中只能使用 一次 。
 *
 * 注意：解集不能包含重复的组合。
 *
 *
 *
 * 示例 1:
 * 输入: candidates = [10,1,2,7,6,1,5], target = 8,
 * 输出:
 * [
 * [1,1,6],
 * [1,2,5],
 * [1,7],
 * [2,6]
 * ]
 *
 * 示例 2:
 * 输入: candidates = [2,5,2,1,2], target = 5,
 * 输出:
 * [
 * [1,2,2],
 * [5]
 * ]
 */
public class CombinationSum2 {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Set<List<Integer>> result = new HashSet<>();

        Arrays.sort(candidates);
        backtracking(result, new ArrayList<>(), candidates, target, 0);

        return new ArrayList<>(result);
    }

    private void backtracking(Set<List<Integer>> result, List<Integer> data, int[] candidates, int remain, int current) {
        if (remain == 0) {
            Collections.sort(data);
            result.add(new ArrayList<>(data));
            return;
        }
        if (remain < 0) {
            return;
        }

        for (int i = current; i < candidates.length; i++) {
            data.add(candidates[i]);
            backtracking(result, data, candidates, remain - candidates[i], i + 1);
            data.remove(data.size() - 1);
        }
    }

    public static void main(String[] args) {
        CombinationSum2 combinationSum2 = new CombinationSum2();
        System.out.println(combinationSum2.combinationSum2(new int[]{1, 2, 3, 2, 3, 2}, 8));
    }
}
