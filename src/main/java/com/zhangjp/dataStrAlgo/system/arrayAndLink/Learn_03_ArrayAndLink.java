package com.zhangjp.dataStrAlgo.system.arrayAndLink;

import java.util.HashMap;
import java.util.Map;

public class Learn_03_ArrayAndLink {

    /**
     运用你所掌握的数据结构，设计和实现一个  LRU (最近最少使用) 缓存机制 。
     实现 LRUCache 类：

     LRUCache(int capacity) 以正整数作为容量 capacity 初始化 LRU 缓存
     int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。
     void put(int key, int value) 如果关键字已经存在，则变更其数据值；如果关键字不存在，
     则插入该组「关键字-值」。当缓存容量达到上限时，它应该在写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。

     */

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(2);
        lruCache.put(1,1);
        lruCache.put(2,2);
        int i = lruCache.get(1);
        System.out.println("i = " + i);
        lruCache.put(3,3);
        int i1 = lruCache.get(2);
        System.out.println("i1 = " + i1);

    }

    static class Node{
        int key;
        int value;
        Node prev;
        Node next;
        public Node(int key ,int data){
            this.value =data;
            this.key = key;
        }
    }

    static class LRUCache {
        Node head = null;
        Node end = null;
        int capacity = 0;
        private Map<Integer,Node> map = new HashMap<>();
        public LRUCache(int capacity){
            this.capacity = capacity;
        }

        public int get(int key){
            if (map.containsKey(key)) {
                Node node = map.get(key);
                remove(node);
                setHead(node);
                return node.value;
            }
            return -1;
        }

        public void put(int key,int value){
            if (map.containsKey(key)) {
                Node node = map.get(key);
                node.value = value;
                remove(node);
                setHead(node);
            }else {
                Node node = new Node(key,value);
                map.put(key,node);
                setHead(node);
                if (map.size() > capacity) {
                    map.remove(end.key);
                    remove(end);
                }
            }
        }

        // 删除双向链表的节点
        public void remove(Node node){
            if (node.prev==null) {
                head = node.next;
            }else {
                node.prev.next = node.next;
            }
            if (node.next ==null) {
                end = node.prev;
            }else {
                node.next.prev = node.prev;
            }
        }

        // reset 双向链表的头结点，容易丢失指针
        public void setHead(Node node){
            node.prev = null;
            node.next = head;
            if (head != null) {
                head.prev = node;
            }
            head = node;
            if(end == null){
                end = head;
            }
        }
    }

}
