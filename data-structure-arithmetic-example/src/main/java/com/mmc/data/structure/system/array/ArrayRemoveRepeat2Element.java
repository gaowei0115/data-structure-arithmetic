package com.mmc.data.structure.system.array;

/**
 * @packageName：com.mmc.data.structure.system.array
 * @desrciption: 删除排序数组中重复元素（重复元素最多保留两个）
 * @author: gaowei
 * @date： 2018-09-20 9:17
 * @history: (version) author date desc
 */
public class ArrayRemoveRepeat2Element {


    public static void main(String[] args) {
        int[] nums = new int[]{0, 0, 0, 1, 1, 1, 3, 3, 4, 5, 5, 5, 5, 5};
        nums = new int[]{1, 2, 3};
        int len = removeDuplicates(nums);
        System.out.println("len : " + len);
        for (int i = 0; i < len; i++) {
            System.out.print(nums[i] + " ");
        }
    }


    /**
     * 分析
     * d: 0, 0, 0, 1, 1, 1, 3, 3, 4, 5, 5, 5, 5, 5
     * c: 0, 0
     */

    /**
     * 删除数组中重复元素
     * @param nums
     * @return
     */
    public static int removeDuplicates(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return 0;
        }
        int count = 0;
        int j = 1;
        for (int i = 1; i < len; i++) {
            if (nums[i] != nums[j - 1]) {
                count = 0;
                nums[j++] = nums[i];
            } else {
                count++;
                if (count > 1) {
                    continue;
                }
                nums[j++] = nums[i];
            }
        }
        return j;
    }
}
