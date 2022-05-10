package com.leetcode.array.graph;

import java.util.*;

public class CanFinish {

    public static void main(String[] args) {
        CanFinish canFinish = new CanFinish();
        System.out.println(canFinish.canFinish(2, new int[][]{{0, 1}}));
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // 这道题其实就是判断是否为dag 
        // 只要没有环那么一定是可以修完的
        Map<Integer, List<Integer>> graph = new HashMap<>(); // 记录图中每个节点已经节点下游
        for(int i=0 ;i<numCourses; i++) {
            graph.put(i, new ArrayList<>());
        }
        int[] ingress = new int[numCourses];//用于记录每一个课程的入度数
        for(int i=0; i<prerequisites.length; i++) {
            //这里一定要注意 graph中存的是key可以作为哪些课程的前置
            // 这样没删除一条边的时候，直接ingress[value]-- 即可
            graph.get(prerequisites[i][1]).add(prerequisites[i][0]);
            ingress[prerequisites[i][0]]++;
        }

        //上面已经准备好了所有课程的前置课程
        // 找出没有前置课程的课程 也就是value为空的课程
        LinkedList<Integer> queue = new LinkedList<>();
        for (int i = 0; i < ingress.length; i++) {
            if (ingress[i] == 0)
                queue.add(i);
        }
        // 所有入度为0的都已经找出来了
        // 从入度为0的开始进行遍历，依次的删除边
        while (!queue.isEmpty()) {
            Integer key = queue.poll();
            for (int cur : graph.get(key)) {
                if (--ingress[cur]==0) {
                    queue.add(cur);
                }
            }
        }
        //判断ingress表是否全部归零了
        for (int i = 0; i < ingress.length; i++) {
            if (ingress[i]!=0) return false;
        }
        return true;
    }
}
