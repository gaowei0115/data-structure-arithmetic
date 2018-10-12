package com.mmc.data.structure.system.array;

/**
 * @packageName：com.mmc.data.structure.system.array
 * @desrciption: 长度最小的子数组
                    给定一个含有 n 个正整数的数组和一个正整数 s ，找出该数组中满足其和 ≥ s 的长度最小的连续子数组。如果不存在符合条件的连续子数组，返回 0。
 * @author: gaowei
 * @date： 2018-10-12 9:38
 * @history: (version) author date desc
 */
public class MinSubArrayLen {


    public static void main(String[] args) {
        int[] arrays = new int[]{2, 5, 3, 1, 2, 4, 6, 7};
        int s = 9;
        int total = minSubArrayLen(arrays, s);
        System.out.println("result : " + total);
    }

    /**
     * 示例:
     输入: s = 7, nums = [2,3,1,2,4,3]
     输出: 2
     解释: 子数组 [4,3] 是该条件下的长度最小的连续子数组。

     进阶:
     如果你已经完成了O(n) 时间复杂度的解法, 请尝试 O(n log n) 时间复杂度的解法。
     * @param nums
     * @param s
     * @return
     */
    public static int minSubArrayLen(int[] nums, int s){

        if (nums == null || nums.length == 0) {
            return 0;
        }

        int i = 0;
        int j = 0;
        int sum = 0;
        int res = nums.length + 1;
        int len = nums.length;
        while (i < len) {
            if (j < len && sum < s) {
                sum += nums[j++];
            } else {
                sum -= nums[i++];
            }
            if (sum >= s) {
                if (res > (j - i)) {
                    res = j - i;
                }
            }
        }
        if (res == nums.length + 1) {
            res = 0;
        }
        return res;
    }
}
