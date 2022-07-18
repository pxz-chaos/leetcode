package com.peixin.data.swordoffer.day05;

import org.junit.Test;

/**
 * 在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个高效的函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/er-wei-shu-zu-zhong-de-cha-zhao-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @ClassName _04_二维数组中的查找
 * @Author pxz_chaos
 * @Date 2022/7/15 15:43
 */
public class _04_二维数组中的查找 {
    /**
     * 二分法
     * 时间复杂度nlog(m)
     *
     * @param matrix 给定一个矩阵
     * @param target 需要查找的元素
     * @return 是否有target这个元素
     */
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        //考虑边界条件
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        //矩阵中至少有一个元素
        int m = matrix.length, n = matrix[0].length;

        //双指针
        int leftCol = 0, rightCol = n - 1;

        for (int i = 0; i < m; i++) {
            while (leftCol < rightCol) {
                int mid = leftCol + ((rightCol - leftCol) >> 1);
                if (matrix[i][mid] >= target) {
                    rightCol = mid;
                } else {
                    leftCol = mid + 1;
                }
            }
            //退出while循环后
            if (target == matrix[i][leftCol]) {
                return true;
            }
            //将重置到原来的位置
            leftCol = 0;
            rightCol = n - 1;

        }


        return false;
    }

    @Test
    public void test() {
        int[][] matrix = {
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };
        findNumberIn2DArray(matrix, 5);

    }
}