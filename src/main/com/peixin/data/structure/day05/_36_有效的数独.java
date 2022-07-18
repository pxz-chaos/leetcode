package com.peixin.data.structure.day05;

import java.awt.image.RasterOp;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * //TODO
 *
 * @ClassName _36_有效的数独
 * @Author pxz_chaos
 * @Date 2022/7/15 10:15
 */
public class _36_有效的数独 {
    /**
     * 思路：搞3个map 分别代表行row 列 column 块 area，9个set，
     * row/column/area：key 0-9 索引 value：代表9个set
     */
    public boolean isValidSudoku(char[][] board) {
        Map<Integer, Set<Integer>> row = new HashMap<>();
        Map<Integer, Set<Integer>> column = new HashMap<>();
        Map<Integer, Set<Integer>> area = new HashMap<>();

        for (int i = 0; i < board.length; i++) {
            row.put(i, new HashSet<>());
            column.put(i, new HashSet<>());
            area.put(i, new HashSet<>());
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                char c = board[i][j];
                if (c == '.') {
                    continue;
                }

                //将字符转化为数字
                int u = c - '0';


                /*
                判断位于那一块区域中 k=0~8
                当0<=i<=2时，k=j/3
                当3<=i<=5时，k=j/3+3
                当6<=i<=8时，k=j/3+6
                所以k = i / 3 * 3 + j / 3;
                 */
                int k = i / 3 * 3 + j / 3;

                //查重
                if (row.get(i).contains(u) || column.get(j).contains(u) || area.get(k).contains(u)) {
                    return false;
                }
                row.get(i).add(u);
                column.get(j).add(u);
                area.get(k).add(u);

            }
        }

        return true;
    }


}
