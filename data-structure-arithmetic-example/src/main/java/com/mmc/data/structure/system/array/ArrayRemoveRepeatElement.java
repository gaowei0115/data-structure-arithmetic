package com.mmc.data.structure.system.array;

/**
 * @packageName：com.mmc.data.structure.system.array
 * @desrciption: 删除重复元素
 * @author: gaowei
 * @date： 2018-09-19 17:24
 * @history: (version) author date desc
 */
public class ArrayRemoveRepeatElement {

    public static void main(String[] args) {
        int[] nums = new int[]{1};

        int len = removeDuplicates(nums);
        System.out.println(len);
        for (int i = 0; i < len; i++) {
            System.out.print(nums[i] + " ");
        }
    }

    public static int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int j = 0;
        for (int i=0; i < nums.length ; i++) {
            if (nums[i] != nums[j] ) {
                nums[++j] = nums[i];
            }
        }
        j += 1;
        return j;

    }
}
