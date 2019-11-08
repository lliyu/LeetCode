package com.offer.backtracking;


/**
 * 剑指offer面试题12 矩阵中的路径
 *
 */
public class StringsHasPath {

    public static void main(String[] args) {
        char[][] chars = {{'a', 'b', 't', 'g'},{'c', 'f', 'c', 's'},{'j', 'd', 'e', 'h'}};
        StringsHasPath hasPath = new StringsHasPath();
        boolean bfce = hasPath.hasPath(chars, "abfb");
        System.out.println(bfce);
    }

    public boolean hasPath(char[][] paths, String target){
        boolean[][] booleans = new boolean[paths.length][paths[0].length];
        //在遍历过程中可能会遇到第一个字符就不满足或者从某一位置开始满足部分
        //这样在递归中没有办法指定从新的位置开始
        //需要在递归体之外来进行这部分操作
        for (int i = 0; i < paths.length; i++) {
            for (int j = 0; j < paths[i].length; j++) {
                if(path(paths, booleans, target, i, j, 0)){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean path(char[][] paths,boolean[][] bool, String target, int x, int y, int index){
        if(index>=target.length())
            return true;

        if(x<0 || x>=paths.length || y<0 || y>=paths[0].length || bool[x][y])
            return false;

        boolean result = false;
        if(paths[x][y] == target.charAt(index)){
            bool[x][y] = true;
            result = path(paths, bool, target, x+1, y, index+1) || //本题中并不需要遍历所有位置的字符 只要其中满足一个就可以结束了 所以使用 ||操作符
                    path(paths, bool, target, x-1, y, index+1) ||
                    path(paths, bool, target, x, y+1, index+1) ||
                    path(paths, bool, target, x, y-1, index+1);
        }
        if(!result){
            //不满足
            bool[x][y] = false;
        }

        return result;
    }
}
