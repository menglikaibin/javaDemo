package com.demo.matrix;

import java.util.ArrayList;
import java.util.List;

/**
 * 54、螺旋矩阵
 * 给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
 *
 * 示例 1：
 *
 *
 * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[1,2,3,6,9,8,7,4,5]
 * 示例 2：
 *
 *
 * 输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
 * 输出：[1,2,3,4,8,12,11,10,9,5,6,7]
 * 提示：
 *
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= m, n <= 10
 * -100 <= matrix[i][j] <= 100
 * Related Topics
 * 数组
 * 矩阵
 * 模拟
 */
public class SpiralOrder {

    public List<Integer> spiralOrder(int[][] matrix) {
        // 行
        int up = 0;
        int down  = matrix.length - 1;

        // 列
        int left = 0;
        int right = matrix[0].length - 1;

        List<Integer> result = new ArrayList<>();

        while (up <= down && left <= right) {
            for (int i = left; i <= right; i++) {
                result.add(matrix[up][i]);
            }
            up ++;

            for (int i = up; i <= down; i++) {
                result.add(matrix[i][right]);
            }
            right --;

            if (up <= down) {
                for (int i = right; i >= left; i--) {
                    result.add(matrix[down][i]);
                }
                down --;
            }

            if (left <= right) {
                for (int i = down; i >= up; i--) {
                    result.add(matrix[i][left]);
                }
                left ++;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        SpiralOrder spiralOrder = new SpiralOrder();
        List<Integer> result = spiralOrder.spiralOrder(matrix);
        System.out.println(result);  // Expected output: [1, 2, 3, 6, 9, 8, 7, 4, 5]
    }

}
