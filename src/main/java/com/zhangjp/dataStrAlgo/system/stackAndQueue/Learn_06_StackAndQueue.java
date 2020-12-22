package com.zhangjp.dataStrAlgo.system.stackAndQueue;

import java.util.LinkedList;

public class Learn_06_StackAndQueue {



    /**
     * @description: 滑动窗口最大值
     * @author: zhangjp
     * @date: 2020/12/17 10:09
     *
     * 【1，2，3，2，1，4，6，7，8，9】
     *
     *  k=3
     */
    public int[] max(int[] nums,int k){
        if (nums == null || nums.length ==0 ){
            return new int[0];
        }
        int[] result = new int[nums.length-k+1];
        LinkedList<Integer> deque = new LinkedList<Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (!deque.isEmpty() && deque.peekFirst()==i-k){
                deque.poll();
            }
            while(!deque.isEmpty() && nums[i] > nums[deque.peekLast()]){
                deque.removeLast();
            }
            deque.offer(i);
            if (i+1 >= k) {
                result[i+1-k] = nums[deque.peek()];
            }
        }
        return result;

    }
    // 【1，2，3，2，1，4，6，7，8，9】
    public int[] maxBL(int[] nums,int k){
        if (nums == null || nums.length ==0 ){
            return new int[0];
        }
        int[] result = new int[nums.length-k+1];

        for (int i = 0; i < nums.length -k; i++) {
            int curMax = Integer.MIN_VALUE;
            for(int j= i;j<i+k;j++){
                curMax = Math.max(curMax,nums[j]);
            }
            result[i] = curMax;
        }
        return result;
    }


}
