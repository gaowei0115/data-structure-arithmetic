package com.mmc.data.structure.system.binarySearch;

import java.util.Arrays;

/**
 * @packageName：com.mmc.data.structure.system.binarySearch
 * @desrciption: 二分查找
 *                  在排序数组中查找元素的第一个和最后一个位置
                    给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。

                    你的算法时间复杂度必须是 O(log n) 级别。

                    如果数组中不存在目标值，返回 [-1, -1]。

                    示例 1:

                    输入: nums = [5,7,7,8,8,10], target = 8
                    输出: [3,4]
                    示例 2:

                    输入: nums = [5,7,7,8,8,10], target = 6
                    输出: [-1,-1]
 * @author: gaowei
 * @date： 2018-10-18 10:09
 * @history: (version) author date desc
 */
public class BinaryLocationSearch {


    public static void main(String[] args) {
        int[] nums = new int[]{3, 5, 5, 6, 6, 8, 8, 9, 15};
        nums = new int[]{1, 1, 7, 7, 8, 8, 10, 10};
//        nums = new int[]{1, 2, 2, 2, 3};
        int target = 10;
        int[] re = searchRange(nums, target);
        re = searchRange1(nums, target);
        System.out.println(Arrays.toString(re));
    }

    /**
     * 二分查找
     * @param nums
     * @param target
     * @return
     */
    public static int[] searchRange(int[] nums, int target) {
        int[] result = new int[]{-1, -1};

        if (nums == null || nums.length == 0) {
            return result;
        }

        if (nums.length == 1) {
            if (nums[0] == target) {
                return  new int[]{0, 0};
            } else {
                return result;
            }
        }

        if (nums.length == 2) {
            if (nums[0] == target) {
                return new int[]{0, 0};
            } else if (nums[1] == target) {
                return new int[]{1, 1};
            } else {
                return result;
            }
        }

        int low = 0;
        int high = nums.length - 1;
        int mid;
        int startIndex = -1;
        int endIndex = -1;
        while (low <= high) {
            mid = low + (high - low) / 2;
            if (nums[mid] > target) {
                high = mid - 1;
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                while (mid >= low && nums[mid] == target) {
                    mid--;
                }
                startIndex = mid + 1;
                mid = low + (high - low) / 2;
                while (mid <= high && nums[mid] == target) {
                    mid++;
                }
                endIndex = mid - 1;
                result[0] = startIndex;
                result[1] = endIndex;
                return result;
            }
        }
        return result;
    }

    /**
     * 二分递归原理
     * @param nums
     * @param target
     * @return
     */
    public static int[] searchRange1(int[] nums, int target) {
        int[] result = new int[]{-1, -1};

        if (nums == null || nums.length == 0) {
            return result;
        }

        if (nums.length == 1) {
            if (nums[0] == target) {
                return  new int[]{0, 0};
            } else {
                return result;
            }
        }

        if (nums.length == 2) {
            if (nums[0] == target && nums[1] != target) {
                return new int[]{0, 0};
            } else if (nums[0] == target && nums[1] == target) {
                return new int[]{0, 1};
            } else if (nums[0] != target && nums[1] == target) {
                return new int[]{1, 1};
            } else {
                return result;
            }
        }
        int left = 0;
        int right = nums.length - 1;
        result = new int[]{nums.length, -1};
        searchRange1(nums, target, left, right, result);
        if (result[0] > result[1]) {
            result[0] = -1;
        }
        return result;
    }

    public static void searchRange1(int[] nums, int target, int left, int right, int[] result) {
        if (left > right) {
            return;
        }
        int mid = left + (right - left) / 2;
        if (nums[mid] == target) {
            if (mid < result[0]) {
                result[0] = mid;
                searchRange1(nums, target, left, mid - 1, result);
            }
            if (mid > result[1]) {
                result[1] = mid;
                searchRange1(nums, target, mid + 1, right, result);
            }
        } else if (nums[mid] > target) {
            searchRange1(nums, target, left, mid - 1, result);
        } else {
            searchRange1(nums, target, mid + 1, right, result);
        }
    }
}
