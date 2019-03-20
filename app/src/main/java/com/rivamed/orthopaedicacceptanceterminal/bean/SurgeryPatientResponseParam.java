package com.rivamed.orthopaedicacceptanceterminal.bean;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

/**
 * @作者: 钱凯
 * @创建时间: 2019/2/21
 * @功能描述:获取手术排班患者返回参数
 */
public class SurgeryPatientResponseParam implements Parcelable {

    /**
     * operateSuccess : true
     * id : 0
     * opFlg : 200
     * pageNo : 1
     * pageSize : 20
     * status : 0
     * surgeryPatientVos : [{"hisPatientId":"5555","patientId":"40288ba96903c4560169044792350000","surgeryId":"40288ba96903c4560169044792710002","patientName":"李斯","gender":"男","caseNo":"8956","roomName":"麻醉科手术间","bedNo":"15236","surgeryName":"阑尾炎手术","doctorName":"手术医生姓名","birthday":"2019-02-19","scheduleTime":"2019-02-19"}]
     */

    private boolean operateSuccess;
    private int id;
    private String opFlg;
    private int pageNo;
    private int pageSize;
    private String status;
    private List<SurgeryPatientVosBean> surgeryPatientVos;

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

    public String getOpFlg() {
        return opFlg;
    }

    public void setOpFlg(String opFlg) {
        this.opFlg = opFlg;
    }

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<SurgeryPatientVosBean> getSurgeryPatientVos() {
        return surgeryPatientVos;
    }

    public void setSurgeryPatientVos(List<SurgeryPatientVosBean> surgeryPatientVos) {
        this.surgeryPatientVos = surgeryPatientVos;
    }

    public static class SurgeryPatientVosBean {
        /**
         * hisPatientId : 5555
         * patientId : 40288ba96903c4560169044792350000
         * surgeryId : 40288ba96903c4560169044792710002
         * patientName : 李斯
         * gender : 男
         * caseNo : 8956
         * roomName : 麻醉科手术间
         * bedNo : 15236
         * surgeryName : 阑尾炎手术
         * doctorName : 手术医生姓名
         * birthday : 2019-02-19
         * scheduleTime : 2019-02-19
         */

        private String hisPatientId = "";
        private String patientId = "";
        private String surgeryId = "";
        private String patientName = "";
        private String gender = "";
        private String caseNo = "";
        private String roomName = "";
        private String bedNo = "";
        private String surgeryName = "";
        private String doctorName = "";
        private String birthday = "";
        private String scheduleTime = "";
        private String height = "";

        public String getHeight() {
            return height;
        }

        public void setHeight(String height) {
            this.height = height;
        }

        public String getHisPatientId() {
            return hisPatientId;
        }

        public void setHisPatientId(String hisPatientId) {
            this.hisPatientId = hisPatientId;
        }

        public String getPatientId() {
            return patientId;
        }

        public void setPatientId(String patientId) {
            this.patientId = patientId;
        }

        public String getSurgeryId() {
            return surgeryId;
        }

        public void setSurgeryId(String surgeryId) {
            this.surgeryId = surgeryId;
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

        public String getRoomName() {
            return roomName;
        }

        public void setRoomName(String roomName) {
            this.roomName = roomName;
        }

        public String getBedNo() {
            return bedNo;
        }

        public void setBedNo(String bedNo) {
            this.bedNo = bedNo;
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

        public String getScheduleTime() {
            return scheduleTime;
        }

        public void setScheduleTime(String scheduleTime) {
            this.scheduleTime = scheduleTime;
        }
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeByte(this.operateSuccess ? (byte) 1 : (byte) 0);
        dest.writeInt(this.id);
        dest.writeString(this.opFlg);
        dest.writeInt(this.pageNo);
        dest.writeInt(this.pageSize);
        dest.writeString(this.status);
        dest.writeList(this.surgeryPatientVos);
    }

    public SurgeryPatientResponseParam() {
    }

    protected SurgeryPatientResponseParam(Parcel in) {
        this.operateSuccess = in.readByte() != 0;
        this.id = in.readInt();
        this.opFlg = in.readString();
        this.pageNo = in.readInt();
        this.pageSize = in.readInt();
        this.status = in.readString();
        this.surgeryPatientVos = new ArrayList<SurgeryPatientVosBean>();
        in.readList(this.surgeryPatientVos, SurgeryPatientVosBean.class.getClassLoader());
    }

    public static final Parcelable.Creator<SurgeryPatientResponseParam> CREATOR = new Parcelable.Creator<SurgeryPatientResponseParam>() {
        @Override
        public SurgeryPatientResponseParam createFromParcel(Parcel source) {
            return new SurgeryPatientResponseParam(source);
        }

        @Override
        public SurgeryPatientResponseParam[] newArray(int size) {
            return new SurgeryPatientResponseParam[size];
        }
    };
}
