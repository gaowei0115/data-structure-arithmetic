package com.mmc.data.structure.system.hash.hello;

/**
 * @packageName：com.mmc.data.structure.system.hash.hello
 * @desrciption:
 * @author: gaowei
 * @date： 2018-08-01 16:26
 * @history: (version) author date desc
 */
public class HelloHashTable {

    private HelloHashVo[] elements;
    private static final  int DEFAULT_SIZE = 100;
    private int size;

    public HelloHashTable() {
        this(DEFAULT_SIZE);
    }

    public HelloHashTable(int size) {
        this.size = size;
        elements = new HelloHashVo[size];
    }

    public void insert(HelloHashVo info) {
        elements[hash(info.getKey())] = info;
    }

    public HelloHashVo get(String key) {
        return elements[hash(key)];
    }

    public int hash(String key) {
        int hashValue = 0;
        int len = key.length();
        int pow27 = 1;
        for (int i = 0; i < len; i++) {
            int lottery = key.charAt(i) - 96;
            hashValue += lottery * pow27;
            pow27 *= pow27 * 27;
        }
        return hashValue % size;
    }

    public static void main(String[] args) {
        HelloHashTable hashTable = new HelloHashTable();
        int hash = hashTable.hash("abc");
        System.out.println(hash);
    }
}
