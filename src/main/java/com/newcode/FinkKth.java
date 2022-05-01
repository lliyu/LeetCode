package com.newcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 描述
 * 有一个整数数组，请你根据快速排序的思路，找出数组中第 k 大的数。
 *
 * 给定一个整数数组 a ,同时给定它的大小n和要找的 k ，请返回第 k 大的数(包括重复的元素，不用去重)，保证答案存在。
 * 要求：时间复杂度 O(nlogn)O(nlogn)，空间复杂度 O(1)O(1)
 * 数据范围：0\le n \le 10000≤n≤1000， 1 \le K \le n1≤K≤n，数组中每个元素满足 0 \le val \le 100000000≤val≤10000000
 */
public class FinkKth {

    public static void main(String[] args) {
        LCS("1NY92514w8AF5q1sul7MVNFZnGengc03vO912lFftHDkWpMwWN0SY4pXO1QLji18ujkZV4vr449Wo495WOyIXiO4C9M5L7hQ4tX9ePvV5ohnX00e4mOW28xO968cdR266Ej5M","1NY92514w8AF5q1sul7MVNFZndJq1vh7qx45XOwP1k1M9jsbB3MLc9FFoy825lu0Cs9Bh3Xm84p5C36r6USQrF96W0b05RfF308001LpK89056qQ8517YFj4pM");
    }

    public static String LCS (String str1, String str2) {
        // write code here
        int[][] dp = new int[str1.length()][str2.length()];
        String rnt = "";
        for(int i=0;i<str1.length();i++){
            for(int j=i;j<str2.length();j++){
                if(str1.charAt(i) == str2.charAt(j)){
                    if(i==0 || j==0){
                        dp[i][j] = 1;
                        if(dp[i][j] > rnt.length())
                            rnt = str1.substring(i, i+1);
                        continue;
                    }
                    dp[i][j] = dp[i-1][j-1] + 1;
                    if(dp[i][j] > rnt.length())
                        rnt = str1.substring(i-dp[i][j]+1, i+1);
                }else {
                    dp[i][j] = 0;
                }
            }
        }
        return rnt;
    }

    public static int findKth(int[] a, int n, int K) {
        // write code here
        LinkedList<Integer> nodes = new LinkedList<Integer>();
        int k = partation(a, 0, n-1);
        while(k != (K-1)){
            if(k < (K-1)){
                k = partation(a, k+1, n-1);
            }else {
                k = partation(a, 0, k-1);
            }
        }
        return a[k];
    }

    public static int partation(int[] a, int left, int right){
        int mid = (left+right)/2;
        int pos = a[left];
        while(left < right){
            while(left < right && a[right]>pos)right--;
            a[left] = a[right];
            while(left < right && a[left]<pos)left++;
            a[right] = a[left];
        }
        a[left] = pos;
        return left;
    }
}
