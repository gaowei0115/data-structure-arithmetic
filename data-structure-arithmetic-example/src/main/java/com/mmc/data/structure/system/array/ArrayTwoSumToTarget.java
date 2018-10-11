package com.mmc.data.structure.system.array;

/**
 * @packageName：com.mmc.data.structure.system.array
 * @desrciption: 排序数组，找回唯一两个下标之和为目标数据， 下标是唯一且从1开始
 * @author: gaowei
 * @date： 2018-09-28 9:26
 * @history: (version) author date desc
 */
public class ArrayTwoSumToTarget {


    public static void main(String[] args) {
        int[] nums = new int[]{2, 4, 6, 7, 10, 18};

        int[] indexArr = twoSum(nums, 14);
        System.out.println("两层循环查找：");
        for (int i : indexArr) {
            System.out.print(i + " ");
        }

        System.out.println();
        indexArr = halfSearch(nums, 14);
        System.out.println("折半查找：");
        for (int i : indexArr) {
            System.out.print(i + " ");
        }

        System.out.println();
        indexArr = flSearch(nums, 14);
        System.out.println("首尾指针碰撞查找：");
        for (int i : indexArr) {
            System.out.print(i + " ");
        }
    }

    /**
     * 首尾碰撞查找
     * @param nums
     * @param target
     * @return
     */
    public static int[] flSearch(int[] nums, int target) {
        int f = 0;
        int l = nums.length - 1;
        for(; f < l;) {
            if (nums[f] + nums[l] > target) {
                l--;
                continue;
            } else if (nums[f] + nums[l] < target) {
                f++;
                continue;
            } else {
                return new int[]{f + 1, l + 1};
            }
        }
        return new int[]{0, 0};
    }

    public static int[] twoSum(int[] nums, int target) {
        int[] indexArr = new int[2];
        int len = nums.length;
        int i;
        int j = 0;
        for (i = 0; i < len - 1; i++) {
            j = i + 1;
            while (j < len) {
                if (nums[i] + nums[j] == target) {
                    indexArr[0] = i + 1;
                    indexArr[1] = j + 1;
                    break;
                }
                j++;
            }
            if (indexArr[0] > 0 && indexArr[1] > 0) {
                break;
            }
        }
        return indexArr;
    }


    /**
     * 采用二分查找方式 n * long2N
     * @param nums
     * @param target
     * @return
     */
    public static int[] halfSearch(int[] nums, int target) {

        int i = 0;
        int j = 0;
        int half = 0;
        int temp;

        for (; i < nums.length - 1; i++) {
            temp = target - nums[i];
            half = (nums.length) / 2;
            int halfTemp = nums[half];
            if (temp < halfTemp) {
                for (j = half - 1; j > i; j--) {
                    if (temp == nums[j]) {
                        return new int[]{i + 1, j + 1};
                    }
                }
            } else {
                for (j = half; j < nums.length; j++) {
                    if (temp == nums[j]) {
                        return new int[]{i + 1, j + 1};
                    }
                }
            }
        }
        return new int[] {0, 0};
    }
}

