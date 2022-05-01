package com.mashibing.sort;

import com.entity.Student;
import com.sun.tools.internal.xjc.reader.xmlschema.bindinfo.BIConversion;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 归并排序应用
 */
public class MergeSort {

    /**
     * 逆序对
     * 一个数组中左边大于右边的数组被称为逆序对
     * 找出所有的逆序对
     */
    public void mergeSort(int[] arr,int left, int right, List<String> lists){
        if(left==right){
            return;
        }
        int mid = left + (right-left)>>1;
        mergeSort(arr, left, mid, lists);//左边部分
        mergeSort(arr, mid+1, right, lists);//右边部分
        merge(arr, left, mid, right, lists);
    }

    private void merge(int[] arr, int left, int mid, int right, List<String> lists) {
        while(left < right){

        }
    }

    public static void main(String[] args) {
        PriorityQueue<Student> heap = new PriorityQueue<Student>(Comparator.comparing(Student::getAge));
        heap.add(new Student());
        heap.add(new Student());
        heap.add(new Student());
        
    }
}
