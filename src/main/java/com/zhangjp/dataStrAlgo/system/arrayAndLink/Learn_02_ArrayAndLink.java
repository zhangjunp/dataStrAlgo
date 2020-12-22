package com.zhangjp.dataStrAlgo.system.arrayAndLink;

public class Learn_02_ArrayAndLink {

    /**
     *25. K 个一组翻转链表
     *给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
     *k 是一个正整数，它的值小于或等于链表的长度。
     *如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
     *示例：
     *给你这个链表：1->2->3->4->5
     *当 k = 2 时，应当返回: 2->1->4->3->5
     *当 k = 3 时，应当返回: 3->2->1->4->5
     *说明：
     *你的算法只能使用常数的额外空间。
     *你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
     **/

    public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

    class Solution {
        // 1->2->3->4->5
        public ListNode reverseKGroup(ListNode head, int k) {
            //边界情况
            if (head == null || k == 1) {
                return head;
            }
            // 辅助指针
            ListNode fakeHead = new ListNode(0);
            fakeHead.next = head; //0->1->2->3->4->5
            ListNode prev = fakeHead;
            int count = 0;
            ListNode end = head;

            while(end!=null){
                count++;
                if (count%k != 0) {
                    end = end.next;
                    continue;
                }
                prev = reverseLinkedList(prev,end.next);
                end = prev.next;
            }
            return fakeHead.next;
        }

        ListNode reverseLinkedList(ListNode prev,ListNode next) {
            //0->1->2->3 prev0 next3
            ListNode last = prev.next; // 1->2->3
            ListNode cur = last.next; // 2->3
            while(cur != next){
                ListNode temp = cur.next;
                cur.next = prev.next;
                prev.next = temp;
                cur = temp;
            }
            return last;
        }




    }

}
