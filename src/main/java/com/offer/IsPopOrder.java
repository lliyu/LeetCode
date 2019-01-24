package com.offer;

import java.util.Stack;

/**
 * @Auther: Administrator
 * @Date: 2019-01-24 17:32
 * @Description: 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出顺序。假设压入栈的所有数字均不相等。
 *
 * 例如序列 1,2,3,4,5 是某栈的压入顺序，序列 4,5,3,2,1 是该压栈序列对应的一个弹出序列，但 4,3,5,1,2 就不可能是该压栈序列的弹出序列。
 */
public class IsPopOrder {
    public static void main(String[] args) {
        System.out.println(isPopOrder(new int[]{1,2,3,4,5},new int[]{3,4,5,2,1}));
    }

    public static boolean isPopOrder(int[] pushOrder,int[] popOrder){
        //保证健壮性
        if(pushOrder.length==0 || popOrder.length==0 || popOrder.length!=pushOrder.length)
            return false;

        int len = 0, stackLength = popOrder.length;
        int i=0;
        int[] order = new int[stackLength];
        Stack stack = new Stack();
        while(i<stackLength){
            int num = popOrder[len];
            //假设第一个出栈数字为4 那么久必须先将123压入栈中
            while (i<stackLength && num != pushOrder[i]){
                stack.push(pushOrder[i++]);
            }
            //当pushOrder已经遍历完成 这时不能讲num存到order中
            if(i < stackLength){
                order[len++] = num;
                i++;
            }
        }

        //获取按照popOrder的逻辑正确的弹栈顺序
        while(!stack.isEmpty()){
            order[len++] = (int) stack.pop();
        }
        //比较
        for(int k=0;k<stackLength;k++){
            if(order[k] != popOrder[k]){
                return false;
            }
        }
        return true;
    }

    public boolean isPopOrder1(int[] pushSequence, int[] popSequence) {
        int n = pushSequence.length;
        Stack<Integer> stack = new Stack<>();

        for (int pushIndex = 0, popIndex = 0; pushIndex < n; pushIndex++) {
            stack.push(pushSequence[pushIndex]);
            while (popIndex < n && !stack.isEmpty()
                    && stack.peek() == popSequence[popIndex]) {
                stack.pop();
                popIndex++;
            }
        }
        return stack.isEmpty();
    }
}
