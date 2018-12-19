package com.data.arithmetic.sort.insert;

import com.data.arithmetic.sort.BaseSort;

import java.util.Random;

/**
 * @packageName：com.data.arithmetic.sort.insert
 * @desrciption:
 * @author: gaowei
 * @date： 2018-12-17 10:14
 * @history: (version) author date desc
 */
public class InsertSort extends BaseSort {

    public InsertSort() {
        super();
    }

    public InsertSort(int size) {
        super(size);
    }

    /**
     * 插入排序
     */
    public void insertSort() {
        int length = this.size;
        int start = 0;
        int end = 1;
        while (end < length) {
            Comparable ele = elements[end];
            start = end;
            while (start > 0 && compareTo(elements[start - 1], ele)) {
                elements[start] = elements[start - 1];
                start--;
            }
            elements[start] = ele;
            end++;
        }
    }


    public void insertSort1() {
        // 内循环
        int in;
        // 外层循环
        int out;
        // 外层循环控制要插入值查找
        for (out = 1; out < size; out++) {
            // 内层循环 控制查找插入位置
            // 内层循环查找范围
            in = out;
            // 要执行插入元素
            Comparable ele = elements[out];
            // 按照倒序
            while (in > 0 && elements[in - 1].compareTo(ele) > 0) {
                // 采用空位法，查找合适位置
                elements[in] = elements[in - 1];
                in--;
            }
            // 根据内层循环找到位置，放入要插入元素
            elements[in] = ele;
        }
    }

    public static void main(String[] args) {
        InsertSort insertSort = new InsertSort();
        Random random = new Random(100);
        int count = 0;
        while (count < 100) {
            insertSort.add(random.nextInt(1000));
            count++;
        }
        System.out.println("sort before : ");
        insertSort.display();

        insertSort.insertSort1();
        System.out.println("sort after : ");
        insertSort.display();


    }
}
