package com.rivamed.common.bean;


/**
 * Describe：EventBus事件类
 * Created by AmosBo on 2018/10/22.
 */


public class Event<T> {

    private String action;
    private T data;

    public Event(String action) {
        this.action = action;
    }

    public Event(String action, T data) {
        this.action = action;
        this.data = data;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

}
