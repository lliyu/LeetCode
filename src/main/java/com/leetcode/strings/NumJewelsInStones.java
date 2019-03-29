package com.leetcode.strings;

import java.math.BigDecimal;

/**
 * @Auther: Administrator
 * @Date: 2019-03-27 15:46
 * @Description:
 *  给定字符串J 代表石头中宝石的类型，和字符串 S代表你拥有的石头。 S 中每个字符代表了一种你拥有的石头的类型，你想知道你拥有的石头中有多少是宝石。
 *
 * J 中的字母不重复，J 和 S中的所有字符都是字母。字母区分大小写，因此"a"和"A"是不同类型的石头。
 *
 * 示例 1:
 *
 * 输入: J = "aA", S = "aAAbbbb"
 * 输出: 3
 * 示例 2:
 *
 * 输入: J = "z", S = "ZZ"
 * 输出: 0
 * 注意:
 * S 和 J 最多含有50个字母。
 *  J 中的字符不重复。
 */
public class NumJewelsInStones {

    public static void main(String[] args) {
//        System.out.println(numJewelsInStones("z", "ZZ"));
        BigDecimal bigDecimal = new BigDecimal(20);
        BigDecimal bigDecimal1 = new BigDecimal(254);
        System.out.println(bigDecimal.compareTo(bigDecimal1));
    }

    public static int numJewelsInStones(String J, String S) {
        char[] Jchars = J.toCharArray();
        char[] Schars = S.toCharArray();
        int count = 0;
        for(int i=0;i<Jchars.length;i++){
            for(int j=0;j<Schars.length;j++){
                if(Jchars[i] == Schars[j]){
                    count++;
                }
            }
        }
        return count;
    }
}
