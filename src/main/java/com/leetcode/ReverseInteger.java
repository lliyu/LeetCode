package com.leetcode;

public class ReverseInteger {

    public static void main(String[] args) {
        int x = 100;
        System.out.println(reverse2(-2147483412));
    }

    private static int reverse(int x) {
        boolean flag = false;
        if(x<0){
            x = x*-1;
            flag = true;
        }
        String num = x + "";
        int len = num.length() - 1;
        int temp = 0;
        long reverse = 0;
        while(len>=0){
            temp = x%10;
            x = x/10;
            if((len == num.length()-1) && temp==0){
                len--;
                continue;
            }
            int test = (int)Math.pow(10,len);
            reverse = reverse+ (temp * test);
            if((reverse < test) && temp != 0){
                return 0;
            }
            if((reverse > Integer.MAX_VALUE) || reverse<0){
                return 0;
            }
            len--;
        }
        if(flag){
            reverse = reverse * -1;
        }
        return (int)reverse;

    }


    public static int reverse2(int x){
        boolean flag = false;
        if(x<0){
            x = x*-1;
            flag = true;
        }
        int temp = 0;
        long reverse = 0;
        String num = x + "";
        int len = num.length() - 1;
        while(len>=0){
            temp = x%10;
            x = x/10;
            if(reverse > ((Integer.MAX_VALUE-temp)/10)){
                return 0;
            }
            reverse = reverse*10+ temp;
            len--;
        }
        if(flag){
            reverse = reverse * -1;
        }
        return (int)reverse;
    }
}
