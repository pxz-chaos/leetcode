package com.peixin.data.structure.day04;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName _117_杨辉三角
 * @Author pxz_chaos
 * @Date 2022/7/15 9:35
 */
public class _117_杨辉三角 {
    public List<List<Integer>> generate(int numRows) {

        int[][] dp = new int[numRows][numRows];
        //初始化
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = 1;

        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp.length; j++) {
                //转移矩阵
                dp[i][j] = dp[i - 1][j] + dp[i - 1][j - 1];
            }
        }

        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            //每次打印完一行就new一个list
            ArrayList<Integer> list = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                list.add(dp[i][j]);
            }
            res.add(list);
        }

        return res;
    }

    @Test
    public void test() {
        System.out.println(generate(30));
    }
}
