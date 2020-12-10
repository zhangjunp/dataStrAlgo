package com.zhangjp.dataStrAlgo.leetcode.bfs;

import lombok.Data;
import java.util.LinkedList;
import java.util.Queue;

/*
101. 对称二叉树
给定一个二叉树，检查它是否是镜像对称的。
例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
    1
   / \
  2   2
 / \ / \
3  4 4  3
但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:

    1
   / \
  2   2
   \   \
   3    3
进阶：
你可以运用递归和迭代两种方法解决这个问题吗？
* */
public class Day04 {
    // BFS 借助Queue解法
    public boolean isSymmetric(TreeNode root) {
        // 每次从队列中取两个进行判断，是否是对称
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        queue.add(root);
        while (!queue.isEmpty()){
            TreeNode t1 = queue.poll();
            TreeNode t2 = queue.poll();
            if (t1 == null && t2 == null) { continue; }
            if (t1 == null || t2 == null) { return false; }
            if (t1.val != t2.val) { return false; }
            // 放入时注意顺序，根据题意的判断逻辑，每次取出两个节点应该是
            // 左边树的左节点 == 右边树的右节点
            // 左边树的右节点 == 右边树的左节点
            queue.add(t1.left);
            queue.add(t2.right);
            queue.add(t1.right);
            queue.add(t2.left);
        }
        return true;
    }


    //DS 递归解法
    public boolean isSymmetricDs(TreeNode root) {
        return isMirror(root,root);
    }

    public boolean isMirror(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) return true;
        if (t1 == null || t2 == null) return false;
        return (t1.val == t2.val) && isMirror(t1.right, t2.left) && isMirror(t1.left, t2.right);
    }

}


