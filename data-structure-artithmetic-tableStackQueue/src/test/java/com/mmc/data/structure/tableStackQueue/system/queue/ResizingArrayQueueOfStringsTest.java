package com.mmc.data.structure.tableStackQueue.system.queue;

import org.junit.Test;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @packageName：com.mmc.data.structure.tableStackQueue.system.queue
 * @desrciption:
 * @author: gaowei
 * @date： 2018-01-09 14:11
 * @history: (version) author date desc
 */
public class ResizingArrayQueueOfStringsTest {

    @Test
    public void test() {
        ResizingArrayQueueOfStrings<String> queue = new ResizingArrayQueueOfStrings<String>();
        for (int i = 0; i < 11; i++) {
            queue.push("ceshi-" + i);
        }

        System.out.println("结果：");
        System.out.print("[ ");
        while (!queue.isEmpty()) {
            System.out.print(queue.poll());
            System.out.print(" ");
        }
        System.out.print("]");
    }

    public static void main(String[] args) {
        ResizingArrayQueueOfStrings<String> queue = new ResizingArrayQueueOfStrings<String>();

        // 接收输入参数
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("请输入查找串（以逗点分割）：");
        try {
            String str = br.readLine();
            System.out.println("接收到串：" + str);
            // 解析输入串
            String[] strA = str.split(",");

            for (String s : strA) {
                queue.push(s);
            }

            System.out.print("请输入查找（前序）元素位置：");
            String indexStr = br.readLine();
            System.out.println(queue.getTop(Integer.parseInt(indexStr)));

            System.out.print("请输入查找（后续）元素位置：");
            String lastStr = br.readLine();
            System.out.println(queue.getLast(Integer.parseInt(lastStr)));

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
