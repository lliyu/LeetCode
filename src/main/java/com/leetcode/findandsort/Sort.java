package com.leetcode.findandsort;

/**
 * @Auther: Administrator
 * @Date: 2018-11-08 14:36
 * @Description:
 */
public class Sort {
    public static void main(String[] args) {
        int[] nums =new int[]{0,4,1,2,3,87,9,2,1,5,7,8,6,4,3};
        shellSort(nums);
        for (int i:nums) {
            System.out.print(i + " ");
        }
    }

    //ѡ������
    public static void selectSort(int[] arr){
        for(int i=0;i<arr.length;i++){
            //һ��֮����С���������±�Ϊi��λ��
            for(int j=i+1;j<arr.length;j++){
                if(arr[i] > arr[j]){
                    swap(arr, i, j);
                }
            }
        }
    }

    //��������
    public static void insertSort(int[] nums){
        int i,j;
        for(i=1;i<nums.length;i++){
            int temp = nums[i];
            //��Ԫ�غ���
            for(j=i-1;j>=0&&temp<nums[j];j--){
                nums[j+1] = nums[j];
            }
            nums[j+1] = temp;
        }
    }

    //���ڱ��Ĳ�������
    public static void insertWithSentinelSort(int[] nums){
        int i,j;
        for(i=1;i<nums.length;i++){
            //����һ��Ԫ��ָ��Ϊ�ڱ�
            //Ҫ����������ԭ���鳤�ȴ�1
            nums[0] = nums[i];
            //��Ԫ�غ���
            for(j=i-1;nums[j]>nums[0];j--){
                nums[j+1] = nums[j];
            }
            nums[j+1] = nums[0];
        }
    }

    //ϣ������
    public static void shellSort(int[] nums){
        int size = nums.length/2;
        int i,j;
        while(size>=1){
            for(i=0;i<nums.length;i++){
                for(j=i;j+size<nums.length;j+=size){
                    if(nums[j]>nums[j+size]){
                        swap(nums, j, j+size);
                    }
                }
            }
            size/=2;
        }
    }



    //ð������
    public static void bubbleSort(int[] arr){
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr.length-i-1;j++){
                if(arr[j] > arr[j+1]){
                    swap(arr, j, j+1);
                }
            }
        }
    }


    //����
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
    }
}
