package com.mmc.data.structure.system.binarySearch;

/**
 * @packageName：com.mmc.data.structure.system.binarySearch
 * @desrciption:
 * @author: gaowei
 * @date： 2018-10-16 9:57
 * @history: (version) author date desc
 */
public class Solution extends GuessGame {


    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println("seed : " + solution.getPick());
        int pick = solution.guessNumber(2126753390);
        System.out.println("pick : " + pick);
    }

    public int guessNumber(int n) {

        if (n == 0) {
            return 0;
        }
        long low = 1;
        long high = n;
        long mid;
        while (low <= high) {
            mid = ((high - low) / 2 + low);
            long num = (long)getNum((int)mid);
            if (num == 1) {
                high = (int)mid - 1;
            } else if (num == -1) {
                low = (int)mid + 1;
            } else {
                return (int)mid;
            }
        }
        return -1;
    }
}
