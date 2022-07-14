package com.peixin.data.structure.day04;

import java.util.ArrayList;

/**
 * @ClassName _566_重塑矩阵
 * @Author pxz_chaos
 * @Date 2022/7/14 16:57
 */
public class _566_重塑矩阵 {
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        int m = mat.length;
        int n = mat[0].length;
        if (m * n != r * c) {
            return mat;
        }
        int[][] reshape = new int[r][c];

        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                list.add(mat[i][j]);
            }
        }


        for (int i = 1; i <= r; i++) {
            for (int j = 1; j <= c; j++) {
                reshape[i - 1][j - 1] = list.get(j + c * (i - 1) - 1);
            }
        }


        return reshape;
    }

    public int[][] matrixReshape1(int[][] nums, int r, int c) {
        int m = nums.length;
        int n = nums[0].length;
        if (m * n != r * c) {
            return nums;
        }

        int[][] ans = new int[r][c];
        for (int x = 0; x < m * n; ++x) {
            ans[x / c][x % c] = nums[x / n][x % n];
        }
        return ans;
    }

}
