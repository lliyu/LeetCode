package com.leetcode.tree;

import java.util.List;

/**
 * @Auther: Administrator
 * @Date: 2019-03-20 14:27
 * @Description:
 */
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val,List<Node> _children) {
        val = _val;
        children = _children;
    }
};