package com.zhangjp.dataStrAlgo.leetcode.array;

/*
* 4. 寻找两个有序数组的中位数
给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。

请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。

你可以假设 nums1 和 nums2 不会同时为空。

示例 1:

nums1 = [1, 3]
nums2 = [2]

则中位数是 2.0
示例 2:

nums1 = [1, 2]
nums2 = [3, 4]

则中位数是 (2 + 3)/2 = 2.5
* */
public class FindMidSortArray {


    public static void main(String[] args) {
        int[] nums1 = {1, 3};
        int[] nums2 = {2};
        double medianSortedArrays = findMedianSortedArrays(nums1, nums2);
        System.out.println("medianSortedArrays = " + medianSortedArrays);
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] ints = mergeTwoSortArray(nums1, nums2);
        int i = ints.length / 2;
        int i1 = ints.length % 2;
        if (ints.length == 1) {
            return ints[1];
        }
        if (i1 == 0) {
            return ints[i];
        }else{
            int sum = ints[i] + ints[i + 1];
            return sum/2.0;
        }

    }


    public static int[] mergeTwoSortArray(int[] nums1, int[] nums2){
        int[] tmp = new int[nums1.length + nums2.length];
        int x = 0;
        int y = 0;
        for(int i=0;i<tmp.length;i++){
            if (x<nums1.length && nums1[x] <= nums2[y]) {
                tmp[i] = nums1[x];
                x++;
            }else {
                tmp[i] = nums2[y];
                y++;
            }
        }
        return tmp;
    }
}
