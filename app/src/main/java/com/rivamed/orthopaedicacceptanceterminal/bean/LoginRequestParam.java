package com.rivamed.orthopaedicacceptanceterminal.bean;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * @ProjectName: Orthopaedic_Acceptance_Terminal
 * @Package: com.rivamed.orthopaedicacceptanceterminal.bean
 * @ClassName: LoginRequestParam
 * @Description: 登录接口参数
 * @Author: Amos_Bo
 * @CreateDate: 2019/2/19 14:55
 * @UpdateUser: 更新者
 * @UpdateDate: 2019/2/19 14:55
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class LoginRequestParam implements Parcelable {


    /**
     * systemType : OCI
     * account : {"password":"000000","accountName":"admin"}
     */

    private String systemType;
    private AccountBean account;

    public String getSystemType() {
        return systemType;
    }

    public void setSystemType(String systemType) {
        this.systemType = systemType;
    }

    public AccountBean getAccount() {
        return account;
    }

    public void setAccount(AccountBean account) {
        this.account = account;
    }

    public static class AccountBean implements Parcelable {
        /**
         * password : 000000
         * accountName : admin
         */

        private String password;
        private String accountName;

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String getAccountName() {
            return accountName;
        }

        public void setAccountName(String accountName) {
            this.accountName = accountName;
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(this.password);
            dest.writeString(this.accountName);
        }

        public AccountBean() {
        }

        protected AccountBean(Parcel in) {
            this.password = in.readString();
            this.accountName = in.readString();
        }

        public static final Creator<AccountBean> CREATOR = new Creator<AccountBean>() {
            @Override
            public AccountBean createFromParcel(Parcel source) {
                return new AccountBean(source);
            }

            @Override
            public AccountBean[] newArray(int size) {
                return new AccountBean[size];
            }
        };
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.systemType);
        dest.writeParcelable(this.account, flags);
    }

    public LoginRequestParam() {
    }

    protected LoginRequestParam(Parcel in) {
        this.systemType = in.readString();
        this.account = in.readParcelable(AccountBean.class.getClassLoader());
    }

    public static final Creator<LoginRequestParam> CREATOR = new Creator<LoginRequestParam>() {
        @Override
        public LoginRequestParam createFromParcel(Parcel source) {
            return new LoginRequestParam(source);
        }

        @Override
        public LoginRequestParam[] newArray(int size) {
            return new LoginRequestParam[size];
        }
    };
}
