package com.zhangjp.dataStrAlgo.leetcode.list;


import com.zhangjp.dataStrAlgo.leetcode.ListNode;
import com.zhangjp.dataStrAlgo.leetcode.list.base.ListNodeBase;

/*
* 24. 两两交换链表中的节点
给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。

你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。

示例:

给定 1->2->3->4, 你应该返回 2->1->4->3.
* */
public class SwapPairs {


    /*
    * 假设只有 1->2 ->3 ->4 两个节点
    *
    * 0->2->1
    * */
    public static ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prevNode = dummy;
        while ((head != null) && (head.next != null)) {
            // Nodes to be swapped
            ListNode firstNode = head; // 1234
            ListNode secondNode = head.next; //234

            // Swapping
            prevNode.next = secondNode; // 0 2 3 4
            firstNode.next = secondNode.next; // 1 3 4
            secondNode.next = firstNode; // 2 1 3 4

            // Reinitializing the head and prevNode for next swap
            prevNode = firstNode;
            head = firstNode.next; // jump 34
        }
        // Return the new head node.
        return dummy.next;
    }



    public static void main(String[] args) {
        ListNode listNode = new ListNode(1).setNext(new ListNode(2).setNext(new ListNode(3).setNext(new ListNode(4))));
        ListNode listNode1 = swapPairs(listNode);
        ListNodeBase.printListNode(listNode1);
    }



}
