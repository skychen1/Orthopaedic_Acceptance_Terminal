package com.rivamed.orthopaedicacceptanceterminal.bean;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

/**
 * @作者: 钱凯
 * @创建时间: 2019/2/21
 * @功能描述:手术信息查询返回参数
 */
public class FindByStatusResponseParam implements Parcelable {

    /**
     * id : 0
     * status : 1
     * surgeryDicts : [{"surgeryDictId":"1","code":"1001","name":"换头手术","remark":null,"status":1,"updateBy":null,"updateTime":null,"updator":null},{"surgeryDictId":"2","code":"1002","name":"洗脑手术","remark":null,"status":1,"updateBy":null,"updateTime":null,"updator":null}]
     */

    private int id;
    private int status;
    private List<SurgeryDictsBean> surgeryDicts;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public List<SurgeryDictsBean> getSurgeryDicts() {
        return surgeryDicts;
    }

    public void setSurgeryDicts(List<SurgeryDictsBean> surgeryDicts) {
        this.surgeryDicts = surgeryDicts;
    }

    public static class SurgeryDictsBean {
        /**
         * surgeryDictId : 1
         * code : 1001
         * name : 换头手术
         * remark : null
         * status : 1
         * updateBy : null
         * updateTime : null
         * updator : null
         */

        private String surgeryDictId="";
        private String code;
        private String name;
        private Object remark;
        private int status;
        private Object updateBy;
        private Object updateTime;
        private Object updator;

        public String getSurgeryDictId() {
            return surgeryDictId;
        }

        public void setSurgeryDictId(String surgeryDictId) {
            this.surgeryDictId = surgeryDictId;
        }

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Object getRemark() {
            return remark;
        }

        public void setRemark(Object remark) {
            this.remark = remark;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public Object getUpdateBy() {
            return updateBy;
        }

        public void setUpdateBy(Object updateBy) {
            this.updateBy = updateBy;
        }

        public Object getUpdateTime() {
            return updateTime;
        }

        public void setUpdateTime(Object updateTime) {
            this.updateTime = updateTime;
        }

        public Object getUpdator() {
            return updator;
        }

        public void setUpdator(Object updator) {
            this.updator = updator;
        }
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.id);
        dest.writeInt(this.status);
        dest.writeList(this.surgeryDicts);
    }

    public FindByStatusResponseParam() {
    }

    protected FindByStatusResponseParam(Parcel in) {
        this.id = in.readInt();
        this.status = in.readInt();
        this.surgeryDicts = new ArrayList<SurgeryDictsBean>();
        in.readList(this.surgeryDicts, SurgeryDictsBean.class.getClassLoader());
    }

    public static final Parcelable.Creator<FindByStatusResponseParam> CREATOR = new Parcelable.Creator<FindByStatusResponseParam>() {
        @Override
        public FindByStatusResponseParam createFromParcel(Parcel source) {
            return new FindByStatusResponseParam(source);
        }

        @Override
        public FindByStatusResponseParam[] newArray(int size) {
            return new FindByStatusResponseParam[size];
        }
    };
}
