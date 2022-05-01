package com.mashibing.zcy;

public class KMP {

    public static void main(String[] args) {
        String str = "abababca";
        System.out.println(strStr("abcdefga", "ababacd"));
    }

    public static int strStr(String haystack, String needle) {

        if("".equals(needle))
            return 0;
        if(haystack.length() < needle.length())
            return -1;

        int[] next = kmp(needle);
        int i=0,j=0;

        while(i<haystack.length() && j<needle.length()){
            if(haystack.charAt(i) == needle.charAt(j)){
                i++;j++;
            }else {
                //不等 需要通过kmp判断
                if(next[j] == -1){
                    i++;
                }else {
                    j = next[j];
                }
            }
        }

        return j==needle.length()?i-j:-1;
    }

    public static int[] kmp(String str){
        if(str.length() == 1)
            return new int[]{-1};
        else if(str.length() == 2){
            return new int[]{-1, 0};
        }

        int[] lens = new int[str.length()];
        lens[0] = -1;
        lens[1] = 0;

        int curent = 0; //表示当前最大已经找到的最长前缀和后缀的长度
        int pos = 2;//前两个值已经定了

        while(pos < str.length()){
            //首先对于计算一个字符串中每一个位置前的最大前缀和后缀的长度需要明确的是
            //1。计算第n个时，只计算n-1的长度，即第n个字符本身不参与计算
            //2。长度最开始都是从0开始的，慢慢增长  可能出现减小的情况  但是增长只可能一个一个涨
            if(str.charAt(pos-1) == str.charAt(curent)){
                //当前一位的value和预期应该比较的值相等时表示可以在之前一位长度上加一
                //比如：对于abacd字符串  现在在第四个位置查找到0：a和2：a相等呢，最大长度1 那么下一位理论上应该是(0+1)和(2+1)比较才有意义
                lens[pos++] = ++curent;
            }else if(curent > 0){
                //不相等时就表示增长断掉了
                //current所在的位置是当前已经比对过相等的字符串的后一位
                //现在相等的断掉了  那么current所在的位置
                curent = lens[curent];
            }else {
                //current<=0的情况就是没办法找出相等的前后缀了
                lens[pos++] = 0;
            }
        }

        return lens;
    }
}
