package com.mmc.data.structure.system.hash.link;

/**
 * @packageName：com.mmc.data.structure.system.hash.link
 * @desrciption:
 * @author: gaowei
 * @date： 2018-08-06 17:42
 * @history: (version) author date desc
 */
public class LinkedHashTableMain {

    public static void main(String[] args) {
        LinkedHashTable linkedHashTable = new LinkedHashTable();
        linkedHashTable.insert(new LinkedInfo("a", "张三"));

        linkedHashTable.insert(new LinkedInfo("ct", "李四"));


        System.out.println(linkedHashTable.find("a"));
        System.out.println(linkedHashTable.find("ct"));

        System.out.println(linkedHashTable.hashValue("a"));

        System.out.println(linkedHashTable.hashValue("ct"));
    }
}
