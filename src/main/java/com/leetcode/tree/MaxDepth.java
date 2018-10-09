package com.leetcode.tree;

/**
 * 二叉树的最大深度
 * 给定一个二叉树，找出其最大深度。
 *
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例：
 * 给定二叉树 [3,9,20,null,null,15,7]，
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回它的最大深度 3 。
 */
public class MaxDepth {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode node1 = new TreeNode(9);
        TreeNode node2 = new TreeNode(20);
        TreeNode node3 = new TreeNode(15);
        TreeNode node4 = new TreeNode(7);
        root.left = node1;
        root.right = node2;
        node2.left = node3;
        node2.right = node4;
        System.out.println(maxDepth(root));

    }

    public int maxDepth1(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = maxDepth1(root.left);
        int right = maxDepth1(root.right);
        return Math.max(left, right) + 1;
    }

    public static int maxDepth(TreeNode root) {
        if(root == null)
            return 0;
        int max = 1;
        int dep = 1;
        return depth(root,max,dep);
    }
    public static int depth(TreeNode root,int max,int depth) {
        if(root.left==null && root.right == null)
           return depth>max?depth:max;
        if(root.left!=null){
            max = depth(root.left, max,depth+1);
        }
        if(root.right!=null){
            max = depth(root.right, max, depth+1);
        }
        return max;
    }

}
