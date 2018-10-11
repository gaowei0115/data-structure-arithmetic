package com.mmc.data.structure.system.array;

/**
 * @packageName：com.mmc.data.structure.system.array
 * @desrciption: 给定 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 *                  说明：你不能倾斜容器，且 n 的值至少为 2。
 * @author: gaowei
 * @date： 2018-10-11 10:43
 * @history: (version) author date desc
 */
public class MaxArea {

    public static void main(String[] args) {
        int[] areas = new int[]{1,8,6,2,5,4,8,3,7};
        int max = maxAreas(areas);
        System.out.println("max : " + max);
    }

    public static int maxAreas(int[] areas) {
        if (areas == null || areas.length == 0) {
            return 0;
        }

        int start = 0;
        int end = areas.length - 1;
        int maxValue = 0;
        int minValue = 0;
        while (start < end) {
            minValue = areas[start];
            if (areas[start] > areas[end]) {
                minValue = areas[end];
            }
            if (maxValue < minValue * (end - start)) {
                maxValue = minValue * (end - start);
            }
            if (areas[start] < areas[end]) {
                start++;
            } else {
                end--;
            }
        }
        return maxValue;
    }

    public static int maxArea(int[] areas) {
        if (areas == null || areas.length == 0) {
            return 0;
        }

        int start = 0;
        int end = areas.length - 1;

        int i = start;
        int j = end;
        int max = 0;
        int min = 0;
        int poitrange = 0;
        while (start < end) {
            min = areas[i];
            if (min > areas[j]) {
                min = areas[j];
            }
            poitrange = j - i;
            if (max < poitrange * min) {
                max = poitrange * min;
            }
            j--;
            if (j == i) {
                i++;
                j = end;
                start++;
            }
        }
        return max;
    }
}
