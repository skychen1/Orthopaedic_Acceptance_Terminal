package com.rivamed.orthopaedicacceptanceterminal.bean;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

/**
 * @作者: 钱凯
 * @创建时间: 2019/2/21
 * @功能描述:获取所有在院患者返回参数
 */
public class GetAllPatientResponseParam implements Parcelable {

    /**
     * id : 0
     * patients : [{"patientId":"40288ba96903c4560169044792350000","hisPatientId":"5555","patientName":"李斯","pym":"ls","gender":"男","birthday":"2019-02-19","idCard":"身份证号","caseNo":"8956","address":"患者详细住址","createTime":"2019-02-19 13:43:13","updateTime":"2019-02-19 13:43:13"},{"patientId":"ff8081816883bcf0016883fe78a4001a","hisPatientId":"2","patientName":"李四","pym":"ls","gender":"女","birthday":"2019-01-25","idCard":"123123445698745","caseNo":"2","address":"患者详细住址","createTime":"2019-01-25 15:51:59","updateTime":"2019-01-25 15:51:59"},{"patientId":"ff8081816883bcf0016883f9be3d0017","hisPatientId":"1","patientName":"张三","pym":"zs","gender":"男","birthday":"2019-01-25","idCard":"123123445698745","caseNo":"1","address":"患者详细住址","createTime":"2019-01-25 15:46:47","updateTime":"2019-01-25 15:46:47"},{"patientId":"ff808181682d1e120168304962d8002e","hisPatientId":"1002","patientName":"甘道夫","pym":"adf","gender":"女","birthday":"2019-01-09","idCard":"130145123654789654","caseNo":"1","address":"患者详细住址","createTime":"2019-01-09 09:45:42","updateTime":"2019-02-19 14:01:42"}]
     */

    private int id;
    private List<PatientsBean> patients;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<PatientsBean> getPatients() {
        return patients;
    }

    public void setPatients(List<PatientsBean> patients) {
        this.patients = patients;
    }

    public static class PatientsBean {
        /**
         * patientId : 40288ba96903c4560169044792350000
         * hisPatientId : 5555
         * patientName : 李斯
         * pym : ls
         * gender : 男
         * birthday : 2019-02-19
         * idCard : 身份证号
         * caseNo : 8956
         * address : 患者详细住址
         * createTime : 2019-02-19 13:43:13
         * updateTime : 2019-02-19 13:43:13
         */

        private String patientId="";
        private String hisPatientId;
        private String patientName;
        private String pym;
        private String gender;
        private String birthday;
        private String idCard;
        private String caseNo;
        private String address;
        private String createTime;
        private String updateTime;

        public String getPatientId() {
            return patientId;
        }

        public void setPatientId(String patientId) {
            this.patientId = patientId;
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

        public String getPym() {
            return pym;
        }

        public void setPym(String pym) {
            this.pym = pym;
        }

        public String getGender() {
            return gender;
        }

        public void setGender(String gender) {
            this.gender = gender;
        }

        public String getBirthday() {
            return birthday;
        }

        public void setBirthday(String birthday) {
            this.birthday = birthday;
        }

        public String getIdCard() {
            return idCard;
        }

        public void setIdCard(String idCard) {
            this.idCard = idCard;
        }

        public String getCaseNo() {
            return caseNo;
        }

        public void setCaseNo(String caseNo) {
            this.caseNo = caseNo;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getCreateTime() {
            return createTime;
        }

        public void setCreateTime(String createTime) {
            this.createTime = createTime;
        }

        public String getUpdateTime() {
            return updateTime;
        }

        public void setUpdateTime(String updateTime) {
            this.updateTime = updateTime;
        }
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.id);
        dest.writeList(this.patients);
    }

    public GetAllPatientResponseParam() {
    }

    protected GetAllPatientResponseParam(Parcel in) {
        this.id = in.readInt();
        this.patients = new ArrayList<PatientsBean>();
        in.readList(this.patients, PatientsBean.class.getClassLoader());
    }

    public static final Parcelable.Creator<GetAllPatientResponseParam> CREATOR = new Parcelable.Creator<GetAllPatientResponseParam>() {
        @Override
        public GetAllPatientResponseParam createFromParcel(Parcel source) {
            return new GetAllPatientResponseParam(source);
        }

        @Override
        public GetAllPatientResponseParam[] newArray(int size) {
            return new GetAllPatientResponseParam[size];
        }
    };
}
