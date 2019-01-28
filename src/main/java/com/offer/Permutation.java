package com.offer;

/**
 * @Auther: Administrator
 * @Date: 2019-01-25 14:53
 * @Description: 输入一个字符串，按字典序打印出该字符串中字符的所有排列。例如输入字符串 abc，则打印出由字符 a, b, c 所能排列出来的所有字符串 abc, acb, bac, bca, cab 和 cba。
 */
public class Permutation {

    public static void main(String[] args) {
        String str = "abc";
        permutation(str.toCharArray(), 0, str.length());
    }

    private static void permutation(char[] chs, int k, int m) {
        if (k == m) {
            System.out.println(chs);
        } else {
            for (int j = k; j < m; j++) {
                swap(chs, j, k);
                permutation(chs, k + 1, m);
                swap(chs, j, k);
            }
        }
    }

    private static void swap(char[] chs, int j, int k) {
        char ch = chs[j];
        chs[j] = chs[k];
        chs[k] = ch;
    }

}
