package com.leetcode.other;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @Auther: Administrator
 * @Date: 2018-12-10 09:35
 * @Description:
 * 在英语中，我们有一个叫做 词根(root)的概念，它可以跟着其他一些词组成另一个较长的单词——我们称这个词为 继承词(successor)。例如，词根an，跟随着单词 other(其他)，可以形成新的单词 another(另一个)。
 *
 * 现在，给定一个由许多词根组成的词典和一个句子。你需要将句子中的所有继承词用词根替换掉。如果继承词有许多可以形成它的词根，则用最短的词根替换它。
 *
 * 你需要输出替换之后的句子。
 *
 * 示例 1:
 *
 * 输入: dict(词典) = ["cat", "bat", "rat"]
 * sentence(句子) = "the cattle was rattled by the battery"
 * 输出: "the cat was rat by the bat"
 */
public class ReplaceWords {

    private static TrieNode root;

    public static void main(String[] args) {
        List list = new ArrayList();
        list.add("ba");
        list.add("bat");
        list.add("rat");

        System.out.println(replaceWords(list, "the cattle was rattled by the battery"));
    }

    //暴力求解 效率较低
    public static String replaceWords1(List<String> dict, String sentence) {
        //对list进行排序
        Collections.sort(dict, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        });
        //抽取句子中的单词
        String[] split = sentence.split(" ");
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<split.length;i++){
            for(String dic:dict){
                if(split[i].indexOf(dic) == 0){
                    split[i] = dic;
                    break;
                }
            }
            sb.append(split[i] + " ");
        }

        return sb.toString().substring(0, sb.toString().length()-1);
    }

    //构造字典树
    public static void insert(String word){
        TrieNode node = root;
        char[] chars = word.toCharArray();
        for(char ch:chars){
            if((node.getChilds())[ch - 'a'] == null){
                (node.getChilds())[ch - 'a'] = new TrieNode();
            }
            node = node.getChilds()[ch - 'a'];
        }
        node.setEnd(true);
    }

    public static String search(String word){
        char[] chars = word.toCharArray();
        TrieNode node = root;
        StringBuilder sb = new StringBuilder();
        for(char ch:chars){
            if((node.getChilds())[ch - 'a'] != null){
                sb.append(ch);
                if((node.getChilds())[ch - 'a'].isEnd()){
                    //到达最近的最短词根
                    return sb.toString();
                }
                node = node.getChilds()[ch - 'a'];
            }else {
                return word;
            }
        }
        return word;
    }
    //字典树的方式求解
    public static String replaceWords(List<String> dict, String sentence) {
        root = new TrieNode();
        for(String dic:dict){
            insert(dic);
        }
        //抽取句子中的单词
        String[] split = sentence.split(" ");
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<split.length;i++){
            sb.append(search(split[i]) + " ");
        }

        return sb.toString().substring(0, sb.toString().length()-1);
    }

}

class TrieNode{
    private TrieNode[] childs;
    private boolean isEnd;

    public TrieNode() {
        this.childs = new TrieNode[26];
        this.isEnd = false;
    }

    public TrieNode[] getChilds() {
        return childs;
    }

    public void setChilds(TrieNode[] childs) {
        this.childs = childs;
    }

    public boolean isEnd() {
        return isEnd;
    }

    public void setEnd(boolean end) {
        isEnd = end;
    }
}
