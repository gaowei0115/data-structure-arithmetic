package com.mmc.data.structure.system.binarySearch;

import java.util.Arrays;

/**
 * @packageName：com.mmc.data.structure.system.binarySearch
 * @desrciption: 寻找旋转排序数组中的最小值 II
                    假设按照升序排序的数组在预先未知的某个点上进行了旋转。
                    ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
                    请找出其中最小的元素。
                    注意数组中可能存在重复的元素。
                    示例 1：
                    输入: [1,3,5]
                    输出: 1
                    示例 2：
                    输入: [2,2,2,0,1]
                    输出: 0

 * @author: gaowei
 * @date： 2018-10-23 14:16
 * @history: (version) author date desc
 */
public class ReverseRepeatArrrayMin {


    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 1};
        int min = findMin(nums);
        System.out.println("nums " + Arrays.toString(nums) + " find min : " + min);
    }

    public static int findMin(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        if (nums.length == 1) {
            return nums[0];
        }

        int low = 0;
        int high = nums.length - 1;
        if (nums[low] < nums[high]) {
            return nums[low];
        } else {
            if(nums.length <= 2) {
                return nums[high];
            }
        }
//        if (nums[high - 1] >= nums[high]) {
//            return nums[high];
//        }

        int mid;
        while (low < high) {
            mid = low + (high - low) / 2;
            if (nums[mid] > nums[high]) {
                low = mid + 1;
            } else if (nums[mid] == nums[high]) {
//                int i = mid;
//                for (; i < high; i++) {
//                    if (nums[high] > nums[i]) {
//                        return nums[i];
//                    }
//                }
//
//                int j = mid - 1;
//                for (; j >= 0; j--) {
//                    if (nums[high] > nums[j]) {
//                        return nums[j];
//                    }
//                }
                high--;
            } else {
                high = mid;
            }
        }
        if (low < nums.length - 1) {
            if (nums[low] > nums[low + 1]) {
                return nums[low + 1];
            }
        }

        return nums[low];
    }
}
