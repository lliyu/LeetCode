package com.leetcode.dynamic;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 给你一个整数数组 nums ，你可以对它进行一些操作。
 *
 * 每次操作中，选择任意一个 nums[i] ，删除它并获得 nums[i] 的点数。之后，你必须删除 所有 等于 nums[i] - 1 和 nums[i] + 1 的元素。
 *
 * 开始你拥有 0 个点数。返回你能通过这些操作获得的最大点数。
 * 示例 1：
 *
 * 输入：nums = [3,4,2]
 * 输出：6
 * 解释：
 * 删除 4 获得 4 个点数，因此 3 也被删除。
 * 之后，删除 2 获得 2 个点数。总共获得 6 个点数。
 * 示例 2：
 *
 * 输入：nums = [2,2,3,3,3,4]
 * 输出：9
 * 解释：
 * 删除 3 获得 3 个点数，接着要删除两个 2 和 4 。
 * 之后，再次删除 3 获得 3 个点数，再次删除 3 获得 3 个点数。
 * 总共获得 9 个点数。
 */
public class DeleteAndEarn {

    public static void main(String[] args) {
        System.out.println(deleteAndEarn(new int[]{1,2,3,15,16,17,18}));
    }

    public static int deleteAndEarn(int[] nums) {
        if(nums.length==1)
            return nums[0];

        Map<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (hashMap.containsKey(nums[i])) {
                hashMap.put(nums[i], hashMap.get(nums[i]) + nums[i]);
            }else {
                hashMap.put(nums[i], nums[i]);
            }
        }

        int[] dp = new int[hashMap.size()+1];
        int index = 1;
        Integer[] integers = hashMap.keySet().toArray(new Integer[hashMap.size()]);
        Arrays.sort(integers);
        for (Integer key : integers) {
            //如果数据都不是连续的 那么所有的直接相加就可以了
            //如果有数据连续  那么直接相加就不可以了 需要将部分去掉
            //状态转移 dp[i] = Math.max(dp[i-1], dp[i-2]+hashMap.get(key));
            if (hashMap.containsKey(key - 1)) {
                if(index>=2){
                    dp[index] = Math.max(dp[index - 1], dp[index - 2] + hashMap.get(key));
                }else {
                    dp[index] = Math.max(dp[index - 1], hashMap.get(key));
                }
            } else {
                dp[index] = dp[index - 1] + hashMap.get(key);
            }
            index++;
        }
        return dp[dp.length-1];
    }
}
