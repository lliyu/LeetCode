package com.offer.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * 给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。
 *
 * 例如，给出 n = 3，生成结果为：
 *
 * [
 *   "((()))",
 *   "(()())",
 *   "(())()",
 *   "()(())",
 *   "()()()"
 * ]
 */
public class GenerateParenthesis {

    public static void main(String[] args) {
        GenerateParenthesis generateParenthesis = new GenerateParenthesis();
        System.out.println(generateParenthesis.generateParenthesis(3));
    }

    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        backTrace(res, "", 0, 0, n);
        return res;
    }

    /**
     *
     * @param res
     * @param str 生成的串
     * @param left 生成的串中左括号的数量
     * @param right 生成的串中右括号的数量
     * @param len
     */
    private void backTrace(List<String> res, String str, int left, int right, int len) {
        if(str.length() == 2*len){
            //生成了一个新串
            res.add(str);
            return;
        }else {
            if(left<len){
                backTrace(res, str+"(", left+1, right, len);
            }

            //这里为了保证生成的括号串有效
            //必须要保证右括号的数量小于左括号
            //注意这一句的意思是左括号任何时候都大于等于右括号数量  所以肯定是有效的
            if(right<left){
                backTrace(res, str+")", left, right+1, len);
            }
        }
    }
}
