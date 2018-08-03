package com.mmc.data.structure.system.hash.open;

import java.io.Serializable;

/**
 * @packageName：com.mmc.data.structure.system.hash.open
 * @desrciption:
 * @author: gaowei
 * @date： 2018-08-03 15:45
 * @history: (version) author date desc
 */
public class OpenHashVo implements Serializable {

    private static final long serialVersionUID = -2687763121215845054L;

    private String key;
    private String value;

    public OpenHashVo() {}

    public OpenHashVo(String key, String value) {
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
