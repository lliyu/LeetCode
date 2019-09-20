package com.leetcode.strings;

/**
 * 给定一个字符串 (s) 和一个字符模式 (p) ，实现一个支持 '?' 和 '*' 的通配符匹配。
 *
 * '?' 可以匹配任何单个字符。
 * '*' 可以匹配任意字符串（包括空字符串）。
 * 两个字符串完全匹配才算匹配成功。
 *
 * 说明:
 *
 * s 可能为空，且只包含从 a-z 的小写字母。
 * p 可能为空，且只包含从 a-z 的小写字母，以及字符 ? 和 *。
 * 示例 1:
 *
 * 输入:
 * s = "aa"
 * p = "a"
 * 输出: false
 * 解释: "a" 无法匹配 "aa" 整个字符串。
 * 示例 2:
 *
 * 输入:
 * s = "aa"
 * p = "*"
 * 输出: true
 * 解释: '*' 可以匹配任意字符串。
 * 示例 3:
 *
 * 输入:
 * s = "cb"
 * p = "?a"
 * 输出: false
 * 解释: '?' 可以匹配 'c', 但第二个 'a' 无法匹配 'b'。
 * 示例 4:
 *
 * 输入:
 * s = "adceb"
 * p = "*a*b"
 * 输出: true
 * 解释: 第一个 '*' 可以匹配空字符串, 第二个 '*' 可以匹配字符串 "dce".
 * 示例 5:
 *
 * 输入:
 * s = "acdcb"
 * p = "a*c?b"
 * 输入: false
 */
public class IsMatch {

    public static void main(String[] args) {
        IsMatch match = new IsMatch();
        System.out.println(match.isMatch("acdcb", "*a*b"));
    }

    public boolean isMatch1(String s, String p) {
        p = trim(p);
        return match(s, p);
    }

    private boolean match(String s, String p) {
        //如果传入的字符串都为空 表示前面的都匹配了
        //返回true
        if(s.length()==0 && p.length()==0)
            return true;

        //如果传入的p=* 那么不管s的值是什么都能匹配成功
        //返回true
        if(p.length()==1 && p.equals("*"))
            return true;

        //如果传入的p="" 而s的值不为空 匹配失败
        //返回false
        if(p.length()==0 && s.length()>0)
            return false;

        //如果传入的s="" 而p的值不为空 匹配失败 这里p=“*”的情况已经去除
        //返回false
        if(s.length()==0 && p.length()>0)
            return false;

        //开始匹配
        //如果p的 第一位为* 则先跳过匹配后面的字符
        int i = 0;
        if(p.charAt(0)=='*')
            for(i=0;i<s.length();i++){
                if(p.charAt(i+1)!=s.charAt(i) && p.charAt(i+1)!='?')
                    continue;
                //到这里就表示字符匹配了 那么前面的字符就是*匹配的
            }


        return false;
    }


    /**
     * 将模式中的连续的*替换为一个
     * @param pattern
     * @return
     */
    public String trim(String pattern){
        return pattern.replaceAll("\\*+", "*");
    }

    /**
     * 动态规划
     * @param s
     * @param p
     * @return
     */
    public boolean isMatch(String s, String p) {

//        //初始化
//        //dp[i][j]表示字符串s从0-i和字符串p从0-j是否匹配
//        boolean[][] dp = new boolean[s.length()][p.length()];
//
//        if(s.charAt(0)==p.charAt(0) || p.charAt(0)=='?' || p.charAt(0)=='*')
//            dp[0][0] = true;
//
//        for(int i=1;i<p.length();i++){
//            dp[0][i] = dp[0][i-1] && p.charAt(i)=='*';
//        }
//
//        //状态转移方程
//        for(int i=1;i<s.length();i++){
//            for (int j = 1; j < p.length(); j++) {
//                if(p.charAt(j)=='*')
//                    //如果这里p[j]匹配空串 那么dp[i][j]=dp[i][j-1]
//                    dp[i][j] = dp[i][j-1] || dp[i-1][j];
//
//                if(s.charAt(i)==p.charAt(j) || p.charAt(j)=='?') {
//                    dp[i][j] = dp[i-1][j-1];
//                }
//            }
//        }
//
//        return dp[s.length()-1][p.length()-1];

        //初始化
        //dp[i][j]表示字符串s从0-i和字符串p从0-j是否匹配
        boolean[][] dp = new boolean[s.length()+1][p.length()+1];

//        if(s.charAt(0)==p.charAt(0) || p.charAt(0)=='?' || p.charAt(0)=='*')
            dp[0][0] = true;

        for(int i=1;i<=p.length();i++){
            dp[0][i] = dp[0][i-1] && p.charAt(i-1)=='*';
        }

        //状态转移方程
        for(int i=1;i<=s.length();i++){
            for (int j = 1; j <= p.length(); j++) {
                if(p.charAt(j-1)=='*')
                    //如果这里p[j]匹配空串 那么dp[i][j]=dp[i][j-1]
                    dp[i][j] = dp[i][j-1] || dp[i-1][j];

                if(s.charAt(i-1)==p.charAt(j-1) || p.charAt(j-1)=='?') {
                    dp[i][j] = dp[i-1][j-1];
                }
            }
        }

        return dp[s.length()][p.length()];
    }


}
