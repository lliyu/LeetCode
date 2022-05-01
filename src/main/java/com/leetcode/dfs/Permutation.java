package com.leetcode.dfs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Permutation {

    public static void main(String[] args) {
        String[] strings = permutation("abb");
        for (String str : strings) {
            System.out.println(str);
        }
    }

    public static String[] permutation(String S) {

        if(S==null || S.length()==0)
            return null;
        Set<String> lists = new HashSet<>();
        boolean[] visited = new boolean[S.length()];
        StringBuilder sb = new StringBuilder();
        backtrace(S,visited, lists, sb, 0);

        return lists.toArray(new String[lists.size()]);
    }

    private static void backtrace(String s, boolean[] visited, Set<String> lists, StringBuilder sb, int index) {
        if(s.length() == sb.length()){
            lists.add(new String(sb));
            return;
        }

        for (int i = 0; i < s.length(); i++) {
//            if(i>0 && s.charAt(i) == s.charAt(i-1))
//                continue;

            if(visited[i])
                continue;
            sb.append(s.charAt(i));
            visited[i] = true;
            backtrace(s, visited, lists, sb, i+1);
            sb.deleteCharAt(sb.length()-1);
            visited[i] = false;
        }
    }


}
