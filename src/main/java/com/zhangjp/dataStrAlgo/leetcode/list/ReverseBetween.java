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
        ListNode listNode = reverseBetween(head, 2, 4);
        // ListNodeBase.printListNode(listNode);
    }

    //    todo  没有解出来
    public static ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dummy = new ListNode(-1);
        ListNode lastNodeR = new ListNode(-1);
        ListNode reverseNode = lastNodeR;
        ListNode lastNode = dummy;
        ListNode curr = head;
        int i = 1;
        while (curr != null) {
            if (m <= i && i <= n) {
                // 需要翻转的部分
                ListNode next = curr.next;
                curr.next = reverseNode;
                reverseNode = curr;
                curr = next;
                i++;
                continue;
            } else if (i<m) {
                // 需要翻转前的那部分
                lastNode.next = new ListNode(curr.val);
                lastNode = lastNode.next;
            }else {
                // 需要翻转后的那部分
                lastNodeR.setVal(curr.val);
                lastNodeR.next = curr.next;
                break;
            }
            curr = curr.next;
            i++;
        }
        lastNode.next = reverseNode;
        return dummy.next;
    }
}
