package com.leetcode.math;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: Administrator
 * @Date: 2019-04-26 16:28
 * @Description:
 * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
 * 示例:
 * 输入: n = 4, k = 2
 * 输出:
 * [
 *   [2,4],
 *   [3,4],
 *   [2,3],
 *   [1,2],
 *   [1,3],
 *   [1,4],
 * ]
 */
public class NumCombine {

    public static void main(String[] args) {
        System.out.println(combine(4,2));
    }

    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> lists = new ArrayList<>();
        for(int i=1;i<=n-k+1;i++){
            for(int j=i,r=1;j<=n&&r<=k;j++,r++){
                List<Integer> temp = new ArrayList<>();
                temp.add(i);
                for(int p=j+1;p<j+k;p++)
                    temp.add(p);
                lists.add(temp);
            }
        }
        return lists;
    }
}
