package com.rivamed.orthopaedicacceptanceterminal.bean;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * @ProjectName: Orthopaedic_Acceptance_Terminal
 * @Package: com.rivamed.orthopaedicacceptanceterminal.bean
 * @ClassName: MianFuncationParam
 * @Description: 主界面功能数据
 * @Author: Amos_Bo
 * @CreateDate: 2019/2/19 16:44
 * @UpdateUser: 更新者
 * @UpdateDate: 2019/2/19 16:44
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class MianFuncationParam implements Parcelable {
    /**
     * path : null
     * title :  订单查询
     * icon : null
     * parentSeq : null
     * seq : 8
     * menu : null
     * children : null
     * selected : false
     */

    private String path;
    private String title;
    private String icon;
    private String parentSeq;
    private int seq;
    private String menu;
    private String children;
    private boolean selected;

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getParentSeq() {
        return parentSeq;
    }

    public void setParentSeq(String parentSeq) {
        this.parentSeq = parentSeq;
    }

    public int getSeq() {
        return seq;
    }

    public void setSeq(int seq) {
        this.seq = seq;
    }

    public String getMenu() {
        return menu;
    }

    public void setMenu(String menu) {
        this.menu = menu;
    }

    public String getChildren() {
        return children;
    }

    public void setChildren(String children) {
        this.children = children;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.path);
        dest.writeString(this.title);
        dest.writeString(this.icon);
        dest.writeString(this.parentSeq);
        dest.writeInt(this.seq);
        dest.writeString(this.menu);
        dest.writeString(this.children);
        dest.writeByte(this.selected ? (byte) 1 : (byte) 0);
    }

    public MianFuncationParam() {
    }

    protected MianFuncationParam(Parcel in) {
        this.path = in.readString();
        this.title = in.readString();
        this.icon = in.readString();
        this.parentSeq = in.readString();
        this.seq = in.readInt();
        this.menu = in.readString();
        this.children = in.readString();
        this.selected = in.readByte() != 0;
    }

    public static final Parcelable.Creator<MianFuncationParam> CREATOR =
            new Parcelable.Creator<MianFuncationParam>() {
        @Override
        public MianFuncationParam createFromParcel(Parcel source) {
            return new MianFuncationParam(source);
        }

        @Override
        public MianFuncationParam[] newArray(int size) {
            return new MianFuncationParam[size];
        }
    };
}
