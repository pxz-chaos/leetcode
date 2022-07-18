package com.peixin.data.swordoffer.day05;

import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。 s 只包含小写字母。
 *
 * @ClassName _50_第一个只出现一次的字符
 * @Author pxz_chaos
 * @Date 2022/7/15 17:08
 */
public class _50_第一个只出现一次的字符 {


    public char firstUniqChar(String s) {
        if (s.length() == 0) {
            return ' ';
        }
        HashMap<Character, Integer> map = new LinkedHashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int value = 1;
            if (map.containsKey(c)) {
                value = map.get(c);
                map.put(c, value++);
            }
            map.put(c, value);
        }
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }

        return ' ';

    }

    public char firstUniqChar1(String s) {

        Map<Character, Integer> frequency = new HashMap<Character, Integer>();
        for (int i = 0; i < s.length(); ++i) {
            char ch = s.charAt(i);
            frequency.put(ch, frequency.getOrDefault(ch, 0) + 1);
        }
        System.out.println(frequency);
        for (int i = 0; i < s.length(); ++i) {
            if (frequency.get(s.charAt(i)) == 1) {
                return s.charAt(i);
            }
        }
        return ' ';
    }

    @Test
    public void test() {
        firstUniqChar1("aaabccce");
    }

    public static void main(String[] args) {
        HashMap<Character, Integer> map = new HashMap<>();

        String s="aaascsdds";
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);
        }
        System.out.println(map);
    }

}
