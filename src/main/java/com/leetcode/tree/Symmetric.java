package com.leetcode.tree;

/**
 * 对称二叉树
 * 给定一个二叉树，检查它是否是镜像对称的。
 * <p>
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 * <p>
 * 1
 * / \
 * 2   2
 * / \ / \
 * 3  4 4  3
 * 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
 * <p>
 * 1
 * / \
 * 2   2
 * \   \
 * 3    3
 * 说明:
 * <p>
 * 如果你可以运用递归和迭代两种方法解决这个问题，会很加分。
 */
public class Symmetric {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(3);
        TreeNode node5 = new TreeNode(4);
        TreeNode node6 = new TreeNode(3);
        TreeNode node7 = new TreeNode(3);
        TreeNode node8 = new TreeNode(2);
        root.left = node1;
        root.right = node2;
//        node1.left = node3;
        node1.right = node3;
        node2.left = node4;
        node3.left = node5;
        node4.right = node6;
        System.out.println(isSymmetric1(root));
    }

    public static boolean isSymmetric1(TreeNode root) {
        if (root == null)
            return true;
        return test(root.left, root.right);
    }

    //迭代版本  还存在问题
    private static boolean test(TreeNode left, TreeNode right) {
        if (left == null && right == null)
            return true;
        if (left == null || right == null)
            return false;
        TreeNode left1 = left;
        TreeNode right1 = right;
        while (left != null || right != null) {
            if(left == null || right == null)
                return false;
            if (left.val != right.val) {
                return false;
            }
            left = left.left;
            right = right.right;
        }

        while (left1 != null || right1 != null) {
            if(left1 == null || right1 == null)
                return false;
            if (left1.val != right1.val) {
                return false;
            }
            left1 = left1.right;
            right1 = right1.left;
        }
        return true;
    }

    //递归版本 通过测试
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }

        return symmetric(root.left, root.right);
    }

    private boolean symmetric(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;
        if (left == null || right == null) return false;
        return (left.val == right.val) && symmetric(left.left, right.right) && symmetric(left.right, right.left);
    }


}
