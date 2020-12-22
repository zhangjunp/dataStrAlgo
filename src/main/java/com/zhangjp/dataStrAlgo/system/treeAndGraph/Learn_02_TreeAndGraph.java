package com.zhangjp.dataStrAlgo.system.treeAndGraph;

import java.util.*;

public class Learn_02_TreeAndGraph {

    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    };

    /**
     * @description: N 叉树的最大深度
     * 广度优先遍历，依赖队列
     * @author: zhangjp
     */

    public int maxDepth(Node node){
        if (node == null){
            return 0;
        }
        int maxDepth = 0;
        LinkedList<List<Node>> queue = new LinkedList<>();
        if (node.children != null && node.children.size()>0) {
            queue.add(node.children);
        }
        // 遍历下一层
        while(!queue.isEmpty()){
            maxDepth +=1;
            List<Node> nextFloor = new ArrayList<>();
            List<Node> poll = queue.poll();
            poll.forEach(item->{
                nextFloor.addAll(item.children);
            });
            // 下一层有node节点，加入队列中
            if (nextFloor.size()>0) {
                queue.add(nextFloor);
            }
        }
        return maxDepth;
    }


}
