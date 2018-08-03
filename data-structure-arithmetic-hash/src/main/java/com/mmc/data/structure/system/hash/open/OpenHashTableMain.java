package com.mmc.data.structure.system.hash.open;

/**
 * @packageName：com.mmc.data.structure.system.hash.open
 * @desrciption:
 * @author: gaowei
 * @date： 2018-08-03 16:19
 * @history: (version) author date desc
 */
public class OpenHashTableMain {

    public static void main(String[] args) {
        OpenHashTable oht = new OpenHashTable();
        System.out.println("insert data ");
        oht.insert(new OpenHashVo("abc", "张三"));
        oht.insert(new OpenHashVo("bcd", "李四"));
        oht.insert(new OpenHashVo("cde", "王五"));

        System.out.println("get data : ");
        System.out.println(oht.get("abc").getValue());
        System.out.println(oht.get("bcd").getValue());
        System.out.println(oht.get("cde").getValue());

        System.out.println("delete data : ");
        System.out.println(oht.delete("bcd").getValue());

        System.out.println("get delete data : ");
        System.out.println(oht.get("bcd"));
    }
}
