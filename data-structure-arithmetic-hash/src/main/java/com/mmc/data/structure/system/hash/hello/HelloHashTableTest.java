package com.mmc.data.structure.system.hash.hello;

/**
 * @packageName：com.mmc.data.structure.system.hash.hello
 * @desrciption:
 * @author: gaowei
 * @date： 2018-08-03 15:13
 * @history: (version) author date desc
 */
public class HelloHashTableTest {

    public static void main(String[] args) {
        HelloHashTable hashTable = new HelloHashTable();
        hashTable.insert(new HelloHashVo("abc", "zhangsan"));
        hashTable.insert(new HelloHashVo("abd", "lisi"));
        hashTable.insert(new HelloHashVo("abe", "wangwu"));

        System.out.println(hashTable.get("abc").getValue());
        System.out.println(hashTable.get("abd").getValue());
        System.out.println(hashTable.get("abe").getValue());
    }
}
