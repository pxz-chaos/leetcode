package com.peixin.data.offer.day03;

import org.junit.Test;

/**
 * @ClassName _05_替换空格
 * @Author pxz_chaos
 * @Date 2022/7/13 19:21
 */
public class _05_替换空格 {

    public String replaceSpace(String s) {

        return s.replace(" ", "%20");
    }

    @Test
    public void testReplaceAll() {
        String s = "We are happy.";
        System.out.println(replaceSpace(s));
    }
}
