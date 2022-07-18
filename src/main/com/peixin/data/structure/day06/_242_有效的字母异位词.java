package com.peixin.data.structure.day06;

import org.junit.Test;

import java.util.Arrays;

/**
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 * <p>
 * 注意：若 s 和 t 中每个字符出现的次数都相同，则称 s 和 t 互为字母异位词。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/valid-anagram
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @ClassName _242_有效的字母异位词
 * @Author pxz_chaos
 * @Date 2022/7/18 14:57
 */
public class _242_有效的字母异位词 {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        int[] letter = new int[26];
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            letter[ch - 'a']++;
        }

        for (int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            letter[ch - 'a']--;
        }

        for (int i = 0; i < letter.length; i++) {
            if (letter[i] != 0) {
                return false;
            }
        }
        return true;
    }

    public boolean isAnagram1(String s, String t) {
        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();

        Arrays.sort(sArr);
        Arrays.sort(tArr);

        return Arrays.equals(sArr,tArr);

    }

    @Test
    public void test() {
        String s = "anadgram", t = "nagaram";
        System.out.println(isAnagram(s, t));
        ;
    }

}
