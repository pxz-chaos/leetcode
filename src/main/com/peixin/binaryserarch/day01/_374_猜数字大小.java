package com.peixin.binaryserarch.day01;

/**
 * @ClassName _374_猜数字大小
 * @Author pxz_chaos
 * @Date 2022/7/14 16:01
 */
public class _374_猜数字大小 {
    public int guessNumber(int n) {
        int left = 1, right = n;

        // 循环直至区间左右端点相同
        while (left < right) {

            int mid = left + ((right - left) >> 1);
            if (guess(mid) <= 0) {
                // 答案在区间 [left, mid] 中
                right = mid;
            } else {
                // 答案在区间 [mid+1, right] 中
                left = mid + 1;
            }
        }
        // 此时有 left == right，区间缩为一个点，即为答案
        return left;

    }

    private int guess(int num) {

        return num;
    }
}



