package com.leetcode.strings;

/**
 * 165. 比较版本号
 * https://leetcode-cn.com/problems/compare-version-numbers/
 * 给你两个版本号 version1 和 version2 ，请你比较它们。
 * 版本号由一个或多个修订号组成，各修订号由一个 '.' 连接。每个修订号由 多位数字 组成，可能包含 前导零 。每个版本号至少包含一个字符。修订号从左到右编号，下标从 0 开始，最左边的修订号下标为 0 ，下一个修订号下标为 1 ，以此类推。例如，2.5.33 和 0.1 都是有效的版本号。
 * 比较版本号时，请按从左到右的顺序依次比较它们的修订号。比较修订号时，只需比较 忽略任何前导零后的整数值 。也就是说，修订号 1 和修订号 001 相等 。如果版本号没有指定某个下标处的修订号，则该修订号视为 0 。例如，版本 1.0 小于版本 1.1 ，因为它们下标为 0 的修订号相同，而下标为 1 的修订号分别为 0 和 1 ，0 < 1 。
 * 返回规则如下：
 * 如果 version1 > version2 返回 1，
 * 如果 version1 < version2 返回 -1，
 * 除此之外返回 0。
 *  
 * 示例 1：
 * 输入：version1 = "1.01", version2 = "1.001"
 * 输出：0
 * 解释：忽略前导零，"01" 和 "001" 都表示相同的整数 "1"
 * 示例 2：
 * 输入：version1 = "1.0", version2 = "1.0.0"
 * 输出：0
 * 解释：version1 没有指定下标为 2 的修订号，即视为 "0"
 * 示例 3：
 * 输入：version1 = "0.1", version2 = "1.1"
 * 输出：-1
 * 解释：version1 中下标为 0 的修订号是 "0"，version2 中下标为 0 的修订号是 "1" 。0 < 1，所以 version1 < version2
 */
public class CompareVersion {

    public static void main(String[] args) {
        System.out.println(Integer.valueOf("0001"));
    }

    /**
     * 题目思路很简单 就是普通的比较即可
     * @param version1
     * @param version2
     * @return
     */
    public int compareVersion(String version1, String version2) {
        String[] version1Num = version1.split("\\.");
        String[] version2Num = version2.split("\\.");
        int len = Math.max(version1Num.length, version2Num.length);
        String str1 = "";
        String str2 = "";
        for(int i=0; i<len; i++) {
            if (i<version1Num.length) str1 = version1Num[i];
            if (i<version2Num.length) str2 = version2Num[i];
            // 字符串比较 首先处理零
            int j = 0; int k = 0;
            // 通过两个索引来记录非零开始的为止
            for(j=0; j<str1.length(); j++) {
                if (str1.charAt(j) != '0') break;
            }
            for(k=0; k<str2.length(); k++) {
                if (str2.charAt(k) != '0') break;
            }
            // 从这里开始都是非零的 所以可以通过简单的比较剩余长度即可
            // 长的一定更大
            if ((str1.length()-j) > (str2.length()-k)) return 1;
            else if ((str1.length()-j) < (str2.length()-k)) return -1;
            // 到这一步就证明两个字符串非零部分长度一样 那就只能比较值来
            while(j<str1.length() && k<str2.length()){
                if ((str1.charAt(j) - str2.charAt(k)) > 0) return 1;
                else if ((str1.charAt(j) - str2.charAt(k)) < 0) return -1;
                j++;k++;
            }
            // 这里需要将字符串清空 因为存在可能其中一个字符串长度小于另一个的情况
            str1 = "";
            str2 = "";
        }
        return 0;
    }
}
