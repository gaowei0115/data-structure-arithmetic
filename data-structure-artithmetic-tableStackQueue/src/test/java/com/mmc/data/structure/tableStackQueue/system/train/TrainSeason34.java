package com.mmc.data.structure.tableStackQueue.system.train;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 包 名：com.mmc.data.structure.tableStackQueue.system.train
 * 类 名: TrainSeason34
 * 描 述: 表、栈、队列编程题
 * 作 者: GW
 * 创 建： 2017-10-24 10:44
 * <p>
 * 历 史: (版本) 作者 时间 注释
 */
public class TrainSeason34 {

    /**
     * 给定两个已排序表L1和L2，只使用基本的表操作编写计算L1和L2交集
     */

    /**
     * 使用Collection API List集合实现交集
     */
    @Test
    public void test01() {
        List<String> l1 = new ArrayList<String>();
        List<String> l2 = new ArrayList<String>();

        l1.add("11111");
        l1.add("22222");
        l1.add("33333");
        l1.add("44444");

        l2.add("22222");
        l2.add("55555");
        l2.add("66666");

        List<String> resultList = l1;
        resultList.retainAll(l2);

        for (String str : resultList) {
            System.out.println(str);
        }
    }

    /**
     * 使用Collection API Set集合实现交集
     */
    @Test
    public void test02() {
        Set<String> s1 = new HashSet<String>();
        s1.add("11111");
        s1.add("22222");
        s1.add("33333");
        s1.add("44444");

        Set<String> s2 = new HashSet<String>();
        s2.add("33333");
        s2.add("55555");

        Set<String> resultSet = s1;
        resultSet.retainAll(s2);
        for (String str : resultSet) {
            System.out.println(str);
        }
    }
}
