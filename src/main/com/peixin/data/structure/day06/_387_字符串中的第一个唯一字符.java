package com.peixin.data.structure.day06;

import java.util.HashMap;
import java.util.LinkedHashMap;

/**
 * 给定一个字符串 s ，找到 它的第一个不重复的字符，并返回它的索引 。如果不存在，则返回 -1 。
 *
 * @ClassName _387_字符串中的第一个唯一字符
 * @Author pxz_chaos
 * @Date 2022/7/18 10:15
 */
public class _387_字符串中的第一个唯一字符 {
    public int firstUniqChar(String s) {

        HashMap<Character, Integer> map = new LinkedHashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        for (int i = 0; i < s.length(); i++) {
         if (map.get(s.charAt(i))==1){
             return i;
         }

        }
//        System.out.println(map);
        return -1;
    }
}
