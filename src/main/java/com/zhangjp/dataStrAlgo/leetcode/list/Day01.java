package com.zhangjp.dataStrAlgo.leetcode.list;




/*
给你两个 非空 链表来代表两个非负整数。数字最高位位于链表开始位置。它们的每个节点只存储一位数字。将这两数相加会返回一个新的链表。
你可以假设除了数字 0 之外，这两个数字都不会以零开头。

进阶：
如果输入链表不能修改该如何处理？换句话说，你不能对列表中的节点进行翻转。

示例：
输入：(7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
输出：7 -> 8 -> 0 -> 7
来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/add-two-numbers-ii
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
*/
import com.zhangjp.dataStrAlgo.leetcode.ListNode;

import java.util.Stack;
public class Day01 {

    public static ListNode addTwoNumbers(ListNode L1, ListNode L2) {
        /*
         * 思路
         *  1.遍历连表，放到栈中（先进后出）
         *  2.遍历两个栈进行相加组装新的链表
         * */
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();
        ListNode listNode = null;

        do {
            s1.push(L1.getVal());
            L1 = L1.next;
        }while (L1 != null);

        do {
            s2.push(L2.getVal());
            L2 = L2.next;
        }while (L2 != null);
        // 获取两个栈中最大的值进行遍历
        int maxLength = Math.max(s1.size(), s2.size());
        Integer nextI = 0;
        for (int i = 0; i < maxLength ; i++) {
            Integer pop1 = 0;
            Integer pop2 = 0;
            if (!s1.isEmpty()) {
                pop1 = s1.pop();
            }
            if (!s2.isEmpty()) {
                pop2 = s2.pop();
            }
            int i1 = pop1 + pop2 + nextI;
            if (i1 >=10 ) {
                i1 = i1 -10;
                nextI = 1;
            }else {
                nextI = 0;
            }
            ListNode currentNode = new ListNode(i1);
            currentNode.next = listNode;
            listNode = currentNode;
        }
        return listNode;
    }

    public static void main(String[] args) {
        ListNode L1 = new ListNode(7).setNext(new ListNode(2).setNext(new ListNode(4).setNext(new ListNode(3))));
        ListNode L2 = new ListNode(5).setNext(new ListNode(6).setNext(new ListNode(4)));
        printListNode(addTwoNumbers(L1,L2));
    }

    public static void printListNode(ListNode listNode){
        do {
            System.out.println(listNode.getVal());
            listNode = listNode.next;
        }while (listNode != null);
    }
}
