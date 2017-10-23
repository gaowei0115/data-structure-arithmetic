package com.mmc.data.structure.tableStackQueue.system.train;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 包 名：com.mmc.data.structure.tableStackQueue.system.train
 * 类 名: TrainSeason31
 * 描 述: 表、栈、队列编程题
 * 作 者: GW
 * 创 建： 2017-10-23 14:19
 * <p>
 * 历 史: (版本) 作者 时间 注释
 */
public class TrainSeason31 {

    /**
     *  3.1 给定一个表L和另一个表P，它们包含升序排列的整数，操作printLots(L, P)将打印出那些由P所指定的位置上的元素。
     *  例如：如果P=1,3,4,6，那么，L中位于第1、第3、第4和第6个位置上的元素打印出来。写出过程printLots(L, P)。只能使用
     *  public型Collection API容器操作。计算该过程需要时间。
     */

    /**
     * 在集合l中打印指定为集合p的元素
     * @param l
     * @param p
     */
    public static void printLots(List<Integer> l, List<Integer> p) {
        if (l == null || l.size() == 0) {
            System.out.println("需要查找的源对象为空");
        }

        if (p == null || p.size() == 0) {
            System.out.println("目标定位对象为空");
        }
        long start = System.currentTimeMillis();
        for (Integer i : p) {
            System.out.println(l.get(i.intValue()));
        }

        long end = System.currentTimeMillis();
        System.out.println("cost time : " +  (end - start) + "ms");
    }

    /**
     * 测试入口
     * @param args
     */
    public static void main(String[] args) {
        List<Integer> l = new ArrayList<Integer>();
        List<Integer> p = new ArrayList<Integer>();
        Random random = new Random();

        for (int i = 0; i < 10000; i++) {
            l.add(random.nextInt(99999999));
        }

        for (int i = 0; i < 10000; i++) {
            if (i % 3 == 0 && i != 0) {
                p.add(i);
            }
        }

        printLots(l, p);
    }
}
