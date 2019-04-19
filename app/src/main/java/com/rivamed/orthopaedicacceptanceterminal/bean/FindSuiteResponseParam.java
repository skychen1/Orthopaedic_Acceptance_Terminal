package com.rivamed.orthopaedicacceptanceterminal.bean;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

/**
 * @作者: 钱凯
 * @创建时间: 2019/2/21
 * @功能描述:套餐查询返回参数
 */
public class FindSuiteResponseParam implements Parcelable {

    /**
     * id : 0
     * term : 套
     * cstCount : 0
     * instrumentCount : 0
     * ociSuiteVos : [{"suiteId":"40288ba96903c456016904511d570003","cstBoxCount":0,"instrumentBoxCount":0,"suiteName":"套餐1","vendorName":"云南白药集团股份有限公司","cstCount":2,"instrumentCount":2,"num":0},{"suiteId":"40288ba96903c456016904535ce80008","cstBoxCount":0,"instrumentBoxCount":0,"suiteName":"套餐2","vendorName":"1999","cstCount":3,"instrumentCount":2,"num":0}]
     */

    private int id;
    private String term;
    private int cstCount;
    private int instrumentCount;
    private List<OciSuiteVosBean> ociSuiteVos;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
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

    public List<OciSuiteVosBean> getOciSuiteVos() {
        return ociSuiteVos;
    }

    public void setOciSuiteVos(List<OciSuiteVosBean> ociSuiteVos) {
        this.ociSuiteVos = ociSuiteVos;
    }

    public static class OciSuiteVosBean{
        /**
         * suiteId : 40288ba96903c456016904511d570003
         * cstBoxCount : 0
         * instrumentBoxCount : 0
         * suiteName : 套餐1
         * vendorName : 云南白药集团股份有限公司
         * cstCount : 2
         * instrumentCount : 2
         * num : 0
         */

        private String suiteId;
        private String id="";
        private int cstBoxCount;
        private int instrumentBoxCount;
        private String suiteName;
        private String vendorName;
        private String remark ="";
        private String vendorId ="";
        private int cstCount;
        private int instrumentCount;
        private int num;

        public String getVendorId() {
            return vendorId;
        }

        public void setVendorId(String vendorId) {
            this.vendorId = vendorId;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getRemark() {
            return remark;
        }

        public void setRemark(String remark) {
            this.remark = remark;
        }

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

        public int getNum() {
            return num;
        }

        public void setNum(int num) {
            this.num = num;
        }
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.id);
        dest.writeString(this.term);
        dest.writeInt(this.cstCount);
        dest.writeInt(this.instrumentCount);
        dest.writeList(this.ociSuiteVos);
    }

    public FindSuiteResponseParam() {
    }

    protected FindSuiteResponseParam(Parcel in) {
        this.id = in.readInt();
        this.term = in.readString();
        this.cstCount = in.readInt();
        this.instrumentCount = in.readInt();
        this.ociSuiteVos = new ArrayList<OciSuiteVosBean>();
        in.readList(this.ociSuiteVos, OciSuiteVosBean.class.getClassLoader());
    }

    public static final Parcelable.Creator<FindSuiteResponseParam> CREATOR = new Parcelable.Creator<FindSuiteResponseParam>() {
        @Override
        public FindSuiteResponseParam createFromParcel(Parcel source) {
            return new FindSuiteResponseParam(source);
        }

        @Override
        public FindSuiteResponseParam[] newArray(int size) {
            return new FindSuiteResponseParam[size];
        }
    };
}
