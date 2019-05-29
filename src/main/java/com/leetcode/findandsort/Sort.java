package com.leetcode.findandsort;

/**
 * @Auther: Administrator
 * @Date: 2018-11-08 14:36
 * @Description:
 */
public class Sort {
    public static void main(String[] args) {
        int[] nums =new int[]{4,1,2,3,87,9,2,1,5,7,8,6,4,3};
        int[] temp = new int[nums.length];
        mergeSort(nums, temp, 0, nums.length-1);
//        sort(nums);
        for (int i:temp) {
            System.out.print(i + " ");
        }
    }

    //选择排序
    public static void selectSort(int[] arr){
        for(int i=0;i<arr.length;i++){
            //一趟之后最小的数到了下标为i的位置
            for(int j=i+1;j<arr.length;j++){
                if(arr[i] > arr[j]){
                    swap(arr, i, j);
                }
            }
        }
    }

    //插入排序
    public static void insertSort(int[] nums){
        int i,j;
        for(i=1;i<nums.length;i++){
            int temp = nums[i];
            //将元素后移
            for(j=i-1;j>=0&&temp<nums[j];j--){
                nums[j+1] = nums[j];
            }
            nums[j+1] = temp;
        }
    }

    //带哨兵的插入排序
    public static void insertWithSentinelSort(int[] nums){
        int i,j;
        for(i=1;i<nums.length;i++){
            //将第一个元素指定为哨兵
            //要求传入的数组比原数组长度大1
            nums[0] = nums[i];
            //将元素后移
            for(j=i-1;nums[j]>nums[0];j--){
                nums[j+1] = nums[j];
            }
            nums[j+1] = nums[0];
        }
    }

    //希尔排序
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



    //冒泡排序
    public static void bubbleSort(int[] arr){
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr.length-i-1;j++){
                if(arr[j] > arr[j+1]){
                    swap(arr, j, j+1);
                }
            }
        }
    }


    //快速排序
    public static void quickSort(int[] nums, int low, int high){
        if(low<high){
            int partation = partation(nums, low, high);
            //这里返回的low值的位置已经确定了 所以不用参与排序
            quickSort(nums, 0, low-1);
            quickSort(nums, low+1, high);
        }
    }

    //进行一次排序 将待排序列分为两个部分
    public static int partation(int[] nums, int low, int high){
        //选取第一个值为枢纽值
        int pivo = nums[low];
        while(low<high){
            while(low<high&&nums[high]>=pivo){
                high--;
            }
            nums[low] = nums[high];
            while(low<high&&nums[low]<=pivo){
                low++;
            }
            nums[high]=nums[low];
        }
        nums[low] = pivo;

        return low;
    }

    //归并排序
    public static void mergeSort(int[] nums, int[] temp, int left, int right){
        if(left<right){
            int mid = (left+right)/2;
            mergeSort(nums, temp,left,mid);
            mergeSort(nums, temp,mid+1,right);
            merge(nums,temp, mid, left, right);
        }
    }

    public static void merge(int[] nums, int[] temp, int mid, int left, int right){
        int i=left,j=mid+1,k=0;
        while(i<=mid&&j<=right){
            if(nums[i]<nums[j]){
                temp[k++] = nums[i++];
            }else {
                temp[k++] = nums[j++];
            }
        }

        while(i<=mid){
            temp[k++] = nums[i++];
        }

        while(j<=right){
            temp[k++] = nums[j++];
        }
        //将temp中的元素全部拷贝到原数组中
        //这里必须将原来排好序的数组值复制回去
        //否则后续的对比前面排序长的数组排序时会出错
        //比如4 1 2 3   讲过排序后分为1 4 和2 3两组
        //如果没有将值复制回去那么合并后将是2 3 4 1
        k=0;
        while(left<=right){
            nums[left++] = temp[k++];
        }
    }


    //交换
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
    }
}
