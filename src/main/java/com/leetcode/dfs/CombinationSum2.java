package com.leetcode.dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum2 {

    public static void main(String[] args) {
        List<List<Integer>> lists = combinationSum3(1, 0);
        System.out.println(lists);
    }

    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> lists = new ArrayList<>();
        Arrays.sort(candidates);
//        dfs(lists, candidates, target, new ArrayList<Integer>(), 0);
        return new ArrayList<>(lists);
    }

    public static List<List<Integer>> combinationSum3(int k, int n) {
        int[] candidates = new int[9];
        for (int i = 0; i < 9; i++) {
            candidates[i] = i+1;
        }
        List<List<Integer>> lists = new ArrayList<>();
        Arrays.sort(candidates);
        dfs(lists, candidates, n, new ArrayList<Integer>(), 0, k);
        return new ArrayList<>(lists);
    }

    public static void dfs(List<List<Integer>> lists, int[] candidates, int target, List<Integer> path,int index, int k){
        if(target == 0 && path.size() == k){
            lists.add(new ArrayList<Integer>(path));
            return;
        }

        if(target<0 || index>=candidates.length)
            return;
        for(int i=index;i<candidates.length;i++){
            if((i>index && candidates[i]==candidates[i-1]))
                continue;
            path.add(candidates[i]);
            dfs(lists, candidates, target-candidates[i], path, i+1, k);
            path.remove(path.size()-1);
        }
    }
}
