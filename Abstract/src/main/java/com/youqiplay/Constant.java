package com.youqiplay;

/**
 * Created by zhouyongbo on 2016/12/11.
 */
public enum Constant {
    COOKIE_NAME("cookie","youqitoken");


    private String key;
    private String value;

    Constant(String key, String value) {
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
