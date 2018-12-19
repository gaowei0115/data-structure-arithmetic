package com.data.arithmetic.sort.common;

import java.util.Collections;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * @packageName：com.data.arithmetic.sort.common
 * @desrciption: 产生随机数
 * @author: gaowei
 * @date： 2018-12-18 10:50
 * @history: (version) author date desc
 */
public class RandomUtils {


    private static final int SEED = 100;

    private static final Random random = new Random(SEED);

    private static final int DEFAULT_SIZE = 10;

    /**
     * 产生随机数组
     * @return
     */
    public static Integer[] randomIntArray() {
        return randomIntArray(DEFAULT_SIZE, SEED);
    }

    /**
     * 产生随机数
     * @param seed
     *          指定产生随机数种子
     * @return
     */
    public static Integer[] randomIntArray(int count, int seed) {
        Integer[] returnArray  = new Integer[count];

        Set<Integer> set = new HashSet<Integer>();
        while (set.size() != count) {
            set.add(random.nextInt(seed));
        }

        returnArray = set.toArray(new Integer[set.size()]);
        return returnArray;
    }

}
