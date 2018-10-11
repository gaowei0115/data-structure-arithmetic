package com.mmc.data.structure.system.array;

/**
 * @packageName：com.mmc.data.structure.system.array
 * @desrciption: 对数组中颜色分类排序，使用O(1)线程时间
 *                  如：0,1,1,0,2,1,0,2
 *                  结果：0,0,0,1,1,1,2,2
 * @author: gaowei
 * @date： 2018-09-20 10:53
 * @history: (version) author date desc
 */
public class ArrayColorKind {

    public static void main(String[] args) {
        int[] nums = new int[]{2, 0, 1, 0, 2, 1, 0, 2, 1, 0};
//        nums = new int[]{1, 2, 0};
        sortColors(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
    }

    public static void sortColors(int[] nums) {
        int len = nums.length;
        int startI = 0;
        int endI = len - 1;
        for (int i = 0; i <= endI; ) {
            if (nums[i] == 0) {
                int temp = nums[startI];
                nums[startI] = nums[i];
                nums[i] = temp;
                i++;
                startI++;
            } else if (nums[i] == 1) {
                i++;
            } else {
                int temp = nums[i];
                nums[i] = nums[endI];
                nums[endI] = temp;
                endI--;
            }
        }
    }
}
