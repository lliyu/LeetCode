package com.leetcode.array;

import java.util.*;
import java.util.stream.Collectors;

public class TopKFrequent {

    public int[] topKFrequent1(int[] nums, int k) {
        Map<Integer, Integer> numsMap = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            numsMap.put(nums[i], numsMap.getOrDefault(nums[i], 0)+1);
        }
        Set<Integer> keys = numsMap.entrySet()
                .stream()
                .sorted(Map.Entry.<Integer,Integer>comparingByValue().reversed())
                .limit(k)
                .map(Map.Entry::getKey)
                .collect(Collectors.toSet());

        int[] rnt = new int[keys.size()];
        Iterator<Integer> iterator = keys.iterator();
        int index = 0;
        while (iterator.hasNext()){
            Integer next = iterator.next();

            rnt[index++] = next;
        }

        return rnt;
    }


    public int[] topKFrequent(int[] nums, int k) {

        int[] rnt = new int[k];
        Map<Integer, Integer> numsMap = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            numsMap.put(nums[i], numsMap.getOrDefault(nums[i], 0)+1);
        }
        //定义小根堆 注意这里虽然是求前k个最大出现次数的 但是不能使用大根堆
        //如果是大根堆比较难将小的值弹出
        //将值和出现次数作为一个整体
        PriorityQueue<Map.Entry<Integer, Integer>> queue
                = new PriorityQueue<>((o1, o2) -> o1.getValue() - o2.getValue());

        Set<Map.Entry<Integer, Integer>> entries = numsMap.entrySet();
        for (Map.Entry<Integer, Integer> entry : entries){
            queue.offer(entry);
            if(queue.size()>k) queue.poll();
        }
        int size = queue.size();
        for(int i=0;i<size;i++){
            rnt[i] = queue.poll().getKey();
        }
        return rnt;
    }
}

class Pair {
    int key;
    int value;
}
