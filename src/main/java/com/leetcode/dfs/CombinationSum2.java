package com.leetcode.dfs;

import java.util.*;

public class CombinationSum2 {

    public static void main(String[] args) {
        List<List<Integer>> lists = combinationSum3(1, 0);
        System.out.println(lists);
    }

    private Set<List<Integer>> rnt = new HashSet<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        backtrace(candidates, target, new ArrayList<>(), 0);
        return new ArrayList<>(rnt);
    }

    public void backtrace(int[] candidates, int target, List<Integer> path, int index) {
        if(target == 0){
            rnt.add(new ArrayList<>(path));
            return;
        }
        if(target < 0 || index==candidates.length) return;

        for(int i=index; i<candidates.length; i++) {
            if(i>index && candidates[i]==candidates[i-1]) continue; // 剪枝
            path.add(candidates[i]);
            backtrace(candidates, target-candidates[i], path, i+1);
            path.remove(path.size()-1);
        }
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
