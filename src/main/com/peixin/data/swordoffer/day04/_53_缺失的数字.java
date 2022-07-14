package com.peixin.data.swordoffer.day04;

/**
 * 一个长度为n-1的递增排序数组中的所有数字都是唯一的，并且每个数字都在范围0～n-1之内。
 * 在范围0～n-1内的n个数字中有且只有一个数字不在该数组中，请找出这个数字。
 * <p>
 *  
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/que-shi-de-shu-zi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @ClassName _53_缺失的数字
 * @Author pxz_chaos
 * @Date 2022/7/14 16:28
 */
public class _53_缺失的数字 {
    /**
     * 暴力法
     *
     * @param nums 给定一个数组
     * @return 缺失的数字
     */
    public int missingNumber(int[] nums) {

        //考虑第一个元素
        if (nums[0] != 0) {
            return 0;
        }
        boolean flag = false;
        int res = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] + 1 == nums[i + 1]) {
                continue;
            }
            res = nums[i] + 1;
            flag = true;
        }
        //考虑最后一个元素
        if (flag) {
            return res;
        }
        return nums[nums.length - 1] + 1;
    }
}
