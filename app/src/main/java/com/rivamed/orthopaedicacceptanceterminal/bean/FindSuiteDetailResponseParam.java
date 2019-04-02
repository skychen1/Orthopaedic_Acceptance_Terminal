package com.rivamed.orthopaedicacceptanceterminal.bean;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

/**
 * @ProjectName: Orthopaedic_Acceptance_Terminal
 * @Package: com.rivamed.orthopaedicacceptanceterminal.bean
 * @ClassName: FindSuiteDetailResponseParam
 * @Description:  套餐明细返回（无菌、复消，器械）
 * @Author: Amos_Bo
 * @CreateDate: 2019/2/20 17:19
 * @UpdateUser: 更新者
 * @UpdateDate: 2019/2/20 17:19
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class FindSuiteDetailResponseParam {
    /**
     * id : 0
     * suiteId : 40288ba96903c456016904511d570003
     * suiteName : 套餐1
     * vendorName : 云南白药集团股份有限公司
     * cstCount : 2
     * instrumentCount : 1
     * asepticCstCount : 1
     * eliminationCstCount : 1
     * asepticCsts : [{"cstBoxCount":0,"instrumentBoxCount":0,"cstCount":0,"instrumentCount":0,
      "cstName":"载玻片（世泰）","cstCode":"2014wg00401897","cstSpec":"fddddfsd","cstType":"1",
     "expireDate":"2019-02-14","batchNo":"222","cstNumber":"qwe","num":3}]
     * instruments : [{"cstBoxCount":0,"instrumentBoxCount":0,"cstCount":0,"instrumentCount":0,
     * "name":"螺丝刀","code":"1001","num":444}]
      eliminationCsts : [{"cstBoxCount":0,"instrumentBoxCount":0,"cstCount":0,
      "instrumentCount":0,"cstName":"咽喉镜","cstCode":"2014wg00401977","cstSpec":"cvcx",
      "cstType":"0","expireDate":"2019-02-14","batchNo":"ww","cstNumber":"ss","num":4}]
     */

    private int id;
    private String suiteId;
    private String suiteName;
    private String vendorName;
    private int cstCount;
    /**
     *  器械种类
     */
    private int instrumentCount;
    /**
     * 复消类耗材种类
     */
    private int asepticCstCount;
    /**
     * 无菌类耗材种类
     */
    private int eliminationCstCount;
    private List<AsepticCstsBean> asepticCsts;
    private List<InstrumentsBean> instruments;
    private List<EliminationCstsBean> eliminationCsts;

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

    public List<AsepticCstsBean> getAsepticCsts() {
        return asepticCsts;
    }

    public void setAsepticCsts(List<AsepticCstsBean> asepticCsts) {
        this.asepticCsts = asepticCsts;
    }

    public List<InstrumentsBean> getInstruments() {
        return instruments;
    }

    public void setInstruments(List<InstrumentsBean> instruments) {
        this.instruments = instruments;
    }

    public List<EliminationCstsBean> getEliminationCsts() {
        return eliminationCsts;
    }

    public void setEliminationCsts(List<EliminationCstsBean> eliminationCsts) {
        this.eliminationCsts = eliminationCsts;
    }

    public static class AsepticCstsBean implements Parcelable {
        /**
         * cstBoxCount : 0
         * instrumentBoxCount : 0
         * cstCount : 0
         * instrumentCount : 0
         * cstName : 载玻片（世泰）
         * cstCode : 2014wg00401897
         * cstSpec : fddddfsd
         * cstType : 1
         * expireDate : 2019-02-14
         * batchNo : 222
         * cstNumber : qwe
         * num : 3
         */

        private int cstBoxCount;
        private int instrumentBoxCount;
        private int cstCount;
        private int instrumentCount;
        private String cstName;
        /**
         * 耗材编码
         */
        private String cstCode;
        private String cstSpec;
        private String cstType;
        private String expireDate;
        private String batchNo;
        /**
         * 耗材编号
         */
        private String cstNumber;
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

        public String getExpireDate() {
            return expireDate;
        }

        public void setExpireDate(String expireDate) {
            this.expireDate = expireDate;
        }

        public String getBatchNo() {
            return batchNo;
        }

        public void setBatchNo(String batchNo) {
            this.batchNo = batchNo;
        }

        public String getCstNumber() {
            return cstNumber;
        }

        public void setCstNumber(String cstNumber) {
            this.cstNumber = cstNumber;
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
            dest.writeString(this.expireDate);
            dest.writeString(this.batchNo);
            dest.writeString(this.cstNumber);
            dest.writeInt(this.num);
        }

        public AsepticCstsBean() {
        }

        protected AsepticCstsBean(Parcel in) {
            this.cstBoxCount = in.readInt();
            this.instrumentBoxCount = in.readInt();
            this.cstCount = in.readInt();
            this.instrumentCount = in.readInt();
            this.cstName = in.readString();
            this.cstCode = in.readString();
            this.cstSpec = in.readString();
            this.cstType = in.readString();
            this.expireDate = in.readString();
            this.batchNo = in.readString();
            this.cstNumber = in.readString();
            this.num = in.readInt();
        }

        public static final Parcelable.Creator<AsepticCstsBean> CREATOR = new Parcelable.Creator<AsepticCstsBean>() {
            @Override
            public AsepticCstsBean createFromParcel(Parcel source) {
                return new AsepticCstsBean(source);
            }

            @Override
            public AsepticCstsBean[] newArray(int size) {
                return new AsepticCstsBean[size];
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
         * num : 444
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

    public static class EliminationCstsBean implements Parcelable {
        /**
         * cstBoxCount : 0
         * instrumentBoxCount : 0
         * cstCount : 0
         * instrumentCount : 0
         * cstName : 咽喉镜
         * cstCode : 2014wg00401977
         * cstSpec : cvcx
         * cstType : 0
         * expireDate : 2019-02-14
         * batchNo : ww
         * cstNumber : ss
         * num : 4
         */

        private int cstBoxCount;
        private int instrumentBoxCount;
        private int cstCount;
        private int instrumentCount;
        private String cstName;
        private String cstCode;
        private String cstSpec;
        private String cstType;
        private String expireDate;
        private String batchNo;
        private String cstNumber;
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

        public String getExpireDate() {
            return expireDate;
        }

        public void setExpireDate(String expireDate) {
            this.expireDate = expireDate;
        }

        public String getBatchNo() {
            return batchNo;
        }

        public void setBatchNo(String batchNo) {
            this.batchNo = batchNo;
        }

        public String getCstNumber() {
            return cstNumber;
        }

        public void setCstNumber(String cstNumber) {
            this.cstNumber = cstNumber;
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
            dest.writeString(this.expireDate);
            dest.writeString(this.batchNo);
            dest.writeString(this.cstNumber);
            dest.writeInt(this.num);
        }

        public EliminationCstsBean() {
        }

        protected EliminationCstsBean(Parcel in) {
            this.cstBoxCount = in.readInt();
            this.instrumentBoxCount = in.readInt();
            this.cstCount = in.readInt();
            this.instrumentCount = in.readInt();
            this.cstName = in.readString();
            this.cstCode = in.readString();
            this.cstSpec = in.readString();
            this.cstType = in.readString();
            this.expireDate = in.readString();
            this.batchNo = in.readString();
            this.cstNumber = in.readString();
            this.num = in.readInt();
        }

        public static final Parcelable.Creator<EliminationCstsBean> CREATOR = new Parcelable.Creator<EliminationCstsBean>() {
            @Override
            public EliminationCstsBean createFromParcel(Parcel source) {
                return new EliminationCstsBean(source);
            }

            @Override
            public EliminationCstsBean[] newArray(int size) {
                return new EliminationCstsBean[size];
            }
        };
    }
}
