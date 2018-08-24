package com.mmc.data.structure.system.hash.link;

/**
 * @packageName：com.mmc.data.structure.system.hash.link
 * @desrciption:
 * @author: gaowei
 * @date： 2018-08-06 17:29
 * @history: (version) author date desc
 */
public class MyLinkedListMain {

    public static void main(String[] args) {
        MyLinkedList<LinkedInfo> linkedList = new MyLinkedList<>();

        linkedList.insert(new LinkedInfo("a", "zhangsan"));

        linkedList.insert(new LinkedInfo("ct", "lisi"));

        System.out.println(linkedList.get("a"));

        System.out.println("----------------------delete---------------------");
        LinkedInfo info  =linkedList.delete("ct");
        System.out.println(info);

        System.out.println(linkedList.get("a"));

    }
}
