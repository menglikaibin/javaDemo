package com.demo.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。请你合并所有重叠的区间，并返回 一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间 。
 *
 *
 *
 * 示例 1：
 * 输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
 * 输出：[[1,6],[8,10],[15,18]]
 * 解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 *
 * 示例 2：
 * 输入：intervals = [[1,4],[4,5]]
 * 输出：[[1,5]]
 * 解释：区间 [1,4] 和 [4,5] 可被视为重叠区间。
 *
 *
 * 提示：
 *
 * 1 <= intervals.length <= 104
 * intervals[i].length == 2
 * 0 <= starti <= endi <= 104
 */
public class MergeRange {

    public int[][] merge(int[][] intervals) {
        int length = intervals.length;

        Arrays.sort(intervals, (interval1, interval2) -> interval1[0] - interval2[0]);

        List<int[]> result = new ArrayList<>();
        int[] first = intervals[0];

        int end = first[1];

        int[] item = new int[]{first[0], first[1]};
        result.add(item);
        for (int i = 0; i < length; i++) {
            int[] interval = intervals[i];

            if (interval[0] > end) {
                result.add(new int[]{interval[0], interval[1]});
                end = interval[1];
            }
            if (interval[0] <= end && interval[1] > end) {
                result.get(result.size() - 1)[1] = interval[1];
                end = interval[1];
            }
        }

        int[][] data = new int[result.size()][2];
        for (int i = 0; i < result.size(); i++) {
            data[i] = result.get(i);
        }

        return data;
    }

    public static void main(String[] args) {
        MergeRange mergeRange = new MergeRange();

        System.out.println(Arrays.deepToString(mergeRange.merge(new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}})));
    }

}
