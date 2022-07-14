package com.peixin.data.structure.day01;

import org.junit.Test;

import java.util.HashSet;

public class _217_ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        if (nums == null || nums.length == 0) return false;
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) return true;
            set.add(nums[i]);
        }

        return false;
    }

    @Test
    public void test() {
        int nums[] = {1, 2, 3, 4};
        System.out.println(containsDuplicate(nums));
    }
}
