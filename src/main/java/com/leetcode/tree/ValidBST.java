package com.leetcode.tree;

/**
 * 验证二叉搜索树
 * 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
 * 假设一个二叉搜索树具有如下特征：
 * 节点的左子树只包含小于当前节点的数。
 * 节点的右子树只包含大于当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 * 示例 1:
 *
 * 输入:
 *     2
 *    / \
 *   1   3
 * 输出: true
 * 示例 2:
 *
 * 输入:
 *     5
 *    / \
 *   1   4
 *      / \
 *     3   6
 * 输出: false
 * 解释: 输入为: [5,1,4,null,null,3,6]。
 *      根节点的值为 5 ，但是其右子节点值为 4 。
 */
public class ValidBST {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(2147483647);
//        TreeNode node1 = new TreeNode(1);
//        TreeNode node2 = new TreeNode(5);
//        TreeNode node3 = new TreeNode(0);
//        TreeNode node4 = new TreeNode(2);
//        TreeNode node5 = new TreeNode(4);
//        TreeNode node6 = new TreeNode(6);
//        TreeNode node7 = new TreeNode(3);
//        TreeNode node8 = new TreeNode(2);
//        root.left = node1;
//        root.right = node2;
//        node1.left = node3;
//        node1.right = node4;
//        node2.left = node5;
//        node2.right = node6;
//        node4.right = node7;
//        node4.left = node8;
        System.out.println(isValidBST(root));
    }

    public static boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        //这题麻烦之处在于构造比较的条件
        //对于左子树所有节点要小于当前节点
        //右子树
        return isBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    public static boolean isBST(TreeNode root, long low, long high) {
        if (root == null)
            return true;
        if (root.val <= low || root.val >= high)
            return false;

        return isBST(root.left, low, root.val) && isBST(root.right, root.val, high);
    }
}
