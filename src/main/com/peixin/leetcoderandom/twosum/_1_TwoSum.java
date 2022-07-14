package com.peixin.leetcoderandom.twosum;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;

public class _1_TwoSum {

    //暴力法：线性查找
    //T:o(n^2)
    //S：o(1)
    public int[] twoSum(int[] nums, int target) {

        if (nums == null || nums.length == 0) return new int[0];

        int[] res = new int[2];
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (target == nums[i] + nums[j]) {
                    res[0] = i;
                    res[1] = j;
                }

            }
        }
        return res;
    }

    //进阶
    //哈希查找：
    //o(n)
    //S:o(n)
    public int[] twoSum2(int[] nums, int target) {
        if (nums == null || nums.length == 0) return new int[0];

        //数据预处理
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            //将元素和对应的索引放到map表中
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            //nums[i]为第一个数  x为第二个数
            int x = target - nums[i];

            if (map.containsKey(x)) {
                int index = map.get(x);
                //为了保证i和index 不是同一元素，因为同一个元素不能使用两次

                if (i != index) return new int[]{i, map.get(x)};
            }

        }

        return new int[0];
    }


    //进阶
    //哈希查找：
    //o(n)
    //S:o(n)
    public int[] twoSum3(int[] nums, int target) {
        if (nums == null || nums.length == 0) return new int[0];

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            //nums[i]为第一个数  x为第二个数
            int x = target - nums[i];

            if (map.containsKey(x)) {
                int index = map.get(x);
               return new int[]{i,index};
            }
            map.put(nums[i],i);

        }

        return new int[0];
    }
    @Test
    public void test() {

        int[] ints = twoSum(new int[]{2, 7, 11, 15}, 18);
        System.out.println(Arrays.toString(ints));
    }
}
