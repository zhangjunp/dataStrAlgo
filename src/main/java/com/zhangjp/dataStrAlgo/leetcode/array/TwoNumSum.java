package com.zhangjp.dataStrAlgo.leetcode.array;


import java.util.*;

public class TwoNumSum {


    /**
     * 给定一个生序数组，以及target，给出数组中两数之后为target的下表
     *
     * @param nums   ex:new int[]{2,4,10,12,15}
     * @param target ex:target = 6
     * @return new int[]{0,1}, because 2+4 = 6;
     * <p/>
     * 重点：only one result and array is ascending array
     * <p>
     * 因为是升序的，可以利用双指针办法，通过一次遍历实现拿到结果。时间复杂度 O(n)
     */
    public static int[] twoSumEqualTarget(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;

        while (l < r) {
            if (nums[l] + nums[r] == target) {
                return new int[]{l, r};
            }
            if (nums[l] + nums[r] > target) {
                r--;
            } else {
                l++;
            }
        }
        return null;
    }


    public static void main1(String[] args) {
        int[] nums = {1, 3, 10, 14, 17};
        int[] result = twoSumEqualTarget(nums, 4);
        System.out.println("Arrays.toString(result) = " + Arrays.toString(result));
    }


    /**
     * 如果是非有序数组那么，暴力解放两层for循环，时间复杂度O(n²), 空间复杂度O(1);
     * 空间换时间，遍历一边将 下标 + 数值 存到map中
     */
    public static int[] twoSumEqualTargetNotSort(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int val = target - nums[i];
            // 排除本身
            if (map.containsKey(val) && map.get(val) != i) {
                return new int[]{map.get(val), i};
            }
        }
        return null;
    }


    /**
     * <p>
     * https://leetcode.cn/problems/3sum/description/?envType=problem-list-v2&envId=DsYF2VPY
     * <p/>
     * 给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]]
     * 满足 i != j、i != k 且 j != k ，同时还满足 nums[i] + nums[j] + nums[k] == 0。
     * 请你返回所有和为 0 且不重复的三元组。
     * 思路：三数之和是二数之和的升级版，暴力解决办法是O(n³) 三层for循环；
     * 如果先将数组变为有序O(nlogᴺ) + 固定下表i，找到非i之中两数之和 = target -i ，就可以采用双指针办法；
     * O(N²) + O(nlogᴺ) 时间复杂度还是 O(N²)
     */
    public static List<List<Integer>> threeNumsSumEqualTarget(int[] nums) {
        List<List<Integer>> result = new LinkedList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            twoSum(nums, i, result);
        }
        return result;
    }


    public static void twoSum(int[] nums, int i, List<List<Integer>> result) {
        int l = i + 1;
        int r = nums.length - 1;
        while (l < r) {
            if (nums[i] + nums[r] + nums[l] == 0) {
                result.add(Arrays.asList(nums[i], nums[l], nums[r]));

                // 针对符合条件的，需要规避重复数据，l 右移时需要和前一位不一致
                // 例如[-1,-1,-1,0,1,2]； result：-1 0 1 这个三元组只能有一个，所以要规避掉
                int temp = nums[l];
                while (l < r && temp == nums[l]) {
                    ++l;
                }
            } else if (nums[i] + nums[r] + nums[l] > 0) {
                --r;
            } else {
                ++l;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {-1, -1, -1, 0, 1, 2};
        List<List<Integer>> lists = threeNumsSumEqualTarget(nums);
        System.out.println("lists.toString() = " + lists.toString());
    }


    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new LinkedList<List<Integer>>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            // 重复需要排除
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            //三数之和解决办法，两层for循环+双指针办法
            for (int j = i + 1; j < nums.length; j++) {
                // 重复的需要排除
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                int l = j + 1;
                int r = nums.length - 1;
                while (l < r) {
                    if ((long) nums[i] + nums[j] + nums[l] + nums[r] == target) {
                        result.add(Arrays.asList(nums[i], nums[j], nums[l], nums[r]));
                        // 满足条件左下标移动需要考虑重复数据
                        int temp = nums[l];
                        while (nums[l] == temp && l < r) {
                            l++;
                        }
                    } else if ((long) nums[i] + nums[j] + nums[l] + nums[r] > target) {
                        --r;
                    } else {
                        ++l;
                    }
                }
            }
        }
        return result;
    }

}
