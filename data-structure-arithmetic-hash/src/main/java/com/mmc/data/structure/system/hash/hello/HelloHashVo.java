package com.mmc.data.structure.system.hash.hello;

import java.io.Serializable;

/**
 * @packageName：com.mmc.data.structure.system.hash.hello
 * @desrciption:
 * @author: gaowei
 * @date： 2018-08-01 16:04
 * @history: (version) author date desc
 */
public class HelloHashVo implements Serializable{

    private static final long serialVersionUID = 1388959906406802743L;

    private String key;
    private String value;

    public HelloHashVo(String key, String value) {
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
}
