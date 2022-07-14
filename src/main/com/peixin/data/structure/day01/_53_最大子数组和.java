package com.peixin.data.structure.day01;

import org.junit.Test;

/*
给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。

子数组 是数组中的一个连续部分。

 

示例 1：

输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
输出：6
解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
示例 2：

输入：nums = [1]
输出：1
示例 3：

输入：nums = [5,4,-1,7,8]
输出：23

来源：力扣（LeetCode）
链接：https://leetcode.cn/problems/maximum-subarray
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _53_最大子数组和 {

    /*
    采用动态规划
    1：列出函数：我们用 f(i)代表以第 i 个数结尾的「连续子数组的最大和」，那么很显然我们要求的答案就是：
        max{f(i)}
     2：找到状态转移函数
     那么我们如何求 f(i)呢？我们可以考虑nums[i]单独成为一段还是加入 f(i-1)对应的那一段
     ，这取决于f(i-1)+nums[i]和nums[i]的大小，

     f(i)=max{f(i-1)+nums[i],nums[i]}


     动规五部曲如下：
        1.确定dp数组（dp table）以及下标的含义
        dp[i]：包括下标i之前的最大连续子序列和为dp[i]。

        2.确定递推公式
        dp[i]只有两个方向可以推出来：
        dp[i - 1] + nums[i]，即：nums[i]加入当前连续子序列和nums[i]，即：从头开始计算当前连续子序列和
一定是取最大的，所以dp[i] = max(dp[i - 1] + nums[i], nums[i]);

        3.dp数组如何初始化
        从递推公式可以看出来dp[i]是依赖于dp[i - 1]的状态，dp[0]就是递推公式的基础。
        dp[0]应该是多少呢?更具dp[i]的定义，很明显dp[0]因为为nums[0]即dp[0] = nums[0]。

        4.确定遍历顺序
        递推公式中dp[i]依赖于dp[i - 1]的状态，需要从前向后遍历。

        举例推导dp数组
        以示例一为例，输入：nums = [-2,1,-3,4,-1,2,1,-5,4]，对应的dp状态如下： !53.最大子序和（动态规划）
        注意最后的结果可不是dp[nums.size() - 1]！ ，而是dp[6]。

        在回顾一下dp[i]的定义：包括下标i之前的最大连续子序列和为dp[i]。

        那么我们要找最大的连续子序列，就应该找每一个i为终点的连续最大子序列。

        所以在递推公式的时候，可以直接选出最大的dp[i]。

        以上动规五部曲分析完毕，完整代码如下：
     */
    public int maxSubArray(int[] nums) {

        int[] dp = new int[nums.length];

        //设置初始值
        dp[0] = nums[0];
        int maxSum = nums[0];


        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            maxSum = maxSum > dp[i] ? maxSum : dp[i];
        }
        return maxSum;
    }

    @Test
    public void test() {
        int nums[] = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(maxSubArray(nums));
    }
}
