package com.rivamed.orthopaedicacceptanceterminal.bean;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

/**
 * @ProjectName: Orthopaedic_Acceptance_Terminal
 * @Package: com.rivamed.orthopaedicacceptanceterminal.bean
 * @ClassName: FindOrderResponseParam
 * @Description: java类作用描述
 * @Author: Amos_Bo
 * @CreateDate: 2019/2/20 16:22
 * @UpdateUser: 更新者
 * @UpdateDate: 2019/2/20 16:22
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class FindOrderResponseParam implements Parcelable {
    /**
     * id : 0
     * status : 1
     * term : 1
     * startDate : 2019-02-12 14:34
     * endDate : 2019-02-19 14:39
     * ociOrderVos : [{"orderId":"40288ba96903bb7c016904589ef50000","patientName":"甘道夫",
     * "caseNo":"1","surgeryName":"换头手术","createTime":"2019-02-19 14:01","status":"已下单"}]
     */

    private int id;
    private String status;
    private String term;
    private String startDate;
    private String endDate;
    private String msg;
    private List<OciOrderVosBean> ociOrderVos;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public List<OciOrderVosBean> getOciOrderVos() {
        return ociOrderVos;
    }

    public void setOciOrderVos(List<OciOrderVosBean> ociOrderVos) {
        this.ociOrderVos = ociOrderVos;
    }

    public static class OciOrderVosBean implements Parcelable {
        /**
         * orderId : 40288ba96903bb7c016904589ef50000
         * patientName : 甘道夫
         * caseNo : 1
         * surgeryName : 换头手术
         * createTime : 2019-02-19 14:01
         * status : 已下单
         */

        private String orderId;
        private String patientName;
        private String caseNo;
        private String surgeryName;
        private String createTime;
        private String status="";
        private String orderNo;

        public String getOrderNo() {
            return orderNo;
        }

        public void setOrderNo(String orderNo) {
            this.orderNo = orderNo;
        }

        public String getOrderId() {
            return orderId;
        }

        public void setOrderId(String orderId) {
            this.orderId = orderId;
        }

        public String getPatientName() {
            return patientName;
        }

        public void setPatientName(String patientName) {
            this.patientName = patientName;
        }

        public String getCaseNo() {
            return caseNo;
        }

        public void setCaseNo(String caseNo) {
            this.caseNo = caseNo;
        }

        public String getSurgeryName() {
            return surgeryName;
        }

        public void setSurgeryName(String surgeryName) {
            this.surgeryName = surgeryName;
        }

        public String getCreateTime() {
            return createTime;
        }

        public void setCreateTime(String createTime) {
            this.createTime = createTime;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(this.orderId);
            dest.writeString(this.patientName);
            dest.writeString(this.caseNo);
            dest.writeString(this.surgeryName);
            dest.writeString(this.createTime);
            dest.writeString(this.status);
        }

        public OciOrderVosBean() {
        }

        protected OciOrderVosBean(Parcel in) {
            this.orderId = in.readString();
            this.patientName = in.readString();
            this.caseNo = in.readString();
            this.surgeryName = in.readString();
            this.createTime = in.readString();
            this.status = in.readString();
        }

        public static final Parcelable.Creator<OciOrderVosBean> CREATOR = new Parcelable.Creator<OciOrderVosBean>() {
            @Override
            public OciOrderVosBean createFromParcel(Parcel source) {
                return new OciOrderVosBean(source);
            }

            @Override
            public OciOrderVosBean[] newArray(int size) {
                return new OciOrderVosBean[size];
            }
        };
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.id);
        dest.writeString(this.status);
        dest.writeString(this.term);
        dest.writeString(this.startDate);
        dest.writeString(this.endDate);
        dest.writeTypedList(this.ociOrderVos);
    }

    public FindOrderResponseParam() {
    }

    protected FindOrderResponseParam(Parcel in) {
        this.id = in.readInt();
        this.status = in.readString();
        this.term = in.readString();
        this.startDate = in.readString();
        this.endDate = in.readString();
        this.ociOrderVos = in.createTypedArrayList(OciOrderVosBean.CREATOR);
    }

    public static final Parcelable.Creator<FindOrderResponseParam> CREATOR =
            new Parcelable.Creator<FindOrderResponseParam>() {
        @Override
        public FindOrderResponseParam createFromParcel(Parcel source) {
            return new FindOrderResponseParam(source);
        }

        @Override
        public FindOrderResponseParam[] newArray(int size) {
            return new FindOrderResponseParam[size];
        }
    };
}
