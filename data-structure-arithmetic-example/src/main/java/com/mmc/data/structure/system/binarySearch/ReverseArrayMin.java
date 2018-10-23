package com.mmc.data.structure.system.binarySearch;

/**
 * @packageName：com.mmc.data.structure.system.binarySearch
 * @desrciption:
 *              假设按照升序排序的数组在预先未知的某个点上进行了旋转。

                ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。

                请找出其中最小的元素。

                你可以假设数组中不存在重复元素。

                示例 1:

                输入: [3,4,5,1,2]
                输出: 1
                示例 2:

                输入: [4,5,6,7,0,1,2]
                输出: 0
 * @author: gaowei
 * @date： 2018-10-17 15:49
 * @history: (version) author date desc
 */
public class ReverseArrayMin {

    public static void main(String[] args) {
        int[] nums = new int[]{4, 5, 6, 8, 0, 1, 2, 3};
//        nums = new int[]{4, 5, 1, 2, 3};
//        nums = new int[]{1, 2, 3};
        int re = findMin(nums);
        System.out.println("re : " + re);
    }

    public static int findMin(int[] nums) {

        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }

        int low = 0;
        int high = nums.length - 1;
        if (nums[low] < nums[high]) {
            return nums[low];
        }
        if (nums[high - 1] > nums[high]) {
            return nums[high];
        }
        int mid = 0;
        while (low < high) {
            mid = low + (high - low) / 2;
            if (nums[mid] > nums[high]) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        if (nums[low] > nums[low + 1]) {
            return nums[low + 1];
        }
        return nums[low];
    }
}
