package com.leetcode.backtrace;

import com.leetcode.tree.TreeNode;
import com.util.AlgorithmUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * 437. 路径总和 III
 * https://leetcode-cn.com/problems/path-sum-iii/
 * 给定一个二叉树的根节点 root ，和一个整数 targetSum ，求该二叉树里节点值之和等于 targetSum 的 路径 的数目。
 *
 * 路径 不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。
 *
 * 示例 1：
 * 输入：root = [10,5,-3,3,2,null,11,3,-2,null,1], targetSum = 8
 * 输出：3
 * 解释：和等于 8 的路径有 3 条，如图所示。
 */
public class PathSum {

    public static void main(String[] args) {
        TreeNode treeNode = AlgorithmUtils.stringToTreeNode("[10,5,-3,3,2,null,11,3,-2,null,1]");
        PathSum sum = new PathSum();
        System.out.println(sum.pathSum(treeNode, 8));
    }

    private int rst = 0;
    public int pathSum(TreeNode root, int targetSum) {
        Map<Integer, Integer> prefixSum = new HashMap<>();
        prefixSum.put(0, 1);
        prefixSum(root, targetSum, prefixSum, 0);
        return rst;
    }

    public void prefixSum(TreeNode root, int targetSum, Map<Integer, Integer> prefixSum, int sum) {
        if (root ==null) return;
        sum += root.val;
        rst += prefixSum.getOrDefault(sum-targetSum, 0);
        prefixSum.put(sum, prefixSum.getOrDefault(sum, 0)+1);
        if(root.left != null) {
            prefixSum(root.left, targetSum, prefixSum, sum);
        }
        if(root.right != null) {
            prefixSum(root.right, targetSum, prefixSum, sum);
        }
        // 注意这里 退出当前节点回到上面的时候必须要减去当前节点
        // 这样才能保证后续遍历其他方向时不会被已有的值影响
        prefixSum.put(sum, prefixSum.get(sum)-1);
        sum -= root.val;
    }
}
