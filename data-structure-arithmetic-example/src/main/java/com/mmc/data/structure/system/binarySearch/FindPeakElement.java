package com.mmc.data.structure.system.binarySearch;

/**
 * @packageName：com.mmc.data.structure.system.binarySearch
 * @desrciption: 峰值元素是指其值大于左右相邻值的元素。
                给定一个输入数组 nums，其中 nums[i] ≠ nums[i+1]，找到峰值元素并返回其索引。
                数组可能包含多个峰值，在这种情况下，返回任何一个峰值所在位置即可。
                你可以假设 nums[-1] = nums[n] = -∞。

                示例 1:
                输入: nums = [1,2,3,1]
                输出: 2
                解释: 3 是峰值元素，你的函数应该返回其索引 2。

                示例 2:
                输入: nums = [1,2,1,3,5,6,4]
                输出: 1 或 5
                解释: 你的函数可以返回索引 1，其峰值元素为 2；
                或者返回索引 5， 其峰值元素为 6。
                说明:
                你的解法应该是 O(logN) 时间复杂度的。

 * @author: gaowei
 * @date： 2018-10-17 14:52
 * @history: (version) author date desc
 */
public class FindPeakElement {


    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 1, 3, 4, 5, 6};
        int index = findPeakElement(nums);
        System.out.println("result : " + index);
    }

    /**
     *
     * @param nums
     * @return
     */
    public static int findPeakElement(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        if (nums.length == 1) {
            return 0;
        }
        if (nums.length == 2) {
            if (nums[0] < nums[1]) {
                return 1;
            } else {
                return 0;
            }
        }

        int start = 1;
        int end = nums.length-2;
        int mid;
        while(start <=  end) {
            mid = start + (end - start) / 2;
            if (nums[mid - 1] < nums[mid] && nums[mid] > nums[mid + 1]) {
                return mid;
            } else if (nums[mid - 1] < nums[mid + 1]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        if(nums[start] < nums[end]) {
            return end;
        } else {
            return start;
        }
    }

}
