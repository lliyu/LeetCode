package com.offer;

/**
 * @Auther: Administrator
 * @Date: 2019-01-14 14:53
 * @Description:打印从 1 到最大的 n 位数
 * 输入数字 n，按顺序打印出从 1 到最大的 n 位十进制数。比如输入 3，则打印出 1、2、3 一直到最大的 3 位数即 999。
 */
public class Print1ToMaxOfNDigits {

    public static void main(String[] args) {
        print1ToMaxOfNDigits(1);
    }

    public static void print1ToMaxOfNDigits(int len){
        StringBuilder sb = new StringBuilder("9");
        while(sb.length() <= len){
            int length = sb.length();
            for(int i=0;i<length;i++){
                char c = sb.toString().charAt(i);
                int res = c - '0' + 1;
                if(res == 10){

                }else {
                    
                }
            }
        }
    }
}
