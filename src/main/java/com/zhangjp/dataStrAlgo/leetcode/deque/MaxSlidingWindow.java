package com.zhangjp.dataStrAlgo.leetcode.deque;

import java.util.Deque;

/*
*
* 239. 滑动窗口最大值
给定一个数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
返回滑动窗口中的最大值。

进阶：
你能在线性时间复杂度内解决此题吗？

示例:

输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
输出: [3,3,5,5,6,7]
解释:

  滑动窗口的位置                最大值
---------------               -----
[1  3  -1] -3  5  3  6  7       3
 1 [3  -1  -3] 5  3  6  7       3
 1  3 [-1  -3  5] 3  6  7       5
 1  3  -1 [-3  5  3] 6  7       5
 1  3  -1  -3 [5  3  6] 7       6
 1  3  -1  -3  5 [3  6  7]      7

提示：
1 <= nums.length <= 10^5
-10^4 <= nums[i] <= 10^4
1 <= k <= nums.length
* */
public class MaxSlidingWindow {

    // 双端队列（Deque）
    // 特点：双端队列和普通队列最大的不同在于，它允许我们在队列的头尾两端都能在 O(1) 的时间内进行数据的查看、添加和删除。
    // 实现：与队列相似，我们可以利用一个双链表实现双端队列。
    // 应用场景：双端队列最常用的地方就是实现一个长度动态变化的窗口或者连续区间，而动态窗口这种数据结构在很多题目里都有运用。

    //1.暴力解法，遍历所有的滑动时间窗口
    public int[] maxSlidingWindow(int[] nums, int k) {
        int length = nums.length;
        if (length == 0 || k == 0) {
            return new int[0];
        }
        if (k == 1) {
            return nums;
        }
        int[] result = new int[length -k + 1];
        for(int i =0; i< length -k + 1; i++ ){
            int currSlidingWindowMax = Integer.MIN_VALUE;
            for(int j = i;j<i+k;j++){
                currSlidingWindowMax = Math.max(currSlidingWindowMax,nums[j]);
            }
            result[i] = currSlidingWindowMax;
        }
        return result;
    }

}
