package com.zhangjp.dataStrAlgo.leetcode.stack;

import java.util.*;

/*
* 20. 有效的括号
给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。

有效字符串需满足：

左括号必须用相同类型的右括号闭合。
左括号必须以正确的顺序闭合。
注意空字符串可被认为是有效字符串。

示例 1:

输入: "()"
输出: true
示例 2:

输入: "()[]{}"
输出: true
示例 3:

输入: "(]"
输出: false
示例 4:

输入: "([)]"
输出: false
示例 5:

输入: "{[]}"
输出: true
* */
public class Day07 {

    public static void main(String[] args) {
        String s = "()";
        boolean valid = isValid(s);
        System.out.println("valid = " + valid);
    }
    /*
    * 思路
    * 1.右括号肯定在左括号之后
    * 2.合理的字符串，其中左括号和右括号挨着的至少有一对
    * 3.利用栈结构，后进先出的结构，遍历字符串，左括号压入栈，遇见右括号取出栈顶元素是否是匹配的括号
    * 4.当遍历完后栈是空的说明是合法的字符串
    * */
    public static boolean isValid(String s) {
        if (null==s || s.isEmpty()) {
            return true;
        }
        Map<Character,Character> rightK = new HashMap<>();
        rightK.put('(',')');
        rightK.put('[',']');
        rightK.put('{','}');
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length() ; i++) {
            char c = s.charAt(i);
            if (rightK.get(c) != null) {
                stack.push(c);
            }else {
                if (stack.isEmpty()) {
                    return false;
                }
                Character pop = stack.pop();
                if (!rightK.get(pop).equals(c)) {
                    return false;
                }
            }

        }
        return stack.isEmpty();
    }
}
