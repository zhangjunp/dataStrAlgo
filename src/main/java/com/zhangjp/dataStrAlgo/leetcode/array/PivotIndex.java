package com.zhangjp.dataStrAlgo.leetcode.array;

/**
 * 数组基本练习
 * <p>
 * https://leetcode.cn/leetbook/read/array-and-string/yf47s/
 */
public class PivotIndex {


    /**
     * 输入：nums = [1, 7, 3, 6, 5, 6]
     * 输出：3
     * 解释：
     * 中心下标是 3 。
     * 左侧数之和 sum = nums[0] + nums[1] + nums[2] = 1 + 7 + 3 = 11 ，
     * 右侧数之和 sum = nums[4] + nums[5] = 5 + 6 = 11 ，二者相等。
     * 链接：https://leetcode.cn/leetbook/read/array-and-string/yf47s/
     * <p>
     * <p>
     * 边界值：
     * 输入：nums = [2, 1, -1]
     * 输出：0
     * 解释：
     * 中心下标是 0 。
     * 左侧数之和 sum = 0 ，（下标 0 左侧不存在元素），
     * 右侧数之和 sum = nums[1] + nums[2] = 1 + -1 = 0 。
     */
    public static int searchPivotIndex(int[] nums) {
        int rightSum = 0;
        int leftSum = 0;
        for (int num : nums) {
            rightSum += num;
        }
        for (int i = 0; i < nums.length; i++) {
            rightSum = rightSum - nums[i];
            if (leftSum == rightSum) {
                return i;
            }
            leftSum += nums[i];
        }
        return -1;
    }

}
