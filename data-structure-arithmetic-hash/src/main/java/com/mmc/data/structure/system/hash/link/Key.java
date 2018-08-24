package com.mmc.data.structure.system.hash.link;

/**
 * @packageName：com.mmc.data.structure.system.hash.link
 * @desrciption:
 * @author: gaowei
 * @date： 2018-08-06 17:01
 * @history: (version) author date desc
 */
public class Key {

    String key;
    String value;

    public Key(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Key{" +
                "key='" + key + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}
