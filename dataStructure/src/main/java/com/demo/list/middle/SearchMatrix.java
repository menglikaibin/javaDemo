package com.demo.list.middle;

/**
 * 240,搜索二维矩阵
 *
 * 编写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target 。该矩阵具有以下特性：
 *
 * 每行的元素从左到右升序排列。
 * 每列的元素从上到下升序排列。
 * 示例 1：
 * 输入：matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]], target = 5
 * 输出：true
 *
 * 示例 2：
 * 输入：matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]], target = 20
 * 输出：false
 * 提示：
 *
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= n, m <= 300
 * -109 <= matrix[i][j] <= 109
 * 每行的所有元素从左到右升序排列
 * 每列的所有元素从上到下升序排列
 * -109 <= target <= 109
 * Related Topics
 * 数组
 * 二分查找
 * 分治
 * 矩阵
 */
public class SearchMatrix {

    public boolean searchMatrix(int[][] matrix, int target) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == target) {
                    return true;
                }
            }
        }

        return false;
    }

    public boolean searchMatrix2(int[][] matrix, int target) {
        int rows = matrix.length;
        int columns = matrix[0].length;

        int row = rows - 1;
        int column = 0;

        while (row >= 0 && column < columns) {
            if (matrix[row][column] == target) {
                return true;
            } else if (matrix[row][column] < target) {
                column ++;
            } else {
                row --;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        SearchMatrix searchMatrix = new SearchMatrix();

        int[][] ints = {{5, 6, 10, 14}, {6, 10, 13, 18}, {10, 13, 18, 19}};
        System.out.println(searchMatrix.searchMatrix(ints, 14));
    }

}
