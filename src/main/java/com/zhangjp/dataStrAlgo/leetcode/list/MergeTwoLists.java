package com.zhangjp.dataStrAlgo.leetcode.list;

import com.zhangjp.dataStrAlgo.leetcode.ListNode;

/*
* 有序链表的合并
21. 合并两个有序链表
将两个升序链表合并为一个新的升序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。

示例：

输入：1->2->4, 1->3->4
输出：1->1->2->3->4->4
* */
public class MergeTwoLists {

    /*
    * 有序链表的合并
    *
    * */
    @SuppressWarnings("SuspiciousNameCombination")
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0); // 哑节点
        ListNode current = dummyHead; // 当前节点
        while(l1 != null && l2 != null){
            int x = l1.val, y = l2.val;
            if (x >= y) {
                current.next = new ListNode(y);
            } else {
                current.next = new ListNode(x);
            }
            current = current.next;
            if (x<y) l1=l1.next;
            if (x>=y) l2=l2.next;
        }
        current.next = (l1==null?l2:l1);
        return dummyHead.next;
    }
}
