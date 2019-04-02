package com.rivamed.orthopaedicacceptanceterminal.bean;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

/**
 * @ProjectName: Orthopaedic_Acceptance_Terminal
 * @Package: com.rivamed.orthopaedicacceptanceterminal.bean
 * @ClassName: OrderStatusResponseParam
 * @Description: java类作用描述
 * @Author: Amos_Bo
 * @CreateDate: 2019/2/20 17:47
 * @UpdateUser: 更新者
 * @UpdateDate: 2019/2/20 17:47
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class FindOrderStatusResponseParam implements Parcelable {
    /**
     * id : 0
     * dicts : [{"desc":"已下单","dictId":"200","value":"1","type":"ociOrder_state"},{"desc":"已审核",
     * "dictId":"201","value":"2","type":"ociOrder_state"},{"desc":"已拒绝","dictId":"202",
     * "value":"3","type":"ociOrder_state"},{"desc":"已到货","dictId":"203","value":"4",
     * "type":"ociOrder_state"},{"desc":"已拒绝","dictId":"204","value":"5","type":"ociOrder_state"}
     * ,{"desc":"供应商确认","dictId":"205","value":"6","type":"ociOrder_state"},{"desc":"供应商拒绝",
     * "dictId":"206","value":"7","type":"ociOrder_state"},{"desc":"护士已验收","dictId":"207",
     * "value":"8","type":"ociOrder_state"},{"desc":"护士已拒绝","dictId":"208","value":"9",
     * "type":"ociOrder_state"},{"desc":"供应室已验收","dictId":"209","value":"10",
     * "type":"ociOrder_state"},{"desc":"供应室已拒绝","dictId":"210","value":"11",
     * "type":"ociOrder_state"},{"desc":"已计费提报","dictId":"211","value":"12",
     * "type":"ociOrder_state"},{"desc":"撤销申请","dictId":"212","value":"13",
     * "type":"ociOrder_state"},{"desc":"已撤销","dictId":"213","value":"14","type":"ociOrder_state"}]
     */

    private int id;
    private List<DictsBean> dicts = new ArrayList<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<DictsBean> getDicts() {
        return dicts;
    }

    public void setDicts(List<DictsBean> dicts) {
        this.dicts = dicts;
    }

    public static class DictsBean implements Parcelable {
        /**
         * desc : 已下单
         * dictId : 200
         * value : 1
         * type : ociOrder_state
         */

        private String desc;
        private String dictId;
        private String value;
        private String type;

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }

        public String getDictId() {
            return dictId;
        }

        public void setDictId(String dictId) {
            this.dictId = dictId;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(this.desc);
            dest.writeString(this.dictId);
            dest.writeString(this.value);
            dest.writeString(this.type);
        }

        public DictsBean() {
        }

        protected DictsBean(Parcel in) {
            this.desc = in.readString();
            this.dictId = in.readString();
            this.value = in.readString();
            this.type = in.readString();
        }

        public static final Parcelable.Creator<DictsBean> CREATOR = new Parcelable.Creator<DictsBean>() {
            @Override
            public DictsBean createFromParcel(Parcel source) {
                return new DictsBean(source);
            }

            @Override
            public DictsBean[] newArray(int size) {
                return new DictsBean[size];
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
        dest.writeTypedList(this.dicts);
    }

    public FindOrderStatusResponseParam() {
    }

    protected FindOrderStatusResponseParam(Parcel in) {
        this.id = in.readInt();
        this.dicts = in.createTypedArrayList(DictsBean.CREATOR);
    }

    public static final Parcelable.Creator<FindOrderStatusResponseParam> CREATOR =
            new Parcelable.Creator<FindOrderStatusResponseParam>() {
        @Override
        public FindOrderStatusResponseParam createFromParcel(Parcel source) {
            return new FindOrderStatusResponseParam(source);
        }

        @Override
        public FindOrderStatusResponseParam[] newArray(int size) {
            return new FindOrderStatusResponseParam[size];
        }
    };
}
