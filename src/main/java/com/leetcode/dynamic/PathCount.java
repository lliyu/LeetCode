package com.leetcode.dynamic;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ly
 * @create 2019-06-19 21:21
 *
 * shopee的办公室非常大，小虾同学的位置坐落在右上角，而大门却在左下角，可以把所有位置抽象为一个网格（门口的坐标为0，0），小虾同学很聪明，每次只向上，或者向右走，因为这样最容易接近目的地，但是小虾同学不想让自己的boss们看到自己经常在他们面前出没，或者迟到被发现。他决定研究一下如果他不通过boss们的位置，他可以有多少种走法？


输入描述:
第一行 x,y,n (0<x<=30, 0<y<=30, 0<=n<= 20) 表示x,y小虾的座位坐标,n 表示boss的数量（ n <= 20）

接下来有n行, 表示boss们的坐标(0<xi<= x, 0<yi<=y，不会和小虾位置重合)

x1, y1

x2, y2

……

xn, yn

输出描述:
输出小虾有多少种走法

输入例子1:
3 3 2
1 1
2 2

输出例子1:
4
 **/
public class PathCount {

    public static void main(String[] args) {
        List<String> locs = new ArrayList<>();
        locs.add("(1,1)");
        locs.add("(2,2)");
        System.out.println(pathCount(3, 3, locs));
    }

    public static int pathCount(int x, int y, List<String> locs){
        return recur(x, y, locs, 0);
    }

    private static int recur(int x, int y, List<String> locs, int count) {
        if(x<0 || y<0)
            return count;
        if(x==0 && y==0)
            return ++count;
        if(locs.contains("(" + x + "," + y + ")")){
            return count;
        }
        count = recur(x-1, y, locs, count);
        count = recur(x, y-1, locs, count);
        return count;
    }
}
