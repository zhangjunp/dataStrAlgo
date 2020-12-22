package com.zhangjp.dataStrAlgo.system.stackAndQueue;

import java.util.EmptyStackException;

public class Learn_01_StackAndQueue {

    public static void main(String[] args) {
        StackNode<Integer> stackNode = new StackNode<>(1);
        stackNode.push(2);
        stackNode.push(3);
        stackNode.push(4);
        while(!stackNode.isEmpty()) {
            System.out.println("stackNode: "+stackNode.pop());
        }

        System.out.println("\n");

        QueueNode<Integer> queueNode = new QueueNode<>(1);
        queueNode.push(2);
        queueNode.push(3);
        queueNode.push(4);

        while(!queueNode.isEmpty()){
            System.out.println("queueNode: " + queueNode.remove());
        }
    }


    // 栈 后进先出
    static class StackNode<T>{
        private T data;
        private StackNode<T> next;
        private StackNode<T> top;

        public StackNode(T item){
            this.data = item;
            top = this;
        }

        // 队列取出元素
        public T pop(){
            if (top == null) {
                throw new EmptyStackException();
            }
            T value = top.data;
            top = top.next;
            return value;
        }

        public void push(T item){
            StackNode<T> node = new StackNode<>(item);
            node.next = top;
            top = node;
        }

        public T peek(){
            if (top == null) {
                return null;
            }
            return top.data;
        }

        public boolean isEmpty(){
            return top == null;
        }
   }



   static class QueueNode<T> {
        private T data;
        private QueueNode<T> next;
        public QueueNode(T item){
            this.data = item;
            first = this;
            last = this;
        }

        private QueueNode<T> first;
        private QueueNode<T> last;

        public T remove(){
            if (first == null) {
                throw new NullPointerException();
            }
            T value = first.data;
            first = first.next;
            if (first == null) {
                last = null;
            }
            return value;
        }

        public T peek(){
            if (first == null) {
                return null;
            }
            return first.data;
        }

        public void push(T item){
            QueueNode<T> node = new QueueNode<>(item);
            if (last != null) {
                last.next = node;
            }
            last = node;
            if (first == null){
                first = last;
            }
        }

       public boolean isEmpty() {
            return last == null;
       }
   }

}
