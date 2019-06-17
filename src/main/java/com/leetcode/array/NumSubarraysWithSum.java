package com.leetcode.array;

import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: Administrator
 * @Date: 2019-06-14 13:47
 * @Description: 930
 * 在由若干 0 和 1  组成的数组 A 中，有多少个和为 S 的非空子数组。
 * 示例：
 * 输入：A = [1,0,1,0,1], S = 2
 * 输出：4
 * 解释：
 * 如下面黑体所示，有 4 个满足题目要求的子数组：
 * [1,0,1,0,1]
 * [1,0,1,0,1]
 * [1,0,1,0,1]
 * [1,0,1,0,1]
 */
public class NumSubarraysWithSum {

    public static void main(String[] args) {
        System.out.println(numSubarraysWithSum(new int[]{1,0,1,0,1},0));
    }


    public static int numSubarraysWithSum(int[] A, int S) {
        Map<Integer,Integer> map=new HashMap<>();
        int sum=0;
        int count=0;
        map.put(0,1);
        for(int i=0;i<A.length;i++){
            sum+=A[i];
            map.putIfAbsent(sum,0);
            map.put(sum,map.get(sum)+1);
        }
        for(int key:map.keySet()){
            if(map.containsKey(key-S)){
                if(S==0){
                    count=(map.get(key)*(map.get(key)-1))/2;
                } else
                    count=count+(map.get(key)*map.get(key-S));
            }
        }
        return count;
    }

    //动态规划 内存超出限制
    //2w长度的数组构造dp数组内存消耗大概2g 同时会超时
    public static int numSubarraysWithSum1(int[] A, int S) {
        int[][] dp = new int[A.length][A.length];//dp[i][j]表示从A[i]到A[j]的和
        int count = 0;
        for (int i = 0; i < A.length; i++) {
            for (int j = i; j < A.length; j++) {
                dp[i][j] = (j>0?dp[i][j-1]:0) + A[j];
                if(dp[i][j]==S)count++;
            }
        }
        return count;
    }

    //暴力 超时
    public static int numSubarraysWithSum2(int[] A, int S) {
        int count = 0;
        int sum = 0;
        for (int i = 0; i < A.length; i++) {
            sum = 0;
            for (int j = i; j < A.length; j++) {
                sum += A[j];
                if(sum == S)
                    count++;
            }
        }
        return count;
    }
}
