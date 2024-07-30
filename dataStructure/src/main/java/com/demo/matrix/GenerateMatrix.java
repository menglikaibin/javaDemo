package com.demo.matrix;

import java.util.Arrays;

/**
 * 59,螺旋矩阵2
 *
 * 给你一个正整数 n ，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。
 *
 * 示例 1：
 *
 *
 * 输入：n = 3
 * 输出：[[1,2,3],[8,9,4],[7,6,5]]
 * 示例 2：
 * 输入：n = 1
 * 输出：[[1]]
 * 提示：
 *
 * 1 <= n <= 20
 * Related Topics
 * 数组
 * 矩阵
 * 模拟
 */
public class GenerateMatrix {

    public int[][] generateMatrix(int n) {

        int top = 0;
        int bottom = n - 1;

        int left = 0;
        int right = n - 1;

        int[][] matrix = new int[n][n];

        int num = 1;
        while (num <= n * n) {
            for (int j = left; j <= right; j++) {
                matrix[top][j] = num ++;
            }
            top++;

            for (int j = top; j <= bottom; j++) {
                matrix[j][right] = num++;
            }
            right--;

            for (int i = right; i >= left; i--) {
                matrix[bottom][i] = num++;
            }
            bottom--;

            for (int i = bottom; i >= top; i--) {
                matrix[i][left] = num++;
            }
            left++;

        }

        return matrix;
    }

    public static void main(String[] args) {
        GenerateMatrix generateMatrix = new GenerateMatrix();
        System.out.println(Arrays.deepToString(generateMatrix.generateMatrix(3)));
    }

}
