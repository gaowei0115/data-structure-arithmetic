package com.mmc.data.structure.tableStackQueue.system.train;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 包 名：com.mmc.data.structure.tableStackQueue.system.train
 * 类 名: TrainSeason35
 * 描 述: 表、栈、队列编程题
 * 作 者: GW
 * 创 建： 2017-10-24 14:52
 * <p>
 * 历 史: (版本) 作者 时间 注释
 */
public class TrainSeason35 {


    /**
     * 给定两个已排序表L1和L2，只使用基本表操作编写计算L1和L2并集
     */

    /**
     * 使用Collection API list集合实现并集
     */
    @Test
    public void test01() {
        List<String> L1 = new ArrayList<String>();
        List<String> L2 = new ArrayList<String>();

        L1.add("张三");
        L1.add("李四");
        L1.add("王五");
        L1.add("赵六");
        L1.add("孙琦");

        L2.add("王权");
        L2.add("政治");
        L2.add("顺治");
        L2.add("赵六");

        List<String> result = L1;
        result.removeAll(L2);
        result.addAll(L2);
        System.out.println("List集合求 并集");
        System.out.print("[");
        int i = 0;
        for (String str : result) {
            System.out.print(str);
            i++;
            if (i != result.size()) {
                System.out.print(",");
            }
        }
        System.out.print("]");
    }

    /**
     * 使用Collection API set集合实现并集
     */
    @Test
    public void test02() {
        Set<String> s1 = new HashSet<String>();
        s1.add("嬴政");
        s1.add("刘邦");
        s1.add("刘彻");
        s1.add("曹操");
        s1.add("杨坚");
        s1.add("李世民");

        Set<String> s2 = new HashSet<String>();
        s2.add("赵匡胤");
        s2.add("铁木真");
        s2.add("曹操");
        s2.add("朱元璋");
        s2.add("朱棣");
        s2.add("玄烨");


        System.out.println("Set集合求 并集");
        Set<String> result = s1;
        s2.removeAll(result);
        result.addAll(s2);
        System.out.print("[");
        int i = 0;
        for (String str : result) {
            System.out.print(str);
            i++;
            if (i != result.size()) {
                System.out.print(",");
            }
        }
        System.out.print("]");
    }
}
