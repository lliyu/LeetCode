package com.leetcode.tree;

/**
 * 将有序数组转换为二叉搜索树
 * 将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。
 *
 * 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
 *
 * 示例:
 *
 * 给定有序数组: [-10,-3,0,5,9],
 *
 * 一个可能的答案是：[0,-3,9,-10,null,5]，它可以表示下面这个高度平衡二叉搜索树：
 *
 *       0
 *      / \
 *    -3   9
 *    /   /
 *  -10  5
 */
public class SortedArrayToBST {

    /**
     * 二分法来创建平衡二叉树，根结点为数组中间的节点，根节点的左子树的根是数组左边部分的中间节点，根节点的右子树是数据右边部分的中间节点
     * @param nums
     * @return
     */
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums == null || nums.length == 0)
            return null;
        return convertTree(nums,0,nums.length - 1);
    }

    public TreeNode convertTree(int []nums, int l, int r){
        if(l <= r){
            int mid = (l+r)/2;
            TreeNode node = new TreeNode(nums[mid]);
            node.left = convertTree(nums,l,mid-1);
            node.right = convertTree(nums,mid+1,r);
            return node;
        }else{
            return null;
        }
    }
}
