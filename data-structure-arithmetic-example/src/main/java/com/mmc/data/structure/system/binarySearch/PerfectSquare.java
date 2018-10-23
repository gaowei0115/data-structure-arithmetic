package com.mmc.data.structure.system.binarySearch;

/**
 * @packageName：com.mmc.data.structure.system.binarySearch
 * @desrciption:
 *                  给定一个正整数 num，编写一个函数，如果 num 是一个完全平方数，则返回 True，否则返回 False。
                    说明：不要使用任何内置的库函数，如  sqrt。
                    示例 1：
                    输入：16
                    输出：True
                    示例 2：
                    输入：14
                    输出：False
 * @author: gaowei
 * @date： 2018-10-23 9:49
 * @history: (version) author date desc
 */
public class PerfectSquare {


    public static void main(String[] args) {
        int num = 1234321;
        boolean result = perfectSquare(num);
        System.out.println("num = " + num + " is " + (result ? "完全平方" : "不完全平方"));
    }

    /**
     * 计算完全平方
     * @param num
     */
    public static boolean perfectSquare(int num) {
        if(num == 0) {
            return true;
        }

        if (num == 1) {
            return true;
        }

        if (num == 2) {
            return false;
        }

        long low = 1;
        long high = num / 2 + 1;
        long mid;
        while (low <= high) {
            mid = low + (high - low) / 2;
            if (mid * mid == num) {
                return true;
            } else if (mid * mid > num) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return false;
    }
}
