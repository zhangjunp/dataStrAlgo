package com.zhangjp.dataStrAlgo.leetcode.tree;

import com.zhangjp.dataStrAlgo.leetcode.bfs.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*树的基本操作*/
public class TreeBase {

    //树
    /*
    * 树的基本总结：
    *
    * 二叉树
    *
    * 完全二叉树
    *
    * 满二叉树
    *
    * 二叉搜索树
    *
    * */

    // 什么是二叉树的中序遍历？
    // 如何将所有节点都遍历打印出来呢？
    // 经典的方法有三种，前序遍历、中序遍历和后序遍历。
    // 其 中，前、中、后序，表示的是节点与它的左右子树节点遍历打印的先后顺序。
    // 前序遍历是指，对于树中的任意节点来说，先打印这个节点，然后再打印它的左子树，最后 打印它的右子树。
    // 中序遍历是指，对于树中的任意节点来说，先打印它的左子树，然后再打印它本身，最后打 印它的右子树。
    // 后序遍历是指，对于树中的任意节点来说，先打印它的左子树，然后再打印它的右子树，最 后打印这个节点本身。
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        inOrder(root,list);
        return list;

    }

    // 中序遍历 ，先打印当前节点的左子树 -> 打印当前节点 -> 打印当前节点的右子树
    public static void inOrder(TreeNode root,List<Integer> list){
        if (root == null){
            return;
        }
        inOrder(root.left,list);
        list.add(root.val);
        inOrder(root.right,list);
    }


    /*中序遍历依赖栈结构*/
    public List<Integer> inOrderByStack(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;
        while(current!= null || !stack.isEmpty()){
            while(current!=null){
                stack.push(current);
                current = current.left;
            }
            current = stack.pop();
            list.add(current.val);
            current = current.right;
        }
        return list;
    }



    // 前序遍历 ，先打印当前节点  -> 打印当前节点的左子树 -> 打印当前节点的右子树
    public static void preOrder(TreeNode root,List<Integer> list){
        if (root == null){
            return;
        }
        list.add(root.val);
        preOrder(root.left,list);
        preOrder(root.right,list);
    }

    // 后序遍历 ，先打印当前节点左子树  -> 打印当前节点的右子树 -> 打印当前节点
    public static void postOrder(TreeNode root, List<Integer> list){
        if (root == null){
            return;
        }
        postOrder(root.left,list);
        postOrder(root.right,list);
        list.add(root.val);
    }

    /*判断是否是二杈搜索树，可以利用二杈树的中序遍历，如果是升序的说明是二杈搜索树*/
    static long preVal = Long.MIN_VALUE;
    // 利用二叉树的中序遍历为升序的特性，来判断一个树是否为二叉搜索树
    public static boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (!isValidBST(root.left)) {
            return false;
        }
        if (root.val <= preVal) {
            return false;
        }
        preVal = (long) root.val;
        return isValidBST(root.right);
    }
}
