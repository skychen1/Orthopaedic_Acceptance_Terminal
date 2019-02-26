package com.rivamed.orthopaedicacceptanceterminal.bean;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * @作者: 钱凯
 * @创建时间: 2019/2/21
 * @功能描述:提交订单申请返回参数
 */
public class SaveOrderResponseParam implements Parcelable {

    /**
     * operateSuccess : true
     * id : 0
     * msg : 申请成功
     */

    private boolean operateSuccess;
    private int id;
    private String msg;

    public boolean isOperateSuccess() {
        return operateSuccess;
    }

    public void setOperateSuccess(boolean operateSuccess) {
        this.operateSuccess = operateSuccess;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeByte(this.operateSuccess ? (byte) 1 : (byte) 0);
        dest.writeInt(this.id);
        dest.writeString(this.msg);
    }

    public SaveOrderResponseParam() {
    }

    protected SaveOrderResponseParam(Parcel in) {
        this.operateSuccess = in.readByte() != 0;
        this.id = in.readInt();
        this.msg = in.readString();
    }

    public static final Parcelable.Creator<SaveOrderResponseParam> CREATOR = new Parcelable.Creator<SaveOrderResponseParam>() {
        @Override
        public SaveOrderResponseParam createFromParcel(Parcel source) {
            return new SaveOrderResponseParam(source);
        }

        @Override
        public SaveOrderResponseParam[] newArray(int size) {
            return new SaveOrderResponseParam[size];
        }
    };
}
