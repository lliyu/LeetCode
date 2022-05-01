package com.leetcode.strings;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

    private Map<Integer, Integer> maps = new HashMap<>();

    private int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        if(!maps.containsKey(key)) return -1;
        Integer value = maps.get(key);
        afterUseOperation(key);
        return value;
    }

    private void afterUseOperation(int key) {

    }

    public void put(int key, int value) {

    }
}
