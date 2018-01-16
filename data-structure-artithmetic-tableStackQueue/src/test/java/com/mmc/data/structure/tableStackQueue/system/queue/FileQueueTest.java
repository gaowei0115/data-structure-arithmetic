package com.mmc.data.structure.tableStackQueue.system.queue;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

/**
 * @packageName：com.mmc.data.structure.tableStackQueue.system.queue
 * @desrciption: 文件列表
 *                      文件夹就是一列文件和文件夹列表。
 *                  编写：
 *                      接受一个文件夹名作为参数，打印出该文件夹下的所有文件并用递归的方式在所有子文件的名下（缩进）列出其
 *                      下的所有文件。
 *                   提示：
 *                      使用队列，并参考java.io.File
 * @author: gaowei
 * @date： 2018-01-16 14:03
 * @history: (version) author date desc
 */
public class FileQueueTest {

    /**
     * 文件根据路径
     */
    private static final String path = "D:\\gw\\mmc";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("input flord: ");
        String fileName = br.readLine();
//        eachFile(fileName);
        eachFile1(fileName);
    }

    /**
     * 根据文件名遍历文件
     * @param fileName
     */
    public static void eachFile(String fileName) {
        String filePath = path.concat("\\").concat(fileName);

        FileQueue<String> fileQueue = new FileQueue<String>();
        fileQueue.enqueue(filePath);
        while (!fileQueue.isEmpty()) {
            File file = new File(fileQueue.dequeue());
            File[] files = file.listFiles();
            System.out.println("-" + file.getName());
            for (File f : files) {
                if (f.isDirectory()) {
                    fileQueue.enqueue(f.getPath());
                } else {
                    System.out.println("--" + f.getName());
                }
            }
        }
    }

    /**
     * 递归查询
     * @param fileName
     */
    public static void eachFile1(String fileName) {
        if (fileName == null || "".equals(fileName)) {
            return;
        }
        File file = new File(fileName);
        System.out.println("-" + fileName);
        File[] files = file.listFiles();
        for (File f : files) {
            if (f.isFile()) {
                System.out.println("--" + f.getName());
            } else {
                eachFile1(f.getPath());
            }
        }
    }
}

/**
 * 文件队列
 * @param <T>
 */
class FileQueue<T extends Comparable<T>> {

    private int top;
    private int tail;
    private int size;
    private T[] elements;
    private static final int DEFAULT_SIZE = 100;

    public FileQueue() {
        this.size = 0;
        this.top = -1;
        this.tail = -1;
        this.elements = (T[]) new Comparable[DEFAULT_SIZE];
    }

    /**
     * 添加队列
     * @param element
     */
    public void enqueue(T element) {
        if (tail == this.elements.length - 1) {
            this.tail = -1;
        }
        elements[++this.tail] = element;
        this.size++;
    }

    /**
     *
     * @return
     */
    public T dequeue() {
        if (top == this.elements.length - 1) {
            this.top = -1;
        }
        T data = elements[++this.top];
        this.size--;
        elements[this.top] = null;
        return data;
    }

    /**
     *
     * @return
     */
    public boolean isEmpty() {
        return (this.size == 0);
    }

    /**
     *
     * @return
     */
    public int size() {
        return this.size;
    }
}
