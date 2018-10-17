package com.mmc.data.structure.system.binarySearch;

import java.util.Random;

/**
 * @packageName：com.mmc.data.structure.system.binarySearch
 * @desrciption:
 * @author: gaowei
 * @date： 2018-10-17 9:40
 * @history: (version) author date desc
 */
public class VersionControl {

    private int count;
    private int total;

    public VersionControl() {
        this(10);
    }

    public VersionControl(int n) {
        this.total = n;
        Random random = new Random();
        this.count = random.nextInt(total);
        if (this.count == 0) {
            this.count = 1;
        }
    }

    public boolean isBadVersion(int version) {
        System.out.println("count : " + count + ", total : " + total);
        if (version >= count && version <= total) {
            return true;
        }
        return false;
    }
}
