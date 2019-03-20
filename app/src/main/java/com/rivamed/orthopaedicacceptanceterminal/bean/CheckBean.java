package com.rivamed.orthopaedicacceptanceterminal.bean;

/**
 * @作者: 钱凯
 * @创建时间: 16-10-25
 * @功能描述:
 */
public class CheckBean {

    protected boolean isCheck;
    protected boolean isWrite;

    public int getAddNum() {
        return addNum;
    }

    public void setAddNum(int addNum) {
        this.addNum = addNum;
    }

    protected int addNum;

    public boolean isCheck() {
        return isCheck;
    }

    public void setCheck(boolean check) {
        isCheck = check;
    }

    public boolean isWrite() {
        return isWrite;
    }

    public void setWrite(boolean write) {
        isWrite = write;
    }
}
