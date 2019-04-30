package com.leetcode.array;


import java.util.*;

/**
 * @Auther: Administrator
 * @Date: 2018-12-04 09:35
 * @Description:
 * 在二维空间中有许多球形的气球。对于每个气球，提供的输入是水平方向上，气球直径的开始和结束坐标。由于它是水平的，所以y坐标并不重要，因此只要知道开始和结束的x坐标就足够了。开始坐标总是小于结束坐标。平面内最多存在104个气球。
 *
 * 一支弓箭可以沿着x轴从不同点完全垂直地射出。在坐标x处射出一支箭，若有一个气球的直径的开始和结束坐标为 xstart，xend， 且满足  xstart ≤ x ≤ xend，则该气球会被引爆。可以射出的弓箭的数量没有限制。 弓箭一旦被射出之后，可以无限地前进。我们想找到使得所有气球全部被引爆，所需的弓箭的最小数量。
 *
 * Example:
 *
 * 输入:
 * [[10,16], [2,8], [1,6], [7,12]]
 *
 * 输出:
 * 2
 *
 * 解释:
 * 对于该样例，我们可以在x = 6（射爆[2,8],[1,6]两个气球）和 x = 11（射爆另外两个气球）。
 */
public class FindMinArrowShots {

    public static void main(String[] args) {
        int[][] arr = {{3,9},{7,12},{3,8},{6,8},{9,10},{2,9},{0,9},{3,9},{0,6},{2,8},{13,15}};

        System.out.println(findMinArrowShots(arr));
    }

    public static int findMinArrowShots(int[][] points) {
        if(points.length == 0)
            return 0;
        //排序
        List<int[]> list = new ArrayList<>();
        for(int i=0;i<points.length;i++){
            list.add(points[i]);
        }
        Collections.sort(list, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0]!=o2[0]){
                    return o1[0] - o2[0];
                }
                return o1[1] - o2[1];
            }
        });

        Object[] objects = list.toArray();
        for(int i=0;i<objects.length;i++){
            points[i] = (int[])objects[i];
        }
        int count = 1;
        int[] point = points[0];
        for(int i=0;i<points.length;i++){
            int[] res = compareMatch(point, points[i]);
            if(res!=null){
                point = res;
            }else {
                count++;
                point = points[i];
            }
        }
        return count;
    }

    private static int[] compareMatch(int[] point, int[] point1) {
        if(point[0]<=point1[0] && point[1]>=point1[1]){
            //包含
            return point1;
        }else if(point[0]>=point1[0] && point[1]<=point1[1]){
            //包含
            return point;
        }else if(point[0]<=point1[0] && point[1]>=point1[0]){
            //交集
            return new int[]{point1[0], point[1]};
        }else if(point[0]>=point1[0] && point[0]<=point1[1]){
            //交集
            return new int[]{point[0], point1[1]};
        }
        return null;
    }
    
}
