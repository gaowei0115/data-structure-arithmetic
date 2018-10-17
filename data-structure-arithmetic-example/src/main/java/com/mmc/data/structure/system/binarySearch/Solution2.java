package com.mmc.data.structure.system.binarySearch;

/**
 * @packageName：com.mmc.data.structure.system.binarySearch
 * @desrciption:
 * @author: gaowei
 * @date： 2018-10-17 9:40
 * @history: (version) author date desc
 */
public class Solution2 extends VersionControl{

    public Solution2() {}

    public Solution2(int n) {
        super(n);
    }

    public static void main(String[] args) {
        Solution2 solution2 = new Solution2(2);
        int re = solution2.firstBadVersion(2);
        System.out.println("re " + re);
    }

    public int firstBadVersion(int n) {
        if (n <= 0) {
            return -1;
        }

        int low = 1;
        int high = n;
        int mid;
        while (low < high) {
            mid = low + (high - low) / 2;
            if (isBadVersion(mid)) {
                high = mid;
            } else {
                low = mid + 1;
                if (isBadVersion(low)) {
                    return low;
                }
            }
        }
        if (low != n) {
            return low;
        }
        return -1;
    }


}
