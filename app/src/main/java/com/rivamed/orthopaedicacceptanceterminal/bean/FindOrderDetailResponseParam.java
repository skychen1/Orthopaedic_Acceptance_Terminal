package com.rivamed.orthopaedicacceptanceterminal.bean;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

/**
 * @ProjectName: Orthopaedic_Acceptance_Terminal
 * @Package: com.rivamed.orthopaedicacceptanceterminal.bean
 * @ClassName: FindOrderDetailResponseParam
 * @Description: 获取订单返回参数
 * @Author: Amos_Bo
 * @CreateDate: 2019/2/20 16:26
 * @UpdateUser: 更新者
 * @UpdateDate: 2019/2/20 16:26
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class FindOrderDetailResponseParam implements Parcelable {
    /**
     * id : 0
     * orderId : 40288ba96903bb7c016904589ef50000
     * status : 1
     * surgeryPatientVo : {"hisPatientId":"1002","patientName":"甘道夫","gender":"女","caseNo":"1",
     * "surgeryName":"换头手术","doctorName":"-","birthday":"2019-01-09"}
     * ociSuiteVos : [{"suiteId":"40288ba96903c456016904511d570003","cstBoxCount":0,
     * "instrumentBoxCount":0,"suiteName":"套餐1","vendorName":"云南白药集团股份有限公司","cstCount":0,
     * "instrumentCount":0,"remark":"备注","num":0},{"suiteId":"40288ba96903c456016904535ce80008",
     * "cstBoxCount":0,"instrumentBoxCount":0,"suiteName":"套餐2","vendorName":"1999","cstCount":0,
     * "instrumentCount":0,"remark":"只是备注","num":0}]
     */

    private int id;
    private String orderId;
    private String status;
    private SurgeryPatientVoBean surgeryPatientVo;
    private List<OciSuiteVosBean> ociSuiteVos = new ArrayList<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public SurgeryPatientVoBean getSurgeryPatientVo() {
        return surgeryPatientVo;
    }

    public void setSurgeryPatientVo(SurgeryPatientVoBean surgeryPatientVo) {
        this.surgeryPatientVo = surgeryPatientVo;
    }

    public List<OciSuiteVosBean> getOciSuiteVos() {
        return ociSuiteVos;
    }

    public void setOciSuiteVos(List<OciSuiteVosBean> ociSuiteVos) {
        this.ociSuiteVos = ociSuiteVos;
    }

    public static class SurgeryPatientVoBean implements Parcelable {
        /**
         * hisPatientId : 1002
         * patientName : 甘道夫
         * gender : 女
         * caseNo : 1
         * surgeryName : 换头手术
         * doctorName : -
         * birthday : 2019-01-09
         */

        private String hisPatientId = "";
        private String patientName = "";
        private String gender = "";
        private String caseNo = "";
        private String surgeryName = "";
        private String doctorName = "";
        private String birthday = "";
        private String scheduleTime = "";

        public String getScheduleTime() {
            return scheduleTime;
        }

        public void setScheduleTime(String scheduleTime) {
            this.scheduleTime = scheduleTime;
        }

        public String getHisPatientId() {
            return hisPatientId;
        }

        public void setHisPatientId(String hisPatientId) {
            this.hisPatientId = hisPatientId;
        }

        public String getPatientName() {
            return patientName;
        }

        public void setPatientName(String patientName) {
            this.patientName = patientName;
        }

        public String getGender() {
            return gender;
        }

        public void setGender(String gender) {
            this.gender = gender;
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

        public String getDoctorName() {
            return doctorName;
        }

        public void setDoctorName(String doctorName) {
            this.doctorName = doctorName;
        }

        public String getBirthday() {
            return birthday;
        }

        public void setBirthday(String birthday) {
            this.birthday = birthday;
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(this.hisPatientId);
            dest.writeString(this.patientName);
            dest.writeString(this.gender);
            dest.writeString(this.caseNo);
            dest.writeString(this.surgeryName);
            dest.writeString(this.doctorName);
            dest.writeString(this.birthday);
        }

        public SurgeryPatientVoBean() {
        }

        protected SurgeryPatientVoBean(Parcel in) {
            this.hisPatientId = in.readString();
            this.patientName = in.readString();
            this.gender = in.readString();
            this.caseNo = in.readString();
            this.surgeryName = in.readString();
            this.doctorName = in.readString();
            this.birthday = in.readString();
        }

        public static final Parcelable.Creator<SurgeryPatientVoBean> CREATOR = new Parcelable.Creator<SurgeryPatientVoBean>() {
            @Override
            public SurgeryPatientVoBean createFromParcel(Parcel source) {
                return new SurgeryPatientVoBean(source);
            }

            @Override
            public SurgeryPatientVoBean[] newArray(int size) {
                return new SurgeryPatientVoBean[size];
            }
        };
    }

    public static class OciSuiteVosBean implements Parcelable {
        /**
         * suiteId : 40288ba96903c456016904511d570003
         * cstBoxCount : 0
         * instrumentBoxCount : 0
         * suiteName : 套餐1
         * vendorName : 云南白药集团股份有限公司
         * cstCount : 0
         * instrumentCount : 0
         * remark : 备注
         * num : 0
         */

        private String suiteId;
        private int cstBoxCount;
        private int instrumentBoxCount;
        private String suiteName;
        private String vendorName;
        private int cstCount;
        private int instrumentCount;
        private String remark;
        private int num;

        public String getSuiteId() {
            return suiteId;
        }

        public void setSuiteId(String suiteId) {
            this.suiteId = suiteId;
        }

        public int getCstBoxCount() {
            return cstBoxCount;
        }

        public void setCstBoxCount(int cstBoxCount) {
            this.cstBoxCount = cstBoxCount;
        }

        public int getInstrumentBoxCount() {
            return instrumentBoxCount;
        }

        public void setInstrumentBoxCount(int instrumentBoxCount) {
            this.instrumentBoxCount = instrumentBoxCount;
        }

        public String getSuiteName() {
            return suiteName;
        }

        public void setSuiteName(String suiteName) {
            this.suiteName = suiteName;
        }

        public String getVendorName() {
            return vendorName;
        }

        public void setVendorName(String vendorName) {
            this.vendorName = vendorName;
        }

        public int getCstCount() {
            return cstCount;
        }

        public void setCstCount(int cstCount) {
            this.cstCount = cstCount;
        }

        public int getInstrumentCount() {
            return instrumentCount;
        }

        public void setInstrumentCount(int instrumentCount) {
            this.instrumentCount = instrumentCount;
        }

        public String getRemark() {
            return remark;
        }

        public void setRemark(String remark) {
            this.remark = remark;
        }

        public int getNum() {
            return num;
        }

        public void setNum(int num) {
            this.num = num;
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(this.suiteId);
            dest.writeInt(this.cstBoxCount);
            dest.writeInt(this.instrumentBoxCount);
            dest.writeString(this.suiteName);
            dest.writeString(this.vendorName);
            dest.writeInt(this.cstCount);
            dest.writeInt(this.instrumentCount);
            dest.writeString(this.remark);
            dest.writeInt(this.num);
        }

        public OciSuiteVosBean() {
        }

        protected OciSuiteVosBean(Parcel in) {
            this.suiteId = in.readString();
            this.cstBoxCount = in.readInt();
            this.instrumentBoxCount = in.readInt();
            this.suiteName = in.readString();
            this.vendorName = in.readString();
            this.cstCount = in.readInt();
            this.instrumentCount = in.readInt();
            this.remark = in.readString();
            this.num = in.readInt();
        }

        public static final Parcelable.Creator<OciSuiteVosBean> CREATOR = new Parcelable.Creator<OciSuiteVosBean>() {
            @Override
            public OciSuiteVosBean createFromParcel(Parcel source) {
                return new OciSuiteVosBean(source);
            }

            @Override
            public OciSuiteVosBean[] newArray(int size) {
                return new OciSuiteVosBean[size];
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
        dest.writeString(this.orderId);
        dest.writeString(this.status);
        dest.writeParcelable(this.surgeryPatientVo, flags);
        dest.writeTypedList(this.ociSuiteVos);
    }

    public FindOrderDetailResponseParam() {
    }

    protected FindOrderDetailResponseParam(Parcel in) {
        this.id = in.readInt();
        this.orderId = in.readString();
        this.status = in.readString();
        this.surgeryPatientVo = in.readParcelable(SurgeryPatientVoBean.class.getClassLoader());
        this.ociSuiteVos = in.createTypedArrayList(OciSuiteVosBean.CREATOR);
    }

    public static final Parcelable.Creator<FindOrderDetailResponseParam> CREATOR =
            new Parcelable.Creator<FindOrderDetailResponseParam>() {
                @Override
                public FindOrderDetailResponseParam createFromParcel(Parcel source) {
                    return new FindOrderDetailResponseParam(source);
                }

                @Override
                public FindOrderDetailResponseParam[] newArray(int size) {
                    return new FindOrderDetailResponseParam[size];
                }
            };
}
