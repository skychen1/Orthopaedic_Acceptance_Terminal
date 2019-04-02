package com.rivamed.orthopaedicacceptanceterminal.bean;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

/**
 * @ProjectName: Orthopaedic_Acceptance_Terminal
 * @Package: com.rivamed.orthopaedicacceptanceterminal.bean
 * @ClassName: SubmitCostReqestAndResponseParam
 * @Description: 计费提报请求和返回参数
 * @Author: Amos_Bo
 * @CreateDate: 2019/2/21 14:08
 * @UpdateUser: 更新者
 * @UpdateDate: 2019/2/21 14:08
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class SubmitCostReqestAndResponseParam implements Parcelable {
    /**
     * operateSuccess : true
     * id : 0
     * msg : 成功提交计费
     * orderId : 4028829468dbccc20168dbd700c50000
     * suiteVos : [{"cstBoxCount":0,"instrumentBoxCount":0,"cstCount":0,"instrumentCount":0,
     * "cstId":"40288297678748df0167875a3b730000","cstName":"医用纱布块呜呜呜呜呜呜呜呜呜呜呜呜呜呜呜呜呜呜呜呜",
     * "cstCode":"C002-10000","cstSpec":"常规","cstType":"1","num":1,
     * "orderDetailId":"4028829468dbccc20168dbd700d20001"},{"cstBoxCount":0,
     * "instrumentBoxCount":0,"cstCount":0,"instrumentCount":0,
     * "cstId":"40288297678748df0167875a409a0007","cstName":"医用手术膜","cstCode":"C001-10004",
     * "cstSpec":"CC","cstType":"1","num":1,"orderDetailId":"4028829468dbccc20168dbd700d20002"}]
     */

    private boolean operateSuccess;
    private int id;
    private String msg;
    private String orderId;
    private List<SuiteVosBean> suiteVos = new ArrayList<>();

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

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public List<SuiteVosBean> getSuiteVos() {
        return suiteVos;
    }

    public void setSuiteVos(List<SuiteVosBean> suiteVos) {
        this.suiteVos = suiteVos;
    }

    public static class SuiteVosBean implements Parcelable {
        /**
         * cstBoxCount : 0
         * instrumentBoxCount : 0
         * cstCount : 0
         * instrumentCount : 0
         * cstId : 40288297678748df0167875a3b730000
         * cstName : 医用纱布块呜呜呜呜呜呜呜呜呜呜呜呜呜呜呜呜呜呜呜呜
         * cstCode : C002-10000
         * cstSpec : 常规
         * cstType : 1
         * num : 1
         * orderDetailId : 4028829468dbccc20168dbd700d20001
         */

        private int cstBoxCount;
        private int instrumentBoxCount;
        private int cstCount;
        private int instrumentCount;
        private String cstId;
        private String cstName;
        private String cstCode;
        private String cstSpec;
        private String cstType;
        private int num;
        private String orderDetailId;

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

        public String getCstId() {
            return cstId;
        }

        public void setCstId(String cstId) {
            this.cstId = cstId;
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

        public String getOrderDetailId() {
            return orderDetailId;
        }

        public void setOrderDetailId(String orderDetailId) {
            this.orderDetailId = orderDetailId;
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
            dest.writeString(this.cstId);
            dest.writeString(this.cstName);
            dest.writeString(this.cstCode);
            dest.writeString(this.cstSpec);
            dest.writeString(this.cstType);
            dest.writeInt(this.num);
            dest.writeString(this.orderDetailId);
        }

        public SuiteVosBean() {
        }

        protected SuiteVosBean(Parcel in) {
            this.cstBoxCount = in.readInt();
            this.instrumentBoxCount = in.readInt();
            this.cstCount = in.readInt();
            this.instrumentCount = in.readInt();
            this.cstId = in.readString();
            this.cstName = in.readString();
            this.cstCode = in.readString();
            this.cstSpec = in.readString();
            this.cstType = in.readString();
            this.num = in.readInt();
            this.orderDetailId = in.readString();
        }

        public static final Parcelable.Creator<SuiteVosBean> CREATOR = new Parcelable.Creator<SuiteVosBean>() {
            @Override
            public SuiteVosBean createFromParcel(Parcel source) {
                return new SuiteVosBean(source);
            }

            @Override
            public SuiteVosBean[] newArray(int size) {
                return new SuiteVosBean[size];
            }
        };
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeByte(this.operateSuccess ? (byte) 1 : (byte) 0);
        dest.writeInt(this.id);
        dest.writeString(this.msg);
        dest.writeString(this.orderId);
        dest.writeTypedList(this.suiteVos);
    }

    public SubmitCostReqestAndResponseParam() {
    }

    protected SubmitCostReqestAndResponseParam(Parcel in) {
        this.operateSuccess = in.readByte() != 0;
        this.id = in.readInt();
        this.msg = in.readString();
        this.orderId = in.readString();
        this.suiteVos = in.createTypedArrayList(SuiteVosBean.CREATOR);
    }

    public static final Parcelable.Creator<SubmitCostReqestAndResponseParam> CREATOR =
            new Parcelable.Creator<SubmitCostReqestAndResponseParam>() {
        @Override
        public SubmitCostReqestAndResponseParam createFromParcel(Parcel source) {
            return new SubmitCostReqestAndResponseParam(source);
        }

        @Override
        public SubmitCostReqestAndResponseParam[] newArray(int size) {
            return new SubmitCostReqestAndResponseParam[size];
        }
    };
}
