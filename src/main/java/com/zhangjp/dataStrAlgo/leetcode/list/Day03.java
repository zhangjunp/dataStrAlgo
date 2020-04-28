package com.zhangjp.dataStrAlgo.leetcode.list;

import com.zhangjp.dataStrAlgo.leetcode.ListNode;

/*
给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
示例：
给定一个链表: 1->2->3->4->5, 和 n = 2.
当删除了倒数第二个节点后，链表变为 1->2->3->5.
说明：
给定的 n 保证是有效的。
进阶：
你能尝试使用一趟扫描实现吗？

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
* */
public class Day03 {

    /*
    * 链表删除指定位置的元素，可以利用快慢指针的思路
    * 当快指针指到5时
    * 另外一个慢指针指到3
    * 只需要将此时的慢指针的Node.next指向5即可
    *
    * 所以想要实现上述效果 应该有两个指针，且两个指针之间相差N个，当快指针指向结尾时，慢指针在倒数第N+1上
    * 剩下的进行去除倒数第N个节点的操作即可
    *
    * 一般用在要返回新的链表的题目中，比如，给定两个排好序的链表，要求将它们整合在一起并排好序。
    * 又比如，将一个链表中的奇数和偶数按照原定的顺序分开后重新组合成一个新的链表，链表的头一半是奇数，后一半是偶数。
    * 在这类问题里，如果不用一个虚假的链表头，那么在创建新链表的第一个元素时，我们都得要判断一下链表的头指针是否为空，
    * 也就是要多写一条 if else 语句。
    * 比较简洁的写法是创建一个空的链表头，直接往其后面添加元素即可，最后返回这个空的链表头的下一个节点即可。
    * */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0); //利用哨兵结点简化实现难度
        dummy.next = head;
        ListNode fast = dummy.next;
        ListNode slow = dummy;
        for (int i = 0; i <n ; i++) {
            fast = fast.next;
        }
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return dummy.next;
    }
}
