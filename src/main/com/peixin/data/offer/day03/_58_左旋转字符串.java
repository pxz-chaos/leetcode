package com.peixin.data.offer.day03;

import org.junit.Test;

/**
 * 字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。请定义一个函数实现字符串左旋转操作的功能。
 * 比如，输入字符串"abcdefg"和数字2，该函数将返回左旋转两位得到的结果"cdefgab"。
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/zuo-xuan-zhuan-zi-fu-chuan-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @ClassName _58_左旋转字符串
 * @Author pxa_chaos
 * @Date 2022/7/13 19:32
 */
public class _58_左旋转字符串 {
    public String reverseLeftWords(String s, int n) {

        String s1 = s.substring(0, n);
        String s2 = s.substring(n, s.length());
        return s2+s1;


    }

    @Test
    public void test() {
        String s="a";
        System.out.println(reverseLeftWords(s,1));
    }
}
