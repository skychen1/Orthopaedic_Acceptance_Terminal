package com.rivamed.orthopaedicacceptanceterminal.bean;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

/**
 * @作者: 钱凯
 * @创建时间: 2019/2/21
 * @功能描述:提交订单申请参数
 */
public class SaveOrderRequestBean implements Parcelable {

    /**
     * ociOrder : {"orderType":"2","patientId":"ff808181682d1e120168304962d8002e","surgeryDictId":"1"}
     * ociSuiteVos : [{"suiteId":"40288ba96903c456016904511d570003","remark":"备注"},{"suiteId":"40288ba96903c456016904535ce80008","remark":"只是备注"}]
     */

    private OciOrderBean ociOrder;
    private List<OciSuiteVosBean> ociSuiteVos = new ArrayList<>();

    public OciOrderBean getOciOrder() {
        return ociOrder;
    }

    public void setOciOrder(OciOrderBean ociOrder) {
        this.ociOrder = ociOrder;
    }

    public List<OciSuiteVosBean> getOciSuiteVos() {
        return ociSuiteVos;
    }

    public void setOciSuiteVos(List<OciSuiteVosBean> ociSuiteVos) {
        this.ociSuiteVos = ociSuiteVos;
    }

    public static class OciOrderBean implements Parcelable {
        /**
         * orderType : 2
         * patientId : ff808181682d1e120168304962d8002e
         * surgeryDictId : 1
         */

        private String orderType;
        private String patientId;
        private String surgeryDictId;
        private String surgeryId;

        public String getSurgeryId() {
            return surgeryId;
        }

        public void setSurgeryId(String surgeryId) {
            this.surgeryId = surgeryId;
        }

        public String getOrderType() {
            return orderType;
        }

        public void setOrderType(String orderType) {
            this.orderType = orderType;
        }

        public String getPatientId() {
            return patientId;
        }

        public void setPatientId(String patientId) {
            this.patientId = patientId;
        }

        public String getSurgeryDictId() {
            return surgeryDictId;
        }

        public void setSurgeryDictId(String surgeryDictId) {
            this.surgeryDictId = surgeryDictId;
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(this.orderType);
            dest.writeString(this.patientId);
            dest.writeString(this.surgeryDictId);
        }

        public OciOrderBean() {
        }

        protected OciOrderBean(Parcel in) {
            this.orderType = in.readString();
            this.patientId = in.readString();
            this.surgeryDictId = in.readString();
        }

        public static final Creator<OciOrderBean> CREATOR = new Creator<OciOrderBean>() {
            @Override
            public OciOrderBean createFromParcel(Parcel source) {
                return new OciOrderBean(source);
            }

            @Override
            public OciOrderBean[] newArray(int size) {
                return new OciOrderBean[size];
            }
        };
    }

    public static class OciSuiteVosBean {
        /**
         * suiteId : 40288ba96903c456016904511d570003
         * remark : 备注
         */

        private String suiteId;
        private String remark;

        public String getSuiteId() {
            return suiteId;
        }

        public void setSuiteId(String suiteId) {
            this.suiteId = suiteId;
        }

        public String getRemark() {
            return remark;
        }

        public void setRemark(String remark) {
            this.remark = remark;
        }
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(this.ociOrder, flags);
        dest.writeList(this.ociSuiteVos);
    }

    public SaveOrderRequestBean() {
    }

    protected SaveOrderRequestBean(Parcel in) {
        this.ociOrder = in.readParcelable(OciOrderBean.class.getClassLoader());
        this.ociSuiteVos = new ArrayList<OciSuiteVosBean>();
        in.readList(this.ociSuiteVos, OciSuiteVosBean.class.getClassLoader());
    }

    public static final Parcelable.Creator<SaveOrderRequestBean> CREATOR = new Parcelable.Creator<SaveOrderRequestBean>() {
        @Override
        public SaveOrderRequestBean createFromParcel(Parcel source) {
            return new SaveOrderRequestBean(source);
        }

        @Override
        public SaveOrderRequestBean[] newArray(int size) {
            return new SaveOrderRequestBean[size];
        }
    };
}
