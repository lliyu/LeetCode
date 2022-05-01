package com.leetcode.backtrace;

import com.leetcode.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(5);
        root.left = node1;
        root.right = node2;
        node1.right = node3;
        System.out.println(binaryTreePaths(root));
    }

    private static List<List<String>> lists = new ArrayList<>();
    public static List<String> binaryTreePaths(TreeNode root) {
        List<String> strings = new ArrayList<>();
        backtrace(root, new ArrayList<>());
        for(List<String> item : lists) {
            StringBuilder sb = new StringBuilder();
            for(int i=0; i<item.size()-1; i++) {
                sb.append(item.get(i) + "->");
            }
            sb.append(item.get(item.size()-1));
            strings.add(sb.toString());
        }
        return strings;
    }

    public static void backtrace(TreeNode root, List<String> path) {
        if (root.left==null && root.right==null) {
            path.add(String.valueOf(root.val));
            lists.add(new ArrayList<>(path));
            return;
        }
        path.add(String.valueOf(root.val));
        if (root.left != null) {
            backtrace(root.left, path);
            path.remove(path.size()-1);
        }
        if (root.right != null) {
            backtrace(root.right, path);
            path.remove(path.size()-1);
        }

    }
}
