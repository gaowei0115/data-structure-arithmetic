package com.mmc.data.structure.system.binarySearch;

/**
 * @packageName：com.mmc.data.structure.system.binarySearch
 * @desrciption: 求一个数平方根，迭代使用二分计算
 * @author: gaowei
 * @date： 2018-10-15 11:12
 * @history: (version) author date desc
 */
public class MySqrt {


    public static void main(String[] args) {
        int x = 6;
        int re = mySqrt(x);
//        int re = sqrt1(x);
        System.out.println("sqrt : " + re);

//        System.out.println(4 >> 1);
//        System.out.println(2 << 1);
    }

    public static int mySqrt(int x) {
        if (x == 0) {
            return 0;
        }
        if (x == 1) {
            return 1;
        }


        int end = x;
        int start = 0;
        long mid;
        long sqrt;
        while (start <= end) {
            mid = (long)(end + start) / 2;
            sqrt = mid * mid;

            if (sqrt > x) {
                end = (int)mid - 1;
            } else if (sqrt < x) {
                start = (int)mid + 1;
            } else {
                return (int)mid;
            }
        }
        return end;
    }

    public static int sqrt1(int x) {
        int low = 0;
        int high = x;
        while(low<=high){
            long mid = (long)(low + high)/2;
            if(mid*mid < x) {
                low = (int) mid + 1;
            }
            else if(mid*mid > x) {
                high = (int) mid - 1;
            }
            else {
                return (int) mid;
            }
        }
        return high;
    }

}
