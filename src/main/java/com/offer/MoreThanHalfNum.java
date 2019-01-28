package com.offer;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * @Auther: Administrator
 * @Date: 2019-01-28 17:20
 * @Description:数组中出现次数超过一半的数字
 */
public class MoreThanHalfNum {

    public static void main(String[] args) throws Exception {
        int[] nums = {1,2,3,4,5,2,2,2,2,2};
        System.out.println(moreThanHalfNum(nums));
    }

    //使用了额外的空间
    public static int moreThanHalfNum1(int[] nums) throws Exception {
        Map<Integer, Integer> map = new HashMap<>();
        for(int num:nums){
            if(map.containsKey(num)){
                map.put(num, map.get(num) + 1);
            }else {
                map.put(num, 1);
            }
        }
        int size = nums.length;
        Set<Integer> integers = map.keySet();
        Iterator<Integer> iterator = integers.iterator();
        while(iterator.hasNext()){
            Integer next = iterator.next();
            if(map.get(next)>(size/2)){
                return next;
            }
        }

        throw new Exception("不存在");
    }

    public static int moreThanHalfNum(int[] nums) {
        int integer=0,count=0;
        for(int num:nums){
            if(count==0){
                integer = num;
            }else if(count>0){
                if(integer==num){
                    count++;
                }else {
                    count--;
                }
            }
        }
        return integer;
    }

}
