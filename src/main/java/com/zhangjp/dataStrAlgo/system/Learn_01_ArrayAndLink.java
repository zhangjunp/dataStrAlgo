package com.zhangjp.dataStrAlgo.system;

import lombok.Data;

public class Learn_01_ArrayAndLink {

    @Data
    static
    class Node {
        Node next;
        int data;
        public Node(int d){
            data = d;
        }
        /**
         * @description: 单链表尾部添加节点
         * @author: zhangjp
         * @date: 2020/12/10 16:41
         */
        Node appendToTail(int d){
            Node end = new Node(d);
            Node n = this;
            while(n.next != null){
                n = n.next;
            }
            n.next = end;
            return this;
        }


        Node delete(int d){
            Node h = this;
            if (h.data == d) {
                return this.next.next;
            }
            while(h.next != null){
                if (h.next.data == d) {
                    h.next = h.next.next;
                    return this;
                }
                h = h.next;
            }
            return this;
        }
    }

    /**
     * @description: 删除单链表中的指定节点
     * @author: zhangjp
     * @date: 2020/12/10 16:53
     */
    static Node delete(Node head,int d){
        Node h = head;
        if (h.data == d) {
            return head.next.next;
        }
        while(h.next != null){
            if (h.next.data == d) {
                h.next = h.next.next;
                return head;
            }
            h = h.next;
        }
        return head;
    }

    static void printNode(Node node){
        while (node!=null) {
            System.out.print(node.data +"->");
            node = node.next;
        }
        System.out.print("null\n");
    }

    public static void main(String[] args) {
        Node node = new Node(1);
        node.appendToTail(2).appendToTail(3).appendToTail(4).appendToTail(5);
        printNode(node);
        node.delete(3);
        printNode(node);
    }




}
