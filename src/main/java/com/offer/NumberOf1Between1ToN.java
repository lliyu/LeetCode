package com.offer;

import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: Administrator
 * @Date: 2019-01-30 09:45
 * @Description:
 */
public class NumberOf1Between1ToN {
    public static void main(String[] args) {

    }

    public int find1Num(int n){
        if(n<1)
            return 0;
        //用于记录位数和从1到该位数的最大值之间1的数量
        Map<Integer, Integer> map = new HashMap<>();
        map.put(1, 1);

        int count = 1;
        int num1Count = 0;
        while(n>=10){
            n = n/10;
            count++;
        }

        double pow = Math.pow(10, count - 1);

        for(int i=2;i<=count-1;i++){
            int res = (int) (map.get(i-1)*10 + Math.pow(map.get(i-1), i-1));
            map.put(i, res);
        }



        return 0;
    }
}
