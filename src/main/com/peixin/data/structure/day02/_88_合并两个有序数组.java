package com.peixin.data.structure.day02;

import junit.framework.TestCase;
import org.junit.Test;

import java.util.Arrays;

@SuppressWarnings("unused")
public class _88_合并两个有序数组{

    //直接法
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        System.arraycopy(nums2, 0, nums1, m, n);
        Arrays.sort(nums1);

    }

    //双指针
    public void merge1(int[] nums1, int m, int[] nums2, int n) {
        int p1 = 0, p2 = 0;
        int cur = 0;
        int[] copy = new int[m + n];
        while (p1 < m || p2 < n) {

            if (p1 == m) {
                copy[cur++] = nums2[p2++];
            }
           else if (p2 == n) {
                copy[cur++] = nums1[p1++];
            }
            else if (p1 < m && p2 < n) {
                if (nums1[p1] <= nums2[p2]) {
                    copy[cur++] = nums1[p1++];

                } else {
                    copy[cur++] = nums2[p2++];

                }
            }

        }

        int i = 0;
        while (i != m + n) {
            nums1[i] = copy[i];
            ++i;
        }
        System.out.println(Arrays.toString(copy));

    }

   @Test
    public void test() {
        int[] nums1 = {1, 2, 3};
        int[] nums2 = {2, 5, 6};
        merge1(nums1, 3, nums2, 3);
    }

}
