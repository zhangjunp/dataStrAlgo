package com.zhangjp.dataStrAlgo.leetcode.string;
/*
* 680. 验证回文字符串 Ⅱ
给定一个非空字符串 s，最多删除一个字符。判断是否能成为回文字符串。

示例 1:

输入: "aba"
输出: True
示例 2:

输入: "abca"
输出: True
解释: 你可以删除c字符。
注意:

字符串只包含从 a-z 的小写字母。字符串的最大长度是50000。
* */
public class ValidPalindrome {

    public static void main(String[] args) {
        String s = "eabccba";
        System.out.println(validPalindrome(s));

        int[] nums = {100,1,2,3,4};
        int i = subarraySum(nums, 6);
        System.out.println("i = " + i);
    }


    public static  int subarraySum(int[] nums, int k) {
        if (nums == null || nums.length <1) {
            return 0;
        }
        int count = 0;
        for(int i=0;i<nums.length;i++){
            int sum = 0;
            if (nums[i] == k) {
                count++;
                continue;
            }
            if (nums[i] > k) {
                continue;
            }
            for(int j = i;j<nums.length;j++){
                sum += nums[j];
                if (sum == k){
                    count++;
                    break;
                }
                if (sum > k) {
                    break;
                }
            }
        }
        return count;

    }

    public static  boolean validPalindrome(String s) {
        if (s == null || s.length()==0) {
            return false;
        }
        boolean flag = false;
        int start = 0;
        int end = s.length()-1;
        while(start<=end){
            boolean ifEqual = s.charAt(start) == s.charAt(end);
            if (!flag && !ifEqual) {
                flag = true;

                if (s.charAt(start +1) == s.charAt(end)) {
                    start = start + 1;
                    start++;
                    end--;
                    continue;
                }

                if (s.charAt(start) == s.charAt(end-1)) {
                    end = end - 1;
                    start++;
                    end--;
                    continue;
                }
                continue;
            }
            // 已经有过一次不一致
            if (flag && !ifEqual) {
                return false;
            }
            start++;
            end--;
        }

        return true;
    }
}
