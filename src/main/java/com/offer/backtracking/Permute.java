package com.offer.backtracking;

import com.leetcode.array.Permutation;

import java.util.ArrayList;
import java.util.List;

/**
 * 46. 全排列
 * 给定一个没有重复数字的序列，返回其所有可能的全排列。
 *
 * 示例:
 *
 * 输入: [1,2,3]
 * 输出:
 * [
 *   [1,2,3],
 *   [1,3,2],
 *   [2,1,3],
 *   [2,3,1],
 *   [3,1,2],
 *   [3,2,1]
 * ]
 */
public class Permute {

    public static void main(String[] args) {
        Permute permute = new Permute();

        permute.permute1(new int[]{1, 2, 3});
    }

    private List<List<Integer>> lists = new ArrayList<>();

    public List<List<Integer>> permute1(int[] nums) {
        recursive(nums, 0, new ArrayList<Integer>());
        return lists;
    }

    public void recursive(int[] nums, int index, List<Integer> path){
        if (path.size() == nums.length){
            lists.add(new ArrayList<Integer>(path));
            return;
        }
        if (index >= nums.length) return ;

        for(int i=index;i<nums.length; i++){
            path.add(nums[index]);
            recursive(nums, index+1, path);
            path.remove(path.size()-1);
        }
    }



    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ints = new ArrayList<>();
        backTrace(nums, 0, "");
        return null;
    }

    private void backTrace(int[] nums, int len, String s) {
        if(s.length() == nums.length){
            System.out.println(s);
        }else {
            for(int i=len;i<nums.length;i++){
                change(nums, i, len);
                backTrace(nums, len+1, s+nums[len]);
                change(nums, i, len);
            }
        }

    }

    private void change(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
}
