package com.zhangjp.dataStrAlgo.leetcode.bfs;


import java.util.LinkedList;
import java.util.Queue;

/*
*
给定一个由 0 和 1 组成的矩阵，找出每个元素到最近的 0 的距离。
两个相邻元素间的距离为 1 。
示例 1:
输入:
0 0 0
0 1 0
0 0 0
输出:
0 0 0
0 1 0
0 0 0
示例 2:
输入:
0 0 0
0 1 0
1 1 1
输出:
0 0 0
0 1 0
1 2 1
注意:
给定矩阵的元素个数不超过 10000。
给定矩阵中至少有一个元素是 0。
矩阵中的元素只在四个方向上相邻: 上、下、左、右。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/01-matrix
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
* */
public class Day02 {

    public static void main(String[] args) {
        // 定义一个三行三列的二维数组来实现矩阵
        int[][] matrix1 = {{0,0,0},{0,1,0},{0,0,0}};
        int[][] ints = updateMatrix(matrix1);
        printM(ints);
    }

    /*
     * 图的遍历有两种： 深度优先和广度优先算法
     * Depth-First Search 深度优先
     * DFS 解决的是连通性的问题，一般解决俩点之间能否联通，不问最短路径，必须依赖栈（Stack），特点是后进先出（LIFO）。
     *
     * 广度优先搜索（Breadth-First Search / BFS）
     * 广度优先搜索，一般用来解决最短路径的问题。和深度优先搜索不同，依赖队列
     * */
    public static int[][] updateMatrix(int[][] matrix){
        Queue<int[]> queue = new LinkedList<>();
        int m = matrix.length;
        int n = matrix[0].length;
        // 遍历图
        // 1.将为0的点作为起始点，放到Queue中
        // 2.将其他点置为 -1 作为未标记的标志
        for (int i = 0; i < m; i++) {
            for (int j = 0; j <n ; j++) {
                if (matrix[i][j] == 0) {
                    queue.add(new int[]{i,j});
                }else {
                    matrix[i][j] = -1;
                }
            }
        }
        // 执行BFS遍历
        int[] dx = new int[]{-1,1,0,0};//左右
        int[] dy = new int[]{0,0,-1,1};//上下
        while(!queue.isEmpty()){
            int[] poll = queue.poll();
            int x = poll[0],y = poll[1];
            // 遍历这个点的上下左右相邻的点
            for (int i = 0; i < 4; i++) {
                int newX = x + dx[i];
                int newY = y + dy[i];
                // 如果此点未被标记过
                if (isSafe(matrix,newX,newY) && matrix[newX][newY ]== -1) {
                    matrix[newX][newY] = matrix[x][y] + 1;
                    // 放入队列中
                    queue.offer(new int[]{newX,newY});
                }
            }
        }
        return matrix;
    }

    // 遍历矩阵
    public static void printM(int[][] m){
        for (int i = 0; i <m.length ; i++) {
            for (int j = 0; j < m[i].length; j++) {
                System.out.print(m[i][j] + "   ");
            }
            System.out.println();
        }
    }
    // 判断是否安全点
    public static boolean isSafe(int[][] maze,int x,int y){
        if (null!=maze && x>=0 && y>=0 && x<maze.length && y<maze[0].length) {
            return true;
        }
        return false;
    }
}
