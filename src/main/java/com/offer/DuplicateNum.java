package com.offer;

/**
 * �ҳ��������ظ�������
 *
 * @author ly
 * @create 2019-01-06 20:46
 **/
public class DuplicateNum {

    public static void main(String[] args) {
        int[] arrs = {1,2,3,4,5,0};
        int duplicate = duplicate(arrs);
        if(duplicate>=0){
            System.out.println(duplicate);
        }else {
            System.out.println("δ�ҵ�");
        }
    }

    //ʱ�临�Ӷ� O(n) �ռ临�Ӷ�O(1)
    //������Ȼ��������ѭ�� �����������ѭ���ҵ��Լ���λ�ú�Ͳ���Ҫ�ٴν����� ʵ�������������൱��������ִ��2n��
    //����ʱ�临�Ӷ� O(n)
    public static int duplicate(int[] arrs){
        if(arrs==null || arrs.length==0){
            return -1;
        }
        int temp = 0;
        for(int i=0;i<arrs.length;i++){
            while(arrs[i] != i){
                if(arrs[arrs[i]] == arrs[i]){
                    return arrs[i];
                }
                temp = arrs[i];
                arrs[i]= arrs[arrs[i]];
                arrs[temp] = temp;
            }
        }
        return -1;
    }
}
