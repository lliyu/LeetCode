package com.leetcode.tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LevelOrderBottom {

    private List<List<Integer>> roots = new ArrayList<>();

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<TreeNode> list = new ArrayList();
        Map<Integer, TreeNode> maps = new HashMap<>();
        maps.put(0, root);
        int len = 1;
        list.add(root);
        while(maps.size()>0){
//            maps.remove()

        }
        Map<Integer, Integer> nums = new HashMap<>();
//        nums.containsKey()

        return null;
    }

    public void bracktrace(int len, TreeNode root, Map<Integer, TreeNode> maps){
        if(root==null)
            return;
        if(roots.size() <= len){
            roots.add(new ArrayList<>());
        }
        if(root.left != null){
            roots.get(len).add(root.left.val);
            maps.put(len+1, root.left);
        }
        if(root.right != null){
            roots.get(len).add(root.right.val);
            maps.put(len+1, root.right);
        }
    }



}
