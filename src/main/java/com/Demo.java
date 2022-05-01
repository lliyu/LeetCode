package com;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Demo {
    public static void main(String[] args) {
//        Demo demo = new Demo();
//        demo.isOdd(1);
//        demo.isOdd1(1);
//
//        GetLeastNumbers_Solution(new int[]{4,5,1,6,2,7,3,8}, 4);

    }

    public static ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
        for(int i=0;i<input.length; i++){
            if(queue.size() == k){
                if(queue.peek()>input[i]){
                    queue.poll();
                    queue.add(input[i]);
                }
            }else {
                queue.add(input[i]);
            }
        }

        ArrayList<Integer> lists = new ArrayList<>();
        while(!queue.isEmpty()){
            lists.add(queue.poll());
        }
        return lists;
    }

    public boolean isOdd(int num) {
        return num % 2 != 0;
    }

    public boolean isOdd1(int num) {
        return (num & 1) == 1;
    }
}
