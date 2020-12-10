package com.zhangjp.dataStrAlgo.leetcode.array;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
* 3. 无重复字符的最长子串
给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。

示例 1:

输入: "abcabcbb"
输出: 3
解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
示例 2:

输入: "bbbbb"
输出: 1
解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
示例 3:

输入: "pwwkew"
输出: 3
解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
* */
public class LengthOfLongestSubstring {

    public static void main(String[] args) {
        int aab = lengthOfLongestSubstring("aab");
        System.out.println("aab = " + aab);
    }



    // 暴力解法
    public static int lengthOfLongestSubstringBak(String s) {
        int length = s.length();
        if (length < 2) {
            return length;
        }
        Set<Character> set;
        int maxL = -1;
        // 分别从下标0开始，计算以此下标开始最长的不重复子串
        for(int i= 0;i<length;i++){
            int j = i;
            set = new HashSet<>();
            // 当出现相同字符，停止（考虑遍历到最后一位的情况）
            while (j<length && !set.contains(s.charAt(j))) {
                set.add(s.charAt(j));
                j++;
            }
            // 比较上一次和该次遍历中最大值
            maxL = Math.max(maxL,set.size());
        }
        return maxL;
    }


    // 解题思路，暴力解法的时间复杂度太高
    // 借助滑动窗口的思路
    // 当遇见重复的时候,找到重复字符的下标，从该下标位置往后重新计算非重复子串的长度
    public static int lengthOfLongestSubstring(String s) {
        int length = s.length();
        if (length < 2) {
            return length;
        }
        Map<Character,Integer> map = new HashMap<>();// 字符：下标
        int start = 0;
        int maxL = -1;
        for(int i= 0;i<length;i++){
            Character currC = s.charAt(i);
            Integer cIndex = map.get(currC);
            // 更改start值得时机需要注意一下
            // 1.map中含有重复元素了 并且  再次开始的下标一定比上次大或等于
            // 2. 比如 abbac 第二次出现a时这种情况
            if (cIndex != null && cIndex>= start) {
                start = cIndex + 1;
            }
            map.put(currC,i);
            maxL = Math.max(maxL,(i - start+1));
        }
        return maxL;
    }
}
