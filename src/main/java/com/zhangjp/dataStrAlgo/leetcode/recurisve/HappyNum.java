package com.zhangjp.dataStrAlgo.leetcode.recurisve;

import java.util.HashSet;
import java.util.Set;

/*
202. 快乐数
编写一个算法来判断一个数 n 是不是快乐数。

「快乐数」定义为：对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和，然后重复这个过程直到这个数变为 1，也可能是 无限循环 但始终变不到 1。如果 可以变为  1，那么这个数就是快乐数。

如果 n 是快乐数就返回 True ；不是，则返回 False 。



示例：

输入：19
输出：true
解释：
12 + 92 = 82
82 + 22 = 68
62 + 82 = 100
12 + 02 + 02 = 1
* */
public class HappyNum {
    // 1.判断是快乐数好理解
    // 2.判断不是快乐数，需要分析，因为总不能无限循环下去，所以肯定有一定规律；比如
    // 5 -> 25 -> 29 -> 85 -> 89 -> 145-> 42-> 20 -> 4 -> 16 ->37 -> 58 -> 89
    // 说明如果非快乐数，它不是可以无限循环下去的，当遇见之前出现过的数，就可以判定这个数不是快乐数
    public static boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        set.add(n);
        return isHappyS(n,set);
    }

    public static boolean isHappyS(int n,Set<Integer> set){
        String s = String.valueOf(n);
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            Integer c = Integer.valueOf(String.valueOf(s.charAt(i)));
            sum += c*c;
        }
        System.out.println("sum = " + sum);
        if (set.contains(sum)) {
            return false;
        }else if (sum == 1) {
            return true;
        }else{
            set.add(sum);
        }
        return isHappyS(sum,set);
    }

    public static void main(String[] args) {
        boolean happy = isHappy(19);
    }
}
