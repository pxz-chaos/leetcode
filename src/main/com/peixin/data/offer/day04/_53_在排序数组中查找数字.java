package com.peixin.data.offer.day04;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName _53_在排序数组中查找数字
 * @Author pxz_chaos
 * @Date 2022/7/14 10:24
 */
public class _53_在排序数组中查找数字 {

    /**
     * 哈希算法
     *
     * @param nums   给定一个数组
     * @param target 目标值
     * @return 目标值在数组中出现的次数
     */
    public int search(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>(10);
        for (int num : nums) {
            int value = 1;
            if (map.containsKey(num)) {
                value = map.get(num) + 1;
                map.put(num, value++);
            } else {
                map.put(num, 1);
            }

        }

        return map.containsKey(target) ? map.get(target) : 0;
    }

    /**
     * 二分查找
     * 因为是一个有序数组
     *
     * @param nums   给定一个数组
     * @param target 目标值
     * @return 目标值在数组中出现的次数
     */
    public int search1(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        int count = 0;
        //第一个while找到等于target的第一个数
        while (left < right) {
            int mid = left + ((right - left) >> 1);
            if (nums[mid] >= target) {
                right = mid;
            }
            if (nums[mid] < target) {
                left = mid + 1;
            }
        }

        //统计target的个数
        while (left < nums.length && nums[left++] == target) {
            count++;
        }
        return count;
    }

    @Test
    public void test() {
        int[] nums = {5, 7, 7, 8, 8, 8, 8, 10, 10};
        System.out.println(search1(nums, 1));
    }
}
