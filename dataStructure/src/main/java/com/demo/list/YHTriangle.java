package com.demo.list;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个非负整数 numRows，生成「杨辉三角」的前 numRows 行。
 *
 * 在「杨辉三角」中，每个数是它左上方和右上方的数的和。
 *
 * 示例 1:
 * 输入: numRows = 5
 * 输出: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
 *
 * 示例 2:
 * 输入: numRows = 1
 * 输出: [[1]]
 *
 *
 * 提示:
 *
 * 1 <= numRows <= 30
 */
public class YHTriangle {

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            if (i == 0) {
                result.add(new ArrayList<>(List.of(1)));
            } else {
                List<Integer> lastRow = result.get(i - 1);
                List<Integer> newRow = new ArrayList<>();
                for (int j = 0; j < lastRow.size() + 1; j++) {
                    if (j == 0) {
                        newRow.add(1);
                    } else if (j == lastRow.size()) {
                        newRow.add(1);
                    } else {
                        newRow.add(lastRow.get(j) + lastRow.get(j-1));
                    }
                }
                result.add(newRow);
            }

        }

        return result;
    }

    public static void main(String[] args) {
        YHTriangle yhTriangle = new YHTriangle();

        System.out.println(yhTriangle.generate(5));
    }
}
