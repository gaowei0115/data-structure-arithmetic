package com.mmc.data.structure.system.binarySearch;

/**
 * @packageName：com.mmc.data.structure.system.binarySearch
 * @desrciption:
 * @author: gaowei
 * @date： 2018-11-06 10:30
 * @history: (version) author date desc
 */
public class FindMedianSortedArrays {



    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if ((nums1 == null || nums1.length == 0) && (nums2 == null || nums2.length == 0)) {
            return 0.0;
        }

        int low1 = 0;
        int high1 = nums1.length - 1;

        int low2 = 0;
        int high2 = nums2.length - 2;

        int mid1, mid2;

        if (nums1[high1] <= nums2[low2]) {
            return (nums1[high1] + nums2[low2]) / 2;
        }
        if (nums1[low1] >= nums2[high2]) {
            return (nums1[low1] + nums2[high2]) / 2;
        }

        while(low1 <= high1) {
            mid1 = low1 + (high1 - low1) / 2;
            while(low2 <= high2) {
                mid2 = low2 + (high2 - low2) / 2;
                if (nums1[mid1] == nums2[mid2]) {
                    return nums1[mid1];
                } else if (nums1[mid1] < nums2[mid2]) {

                }
            }
        }

        return 1;
    }
}
