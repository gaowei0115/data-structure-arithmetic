package com.mmc.data.structure.tableStackQueue.system.train;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 包 名：com.mmc.data.structure.tableStackQueue.system.train
 * 类 名: TrainSeason38
 * 描 述: 表、栈、队列编程
 * 作 者: GW
 * 创 建： 2017-10-26 15:10
 * <p>
 * 历 史: (版本) 作者 时间 注释
 */
public class TrainSeason38 {

    /**
     *
     */


    /**
     *
     * @param list
     */
    public static void removeFirstHalf(List<?> list) {
        long start = System.currentTimeMillis();
        int theSize = list.size() >> 1;
        for (int i = 0; i < theSize; i++) {
            list.remove(0);
        }
        long end = System.currentTimeMillis();
        System.out.println("cost time " + (end -start) + "ms");
    }

    public static void main(String[] args) {
        List<String> arrayList = new ArrayList<String>();
        arrayList.add("周文王");
        arrayList.add("秦始皇");
        arrayList.add("汉高祖");
        arrayList.add("汉武帝");
        arrayList.add("刘皇叔");
        arrayList.add("魏武帝");
        arrayList.add("隋炀帝");
        arrayList.add("唐高宗");
        arrayList.add("宋徽宗");
        arrayList.add("元大头");
        arrayList.add("明成祖");
        arrayList.add("康熙");

        System.out.println("执行之前：");
        System.out.print("[");
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            System.out.print(arrayList.get(i));
            if (size != i + 1) {
                System.out.print(",");
            }
        }
        removeFirstHalf(arrayList);
        System.out.println("执行之后：");
        size = arrayList.size();
        for (int i = 0; i < size; i++) {
            System.out.print(arrayList.get(i));
            if (size != i + 1) {
                System.out.print(",");
            }
        }


        List<String> linkedList = new LinkedList<String>();
        linkedList.add("周文王");
        linkedList.add("秦始皇");
        linkedList.add("汉高祖");
        linkedList.add("汉武帝");
        linkedList.add("刘皇叔");
        linkedList.add("魏武帝");
        linkedList.add("隋炀帝");
        linkedList.add("唐高宗");
        linkedList.add("宋徽宗");
        linkedList.add("元大头");
        linkedList.add("明成祖");
        linkedList.add("康熙");

        System.out.println("-------------------------------------------");
        System.out.println("执行之前：");
        System.out.print("[");
        size = linkedList.size();
        for (int i = 0; i < size; i++) {
            System.out.print(linkedList.get(i));
            if (size != i + 1) {
                System.out.print(",");
            }
        }
        removeFirstHalf(linkedList);
        System.out.println("执行之后：");
        size = linkedList.size();
        for (int i = 0; i < size; i++) {
            System.out.print(linkedList.get(i));
            if (size != i + 1) {
                System.out.print(",");
            }
        }

    }
}
