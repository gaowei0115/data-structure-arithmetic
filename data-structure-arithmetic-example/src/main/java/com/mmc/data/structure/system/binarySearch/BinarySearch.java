package com.mmc.data.structure.system.binarySearch;

import com.mmc.data.structure.system.SortUtils;

/**
 * @packageName：com.mmc.data.structure.system.binarySearch
 * @desrciption: 二分查找
 * @author: gaowei
 * @date： 2018-10-15 9:40
 * @history: (version) author date desc
 */
public class BinarySearch {


    public static void main(String[] args) {
        int[] nums = new int[]{7, 5, 3, 9, 10, 17, 14, 8, 11, 6, 4, 1, 19, 2};
        int target = 19;
        // 排序
        SortUtils.sortInsert(nums);
        SortUtils.print(nums);
        int index = search(nums, target);
        System.out.println("索引位置 ： " + index);
    }

    /**
     * 二分查找，返回索引位置，若不存在，则返回-1
     * @param nums
     * @param target
     * @return
     */
    public static int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        // 查找索引位置
        int index = -1;
        int start = 0;
        int end = nums.length - 1;
        int mid;
        while (start <= end) {
            mid = (end + start) / 2;
            if (nums[mid] < target) {
                start = mid + 1;
            } else if (nums[mid] > target) {
                end = mid - 1;
            } else {
                index = mid;
                break;
            }
        }
        return index;
    }
}
