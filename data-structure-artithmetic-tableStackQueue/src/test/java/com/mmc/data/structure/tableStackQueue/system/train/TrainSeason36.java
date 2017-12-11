package com.mmc.data.structure.tableStackQueue.system.train;

import com.mmc.data.structure.tableStackQueue.system.linked.CycLinkedList;
import org.junit.Test;

/**
 * 包 名：com.mmc.data.structure.tableStackQueue.system.train
 * 类 名: TrainSeason36
 * 描 述: 表、栈、队列编程
 * 作 者: GW
 * 创 建： 2017-10-24 15:58
 * <p>
 * 历 史: (版本) 作者 时间 注释
 */
public class TrainSeason36 {

    /**
     * josephus（问题）分析如下游戏规则：
     *      由N个人编号从1到N，围成一个圆圈。从1号开始抛一个热土豆，经过M次传递后拿着热土豆的人清除座位，围坐的圆圈紧缩
     *      ，由被清除后面的人拿起热土豆继续游戏。最后剩下的人获胜。因此，如果M=0和N=5，则游戏人依次被清除，5号游戏人获胜。
     *      如果M=1和N=5，那么被清除人的顺序为2,4,1,5 最终剩下3
     *
     *      编写一个程序解决M和N在一般值下的josephus问题，应使程序尽可能地高效率，确保清除各个单元。
     *      程序运行时间。
     */

    /**
     * 通过数组实现
     */
    @Test
    public void test01() {
        System.out.println("start .....");
        long startTime = System.currentTimeMillis();
        int[] persons = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};
        int m = 1;

        int[] temp = persons;
        int start = m;
        int size = persons.length;
        int index = 0;
        boolean condation = true;
        while (condation && size > 0) {
            if (start > size) {
                start = start % size - 1;
            } else if (start == size) {
                start = 0;
            }
            int [] temp1 = temp;
            int sym = temp[start];
            System.out.println(sym);
            temp = new int[size-1];
            int j = 0;
            for (int i = 0; i < size; i++) {
                if (sym == temp1[i]) {
                    index = j;
                }

                if (start != i) {
                    temp[j++] = temp1[i];
                }

            }
            start = index + m ;
            size = temp.length;
        }
        long endTime = System.currentTimeMillis();
        System.out.println("cost time : " +  (endTime - startTime) + "ms");

    }


    /**
     * 使用循环链表实现
     */
    @Test
    public void tet02() {
        CycLinkedList<Integer> cyc = new CycLinkedList<Integer>();
        for (int i = 1; i <= 10; i++) {
            cyc.push(i);
        }

        cyc.play(0, 2);
    }

}
