package com.zhangjp.dataStrAlgo.system.treeAndGraph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


public class Learn_03_TreeAndGraph {

    /**
     * @description: 删除 二杈搜索树 中的节点
     * @author: zhangjp
     * @date: 2020/12/22 14:48
     *       8
     *      / \
     *     4   11
     *    /\    \
     *   2  6   18
     *
     *     5
     *    / \
     *   3   6
     *  / \   \
     * 2   4   7
     *  1.如果要删除的节点时叶子节点，直接设置为null即可
     *  2.如果要删除的节点非叶子节点
     *      2.1 如果该节点有右子树，需要将右子树中最小值节点（ps：此节点称之为后继节点）进行互换，最后在右子树中删除互换后的节点
     *      2.2 如果该节点有左子树，需要将左子树中最大值节点（ps：此节点称之为前驱节点）进行互换，最后在右子树中删除互换后的节点
     */

    // 获得一个树的后续节点中的值
    public static int successor(TreeNode node){
        node = node.right;
        while (node.left != null) {
            node = node.left;
        }
        return node.val;
    }

    public static int predecessor(TreeNode node){
        node = node.left;
        while (node.right != null) {
            node = node.right;
        }
        return node.val;
    }

    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null){
            return root;
        }
        if (key > root.val){
            root = deleteNode(root.right,key);
        }
        if (key < root.val){
            root = deleteNode(root.left,key);
        }
        if (root.val == key) {
            if(root.left == null && root.right == null){
                root = null;
            }else if (root.right!=null){
                int val = successor(root);
                root.val = val;
                root.right = deleteNode(root.right,val);
            }else {
                int val = predecessor(root);
                root.val = val;
                root.left = deleteNode(root.left,val);
            }
        }
        return root;
    }



    public class TreeNode {
       int val;
       TreeNode left;
       TreeNode right;
       TreeNode() {}
       TreeNode(int val) { this.val = val; }
       TreeNode(int val, TreeNode left, TreeNode right) {
           this.val = val;
           this.left = left;
           this.right = right;
       }
   }
}
