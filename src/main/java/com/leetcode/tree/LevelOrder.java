package com.leetcode.tree;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

/**
 * 二叉树的层次遍历
 * 给定一个二叉树，返回其按层次遍历的节点值。 （即逐层地，从左到右访问所有节点）。
 *
 * 例如:
 * 给定二叉树: [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回其层次遍历结果：
 *
 * [
 *   [3],
 *   [9,20],
 *   [15,7]
 * ]
 */
public class LevelOrder {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode node1 = new TreeNode(9);
//        TreeNode node2 = new TreeNode(20);
//        TreeNode node3 = new TreeNode(15);
//        TreeNode node4 = new TreeNode(7);
//        TreeNode node5 = new TreeNode(1);
//        TreeNode node6 = new TreeNode(2);
        root.left = node1;
//        root.right = node2;
//        node2.left = node3;
//        node2.right = node4;
//        node1.left = node5;
//        node1.right = node6;
        System.out.println(levelOrder(root));
//        nonRecAfterOrder(root);
    }

    public static List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null)
            return new ArrayList();
        List<List<Integer>> lists = new ArrayList();
        List<List<TreeNode>> nodes = new ArrayList();
        nodes.add(Arrays.asList(root));
        while(!nodes.isEmpty()){
            List<TreeNode> trees = nodes.remove(0);
            List<TreeNode> nums = new ArrayList();
            List<Integer> temp = new ArrayList();
            for(int i=0;i<trees.size();i++){
                TreeNode node = trees.get(i);
                if(node.left!=null){
                    nums.add(node.left);
                }
                if(node.right!=null){
                    nums.add(node.right);
                }
                temp.add(node.val);
            }
            if(nums.size()>0)
                nodes.add(nums);
            if(temp.size()>0)
                lists.add(temp);
        }
        return lists;
    }

    public static List<List<Integer>> levelOrder1(TreeNode root) {
        if(root == null)
            return new ArrayList<>();
        List<List<Integer>> list = new ArrayList<>();
        list.add(Collections.singletonList(root.val));
        order(root,list, 1);
        return list;
    }

    public static void order1(TreeNode root, List<List<Integer>> list, int depth) {
        if(root == null)
            return;
        if(root.left==null && root.right==null)
            return;
        List<Integer> tree = null;
        if(list.size() <= depth){
            tree = new ArrayList<>();
        }else{
            tree = list.get(depth);
        }
        if(root.left != null){
            tree.add(root.left.val);
        }
        if(root.right != null){
            tree.add(root.right.val);
        }
        if(list.size() <= depth){
            list.add(tree);
        }
        if(root.left != null){
            order1(root.left,list,depth+1);
        }
        if(root.right != null){
            order1(root.right,list,depth+1);
        }

    }

    public static List<Double> levelOrder2(TreeNode root) {
        if(root == null)
            return new ArrayList<>();
        List<List<Integer>> list = new ArrayList<>();
        order(root,list, 0);
        List<Double> doubles = list.stream().map(item -> {
            BigDecimal big = new BigDecimal(0);
            List<BigDecimal> bigs = item.stream().map(num -> {
                return new BigDecimal(num);
            }).collect(Collectors.toList());

            for (BigDecimal num : bigs) {
                big = big.add(num);
            }

            return big.doubleValue() / item.size();
        }).collect(Collectors.toList());

        return doubles;
    }

    //简化版本
    public static void order(TreeNode root, List<List<Integer>> list, int depth) {
        if(root == null)
            return;

        if(list.size() <= depth){
            list.add(new ArrayList<Integer>());
        }
        List<Integer> tree = list.get(depth);
        tree.add(root.val);
        order(root.left,list,depth+1);
        order(root.right,list,depth+1);
    }

    public static void preOrder(TreeNode root){
        if(root==null)
            return;
        System.out.println(root.val);
        if(root.left!=null){
            preOrder(root.left);
        }
        if(root.right!=null){
            preOrder(root.right);
        }
    }

    public static void nonRecPreOrder(TreeNode root){
        if(root==null)
            return;
        Stack stack = new Stack();
        TreeNode node = root;
        //左子树的节点遍历
        while(!stack.isEmpty() || node!=null){
            while (node!=null){
                System.out.println(node.val);
                stack.push(node);
                node = node.left;
            }
            if(!stack.isEmpty()){
                TreeNode pop = (TreeNode) stack.pop();
                node = pop.right;
            }
        }
    }

    public static void nonRecMidOrder(TreeNode root){
        if(root==null)
            return;
        Stack stack = new Stack();
        TreeNode node = root;
        while(!stack.isEmpty() || node!=null){
            //左子树的节点遍历
            while (node!=null){
                stack.push(node);
                node = node.left;
            }
            if(!stack.isEmpty()){
                TreeNode pop = (TreeNode) stack.pop();
                node = pop.right;
                System.out.println(pop.val);
            }
        }
    }

    public static void nonRecAfterOrder(TreeNode root){
        if(root==null)
            return;
        Stack stack = new Stack();
        TreeNode node = root;
        while(!stack.isEmpty() || node!=null){
            //左子树的节点遍历
            while (node!=null){
                stack.push(node);
                if(node.right!=null){
                    stack.push(node.right);
                }
                node = node.left;
            }
            if(!stack.isEmpty()){
                TreeNode pop = (TreeNode) stack.pop();
                node = pop.right;
                System.out.println(pop.val);
            }
        }
    }
}
