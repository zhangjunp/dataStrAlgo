package com.zhangjp.dataStrAlgo.leetcode.bsearch;

/*
*
* 1095. 山脉数组中查找目标值
（这是一个 交互式问题 ）

给你一个 山脉数组 mountainArr，请你返回能够使得 mountainArr.get(index) 等于 target 最小 的下标 index 值。

如果不存在这样的下标 index，就请返回 -1。



何为山脉数组？如果数组 A 是一个山脉数组的话，那它满足如下条件：

首先，A.length >= 3

其次，在 0 < i < A.length - 1 条件下，存在 i 使得：

A[0] < A[1] < ... A[i-1] < A[i]
A[i] > A[i+1] > ... > A[A.length - 1]


你将 不能直接访问该山脉数组，必须通过 MountainArray 接口来获取数据：

MountainArray.get(k) - 会返回数组中索引为k 的元素（下标从 0 开始）
MountainArray.length() - 会返回该数组的长度


注意：

对 MountainArray.get 发起超过 100 次调用的提交将被视为错误答案。此外，任何试图规避判题系统的解决方案都将会导致比赛资格被取消。

为了帮助大家更好地理解交互式问题，我们准备了一个样例 “答案”：https://leetcode-cn.com/playground/RKhe3ave，请注意这 不是一个正确答案。



示例 1：

输入：array = [1,2,3,4,5,3,1], target = 3
输出：2
解释：3 在数组中出现了两次，下标分别为 2 和 5，我们返回最小的下标 2。
示例 2：

输入：array = [0,1,2,4,2,1], target = 3
输出：-1
解释：3 在数组中没有出现，返回 -1。


提示：

3 <= mountain_arr.length() <= 10000
0 <= target <= 10^9
0 <= mountain_arr.get(index) <= 10^9
*
* https://leetcode-cn.com/problems/find-in-mountain-array/
* */
public class FindInMountainArray {
    static class MountainArray {

        int[] mountainArr = {3, 5, 3, 2, 0};//{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,20,19,18,17,16,15,14,13,12,11,10,9,8,7,6,5,4,3,2};

        public int get(int index) {
            return mountainArr[index];
        }

        public int length() {
            return mountainArr.length;
        }
    }

    public static void main(String[] args) {
        int result = findInMountainArray(21, new MountainArray());
        System.out.println("result = " + result);

    }


    public static int findInMountainArray(int target, MountainArray mountainArr) {
        // 1.先找到山顶
        // 2.二分查找 右半边
        // 3.如果没有在右半边中查找到，查找左半边
        int length = mountainArr.length(); // 数组长度
        // 由于有mountainArr.get(i)的限制，所以获取山顶的方法不能够使用暴力遍历方式解决，采用二分查找方式进行遍历
        int maxIndex = binarySearchM(0, length - 1, mountainArr);
        // for(int i=0; i<length -1;i++){
        //     int curr = mountainArr.get(i);
        //     int next = mountainArr.get(i+1);
        //     if (curr > next) {
        //         maxIndex = i;
        //         break;
        //     }
        // }
        int result = binarySearch(target, 0, maxIndex, mountainArr);
        if (result == -1) {
            // 如果升序数组中未找到在降序数组中进行查找
            result = binarySearchL(target, maxIndex + 1, length - 1, mountainArr);
        }
        return result;
    }

    // 二分查找，查询山顶下标
    public static int binarySearchM(int low, int high, MountainArray nums) {
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int curr = nums.get(mid);
            int preIndex = Math.max(mid - 1, 0);
            int prev = nums.get(preIndex);
            int next = nums.get(mid + 1);
            if (curr > prev && curr > next) {
                return mid;
            } else if (curr > next) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    // 二分查找法 从小到大有序数组中
    public static int binarySearch(int target, int low, int high, MountainArray nums) {
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums.get(mid) == target) {
                return mid;
            } else if (nums.get(mid) > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    // 二分查找法 从大到小有序数组中
    public static int binarySearchL(int target, int low, int high, MountainArray nums) {
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums.get(mid) == target) {
                return mid;
            } else if (nums.get(mid) < target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }
}
