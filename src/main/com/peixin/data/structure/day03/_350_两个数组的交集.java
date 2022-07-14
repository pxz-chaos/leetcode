package com.peixin.data.structure.day03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

/**
 * 给你两个整数数组 nums1 和 nums2 ，请你以数组形式返回两数组的交集。
 * 返回结果中每个元素出现的次数，应与元素在两个数组中都出现的次数一致（如果出现次数不一致，则考虑取较小值）。可以不考虑输出结果的顺序。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/intersection-of-two-arrays-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @ClassName _350_两个数组的交集
 * @Author pxz_chaos
 * @Date 2022/7/13 20:25
 */
public class _350_两个数组的交集 {
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        ArrayList<Integer> list = new ArrayList<>();


        for (int num : nums1) {
            stack1.push(num);
        }
        for (int num : nums2) {
            stack2.push(num);
        }


        while (!stack1.isEmpty() && !stack2.isEmpty()) {
            int n1 = stack1.peek(), n2 = stack2.peek();
            if (n1 == n2) {

                list.add(n1);
                stack1.pop();
                stack2.pop();
            } else if (n1 > n2) {
                stack1.pop();
            } else {
                stack2.pop();
            }
        }
        int[] nums = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            nums[i] = list.get(i);
        }
        return nums;
    }

    /**
     * 双指针+排序
     *
     * @param nums1 给定数组
     * @param nums2 数组2
     * @return 交集数组
     */
    public int[] intersect2(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int index1 = 0, index2 = 0, index = 0, l1 = nums1.length, l2 = nums2.length;

        int[] res = new int[Math.max(l1, l2)];
        while (index1 < l1 && index2 < l2) {
            if (nums1[index1] < nums2[index2]) {
                index1++;
            } else if (nums1[index1] > nums2[index2]) {
                index2++;
            } else {
                res[index++] = nums1[index1++];
                index2++;
            }
        }
        return Arrays.copyOfRange(res, 0, index);
    }


}
