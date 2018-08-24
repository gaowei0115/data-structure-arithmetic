package com.mmc.data.structure.system.hash.utils;

/**
 * @packageName：com.mmc.data.structure.system.hash.utils
 * @desrciption:
 * @author: gaowei
 * @date： 2018-08-13 14:40
 * @history: (version) author date desc
 */
public class MathUtils {


    /**
     * 验证是否素数（质数）
     *  除了1，能被1和自身整除的数
     * @param number
     * @return
     */
    public static boolean primeNumber(int number) {
        // 判定1不是素数
        if (number == 1) {
            return false;
        }
        // 通过开二次方根计算素数
        long value = (long) Math.sqrt(number);
        for (int i = 2; i <= value; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * 求下一个素数
     * @param number
     * @return
     */
    public static int nextPrimeNumber(int number) {
        for (int i = number + 1; i < Integer.MAX_VALUE; i++) {
            if (primeNumber(i)) {
                return i;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        for (int i = 1; i < 100; i++) {
            if (primeNumber(i)) {
                System.out.print(i);
                System.out.print(",");
            }
        }

        System.out.println("求下一个素数：");
        System.out.println(nextPrimeNumber(47));

        System.out.println(11 << 1);
    }
}
