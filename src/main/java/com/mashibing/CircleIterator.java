package com.mashibing;

public class CircleIterator {

    public static void main(String[] args) {
        int[][] nums = {{1,2,3,4}, {5,6,7,8},{9,10,11,12},{13,14,15,16}};
        circleIterator(nums);
    }

    public static void circleIterator(int[][] arr){
        boolean[][] isVisit = new boolean[arr.length][arr[0].length];
        iterator(arr, 1, 0, arr[0].length-1, arr.length-1, 0, isVisit);
    }


    /**
     *
     * @param arr
     * @param index 1，2，3，4分表表示当前的方向 1：右 2：下 3：左 4：上
     * @param l0 向左的起始位置，每一次向左打印一次就加1
     * @param l1 向下的起始位置，每一次向下打印一次就加
     *           1
     * @param r0 向右的起始位置，每一次向右打印一次就加1
     * @param r1 向上的起始位置，每一次向上打印一次就加1
     * @param isVisit 用于记录打印过的区域
     */
    private static void iterator(int[][] arr, int index, int l0, int l1, int r0, int r1, boolean[][] isVisit) {
        int temp = 0;
        switch (index){
            case 1:
                //左
                if(isVisit[l0][l0]){
                    return;
                }
                for(temp=l0;temp<=l1;temp++){
                    System.out.println(arr[l0][temp]);
                    isVisit[l0][temp] = true;
                }
                l0++;
                iterator(arr, 2, l0, l1, r0, r1, isVisit);
                break;
            case 2:
                // 下
                if(isVisit[l0][l1]){
                    return;
                }
                for(temp=l0;temp<=r0;temp++){
                    System.out.println(arr[temp][l1]);
                    isVisit[temp][l1] = true;
                }
                l1--;
                iterator(arr, 3, l0, l1, r0, r1, isVisit);
                break;
            case 3:
                //右
                if(isVisit[r0][l1]){
                    return;
                }
                for(temp=l1;temp>=r1;temp--){
                    System.out.println(arr[r0][temp]);
                    isVisit[r0][temp] = true;
                }
                r0--;
                iterator(arr, 4, l0, l1, r0, r1, isVisit);
                break;
            case 4:
                //上
                if(isVisit[r0][r1]){
                    return;
                }
                for(temp=r0;temp>=l0;temp--){
                    System.out.println(arr[temp][r1]);
                    isVisit[temp][r1] = true;
                }
                r1++;
                iterator(arr, 1, l0, l1, r0, r1, isVisit);
                break;
        }
    }

}
