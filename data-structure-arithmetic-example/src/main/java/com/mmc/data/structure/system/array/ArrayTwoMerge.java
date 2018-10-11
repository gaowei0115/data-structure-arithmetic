package com.mmc.data.structure.system.array;

/**
 * @packageName：com.mmc.data.structure.system.array
 * @desrciption: 两个有序的数组合并之后是排序的
 * @author: gaowei
 * @date： 2018-09-26 9:41
 * @history: (version) author date desc
 */
public class ArrayTwoMerge {


    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 2, 4, 7, 9, 0, 0, 0, 0, 0, 0};
        int[] nums2 = new int[]{2, 3, 5, 10};

        int m = 5;
        int n = nums2.length;

        merge(nums1, m, nums2, n);

        System.out.print("result: ");
        for (int i = 0; i < (m + n); i++) {
            System.out.print(nums1[i] + " ");
        }

        System.out.println();
    }


    /**
     * 合并两个数组
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public static void merge(int[] nums1, int m, int[] nums2, int n) {

        /**
         * 插入排序
         */
        for (int i = 0; i < n; i++) {
            int k = m + i;
            nums1[k] = nums2[i];
            int temp = nums1[k];
            while(k > 0 && nums1[k - 1] > temp) {
                nums1[k] = nums1[k - 1];
                k--;
            }
            nums1[k] = temp;
        }
    }
}
