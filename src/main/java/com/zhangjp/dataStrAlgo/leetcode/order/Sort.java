package com.zhangjp.dataStrAlgo.leetcode.order;

import java.util.Arrays;

public class Sort {

    public static void main(String[] args) {
        int[] ints = {1, 3, 2, 9, 10, 3, 8, 5, 1, 3434, 532, 543};
        int[] sort = sort(ints);
        System.out.println("Arrays.toString(sort) = " + Arrays.toString(sort));
        int[] ints1 = {3,4,1,2,5};
        int[] ints2 = insertionSort(ints1);
        System.out.println("Arrays.toString(ints2) = " + Arrays.toString(ints2));;
    }

    /*冒泡排序，稳定排序，时间复杂度为 O(N的二次方) 空间复杂度为O(1)
    * 思想是把最大的移到数组最后一位
    * 下一次遍历把最大的移动到倒数第二位，依次遍历比较最终得到有序的数组
    * 如果此次遍历没有移动任何元素，说明数组已经是有序的，无须进行排序了
    * */
    public static int[] sort(int[] nums){
        if (nums.length <= 1) {
            return nums;
        }
        boolean swapped = true;
        for(int i = 0 ;i<nums.length-1 && swapped;i++){
            swapped = false;
            for (int j = 0;j<nums.length-1-i;j++){
                if (nums[j] > nums[j+1]){
                    swap(nums,j,j+1);
                    swapped = true;
                }
            }
        }
        return nums;
    }

    public static void swap(int[] nums,int i,int j){
        int iVal = nums[i];
        int jVal = nums[j];
        nums[i] = jVal;
        nums[j] = iVal;
    }

    /*
    *插入排序，稳定的排序算法，O（N的平方） 空间复杂度O（1）  3,4,1,2,5
    *为什么插入排序要不冒泡排序要高效一点
    * 因为冒泡排序进行数据交换时，冒泡需要三个赋值操作，而插入只需要一个赋值操作
    * */
    public static int[] insertionSort(int[] nums){
        if (nums.length <= 1) {
            return nums;
        }
        // 假设数组第一个元素是有序的，从第二个元素进行遍历
        for (int i = 1; i <nums.length ; i++) {
            int value = nums[i];
            int j = i-1;
            for(;j>=0;j--){
                if (nums[j]>value) {
                    nums[j+1] = nums[j];//数据移动
                }else {
                    break;
                }
            }
            nums[j+1] = value; // 插入数据
        }
        return nums;
    }










}
