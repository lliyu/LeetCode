package com.offer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Auther: Administrator
 * @Date: 2019-01-25 14:53
 * @Description: 输入一个字符串，按字典序打印出该字符串中字符的所有排列。例如输入字符串 abc，则打印出由字符 a, b, c 所能排列出来的所有字符串 abc, acb, bac, bca, cab 和 cba。
 */
public class Permutation {

    private static List<List<Integer>> lists = new ArrayList<>();

    public static void main(String[] args) {
        String str = "123";
        permute(new int[]{1,2,3}, 0, 3);
        System.out.println(lists);
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

    private static void permute(int[] chs, int k, int m) {
        if (k == m) {
            List<Integer> integers = new ArrayList<>();
            Arrays.stream(chs).forEach(ch -> integers.add(ch));
            lists.add(integers);

        } else {
            for (int j = k; j < m; j++) {
                swap1(chs, j, k);
                permute(chs, k + 1, m);
                swap1(chs, j, k);
            }
        }
    }

    private static void swap1(int[] chs, int j, int k) {
        int ch = chs[j];
        chs[j] = chs[k];
        chs[k] = ch;
    }

}
