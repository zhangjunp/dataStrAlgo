package com.zhangjp.dataStrAlgo.leetcode.bfs;

import java.util.*;

/*
* 103. 二叉树的锯齿形层次遍历
给定一个二叉树，返回其节点值的锯齿形层次遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
例如：
给定二叉树 [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
返回锯齿形层次遍历如下：
[
  [3],
  [20,9],
  [15,7]
]
* */
public class Day05 {

    /*
    *思路和层遍历一样
    *1.按层遍历
    *2.声明flag，将需要翻转的层进行翻转
    * */
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        List<Integer> currentFool = new ArrayList<>();
        boolean left = true;
        queue.offer(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0; i<size; i++){
                TreeNode curNode = queue.poll();
                if (curNode != null) {
                    currentFool.add(curNode.val);
                    if (curNode.right != null) queue.offer(curNode.right);
                    if (curNode.left != null) queue.offer(curNode.left);
                }
            }
            if (left) {
                Collections.reverse(currentFool);
            }
            left = !left;
            list.add(currentFool);
            currentFool = new ArrayList<>();
        }
        return list;
    }
}
