package com.rivamed.orthopaedicacceptanceterminal.bean;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * @ProjectName: Orthopaedic_Acceptance_Terminal
 * @Package: com.rivamed.orthopaedicacceptanceterminal.bean
 * @ClassName: FindOrderRequestParam
 * @Description: 查找订单
 * @Author: Amos_Bo
 * @CreateDate: 2019/2/20 16:17
 * @UpdateUser: 更新者
 * @UpdateDate: 2019/2/20 16:17
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class FindOrderRequestParam implements Parcelable {
    /**
     * endDate : 2019-02-19 14:39
     * startDate : 2019-02-12 14:34
     * term : 1
     * status : 1
     */

    private String endDate;
    private String startDate;
    private String term;
    private String status;

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.endDate);
        dest.writeString(this.startDate);
        dest.writeString(this.term);
        dest.writeString(this.status);
    }

    public FindOrderRequestParam() {
    }

    protected FindOrderRequestParam(Parcel in) {
        this.endDate = in.readString();
        this.startDate = in.readString();
        this.term = in.readString();
        this.status = in.readString();
    }

    public static final Parcelable.Creator<FindOrderRequestParam> CREATOR =
            new Parcelable.Creator<FindOrderRequestParam>() {
        @Override
        public FindOrderRequestParam createFromParcel(Parcel source) {
            return new FindOrderRequestParam(source);
        }

        @Override
        public FindOrderRequestParam[] newArray(int size) {
            return new FindOrderRequestParam[size];
        }
    };
}
