package com.mmc.data.structure.system.array;

/**
 * @packageName：com.mmc.data.structure.system.array
 * @desrciption: 查找数组中第K个最大元素
 * @author: gaowei
 * @date： 2018-09-25 9:28
 * @history: (version) author date desc
 */
public class ArrayFindKLargest {


    public static void main(String[] args) {
        int[] nums = new int[]{2, 3, 1, 5, 4, 8, 9, 10, 7, 6, 11};
        nums = new int[]{2, 1};
        System.out.println(findKthLargest(nums, 1));
    }

    public static int findKthLargest(int[] nums, int k) {
        if (k == 0) {
            return 0;
        }

        int temp ;
        int i;
        int j;
        for (i = 1; i < nums.length ; i++) {
            temp = nums[i];
            j = i;
            while (j > 0 && temp > nums[j - 1]) {
                nums[j] = nums[j - 1];
                j--;
            }
            nums[j] = temp;
        }
        return nums[k - 1];
    }
}
