package com.zhangjp.dataStrAlgo.system.stackAndQueue;

import java.util.Stack;

public class Learn_04_StackAndQueue {


//    https://leetcode-cn.com/problems/trapping-rain-water/
    /**
     * @description: 接雨水
     * @author: zhangjp
     * @date: 2020/12/17 09:54
     */
    public static void main(String[] args) {
        int[] ints = {4,1,2,5};
        System.out.println("trap(ints) = " + trap(ints));
    }

    public static int trap(int[] height) {
        int result =0;
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<height.length;i++){
            while(!stack.isEmpty() && height[i] > height[stack.peek()]){
                Integer pop = stack.pop();
                if (!stack.isEmpty()) {
                    int width = i -stack.peek() -1; // 宽度
                    int h = Math.min(height[i],height[stack.peek()]) - height[pop]; // 高度
                    result += width * h;
                }
            }
            stack.push(i);
        }
        return result;

    }

}
