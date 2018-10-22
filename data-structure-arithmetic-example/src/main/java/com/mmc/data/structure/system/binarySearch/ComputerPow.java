package com.mmc.data.structure.system.binarySearch;

/**
 * @packageName：com.mmc.data.structure.system.binarySearch
 * @desrciption: 实现 pow(x, n) ，即计算 x 的 n 次幂函数。
                    示例 1:
                    输入: 2.00000, 10
                    输出: 1024.00000
                    示例 2:
                    输入: 2.10000, 3
                    输出: 9.26100
                    示例 3:
                    输入: 2.00000, -2
                    输出: 0.25000
                    解释: 2-2 = 1/22 = 1/4 = 0.25
                    说明:
                    -100.0 < x < 100.0
                    n 是 32 位有符号整数，其数值范围是 [−231, 231 − 1] 。
 * @author: gaowei
 * @date： 2018-10-22 13:32
 * @history: (version) author date desc
 */
public class ComputerPow {

    public static void main(String[] args) {
        double x = 2.0;
        int n = Integer.MIN_VALUE;
        double reuslt = myPow(x, n);
        System.out.println("pow(" + x + ", " + n + ") = " + reuslt);

        System.out.println(Double.isInfinite(reuslt));

        System.out.println(Integer.MIN_VALUE);
    }


    /**
     * 二分递归思想
     * @param x
     * @param n
     * @return
     */
    public static double myPow(double x, int n) {

        if (n == 0) {
            return 1.0;
        }

        if (n == 1) {
            return x;
        }

        if(n == Integer.MIN_VALUE) {
            return 1 / myPow(x, n + 1) / x;
        }
        if (n < 0) {
            n = -n;
            x = 1 / x;
        }
        if (n % 2 != 0) {
            return x * myPow(x * x, n / 2);
        } else {
            return myPow(x * x, n / 2);
        }

//        if (half == 0.0 || half == -0.0) {
//            return 0;
//        }
//        return half;

//        if (n < 0) {
//           if (n == Integer.MIN_VALUE) {
//                return 1.0 / myPow(x, Integer.MIN_VALUE) / x;
//           } else {
//               return 1.0 / myPow(x, -n);
//           }
//        }
//
//        double half = myPow(x, n >> 1);
//        half *= half;
//        if ((n & 1) == 1) {
//            half *= x;
//        }
//        return half;
//        if (n % 2 == 0) {
//            return half * half;
//        } else {
//            return x * half * half;
//        }
    }


    public static double myPow2(double x, int n) {

        if (n == 0) {
            return 1;
        }
        if (n == Integer.MIN_VALUE) {
            return 1 / x * myPow2(x, n + 1);
        }

        if (n < 0) {
            n = -n;
            x = 1 / x;
        }

        return (n % 2 == 0) ? myPow2(x * x, n / 2) : x * myPow2(x * x, n / 2);
    }

    /**
     * 通过递归实现
     * @param x
     * @param n
     * @return
     */
    public static double mypow1(double x, int n) {
        if (n > 0) {
            return positivePow1(x, n);
        } else if (n == 0) {
            return 1;
        } else {
            return 1 / positivePow1(x, -n);
        }
    }

    /**
     * 递归
     * @param x
     * @param n
     * @return
     */
    public static double positivePow1(double x, int n) {
        if (n == 1) {
            return x;
        }

        double half = positivePow1(x, n / 2);
        if (half % 2 == 0) {
            return half * half;
        } else {
            return x * half * half;
        }
    }


}
