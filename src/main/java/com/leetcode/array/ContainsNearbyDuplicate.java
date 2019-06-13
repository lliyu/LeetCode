package com.leetcode.array;

import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: Administrator
 * @Date: 2019-06-03 16:16
 * @Description:
 */
public class ContainsNearbyDuplicate {
    public static void main(String[] args) {
        System.out.println(containsNearbyDuplicate(new int[]{1,2,3,1,2,3}, 2));
    }

    public static boolean containsNearbyDuplicate1(int[] nums, int k) {
        for(int i=0;i<nums.length;i++){
            for(int j=nums.length-1;j>i;j--){
                if(nums[i] == nums[j]){
                    if((j-i)<=k)
                        return true;
                }
            }
        }
        return false;
    }

    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> maps = new HashMap<>(nums.length);
        for(int i=0;i<nums.length;i++){
            if(!maps.containsKey(nums[i])){
                maps.put(nums[i], i);
            }else if((i - maps.get(nums[i]) <= k)) {
                return true;
            }else {
                maps.put(nums[i], i);
            }
        }
        return false;
    }

}
