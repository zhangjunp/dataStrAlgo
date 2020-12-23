package com.zhangjp.dataStrAlgo.system.stackAndQueue;

import java.util.Arrays;
import java.util.Stack;

public class Learn_02_StackAndQueue {

    /**
     * @description: 数组中矩形面积
     * @author: zhangjp
     * @date: 2020/12/17 09:51
     */
    public static void main(String[] args) {
        int[] ints = {2,1,5,6,2,3};
        int i = largestRectangleArea(ints);
        System.out.println("i = " + i);

        int i1 = largestArea(ints);
        System.out.println("i1 = " + i1);


    }

    public static int largestRectangleArea(int[] heights) {
        // 矩形面积为 高 *宽
        // 以数组中数值为高度，只要求得每个高度对应的宽度，就是所有矩形的面积
        // 重点在于求每一个矩形的宽度，宽度为： 右边第一个比自己小的位置 - 左边第一个比自己小的位置 = 当前矩形的宽度
        if (null == heights || heights.length == 0){
            return 0;
        }
        int result = 0;
        for(int i=0;i<heights.length;i++){
            int left = i;
            int right = i;
            // 找左边第一个比自己小的位置
            while(left>-1 && heights[left] >= heights[i]){
                left = left-1;
            }
            // 找右边第一个比自己小的位置
            while(right< heights.length && heights[right] >= heights[i] ){
                right = right+1;
            }
            int tmp = (right-left-1)*heights[i] ;
            result = Math.max(tmp,result);
        }
        return result;
    }


    /**
     * @description: 借用栈，单调栈来解决此问题
     * @author: zhangjp
     * @date: 2020/12/15 10:58
     */
    public static int largestArea(int[] heights){
        if (null == heights || heights.length == 0){
            return 0;
        }
        Stack<Integer> stack = new Stack<>();
        int l = heights.length;
        int result = 0;
        for (int i = 0; i <=l ; i++) {
            int cur = i ==l?-1:heights[i];
            //  2 1 5 6 2 3
            while(!stack.isEmpty() && cur <= heights[stack.peek()]){
                int height = heights[stack.pop()];
                int left = stack.isEmpty()?0:(stack.peek() + 1);
                int right = i-1;
                int area = height * (right - left +1);
                result = Math.max(area,result);
            }
            stack.push(i);
        }
        return result;
    }
}
