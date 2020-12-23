package com.zhangjp.dataStrAlgo.system.treeAndGraph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @description: 二叉树的序列化与反序列化
 * @author: zhangjp
 * @date: 2020/12/21 14:47
 */
public class Learn_01_TreeAndGraph {

    /**
     * @description:
     *      8
     *     / \
     *    4   11
     *   /\
     *  2  6
     *
     *  前序遍历序列化后  8 4 2 null null 6 null null 11 null null
     *  反序列化： 采用递归 根节点 左子树 右子树
     * @author: zhangjp
     * @date: 2020/12/22 14:44
     */
    public static void main(String[] args) {
       String str = "8,4,2,null,null,6,null,null,11,null,null";
       TreeNode treeNode = deserialize(str);
       System.out.println(serialize(treeNode));
    }


    // Encodes a tree to a single string. 将树序列化成字符串
    public static String serialize(TreeNode root) {
        return serializeHelper(root,"");
    }

    public static String serializeHelper(TreeNode treeNode,String str){
        if (treeNode == null) {
            str += "null,";
        }else{
            // 前序遍历 深度优先，借助递归实现
            str += treeNode.val +",";
            str=serializeHelper(treeNode.left,str);
            str=serializeHelper(treeNode.right,str);
        }
        return str;
    }

    // Decodes your encoded data to tree. 将字符串序列化成树
    public static TreeNode deserialize(String data) {
        String[] split = data.split(",");
        List<String> dataList = new ArrayList<>(Arrays.asList(split));
        return deserializeHelper(dataList);
    }

    public static TreeNode deserializeHelper(List<String> list) {
        if (list.get(0).equals("null")) {
            list.remove(0);
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(list.get(0)));
        list.remove(0);
        root.left = deserializeHelper(list);
        root.right = deserializeHelper(list);
        return root;
    }


    public static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }


}
