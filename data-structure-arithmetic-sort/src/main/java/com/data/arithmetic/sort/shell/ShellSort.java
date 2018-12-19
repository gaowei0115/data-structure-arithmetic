package com.data.arithmetic.sort.shell;

import com.data.arithmetic.sort.BaseSort;
import com.data.arithmetic.sort.common.RandomUtils;

/**
 * @packageName：com.data.arithmetic.sort.shell
 * @desrciption: 希尔排序
 * @author: gaowei
 * @date： 2018-12-18 10:47
 * @history: (version) author date desc
 */
public class ShellSort extends BaseSort{

    public ShellSort() {
        super();
    }

    public ShellSort(int size) {
        super(size);
    }

    /**
     * shell排序
     */
    public void shellSort() {
        int size = this.size;
        Comparable[] elements = this.elements;

        int shell = 0;
        for (shell = size / 2; shell > 0; shell = shell / 2) {
            int in = 0;
            int out = 0;
            for (out = shell; out < size; out++) {
                Comparable ele = elements[out];
                for (in = out; in >= shell && ele.compareTo(elements[in - shell]) < 0; in = in - shell) {
                    elements[in] = elements[in - shell];
                }
                elements[in] = ele;
            }
        }
    }

    public static void main(String[] args) {
        ShellSort shellSort = new ShellSort(10);

        Integer[] array = RandomUtils.randomIntArray();

        shellSort.addAll(array);

        System.out.println("shell before: ");
        shellSort.display();

        shellSort.shellSort();

        System.out.println("shell after: ");
        shellSort.display();
    }
}
