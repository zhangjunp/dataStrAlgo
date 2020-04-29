package com.zhangjp.dataStrAlgo.leetcode.list;

import com.zhangjp.dataStrAlgo.leetcode.ListNode;
import com.zhangjp.dataStrAlgo.leetcode.list.base.ListNodeBase;

/*
82. 删除排序链表中的重复元素 II
给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中 没有重复出现 的数字。

示例 1:

输入: 1->2->3->3->4->4->5
输出: 1->2->5
示例 2:

输入: 1->1->1->2->3
输出: 2->3
*
* */
public class DeleteDuplicates2 {


    public static void main(String[] args) {
        ListNode head = new ListNode(1)
                .setNext(new ListNode(2)
                        .setNext(new ListNode(3)
                                .setNext(new ListNode(3)
                                        .setNext(new ListNode(4)
                                        .setNext(new ListNode(4)
                                        .setNext(new ListNode(5)))))));
        head = new ListNode(1)
                .setNext(new ListNode(1)
                        .setNext(new ListNode(1)
                                .setNext(new ListNode(2)
                                        .setNext(new ListNode(3)))));

        // ListNodeBase.printListNode(head);
        ListNode listNode = deleteDuplicates(head);
        ListNodeBase.printListNode(listNode);

    }

    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        ListNode lastNode = dummy; // 声明lastNode方便构建新的list
        // 排序链表这个需要注意一下，说明如果重复则，两个相邻节点肯定是重复的
        while(head != null && head.next != null){
            int currVal = head.val;
            int nexVal = head.next.val;
            // 如果当前节点和下一个节点重复,则找到下一个不重复的点开始
            if (currVal == nexVal ) {
                while (head != null && head.val == currVal){
                    head = head.next;
                }
            }else{
                lastNode.next = new ListNode(currVal);
                head = head.next;
                lastNode = lastNode.next;
            }
        }
        // 最后一个节点不要忘记处理
        if (head != null) {
            lastNode.next = new ListNode(head.val);
        }
        return dummy.next;
    }
}
