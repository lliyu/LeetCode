package com.offer;

import java.io.File;

/**
 * @Auther: Administrator
 * @Date: 2019-01-14 14:53
 * @Description: 打印从 1 到最大的 n 位数
 * 输入数字 n，按顺序打印出从 1 到最大的 n 位十进制数。比如输入 3，则打印出 1、2、3 一直到最大的 3 位数即 999。
 */
public class Print1ToMaxOfNDigits {

    public static void main(String[] args) {
        print1ToMaxOfNDigits(2);
    }

    public static void print1ToMaxOfNDigits(int len){
        char[] chars = new char[len];
        chars[len-1] = '0';
        boolean falg = true;
        while(falg){
            chars[len-1] = (char)(chars[len-1]+1);
            if(chars[len-1] == 58){
                chars[len-1] = '0';
                int temp = len - 2;
                if(temp<0)falg=false;
                while(temp>=0){
                    if(chars[temp]>58 || chars[temp]<48){
                        chars[temp] = '1';
                    }else {
                        chars[temp] = (char)(chars[temp]+1);
                    }
                    if(chars[temp]==58){
                        chars[temp] = '0';
                        temp--;
                        if(temp<0)
                            falg=false;
                    }else {
                        break;
                    }
                }
            }
            if(falg){
                System.out.println(chars);
            }
        }
    }
}
