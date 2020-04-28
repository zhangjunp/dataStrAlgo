package com.zhangjp.dataStrAlgo.leetcode.bfs;


import java.util.*;

/*
* 102. 二叉树的层序遍历
给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。
示例：
二叉树：[3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
返回其层次遍历结果：
[
  [3],
  [9,20],
  [15,7]
]
* */
public class Day03 {

    // 二叉树的层序遍历
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        List<Integer> currentFool = new ArrayList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            // 当前层中节点个数进行for循环
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                assert poll != null;
                currentFool.add(poll.val);
                if (poll.left!=null) {
                    queue.offer(poll.left);
                }
                if (poll.right!=null) {
                    queue.offer(poll.right);
                }
            }
            // 当前层遍历完后，将当前层List加入，并new一个新的List指向当前层list

            list.add(currentFool);
            currentFool = new ArrayList<>();
        }
        return list;
    }
}





