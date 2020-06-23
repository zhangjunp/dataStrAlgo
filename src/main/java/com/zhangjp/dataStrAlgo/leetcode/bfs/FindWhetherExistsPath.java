package com.zhangjp.dataStrAlgo.leetcode.bfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
* 面试题 04.01. 节点间通路
节点间通路。给定有向图，设计一个算法，找出两个节点之间是否存在一条路径。

示例1:

 输入：n = 3, graph = [[0, 1], [0, 2], [1, 2], [1, 2]], start = 0, target = 2
 输出：true
示例2:

 输入：n = 5, graph = [[0, 1], [0, 2], [0, 4], [0, 4], [0, 1], [1, 3], [1, 4], [1, 3], [2, 3], [3, 4]], start = 0, target = 4
 输出 true
提示：

节点数量n在[0, 1e5]范围内。
节点编号大于等于 0 小于 n。
图中可能存在自环和平行边。
* */
public class FindWhetherExistsPath {

    public static void main(String[] args) {
        // 0定点 1定点 2顶点 3顶点; 0到1和3顶点  1到无  2到无  1到2和3
        // 所以0能到2
        int[][] graph = {{0, 1}, {0, 3}, {1, 2}, {1, 3}};
        boolean whetherExistsPath = findWhetherExistsPath(4, graph, 0, 2);
        System.out.println("whetherExistsPath = " + whetherExistsPath);
        // 邻接表来表示有向图
        // 0->1->3
        // 1->2->3
        // 2->/
        // 3->/
    }


    public static boolean findWhetherExistsPath(int n, int[][] graph, int start, int target) {
        List<Integer>[] digraph = digraph(n, graph);
        return havePath(digraph,start,target);
    }

    // 有向图的构建
    public static List<Integer>[] digraph (int n,int[][]graph) {
        List<Integer>[] adj= new ArrayList[n];
        for (int[] edge:graph){
            int from=edge[0];
            int to=edge [1];
            if (adj[from]==null){
                adj[from]=new ArrayList<>();
            }
            adj[from].add(to);
        }
        return adj;
    }



    public static boolean havePath(List<Integer>[] digraph,int start,int end){
        if (digraph == null || digraph.length < 1) {
            return false;
        }
        List<Integer> haveVisted = new ArrayList<>();
        haveVisted.add(0);
        for (int i = 0; i <digraph.length ; i++) {
            if (start <= i && haveVisted.contains(i)){
                List<Integer> integers = digraph[i];
                for (Integer item:integers) {
                    haveVisted.add(item);
                    if (end == item){
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
