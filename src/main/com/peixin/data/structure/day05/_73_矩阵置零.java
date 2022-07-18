package com.peixin.data.structure.day05;

import org.junit.Test;

import java.util.Stack;

/**
 * 给定一个 m x n 的矩阵，如果一个元素为 0 ，则将其所在行和列的所有元素都设为 0 。请使用 原地 算法。
 *
 * @ClassName _73_矩阵置零
 * @Author pxz_chaos
 * @Date 2022/7/15 14:49
 */
public class _73_矩阵置零 {

    public void setZeroes(int[][] matrix) {
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    //记录索引
                    stack1.push(i);
                    stack2.push(j);
                }
            }
        }

        while (!stack1.isEmpty() || !stack2.isEmpty()) {
            //列置0
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[stack1.peek()][j] = 0;
            }
            stack1.pop();
            //行置零
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][stack2.peek()] = 0;
            }
            stack2.pop();
        }

    }

    /**
     * 标记数组法
     *
     * @param matrix 给定一个矩阵
     */
    public void setZeroes1(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        boolean[] row = new boolean[m];
        boolean[] col = new boolean[n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[j][j] == 0) {
                    row[i] = col[j] = true;
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (row[i] || col[j]) {
                    matrix[i][j] = 0;
                }
            }
        }

    }

    @Test
    public void test() {
        int[][] matrix = {{0, 1, 2, 0}, {3, 4, 5, 2}, {1, 3, 1, 5}};
        setZeroes(matrix);
    }
}
