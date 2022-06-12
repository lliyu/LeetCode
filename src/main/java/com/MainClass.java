package com;

/* -----------------------------------
 *  WARNING:
 * -----------------------------------
 *  Your code may fail to compile
 *  because it contains public class
 *  declarations.
 *  To fix this, please remove the
 *  "public" keyword from your class
 *  declarations.
 */

import com.leetcode.tree.TreeNode;
import java.io.IOException;
import java.util.*;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public String decodeString(String s) {
        Stack<Character> stack = new Stack<>();

        int len = s.length();
        int index = 0;
        StringBuilder rst = new StringBuilder();
        while(index<len){
            if(s.charAt(index)== ']'){
                StringBuilder subStr = new StringBuilder();
                //取出最近的子字符串
                while(!stack.isEmpty()){
                    char ch = stack.pop();
                    if(ch == '['){
                        //计算重复次数
                        StringBuilder countS = new StringBuilder();
                        while(!stack.isEmpty()){
                            char c = stack.peek();
                            if(c == ']' || (c<'0' || c>'9'))break;
                            countS.insert(0, stack.pop());
                        }
                        int count = Integer.valueOf(countS.toString());
                        for(int i=0;i<count;i++){
                            for(int j=0;j<subStr.length();j++){
                                stack.push(subStr.charAt(j));
                            }
                        }
                        break;
                    }
                    subStr.insert(0, ch);
                }
            }else {
                stack.push(s.charAt(index));
            }
            index++;
        }
        while(!stack.isEmpty()){
            rst.append(stack.pop());
        }
        return rst.reverse().toString();
    }


    private List<List<Integer>> lists = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        order(root.left, new ArrayList<>());
        order(root.right, new ArrayList<>());
        return lists;
    }

    public void order(TreeNode root, List<Integer> path) {
        if (root == null) return;
        if (root.left==null && root.right==null) {
            path.add(root.val);
            lists.add(new ArrayList<>(path));
            return ;
        }
        int sum = path.stream().mapToInt(Integer::intValue).sum();
        path.add(root.val);
        order(root.left, path);
        path.remove(path.size()-1);
        order(root.right, path);
        path.remove(path.size()-1);
    }
}

public class MainClass {
    public static TreeNode stringToTreeNode(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
            return null;
        }

        String[] parts = input.split(",");
        String item = parts[0];
        TreeNode root = new TreeNode(Integer.parseInt(item));
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.add(root);

        int index = 1;
        while(!nodeQueue.isEmpty()) {
            TreeNode node = nodeQueue.remove();

            if (index == parts.length) {
                break;
            }

            item = parts[index++];
            item = item.trim();
            if (!item.equals("null")) {
                int leftNumber = Integer.parseInt(item);
                node.left = new TreeNode(leftNumber);
                nodeQueue.add(node.left);
            }

            if (index == parts.length) {
                break;
            }

            item = parts[index++];
            item = item.trim();
            if (!item.equals("null")) {
                int rightNumber = Integer.parseInt(item);
                node.right = new TreeNode(rightNumber);
                nodeQueue.add(node.right);
            }
        }
        return root;
    }

    public static void main(String[] args) throws IOException {
        TreeNode root = stringToTreeNode("[5,4,8,11,null,13,4,7,2,null,null,5,1]");
        int targetSum = 22;

        List<List<Integer>> lists = new Solution().pathSum(root, targetSum);

    }
}