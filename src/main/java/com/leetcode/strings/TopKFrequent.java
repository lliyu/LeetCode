package com.leetcode.strings;

import java.util.*;

/**
 * @Auther: Administrator
 * @Date: 2019-05-29 15:58
 * @Description: 前K个高频单词
 * 给一非空的单词列表，返回前 k 个出现次数最多的单词。
 *
 * 返回的答案应该按单词出现频率由高到低排序。如果不同的单词有相同出现频率，按字母顺序排序。
 *
 * 示例 1：
 *
 * 输入: ["i", "love", "leetcode", "i", "love", "coding"], k = 2
 * 输出: ["i", "love"]
 * 解析: "i" 和 "love" 为出现次数最多的两个单词，均为2次。
 *     注意，按字母顺序 "i" 在 "love" 之前。
 *
 *
 * 示例 2：
 *
 * 输入: ["the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"], k = 4
 * 输出: ["the", "is", "sunny", "day"]
 * 解析: "the", "is", "sunny" 和 "day" 是出现次数最多的四个单词，
 *     出现次数依次为 4, 3, 2 和 1 次。
 *
 *
 * 注意：
 *
 * 假定 k 总为有效值， 1 ≤ k ≤ 集合元素数。
 * 输入的单词均由小写字母组成。
 *
 *
 * 扩展练习：
 *
 * 尝试以 O(n log k) 时间复杂度和 O(n) 空间复杂度解决。
 */
public class TopKFrequent {

    public static void main(String[] args) {
        List<Integer> list = new LinkedList<>();
        System.out.println(list.indexOf(1));
        System.out.println(topKFrequent(new int[]{1,1,1,2,2,3}, 2));
    }


    public static List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> maps = new HashMap<>();
        for(String str:words){
            maps.put(str,maps.getOrDefault(str,0)+1);
        }

        //放入自定义排序的优先队列中
        PriorityQueue<Map.Entry<String, Integer>> queue = new PriorityQueue<>(new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                if (o1.getValue() == o2.getValue()) {
                    return o1.getKey().compareTo(o2.getKey());
                }
                return o2.getValue() - o1.getValue();//如果想实现小根堆可以o1.getValue()-o2.getValue()
            }
        });

        queue.addAll(maps.entrySet());
        List<String> list = new LinkedList<>();
        for(int i=0;i<k;i++){
            list.add(queue.poll().getKey());
        }
        return list;
    }

    public static List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> maps = new HashMap<>();
        for(Integer num:nums){
            maps.put(num,maps.getOrDefault(num,0)+1);
        }

        //放入自定义排序的优先队列中
        PriorityQueue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<>(new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o2.getValue() - o1.getValue();//如果想实现小根堆可以o1.getValue()-o2.getValue()
            }
        });

        queue.addAll(maps.entrySet());
        List<Integer> list = new LinkedList<>();
        for(int i=0;i<k;i++){
            list.add(queue.poll().getKey());
        }
        return list;
    }


}
