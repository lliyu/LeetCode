package com.offer;

/**
 * @Auther: Administrator
 * @Date: 2019-01-11 16:28
 * @Description: 请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。
 * 路径可以从矩阵中的任意一个格子开始，每一步可以在矩阵中向左，向右，向上，向下移动一个格子。如果一条路径经过了矩阵中的某一个格子，则该路径不能再进入该格子。
 */
public class HasContainsString {

    public static void main(String[] args) {
        char[][] chars = {{'a', 'b', 't', 'g'}, {'c', 'f', 'c', 's'}, {'j', 'd', 'e', 'h'}};
        System.out.println(hashPath(chars, new char[]{'b', 'f', 'c', 'e'}));
    }

    /**
     *
     * @param array 数组
     * @param str 指定字符串
     * @return
     */
    public static boolean hashPath(char[][] array, char[] str) {
        int row = array.length;
        int col = array[0].length;
        //记录已经被标记的点
        boolean[][] visited = new boolean[row][col];
        //遍历数组
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                //查找字符串
                if(backTracking(array, str, visited, 0, i, j)){
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean backTracking(char[][] array, char[] str, boolean[][] visited, int strFindLen, int row, int col) {
        //当strFindLen等于str的长度时 表示已经找到了
        if(strFindLen == str.length)
            return true;
        //越界或者字符不匹配
        if(row<0 || col<0 || row>array.length || col>array[0].length ||
                array[row][col]!=str[strFindLen] ||
                visited[row][col])
            return false;
        //标记该点已经走过
        visited[row][col] = true;

        // 字符匹配后 继续匹配该点的附近
        // 向上
        if(backTracking(array, str, visited, strFindLen+1, row-1, col)){
            return true;
        }
        // 向下
        if(backTracking(array, str, visited, strFindLen+1, row+1, col)){
            return true;
        }
        // 向左
        if(backTracking(array, str, visited, strFindLen+1, row, col-1)){
            return true;
        }
        // 向右
        if(backTracking(array, str, visited, strFindLen+1, row, col+1)){
            return true;
        }

        //当该点附近的点都无法匹配时  表示这一路径无解 需要回到上一个点
        //当回到上一个点时 该点的标记情况需要清除 保证后续该点可用
        visited[row][col] = false;

        return false;
    }
}
