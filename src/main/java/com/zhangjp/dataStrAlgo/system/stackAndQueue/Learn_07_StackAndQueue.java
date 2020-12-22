package com.zhangjp.dataStrAlgo.system.stackAndQueue;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Stack;

public class Learn_07_StackAndQueue {



    /**
     * @description:
     * 实现 FreqStack，模拟类似栈的数据结构的操作的一个类。
     * FreqStack 有两个函数：
     * push(int x)，将整数 x 推入栈中。
     * pop()，它移除并返回栈中出现最频繁的元素。
     * 如果最频繁的元素不只一个，则移除并返回最接近栈顶的元素。
     * 链接：https://leetcode-cn.com/leetbook/read/algorithm-and-interview-skills/xuclpm/
     *
     * @author: zhangjp
     * @date: 2020/12/17 10:09
     */
    static class FreqStack {
        Map<Integer, Integer> freq;
        Map<Integer, Stack<Integer>> group;
        int maxFreq;
        public FreqStack() {
            freq = new HashMap<>();
            group = new HashMap<>();
            maxFreq = 0;
        }

        public void push(int x) {
            int f = freq.getOrDefault(x, 0) + 1;
            freq.put(x, f);
            if (f > maxFreq){
                maxFreq = f;
            }
            group.computeIfAbsent(f, z-> new Stack<>()).push(x);
        }

        public int pop() {
            int x = group.get(maxFreq).pop();
            freq.put(x, freq.get(x) - 1);
            if (group.get(maxFreq).size() == 0){
                maxFreq--;
            }

            return x;
        }






    }


    public static void main(String[] args) {
        FreqStack freqStack = new FreqStack();
        freqStack.push(2);
        freqStack.push(2);
        freqStack.push(2);
        freqStack.push(2);
        freqStack.push(4);
        System.out.println("pop = " + freqStack.pop());
        System.out.println("pop = " + freqStack.pop());
        System.out.println("pop = " + freqStack.pop());
        System.out.println("pop = " + freqStack.pop());
        System.out.println("pop = " + freqStack.pop());

    }




}
