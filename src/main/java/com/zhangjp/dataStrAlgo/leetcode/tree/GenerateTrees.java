package com.zhangjp.dataStrAlgo.leetcode.tree;

import com.zhangjp.dataStrAlgo.leetcode.bfs.TreeNode;

import java.util.LinkedList;
import java.util.List;

/*
*95. 不同的二叉搜索树 II
给定一个整数 n，生成所有由 1 ... n 为节点所组成的二叉搜索树。

示例:

输入: 3
输出:
[
  [1,null,3,2],
  [3,2,null,1],
  [3,1,null,null,2],
  [2,1,3],
  [1,null,2,null,3]
]
解释:
以上的输出对应以下 5 种不同结构的二叉搜索树：

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3

https://leetcode-cn.com/problems/unique-binary-search-trees-ii/
* */
public class GenerateTrees {


    public static void main(String[] args) {
        List<TreeNode> treeNodes = generateTrees(2);
        System.out.println("treeNodes = " + treeNodes);

    }

    public static List<TreeNode> generateTrees(int n) {
        List<TreeNode> list = new LinkedList<>();
        if (n == 0) {
            return list;
        }
        return generateTs(1,n);
    }

    public static List<TreeNode> generateTs(int start,int end){
        LinkedList<TreeNode> treeNodes = new LinkedList<>();
        if (start > end) {
            treeNodes.add(null);
            return treeNodes;
        }
        for (int i = start; i <= end; i++) {
            List<TreeNode> leftNodes = generateTs(start, i - 1);
            List<TreeNode> rightNodes = generateTs(i + 1, end);
            for (TreeNode l: leftNodes) {
                for (TreeNode r: rightNodes) {
                    TreeNode treeNode = new TreeNode(i);
                    treeNode.left = l;
                    treeNode.right = r;
                    treeNodes.add(treeNode);
                }
            }
        }
        return treeNodes;

    }

}
