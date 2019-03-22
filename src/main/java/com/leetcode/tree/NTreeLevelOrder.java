package com.leetcode.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: Administrator
 * @Date: 2019-03-20 14:28
 * @Description:
 */
public class NTreeLevelOrder {

    public static void main(String[] args) {
    }

    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> order = new ArrayList<>();
        if(root==null) {
            return order;
        }
        List<Integer> temp = new ArrayList<>();
        order.add(temp);
        order(root, order, 0);
        return order;
    }

    public void order(Node node, List<List<Integer>> order,int depth){
        if(node==null)
            return;
        if(order.size()<=depth){
            List<Integer> temp = new ArrayList<>();
            order.add(temp);
        }
        order.get(depth).add(node.val);
        //遍历子树
        List<Node> childrens = node.children;
        for(Node children : childrens){
            order(children, order, depth+1);
        }
    }
}
