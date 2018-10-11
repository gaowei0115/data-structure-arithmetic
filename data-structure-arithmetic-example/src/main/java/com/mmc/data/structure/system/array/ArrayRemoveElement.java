package com.mmc.data.structure.system.array;

/**
 * @packageName：com.mmc.data.structure.system.array
 * @desrciption:
 * @author: gaowei
 * @date： 2018-09-19 9:44
 * @history: (version) author date desc
 */
public class ArrayRemoveElement {


    public static void main(String[] args) {
        int[] nums = new int[]{3, 2, 4, 5, 3};
        nums = new int[]{3, 3};
        int len = removeElement(nums, 3);
        System.out.println(len);
        for (int i = 0; i < len; i++) {
            System.out.print(nums[i] + " ");
        }
    }

    public static int removeElement(int[] nums, int val){
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[j++] = nums[i];
            }
        }
        return j;
    }


}
