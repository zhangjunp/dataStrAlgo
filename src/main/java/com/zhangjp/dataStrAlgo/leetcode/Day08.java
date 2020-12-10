package com.zhangjp.dataStrAlgo.leetcode;

import java.util.HashMap;
import java.util.Map;

/*
242. 有效的字母异位词
给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
示例 1:
输入: s = "anagram", t = "nagaram"
输出: true
示例 2:
输入: s = "rat", t = "car"
输出: false
说明:
你可以假设字符串只包含小写字母。
进阶:
如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？
* */
public class Day08 {

    public static void main(String[] args) {
        String s1 = "a";
        String s2 = "b";
        System.out.println(isAnagram(s1,s2));
    }

    /*
    *
    * 1.利用数组，声明26长度数组，用来存放a-z
    * 2.遍历两个字符串，一个执行+ 一个执行- 最后判断字符串是否wei
 * */
    public static boolean isAnagram(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        if (s == null && t == null) {
            return true;
        }
        if (s == null || t == null) {
            return false;
        }
        if (s.length() != t.length()) {
            return false;
        }
        for (int i = 0; i <s.length() ; i++) {
            char c = s.charAt(i);
            map.merge(c, 1, Integer::sum);
        }
        for (int i = 0; i <t.length() ; i++) {
            char c = t.charAt(i);
            Integer count = map.get(c);
            if (count == null) {
                return false;
            }
            int i1 = count - 1;
            if (i1 == 0) {
                map.remove(c);
            }else {
                map.put(c,i1);
            }
        }
        return map.isEmpty();
    }
}
