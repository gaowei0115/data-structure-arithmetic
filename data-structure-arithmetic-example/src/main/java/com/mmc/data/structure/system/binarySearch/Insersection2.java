package com.mmc.data.structure.system.binarySearch;

import java.util.Arrays;
import java.util.List;

/**
 * @packageName：com.mmc.data.structure.system.binarySearch
 * @desrciption: 给定两个数组，编写一个函数来计算它们的交集。
                    示例 1:
                    输入: nums1 = [1,2,2,1], nums2 = [2,2]
                    输出: [2,2]
                    示例 2:
                    输入: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
                    输出: [4,9]
                    说明：
                    输出结果中每个元素出现的次数，应与元素在两个数组中出现的次数一致。
                    我们可以不考虑输出结果的顺序。
                    进阶:
                    如果给定的数组已经排好序呢？你将如何优化你的算法？
                    如果 nums1 的大小比 nums2 小很多，哪种方法更优？
                    如果 nums2 的元素存储在磁盘上，磁盘内存是有限的，并且你不能一次加载所有的元素到内存中，你该怎么办？

 * @author: gaowei
 * @date： 2018-10-24 10:35
 * @history: (version) author date desc
 */
public class Insersection2 {

    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 2, 3, 4, 4, 5, 5, 6, 7, 10, 10};
        int[] nums2 = new int[]{20, 6, 11, 30, 32, 4, 5, 50, 4, 35, 90, 5, 21, 27, 29, 9, 2, 7};
        int[] reuslt = intersect(nums1, nums2);
        System.out.println("nums1 " + Arrays.toString(nums1));
        System.out.println("join(no repeat)");
        System.out.println("nums2 " + Arrays.toString(nums2));
        System.out.println("result: " + Arrays.toString(reuslt));
    }

    public static int[] intersect(int[] nums1, int[] nums2) {
        if (nums1 == null || nums1.length == 0) {
            return new int[0];
        }

        if (nums2 == null || nums2.length == 0) {
            return new int[0];
        }

        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int[] result = new int[nums1.length];
        if (nums1.length > nums2.length) {
            result = new int[nums2.length];
        }

        int i = 0;
        int j = 0;
        int k = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] == nums2[j]) {
                result[k++] = nums1[i];
                i++;
                j++;
            } else if (nums1[i] > nums2[j]) {
                j++;
            } else {
                i++;
            }
        }
        int[] rs = new int[k];
        for (int n = 0; n < k; n++) {
            rs[n] = result[n];
        }
        return rs;
    }
}
