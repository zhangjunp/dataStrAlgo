package com.zhangjp.dataStrAlgo.system.stackAndQueue;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Stack;

public class Learn_05_StackAndQueue {



    public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    /**
     * @description: 合并有序链表
     * @author: zhangjp
     * @date: 2020/12/16 14:33
     * 借助优先队列实现
     */
    public ListNode mergeKLists(ListNode[] lists) {
        // 合并有序链表
        // 边界情况处理
        if (lists == null || lists.length == 0) {
            return null;
        }
        PriorityQueue<ListNode> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o.val));
        ListNode fakeHead = new ListNode(0);
        ListNode p = fakeHead;
        for (ListNode item:lists) {
            if (item != null) {
                queue.add(item);
            }
        }
        while(!queue.isEmpty()){
            ListNode poll = queue.poll();
            p.next = poll;
            p = p.next;
            if (poll.next != null) {
                queue.offer(poll.next);
            }
        }
        return fakeHead.next;

    }
}
