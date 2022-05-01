package com.offer;

/**
 * 给定一个数据arr和一个数字m
 * 求arr的子序列中和m取模可以得到的最大值
 */
public class SubSeqSum {

    public int subSeqSum(int[] arr, int m){

        int max = 0;
        for (int i = 0; i < arr.length; i++) {

            int mod = arr[i] % m;
            //判断当前mod和max和 取模是否大于max
            if((mod + max) > m){
                //重新取模
                max = Math.max((mod+max)%m, max);
            }else {
                max = Math.max(mod+max, max);
            }

            //然后判断mod和max的值
            max = Math.max(mod,max);

        }

        return max;
    }

    public static void main(String[] args) {
        SubSeqSum subSeqSum = new SubSeqSum();
        System.out.println(subSeqSum.subSeqSum(new int[]{5,1,2, 1}, 5));
    }
}
