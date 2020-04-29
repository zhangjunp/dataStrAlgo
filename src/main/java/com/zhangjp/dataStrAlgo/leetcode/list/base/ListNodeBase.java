package com.zhangjp.dataStrAlgo.leetcode.list.base;

import com.zhangjp.dataStrAlgo.leetcode.ListNode;

import java.util.LinkedList;


public class ListNodeBase {

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1).setNext(new ListNode(2).setNext(new ListNode(3).setNext(new ListNode(4))));
        printListNode(listNode);
        System.out.println(" ======= ");
        printListNode(listReverse(listNode));
    }


    /*
    * 单向链表翻转
    * 1->2->3->4->null
    * 翻转后
    * 4->3->2->1->null
    * 在遍历列表时，将当前节点的 next 指针改为指向前一个元素。由于节点没有引用其上一个节点，因此必须事先存储其前一个元素。
    * 在更改引用之前，还需要另一个指针来存储下一个节点。不要忘记在最后返回新的头引用！
    * */
    public static ListNode listReverse(ListNode listNode){
        if (listNode == null || listNode.getNext() == null) {
            return listNode;
        }
        ListNode prev = null;
        ListNode curr = listNode;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }


    /*
    * 检查是否是回环
    * */
    public static boolean checkCircle(ListNode list) {
        if (list == null) return false;

        ListNode fast = list.next;
        ListNode slow = list;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (slow == fast) return true;
        }
        return false;
    }


    /*打印整个链表*/
    public static void printListNode(ListNode listNode){
        do {
            System.out.println(listNode.getVal());
            listNode = listNode.next;
        }while (listNode != null);
    }
}
