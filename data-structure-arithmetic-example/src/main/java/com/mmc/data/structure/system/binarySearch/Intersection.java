package com.mmc.data.structure.system.binarySearch;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;

/**
 * @packageName：com.mmc.data.structure.system.binarySearch
 * @desrciption: 两个数组的交集
                    给定两个数组，编写一个函数来计算它们的交集。
                    示例 1:
                    输入: nums1 = [1,2,2,1], nums2 = [2,2]
                    输出: [2]
                    示例 2:
                    输入: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
                    输出: [9,4]
                    说明:
                    输出结果中的每个元素一定是唯一的。
                    我们可以不考虑输出结果的顺序。

 * @author: gaowei
 * @date： 2018-10-24 9:35
 * @history: (version) author date desc
 */
public class Intersection {

    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 2, 3, 4, 4, 5, 5, 6, 7, 10, 10};
        int[] nums2 = new int[]{20, 6, 11, 30, 32, 50, 35, 90, 21, 27, 29, 9, 2, 7};
        int[] reuslt = insersection(nums1, nums2);
        System.out.println("nums1 " + Arrays.toString(nums1));
        System.out.println("join(no repeat)");
        System.out.println("nums2 " + Arrays.toString(nums2));
        System.out.println("result: " + Arrays.toString(reuslt));
    }


    public static int[] insersection(int[] nums1, int[] nums2) {
        if (nums1 == null || nums1.length == 0) {
            return new int[0];
        }

        if (nums2 == null || nums2.length == 0) {
            return new int[0];
        }

        Set<Integer> set = new HashSet<>();
        if (nums1.length > nums2.length) {
            Arrays.sort(nums1);
            /**
             * 对一个数组进行排序，使用二分查找思想操作
             */
            for (int i = 0; i < nums2.length; i++) {
                int r = searchBinary(nums1, nums2[i]);
                if (r != -1) {
                    set.add(r);
                }
            }
        } else {
            Arrays.sort(nums2);
            /**
             * 对一个数组进行排序，使用二分查找思想操作
             */
            for (int i = 0; i < nums1.length; i++) {
                int r = searchBinary(nums2, nums1[i]);
                if (r != -1) {
                    set.add(r);
                }
            }
        }
        Integer[] integers = set.toArray(new Integer[set.size()]);
        int[] result = new int[integers.length];
        int i = 0;
        for (int key : integers){
            result[i++] = key;
        }
        return result;
    }


    public static int searchBinary(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        int mid;
        while (low <= high) {
            mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                return nums[mid];
            } else if (nums[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }



}
