package com.leetcode.dynamic;

/**
 * 给定一个二维网格和一个单词，找出该单词是否存在于网格中。
 *
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 *
 *  
 *
 * 示例:
 *
 * board =
 * [
 *   ['A','B','C','E'],
 *   ['S','F','C','S'],
 *   ['A','D','E','E']
 * ]
 *
 * 给定 word = "ABCCED", 返回 true
 * 给定 word = "SEE", 返回 true
 * 给定 word = "ABCB", 返回 false
 */
public class WordsSearch {

    public static void main(String[] args) {
        WordsSearch search = new WordsSearch();
        System.out.println(search.exist(new char[][]{{'A','B','C','E'}, {'S','F','C','S'}, {'A','D','E','E'}}, "SEE"));
    }

    public boolean exist(char[][] board, String word) {
        for(int i=0;i<board.length;i++){
            for (int j = 0; j < board[0].length; j++) {
                boolean res = false;
                boolean[][] used = new boolean[board.length][board[0].length];
                if(board[i][j] == word.charAt(0)){
                    res = baktrace(board, word, 0, i, j, used, res);
                    if (res)
                        return res;
                }
            }
        }
        return false;
    }

    public boolean baktrace(char[][] board, String word, int len, int x, int y, boolean[][] used, boolean res){
        if(word.length() == len){
            return true;
        }
        if(x>=board.length || x<0){
            return false;
        }
        if(y>=board[0].length || y<0){
            return false;
        }

        if(board[x][y] != word.charAt(len) || used[x][y]){
            return false;
        }
        used[x][y] = true;
        res = baktrace(board, word, len + 1, x + 1, y, used, res);
        if(res){
            return true;
        }
        res = baktrace(board, word, len+1, x-1, y, used, res);
        if(res){
            return true;
        }
        res = baktrace(board, word, len+1, x, y+1, used, res);
        if(res){
            return true;
        }
        res = baktrace(board, word, len+1, x, y-1, used, res);
        if(res){
            return true;
        }
        used[x][y] = false;
        return false;
    }
}
