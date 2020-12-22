package com.zhangjp.dataStrAlgo.system.stackAndQueue;

import java.util.PriorityQueue;

public class Learn_03_StackAndQueue {

    /**
     * @description: 中位数
     * @author: zhangjp
     * @date: 2020/12/17 09:50
     */
    public static void main(String[] args) {
        PriorityQueue<Integer> integers = new PriorityQueue<>();
        integers.add(1);
        integers.add(2);
        Integer peek = integers.peek();
        System.out.println("peek = " + peek);
        PriorityQueue<Integer> maxQueue = new PriorityQueue<>((a,b)->b-a);
        maxQueue.add(1);
        maxQueue.add(2);
        System.out.println("maxQueue = " + maxQueue.peek());

    }

    //优先队列
    class MedianFinder{
        PriorityQueue<Integer> maxQueue;
        PriorityQueue<Integer> minQueue;

        public MedianFinder(){
            maxQueue = new PriorityQueue<>((a,b)->b-a);
            minQueue = new PriorityQueue<>();
        }

        public void addNum(int num) {
            maxQueue.add(num);
            minQueue.add(maxQueue.poll());
            if (maxQueue.size() < minQueue.size()) {
                maxQueue.add(minQueue.poll());
            }
        }

        public double findMedian() {
            if (maxQueue.size() == minQueue.size()) {
                return (maxQueue.peek() + minQueue.peek()) * 0.5;
            }
            return maxQueue.peek();
        }

    }


}
