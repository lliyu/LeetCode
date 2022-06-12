package com.leetcode.math;

import com.google.common.collect.Maps;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class Next {

    public static void main(String[] args) {
        Next next = new Next(new int[]{50,1,2,3});

        HashMap<Integer, Integer> nums = Maps.newHashMap();
        for (int i = 0; i < 100000; i++) {
            int res = next.pickIndex();
            nums.put(res, nums.getOrDefault(res, 0)+1);
        }
        int sum = nums.values().stream().mapToInt(Integer::intValue).sum();
        nums.keySet().stream().sorted().forEach(key -> {
            System.out.println(key + ":" + (nums.get(key)/(sum*1.0)));
        });
    }

    // 桶编号 / 桶内编号 / 总数
    int bid, iid, tot;
    List<int[]> list = new ArrayList<>();
    public Next(int[] w) {
        int n = w.length;
        double sum = 0, min = Double.MAX_VALUE;
        for (int i : w) {
            sum += i;
            min = Math.min(min, i); //找出数组中最小的数字
        }
        double minv = min / sum;
        int k = 1;
        while (minv * k < 1) k *= 10;
        for (int i = 0; i < n; i++) {
            int cnt = (int)(w[i] / sum * k);
            list.add(new int[]{i, cnt});
            tot += cnt;
        }
    }

    public int pickIndex() {
        if (bid >= list.size()) {
            bid = 0; iid = 0;
        }
        int[] info = list.get(bid);
        int id = info[0], cnt = info[1];
        if (iid >= cnt) {
            bid++; iid = 0;
            return pickIndex();
        }
        iid++;
        return id;
    }
}
