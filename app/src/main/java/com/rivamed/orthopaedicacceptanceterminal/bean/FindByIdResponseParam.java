package com.rivamed.orthopaedicacceptanceterminal.bean;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

/**
 * @作者: 钱凯
 * @创建时间: 2019/2/21
 * @功能描述:套餐明细返回参数
 */
public class FindByIdResponseParam implements Parcelable {

    /**
     * id : 0
     * suiteId : 40288ba96903c456016904535ce80008
     * suiteName : 套餐2
     * vendorName : 1999
     * cstCount : 3
     * instrumentCount : 2
     * asepticCstCount : 0
     * eliminationCstCount : 0
     * csts : [{"cstBoxCount":0,"instrumentBoxCount":0,"cstCount":0,"instrumentCount":0,"cstName":"钢瓶","cstCode":"2014wg00402037","cstSpec":"3L","cstType":"0","num":1},{"cstBoxCount":0,"instrumentBoxCount":0,"cstCount":0,"instrumentCount":0,"cstName":"减压器","cstCode":"2014wg00402038","cstSpec":"3L","cstType":"0","num":1},{"cstBoxCount":0,"instrumentBoxCount":0,"cstCount":0,"instrumentCount":0,"cstName":"医用氧","cstCode":"2014wg00402039","cstSpec":"3L","cstType":"0","num":1}]
     * instruments : [{"cstBoxCount":0,"instrumentBoxCount":0,"cstCount":0,"instrumentCount":0,"name":"螺丝刀","code":"1001","num":1},{"cstBoxCount":0,"instrumentBoxCount":0,"cstCount":0,"instrumentCount":0,"name":"扳手","code":"1002","num":1}]
     */

    private int id;
    private String suiteId;
    private String suiteName;
    private String vendorName;
    private String vendorId;
    private String mFrom = "";
    private int cstCount;
    private int instrumentCount;
    private int asepticCstCount;
    private int eliminationCstCount;
    private List<CstsBean> csts=new ArrayList<>();
    private List<InstrumentsBean> instruments=new ArrayList<>();

    public String getVendorId() {
        return vendorId;
    }

    public void setVendorId(String vendorId) {
        this.vendorId = vendorId;
    }

    public String getFrom() {
        return mFrom;
    }

    public void setFrom(String from) {
        mFrom = from;
    }

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

    public static class CstsBean {
        /**
         * cstBoxCount : 0
         * instrumentBoxCount : 0
         * cstCount : 0
         * instrumentCount : 0
         * cstName : 钢瓶
         * cstCode : 2014wg00402037
         * cstSpec : 3L
         * cstType : 0
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
    }

    public static class InstrumentsBean {
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
        dest.writeList(this.csts);
        dest.writeList(this.instruments);
    }

    public FindByIdResponseParam() {
    }

    protected FindByIdResponseParam(Parcel in) {
        this.id = in.readInt();
        this.suiteId = in.readString();
        this.suiteName = in.readString();
        this.vendorName = in.readString();
        this.cstCount = in.readInt();
        this.instrumentCount = in.readInt();
        this.asepticCstCount = in.readInt();
        this.eliminationCstCount = in.readInt();
        this.csts = new ArrayList<CstsBean>();
        in.readList(this.csts, CstsBean.class.getClassLoader());
        this.instruments = new ArrayList<InstrumentsBean>();
        in.readList(this.instruments, InstrumentsBean.class.getClassLoader());
    }

    public static final Parcelable.Creator<FindByIdResponseParam> CREATOR = new Parcelable.Creator<FindByIdResponseParam>() {
        @Override
        public FindByIdResponseParam createFromParcel(Parcel source) {
            return new FindByIdResponseParam(source);
        }

        @Override
        public FindByIdResponseParam[] newArray(int size) {
            return new FindByIdResponseParam[size];
        }
    };
}
