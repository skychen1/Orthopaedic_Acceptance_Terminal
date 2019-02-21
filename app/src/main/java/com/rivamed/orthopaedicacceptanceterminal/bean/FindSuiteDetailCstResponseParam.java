package com.rivamed.orthopaedicacceptanceterminal.bean;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

/**
 * @ProjectName: Orthopaedic_Acceptance_Terminal
 * @Package: com.rivamed.orthopaedicacceptanceterminal.bean
 * @ClassName: FindSuiteDetailResponseParam
 * @Description:  套餐明细（耗材、器械）
 * @Author: Amos_Bo
 * @CreateDate: 2019/2/20 17:19
 * @UpdateUser: 更新者
 * @UpdateDate: 2019/2/20 17:19
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class FindSuiteDetailCstResponseParam implements Parcelable {

    /**
     * id : 0
     * suiteId : 40288ba96903c456016904511d570003
     * suiteName : 套餐1
     * vendorName : 云南白药集团股份有限公司
     * cstCount : 2
     * instrumentCount : 2
     * asepticCstCount : 0
     * eliminationCstCount : 0
     * csts : [{"cstBoxCount":0,"instrumentBoxCount":0,"cstCount":0,"instrumentCount":0,
     * "cstName":"载玻片（世泰）","cstCode":"2014wg00401897","cstSpec":"双面磨砂","cstType":"1","num":1},{
     * "cstBoxCount":0,"instrumentBoxCount":0,"cstCount":0,"instrumentCount":0,"cstName":"咽喉镜",
     * "cstCode":"2014wg00401977","cstSpec":"-10","cstType":"0","num":1}]
     * instruments : [{"cstBoxCount":0,"instrumentBoxCount":0,"cstCount":0,"instrumentCount":0,
     * "name":"螺丝刀","code":"1001","num":1},{"cstBoxCount":0,"instrumentBoxCount":0,"cstCount":0,
     * "instrumentCount":0,"name":"扳手","code":"1002","num":1}]
     */

    private int id;
    private String suiteId;
    private String suiteName;
    private String vendorName;
    private int cstCount;
    private int instrumentCount;
    private int asepticCstCount;
    private int eliminationCstCount;
    private List<CstsBean> csts;
    private List<InstrumentsBean> instruments;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSuiteId() {
        return suiteId;
    }

    public void setSuiteId(String suiteId) {
        this.suiteId = suiteId;
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

    public int getAsepticCstCount() {
        return asepticCstCount;
    }

    public void setAsepticCstCount(int asepticCstCount) {
        this.asepticCstCount = asepticCstCount;
    }

    public int getEliminationCstCount() {
        return eliminationCstCount;
    }

    public void setEliminationCstCount(int eliminationCstCount) {
        this.eliminationCstCount = eliminationCstCount;
    }

    public List<CstsBean> getCsts() {
        return csts;
    }

    public void setCsts(List<CstsBean> csts) {
        this.csts = csts;
    }

    public List<InstrumentsBean> getInstruments() {
        return instruments;
    }

    public void setInstruments(List<InstrumentsBean> instruments) {
        this.instruments = instruments;
    }

    public static class CstsBean implements Parcelable {
        /**
         * cstBoxCount : 0
         * instrumentBoxCount : 0
         * cstCount : 0
         * instrumentCount : 0
         * cstName : 载玻片（世泰）
         * cstCode : 2014wg00401897
         * cstSpec : 双面磨砂
         * cstType : 1
         * num : 1
         */

        private int cstBoxCount;
        private int instrumentBoxCount;
        private int cstCount;
        private int instrumentCount;
        private String cstName;
        private String cstCode;
        private String cstSpec;
        private String cstType;
        private int num;

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

        public String getCstName() {
            return cstName;
        }

        public void setCstName(String cstName) {
            this.cstName = cstName;
        }

        public String getCstCode() {
            return cstCode;
        }

        public void setCstCode(String cstCode) {
            this.cstCode = cstCode;
        }

        public String getCstSpec() {
            return cstSpec;
        }

        public void setCstSpec(String cstSpec) {
            this.cstSpec = cstSpec;
        }

        public String getCstType() {
            return cstType;
        }

        public void setCstType(String cstType) {
            this.cstType = cstType;
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
            dest.writeInt(this.cstBoxCount);
            dest.writeInt(this.instrumentBoxCount);
            dest.writeInt(this.cstCount);
            dest.writeInt(this.instrumentCount);
            dest.writeString(this.cstName);
            dest.writeString(this.cstCode);
            dest.writeString(this.cstSpec);
            dest.writeString(this.cstType);
            dest.writeInt(this.num);
        }

        public CstsBean() {
        }

        protected CstsBean(Parcel in) {
            this.cstBoxCount = in.readInt();
            this.instrumentBoxCount = in.readInt();
            this.cstCount = in.readInt();
            this.instrumentCount = in.readInt();
            this.cstName = in.readString();
            this.cstCode = in.readString();
            this.cstSpec = in.readString();
            this.cstType = in.readString();
            this.num = in.readInt();
        }

        public static final Parcelable.Creator<CstsBean> CREATOR = new Parcelable.Creator<CstsBean>() {
            @Override
            public CstsBean createFromParcel(Parcel source) {
                return new CstsBean(source);
            }

            @Override
            public CstsBean[] newArray(int size) {
                return new CstsBean[size];
            }
        };
    }

    public static class InstrumentsBean implements Parcelable {
        /**
         * cstBoxCount : 0
         * instrumentBoxCount : 0
         * cstCount : 0
         * instrumentCount : 0
         * name : 螺丝刀
         * code : 1001
         * num : 1
         */

        private int cstBoxCount;
        private int instrumentBoxCount;
        private int cstCount;
        private int instrumentCount;
        private String name;
        private String code;
        private int num;

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

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
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
            dest.writeInt(this.cstBoxCount);
            dest.writeInt(this.instrumentBoxCount);
            dest.writeInt(this.cstCount);
            dest.writeInt(this.instrumentCount);
            dest.writeString(this.name);
            dest.writeString(this.code);
            dest.writeInt(this.num);
        }

        public InstrumentsBean() {
        }

        protected InstrumentsBean(Parcel in) {
            this.cstBoxCount = in.readInt();
            this.instrumentBoxCount = in.readInt();
            this.cstCount = in.readInt();
            this.instrumentCount = in.readInt();
            this.name = in.readString();
            this.code = in.readString();
            this.num = in.readInt();
        }

        public static final Parcelable.Creator<InstrumentsBean> CREATOR = new Parcelable.Creator<InstrumentsBean>() {
            @Override
            public InstrumentsBean createFromParcel(Parcel source) {
                return new InstrumentsBean(source);
            }

            @Override
            public InstrumentsBean[] newArray(int size) {
                return new InstrumentsBean[size];
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
        dest.writeString(this.suiteId);
        dest.writeString(this.suiteName);
        dest.writeString(this.vendorName);
        dest.writeInt(this.cstCount);
        dest.writeInt(this.instrumentCount);
        dest.writeInt(this.asepticCstCount);
        dest.writeInt(this.eliminationCstCount);
        dest.writeTypedList(this.csts);
        dest.writeTypedList(this.instruments);
    }

    public FindSuiteDetailCstResponseParam() {
    }

    protected FindSuiteDetailCstResponseParam(Parcel in) {
        this.id = in.readInt();
        this.suiteId = in.readString();
        this.suiteName = in.readString();
        this.vendorName = in.readString();
        this.cstCount = in.readInt();
        this.instrumentCount = in.readInt();
        this.asepticCstCount = in.readInt();
        this.eliminationCstCount = in.readInt();
        this.csts = in.createTypedArrayList(CstsBean.CREATOR);
        this.instruments = in.createTypedArrayList(InstrumentsBean.CREATOR);
    }

    public static final Parcelable.Creator<FindSuiteDetailCstResponseParam> CREATOR =
            new Parcelable.Creator<FindSuiteDetailCstResponseParam>() {
        @Override
        public FindSuiteDetailCstResponseParam createFromParcel(Parcel source) {
            return new FindSuiteDetailCstResponseParam(source);
        }

        @Override
        public FindSuiteDetailCstResponseParam[] newArray(int size) {
            return new FindSuiteDetailCstResponseParam[size];
        }
    };
}
