package com.zhangjp.dataStrAlgo.leetcode;


public class ListNode {
    public ListNode(int x) { val = x; }
    public int val;
    public ListNode next;
    public int getVal() {
        return val;
    }

    public ListNode getNext() {
        return next;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public ListNode setNext(ListNode next) {
        this.next = next;
        return this;
    }
}

