package com.mmc.data.structure.system.binarySearch;

/**
 * @packageName：com.mmc.data.structure.system.binarySearch
 * @desrciption: 查找反转数组
 *                  假设按照升序排序的数组在预先未知的某个点上进行了旋转。

                    ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。

                    搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。

                    你可以假设数组中不存在重复的元素。

                    你的算法时间复杂度必须是 O(log n) 级别。

                    示例 1:

                    输入: nums = [4,5,6,7,0,1,2], target = 0
                    输出: 4
                    示例 2:

                    输入: nums = [4,5,6,7,0,1,2], target = 3
                    输出: -1

 * @author: gaowei
 * @date： 2018-10-16 13:11
 * @history: (version) author date desc
 */
public class ReverseArraySearch {

    public static void main(String[] args) {
        int[] nums = new int[]{8, 9, 10, 12, 14, 3, 5, 6, 7};
        int target = 19;
        int res = search1(nums, target);
        System.out.println("result : " + res);
    }

    public static int search1(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int low = 0;
        int high = nums.length - 1;
        int mid;
        while (low <= high) {
            mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[high] > nums[mid]) {
                if (target <= nums[high] && target > nums[mid]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            } else {
                if (target >= nums[low] && target < nums[mid]) {
                    high = mid - 1;
                } else {
                    low = mid  + 1;
                }
            }
        }
        return -1;
    }

    /**
     * 返回查找下标
     * @param nums
     * @param target
     * @return
     */
    public static int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int left = 0;
        int right = nums.length - 1;
        int mid;
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < nums[right]) {
                if (nums[mid] < target && nums[right] >= target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            } else {
                if (nums[mid] > target && nums[left] <= target) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
        }
        return -1;
    }
}
