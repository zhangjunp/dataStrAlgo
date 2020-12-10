package com.zhangjp.dataStrAlgo.leetcode.list;

import com.zhangjp.dataStrAlgo.leetcode.ListNode;
import com.zhangjp.dataStrAlgo.leetcode.list.base.ListNodeBase;
import org.omg.PortableInterceptor.INACTIVE;

import java.util.*;

/*
*92. 反转链表 II
反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。

说明:
1 ≤ m ≤ n ≤ 链表长度。

示例:

输入: 1->2->3->4->5->NULL, m = 2, n = 4
输出: 1->4->3->2->5->NULL
* */
public class ReverseBetween {

    public static void main(String[] args) {
        ListNode head = new ListNode(1)
                .setNext(new ListNode(2)
                        .setNext(new ListNode(3)
                                .setNext(new ListNode(4)
                                        .setNext(new ListNode(5)))));
        ListNode listNode = reverseBetween(head, 3, 4);
        ListNodeBase.printListNode(listNode);
    }

    // Java-双指针-头插法
    public static ListNode reverseBetween(ListNode head, int m, int n) {
        if (head==null || head.next == null) {
            return head;
        }

        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;

        ListNode g = dummyHead;
        ListNode p = dummyHead.next;

        int step = 0;
        while (step < m - 1) {
            g = g.next; p = p.next;
            step ++;
        }

        for (int i = 0; i < n - m; i++) {
            ListNode removed = p.next;
            p.next = p.next.next;
            removed.next = g.next;
            g.next = removed;
        }

        return dummyHead.next;
    }
}
