package com.leetcode.array;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @Auther: Administrator
 * @Date: 2019-04-29 17:16
 * @Description:
 * 数组arr是[0, 1, ..., arr.length - 1]的一种排列，我们将这个数组分割成几个“块”，并将这些块分别进行排序。之后再连接起来，使得连接的结果和按升序排序后的原数组相同。
 *
 * 我们最多能将数组分成多少块？
 *
 * 示例 1:
 *
 * 输入: arr = [4,3,2,1,0]
 * 输出: 1
 * 解释:
 * 将数组分成2块或者更多块，都无法得到所需的结果。
 * 例如，分成 [4, 3], [2, 1, 0] 的结果是 [3, 4, 0, 1, 2]，这不是有序的数组。
 * 示例 2:
 *
 * 输入: arr = [1,0,2,3,4]
 * 输出: 4
 * 解释:
 * 我们可以把它分成两块，例如 [1, 0], [2, 3, 4]。
 * 然而，分成 [1, 0], [2], [3], [4] 可以得到最多的块数。
 */
public class MaxChunksToSorted {
    public static void main(String[] args) {
//        System.out.println(maxChunksToSorted(new int[]{4,3,2,1,0}));//1 0 2 3 4
//        System.out.println(getMaxNumIndex(new int[]{1,2,4,3}, 0, 3));
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(3);
        Executors.newSingleThreadExecutor();
        executorService.schedule(()->{
            System.out.println("test");
        }, 2, TimeUnit.SECONDS);
        executorService.shutdown();
    }

    public static int maxChunksToSorted(int[] arr) {
        int max = 0;
        int result = 0;
        for(int i = 0;i<arr.length;i++){
            //记录这个区间的最大值
            max = Math.max(max,arr[i]);
            //最大值等于下标，说明这个区间的数升序排序后刚好等于下标
            if(max == i){
                result++;
                max = 0;
            }
        }
        return result;
    }

    public static int maxChunksToSorted1(int[] arr) {
        if(arr.length <= 1)
            return arr.length;
        int count = 0,index;
        int left = 0, right = arr.length-1;
        int leftMax = 0, rightMin = 0;
        while (right >= 0){
            index = getMaxNumIndex(arr, left, right);
            count++;
            if(right == index) {
                right = index-1;
                continue;
            }
            //通过index将数组分为两部分
            //查找前一部分最大值
            leftMax = getMaxNumIndex(arr, 0, index-1);
            //后一部分最小值
            rightMin = getMinNumIndex(arr, index+1, right);
            //如果前一部分最大值大于后一部分最小值则从前一部分最大值处划分
            if(arr[leftMax]>arr[rightMin]){
                right = leftMax-1;
            }else if(arr[leftMax]>arr[rightMin]){
                right = index-1;
            }
        }
        return count;
    }

    public static int getMaxNumIndex(int[] arr, int left, int right){
        int max = left;
        for(int i=left+1;i<=right;i++){
            if(arr[i]>arr[max])
                max = i;
        }
        return max;
    }

    public static int getMinNumIndex(int[] arr, int left, int right){
        int min = left;
        for(int i=left+1;i<=right;i++){
            if(arr[i]<arr[min])
                min = i;
        }
        return min;
    }
}
