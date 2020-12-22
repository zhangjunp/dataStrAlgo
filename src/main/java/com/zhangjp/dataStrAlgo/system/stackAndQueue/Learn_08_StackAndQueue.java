package com.zhangjp.dataStrAlgo.system.stackAndQueue;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Stack;

public class Learn_08_StackAndQueue {




        /**
         * @description:
         * 设计你的循环队列实现。 循环队列是一种线性数据结构，其操作表现基于 FIFO（先进先出）原则并且队尾被连接在队首之后以形成一个循环。它也被称为“环形缓冲器”。
         *
         * 循环队列的一个好处是我们可以利用这个队列之前用过的空间。在一个普通队列里，一旦一个队列满了，我们就不能插入下一个元素，即使在队列前面仍有空间。
         * 但是使用循环队列，我们能使用这些空间去存储新的值。
         *
         * 你的实现应该支持如下操作：
         *
         * MyCircularQueue(k): 构造器，设置队列长度为 k 。
         * Front: 从队首获取元素。如果队列为空，返回 -1 。
         * Rear: 获取队尾元素。如果队列为空，返回 -1 。
         * enQueue(value): 向循环队列插入一个元素。如果成功插入则返回真。
         * deQueue(): 从循环队列中删除一个元素。如果成功删除则返回真。
         * isEmpty(): 检查循环队列是否为空。
         * isFull(): 检查循环队列是否已满。
         *
         * 链接：https://leetcode-cn.com/leetbook/read/algorithm-and-interview-skills/xujne7/
         *
         * @author: zhangjp
         * @date: 2020/12/17 14:04
         *
         *
         *  FIFO（先进先出）
         */

    public static void main(String[] args) {
        LinkedNode<Integer> node = new LinkedNode<>();
        node.add(1);
        node.add(2);
        node.add(3);
        System.out.println(node.pop());
        System.out.println(node.popLast());
        System.out.println(node.pop());

    }


    class MyCircularQueue {

        int count = 0;
        int cap;
        LinkedNode<Integer> node;


        public MyCircularQueue(int k) {
            this.cap = k;
            node = new LinkedNode<Integer>();
        }

        public boolean enQueue(int value) {
            if (count<cap) {
                node.add(value);
                count++;
                return true;
            }
            return false;
        }

        public boolean deQueue() {
            if (count>0) {
                node.popLast();
                count--;
                return true;
            }
            return false;
        }

        // 只返回不删除
        public int Front() {
            if (count == 0){
                return -1;
            }
            return node.peekLast();
        }

        // 只返回不删除
        public int Rear() {
            if (count == 0){
                return -1;
            }
            return node.peekHead();
        }

        public boolean isEmpty() {
            return count == 0;
        }

        public boolean isFull() {
            return count == cap;

        }

    }


    static class LinkedNode<T>{
        LinkedNode<T> prev;
        LinkedNode<T> next;
        T data;


        LinkedNode<T> head;
        LinkedNode<T> last;
        public LinkedNode(){
        }
        public LinkedNode(T item){
            data = item;
        }
        // 从头部添加元素
        public void add(T item){
            LinkedNode<T> node = new LinkedNode<>(item);
            node.prev =null;
            if (head ==null) {
                head = node;
                last = head;
            }else{
                head.prev = node;
                node.next = head;
                head = node;
            }
        }

        public T pop(){
            if(head == null){
                return null;
            }
            T data = head.data;
            if (head.next != null) {
                head = head.next;
                head.prev = null;
            }else{
                head = null;
                last = null;
            }
            return data;
        }

        public T peekHead(){
            if(head == null){
                return null;
            }
            return head.data;
        }

        public T popLast(){
            if(last == null){
                return null;
            }
            T data = last.data;
            if (last.prev !=null) {
                last = last.prev;
                last.next = null;
            }else {
                last = null;
                head = null;
            }
            return data;
        }

        public T peekLast(){
            if(last == null){
                return null;
            }
            return last.data;
        }
    }



}
