package com.zhangjp.dataStrAlgo.leetcode.string;

import java.util.*;

public class LengthOfLongestSubstring {

    public static void main(String[] args) {
        //"pwwkew"
        // System.out.println("子串长度 = " + lengthOfLongestSubstring("abcabcbb"));;
        System.out.println("子串长度 = " + lengthOfLongestSubstring("anviaj"));;
    }


    /*
     * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
     * 输入: "pwwkew"
     * 输出: 3
     * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
     *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public static int lengthOfLongestSubstring(String s) {
        assert s != null;
        if (s.length()<=1) {
            return s.length();
        }
        char[] chars = s.toCharArray();
        Set<Object> tmp = new HashSet<>();
        Set<Object> currentTmp = new HashSet<>();
        for (int i = 0; i < chars.length; i++) {
            if (!tmp.contains(chars[i]) && currentTmp.size()==0) {
                tmp.add(chars[i]);
            }else {
                if (currentTmp.size() == 0 && chars[i-1] != chars[i]) {
                    currentTmp.add(chars[i-1]);
                }
                currentTmp.add(chars[i]);
            }
            if (currentTmp.size() >= tmp.size()) {
                tmp = currentTmp;
                currentTmp = new HashSet<>();
            }
        }
        return tmp.size();
    }

}
