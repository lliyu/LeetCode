package com.newcode;

import java.util.Scanner;

public class Question1 {

    public static void main(String[] args) {
        Question1 question1 = new Question1();
        test(question1);
        System.out.println(question1);
    }

    public static void test(Question1 question){
        System.out.println(question);
        question = new Question1();
        System.out.println(question);
    }

    private static void question3() {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        char[] chars = new char[]{'1','2','3','4','5','6'};

        for (int i = 0; i < str.length(); i++) {
            switch (str.charAt(i)){
                case 'L':
                    swap(chars, 0, 1);
                    swap(chars, 0, chars.length-2);
                    swap(chars, 1, chars.length-1);
                    break;
                case 'R':
                    swap(chars, 0, 1);
                    swap(chars, 0, chars.length-1);
                    swap(chars, 1, chars.length-2);
                    break;
                case 'F':
                    swap(chars, 2, 3);
                    swap(chars, 2, 4);
                    swap(chars, 3, 5);
                    break;
                case 'B':
                    swap(chars, 2, 3);
                    swap(chars, 2, 5);
                    swap(chars, 3, 4);
                    break;
                case 'A':
                    swap(chars, 0, 1);
                    swap(chars, 0, 3);
                    swap(chars, 1, 2);
                    break;
                case 'C':
                    swap(chars, 0, 1);
                    swap(chars, 0, 2);
                    swap(chars, 1, 3);
                    break;
            }
        }

        System.out.println(new String(chars));
    }

    public static void swap(char[] chars, int left, int right){
        char temp = chars[left];
        chars[left] = chars[right];
        chars[right] = temp;
    }

    private static void question1() {
        Scanner sc = new Scanner(System.in);
        String t = sc.next();
        String p = sc.next();
        if(t.length()==0 || p.length()==0){
            System.out.println("No");
            return;
        }
        if(t.length()<p.length()){
            System.out.println("No");
            return;
        }
        int index = 0;
        for (int i = 0; i < t.length(); i++) {
            if(t.charAt(i) == p.charAt(index)){
                index++;
                if(p.length() == index){
                    System.out.println(i-p.length()+2);
                    break;
                }
            }else {
                index = 0;
            }
        }
    }

    private static void question2() {
        Scanner in = new Scanner(System.in);
        String str = in.next();
//        String str = "3#4#5#6";
        if(str==null || str.length()==0)
            System.out.println(0);
        //处理优先级高的$
        String numS1 = null;
        String numS2 = null;
        int num1 = 0;
        int num2 = 0;
        int index = -1;
        for (int i = 0; i < str.length(); i++) {
            if(str.charAt(i) == '#'){
                index = i;
                continue;
            }
            if(str.charAt(i) == '$'){
                numS1 = str.substring(index+1, i);
                numS2 = "";
                int j = i+1;
                for (; j <= str.length(); j++) {
                    if(j == str.length()){
                        numS2 = str.substring(i+1);
                        break;
                    }
                    if(str.charAt(j) == '#' || str.charAt(j) == '$'){
                        numS2 = str.substring(i+1, j);
                        break;
                    }
                }
                num1 = Integer.valueOf(numS1);
                num2 = Integer.valueOf(numS2);
                int num = 3*num1 + 2 + num2;
                str = str.substring(0, index+1) + num + str.substring(j);
                i = String.valueOf(num).length() + index;
            }
        }

        //开始处理#
        index = -1;
        boolean isReset = false;
        for (int i = 0; i < str.length(); i++) {
            if(!isReset && str.charAt(i)!='#')
                continue;
            if(str.charAt(i) == '#'){
                isReset = true;
                num1 = Integer.valueOf(str.substring(index+1, i));
                continue;
            }
            int j = i;
            for (; j <= str.length(); j++) {
                if(j == str.length()){
                    num2 = Integer.valueOf(str.substring(i));
                    break;
                }
                if(str.charAt(j) == '#'){
                    num2 = Integer.valueOf(str.substring(i, j));
                    break;
                }
            }
            int num = 2*num1 + 3*num2 + 4;
            str = num + str.substring(j);
            i = String.valueOf(num).length()-1;
        }

        System.out.println(str);
    }
}
