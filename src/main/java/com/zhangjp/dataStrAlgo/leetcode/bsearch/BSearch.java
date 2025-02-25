package com.zhangjp.dataStrAlgo.leetcode.bsearch;

public class BSearch {

    public static void main(String[] args) {
        int[] ints = {1, 2, 3, 4, 5, 6, 7, 8};
        int search = binarySearch(ints, 5);
        System.out.println(ints[search]);
        System.out.println("==========");
        System.out.println("binarySearchRecursion(ints,8) = " + binarySearchRecursion(ints,8));


        int[] numsR = {1,3,4,5,6,8,8,8,11,18};
        System.out.println("binarySearchFirst(numsR,8) = " + binarySearchFirst(numsR, 8));
        int i = 2 + (3 - 2) / 2;
        System.out.println("2+(3-2)/2 = " + i);
    }

    /*
    * 普通的二分查找
    * 1.循环退出条件 注意是 low<=high，而不是 low<high。
    * 2.mid 的取值 实际上，mid=(low+high)/2 这种写法是有问题的。
    * 因为如果 low 和 high 比较大的话，两者之 和就有可能会溢出。
    * 改进的方法是将 mid 的计算方式写成 low+(high-low)/2。更进一步，如果 要将性能优化到极致的话，我们可以将这里的除以 2 操作转化成位运算 low+((high-low)>>1)。
    * 因为相比除法运算来说，计算机处理位运算要快得多。
    *  3.low 和 high 的更新 low=mid+1，high=mid-1。注意这里的 +1 和 -1，如果直接写成 low=mid 或者 high=mid，就 可能会发生死循环。
    * 比如，当 high=3，low=3 时，如果 a[3] 不等于 value，就会导致一直循环 不退出。
    * */
    public static int binarySearch (int[] nums,int target) {
        if (null == nums) {
            return -1;
        }
        int low = 0;
        int high = nums.length-1;
        while (low <= high){
            int mid = low + (high - low)/2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                low = mid+1;
            }else {
                high = mid-1;
            }
        }
        return -1;
    }

    /*
     *递归方式
     * */
    public static int binarySearchRecursion(int[] nums,int target){
        if (null == nums) {
            return -1;
        }
        return binarySearchRecursion(nums,target,0,nums.length-1);
    }

    private static int binarySearchRecursion(int[] nums,int target,int low,int high){
        if (high < low) {
            return -1;
        }
        int mid = low + (high-low)/2;
        if (nums[mid] == target) {
            return mid;
        }else if (nums[mid] < target) {
            return binarySearchRecursion(nums,target,mid+1,high);
        }else{
            return binarySearchRecursion(nums,target,low,mid-1);
        }
    }


    /*
    * 变体1 ： 有序重复数组中，查找第一个值等于给定值的元素
    * 【1，2，3，4，5，6，8，8，8，8，9】
    * */
    public static int binarySearchFirst(int[] nums,int target){
        int low = 0;
        int high = nums.length-1;
        while(low<=high){
            int mid = low + (high - low)/2;
            //
            if ( (mid == 0 && nums[mid] == target) || (nums[mid] == target && nums[mid-1] != target)) {
                return mid;
            }else if (nums[mid] >= target) {
                high = mid - 1;
            }else {
                low = mid + 1;
            }
        }
        return -1;
    }
}
