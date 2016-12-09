package com.youqiplay.shared;

/**
 * Created by zhouyongbo on 2016/12/7.
 */
public class ObjectResult {
    private String status; //状态
    private Object message; //返回信息
    private Object prompt; //提示信息

    public ObjectResult(String status, Object message) {
        this.status = status;
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Object getMessage() {
        return message;
    }

    public void setMessage(Object message) {
        this.message = message;
    }

    public Object getPrompt() {
        return prompt;
    }

    public void setPrompt(Object prompt) {
        this.prompt = prompt;
    }
}
