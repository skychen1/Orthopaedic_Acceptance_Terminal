package com.rivamed.orthopaedicacceptanceterminal.bean;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

/**
 * @ProjectName: Orthopaedic_Acceptance_Terminal
 * @Package: com.rivamed.orthopaedicacceptanceterminal.bean
 * @ClassName: LoginResponseParam
 * @Description: java类作用描述
 * @Author: Amos_Bo
 * @CreateDate: 2019/2/19 15:08
 * @UpdateUser: 更新者
 * @UpdateDate: 2019/2/19 15:08
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class LoginResponseParam implements Parcelable {
    /**
     * operateSuccess : true
     * id : 0
     * opFlg : 200
     * pageNo : 1
     * pageSize : 20
     * userFeatureInfo : {"userId":"10000000000000000000000000000001","type":"1"}
     * appAccountInfoVo : {"clientId":null,"userInfo":null,"accountName":"admin",
     * "tenantId":"10000000000000000000000000000001","userName":"系统管理员","roles":[{"roleCode
     * ":"admin","roleName":"系统管理员","funcs":[]},{"roleCode":"0","roleName":"高值耗材","funcs":[]},{
     * "roleCode":"2","roleName":"医生1","funcs":[]}],"accountId":"10000000000000000000000000000001
     * ","password":null,"salt":null,"userId":"10000000000000000000000000000001","isFinger":0,
     * "isWaidai":0,"isEmergency":0,"sex":"男","useState":"1","emergencyPwd":null}
     * systemType : OCI
     * loginTime : 2019-02-19
     * accessToken : {"createTime":"2019-02-19","tokenId":"bb8c09839c12c9179dab5487eeff34af",
     * "username":"admin","clientId":"OCI","authenticationId":"69e4e670ebcdd324b5102d99ea181076",
     * "refreshToken":"09a186223df5f9d81e5b4e753168551d","tokenType":"Bearer",
     * "tokenExpiredSeconds":54000,"refreshTokenExpiredSeconds":7200,"userDto":null}
     */

    private boolean operateSuccess;
    private int id;
    private String opFlg;
    private int pageNo;
    private int pageSize;
    private UserFeatureInfoBean userFeatureInfo;
    private AppAccountInfoVoBean appAccountInfoVo;
    private String systemType;
    private String loginTime;
    private AccessTokenBean accessToken;

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

    public String getOpFlg() {
        return opFlg;
    }

    public void setOpFlg(String opFlg) {
        this.opFlg = opFlg;
    }

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public UserFeatureInfoBean getUserFeatureInfo() {
        return userFeatureInfo;
    }

    public void setUserFeatureInfo(UserFeatureInfoBean userFeatureInfo) {
        this.userFeatureInfo = userFeatureInfo;
    }

    public AppAccountInfoVoBean getAppAccountInfoVo() {
        return appAccountInfoVo;
    }

    public void setAppAccountInfoVo(AppAccountInfoVoBean appAccountInfoVo) {
        this.appAccountInfoVo = appAccountInfoVo;
    }

    public String getSystemType() {
        return systemType;
    }

    public void setSystemType(String systemType) {
        this.systemType = systemType;
    }

    public String getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(String loginTime) {
        this.loginTime = loginTime;
    }

    public AccessTokenBean getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(AccessTokenBean accessToken) {
        this.accessToken = accessToken;
    }

    public static class UserFeatureInfoBean implements Parcelable {
        /**
         * userId : 10000000000000000000000000000001
         * type : 1
         */

        private String userId;
        private String type;

        public String getUserId() {
            return userId;
        }

        public void setUserId(String userId) {
            this.userId = userId;
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
            dest.writeString(this.userId);
            dest.writeString(this.type);
        }

        public UserFeatureInfoBean() {
        }

        protected UserFeatureInfoBean(Parcel in) {
            this.userId = in.readString();
            this.type = in.readString();
        }

        public static final Parcelable.Creator<UserFeatureInfoBean> CREATOR =
                new Parcelable.Creator<UserFeatureInfoBean>() {
            @Override
            public UserFeatureInfoBean createFromParcel(Parcel source) {
                return new UserFeatureInfoBean(source);
            }

            @Override
            public UserFeatureInfoBean[] newArray(int size) {
                return new UserFeatureInfoBean[size];
            }
        };
    }

    public static class AppAccountInfoVoBean implements Parcelable {
        /**
         * clientId : null
         * userInfo : null
         * accountName : admin
         * tenantId : 10000000000000000000000000000001
         * userName : 系统管理员
         * roles : [{"roleCode":"admin","roleName":"系统管理员","funcs":[]},{"roleCode":"0",
         * "roleName":"高值耗材","funcs":[]},{"roleCode":"2","roleName":"医生1","funcs":[]}]
         * accountId : 10000000000000000000000000000001
         * password : null
         * salt : null
         * userId : 10000000000000000000000000000001
         * isFinger : 0
         * isWaidai : 0
         * isEmergency : 0
         * sex : 男
         * useState : 1
         * emergencyPwd : null
         */

        private String clientId;
        private String userInfo;
        private String accountName;
        private String tenantId;
        private String userName;
        private String accountId;
        private String password;
        private String salt;
        private String userId;
        private int isFinger;
        private int isWaidai;
        private int isEmergency;
        private String sex;
        private String useState;
        private String emergencyPwd;
        private List<RolesBean> roles;

        public String getClientId() {
            return clientId;
        }

        public void setClientId(String clientId) {
            this.clientId = clientId;
        }

        public String getUserInfo() {
            return userInfo;
        }

        public void setUserInfo(String userInfo) {
            this.userInfo = userInfo;
        }

        public String getAccountName() {
            return accountName;
        }

        public void setAccountName(String accountName) {
            this.accountName = accountName;
        }

        public String getTenantId() {
            return tenantId;
        }

        public void setTenantId(String tenantId) {
            this.tenantId = tenantId;
        }

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public String getAccountId() {
            return accountId;
        }

        public void setAccountId(String accountId) {
            this.accountId = accountId;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String getSalt() {
            return salt;
        }

        public void setSalt(String salt) {
            this.salt = salt;
        }

        public String getUserId() {
            return userId;
        }

        public void setUserId(String userId) {
            this.userId = userId;
        }

        public int getIsFinger() {
            return isFinger;
        }

        public void setIsFinger(int isFinger) {
            this.isFinger = isFinger;
        }

        public int getIsWaidai() {
            return isWaidai;
        }

        public void setIsWaidai(int isWaidai) {
            this.isWaidai = isWaidai;
        }

        public int getIsEmergency() {
            return isEmergency;
        }

        public void setIsEmergency(int isEmergency) {
            this.isEmergency = isEmergency;
        }

        public String getSex() {
            return sex;
        }

        public void setSex(String sex) {
            this.sex = sex;
        }

        public String getUseState() {
            return useState;
        }

        public void setUseState(String useState) {
            this.useState = useState;
        }

        public String getEmergencyPwd() {
            return emergencyPwd;
        }

        public void setEmergencyPwd(String emergencyPwd) {
            this.emergencyPwd = emergencyPwd;
        }

        public List<RolesBean> getRoles() {
            return roles;
        }

        public void setRoles(List<RolesBean> roles) {
            this.roles = roles;
        }

        public static class RolesBean implements Parcelable {
            /**
             * roleCode : admin
             * roleName : 系统管理员
             * funcs : []
             */

            private String roleCode;
            private String roleName;
            private List<String> funcs;

            public String getRoleCode() {
                return roleCode;
            }

            public void setRoleCode(String roleCode) {
                this.roleCode = roleCode;
            }

            public String getRoleName() {
                return roleName;
            }

            public void setRoleName(String roleName) {
                this.roleName = roleName;
            }

            public List<String> getFuncs() {
                return funcs;
            }

            public void setFuncs(List<String> funcs) {
                this.funcs = funcs;
            }

            @Override
            public int describeContents() {
                return 0;
            }

            @Override
            public void writeToParcel(Parcel dest, int flags) {
                dest.writeString(this.roleCode);
                dest.writeString(this.roleName);
                dest.writeStringList(this.funcs);
            }

            public RolesBean() {
            }

            protected RolesBean(Parcel in) {
                this.roleCode = in.readString();
                this.roleName = in.readString();
                this.funcs = in.createStringArrayList();
            }

            public static final Creator<RolesBean> CREATOR = new Creator<RolesBean>() {
                @Override
                public RolesBean createFromParcel(Parcel source) {
                    return new RolesBean(source);
                }

                @Override
                public RolesBean[] newArray(int size) {
                    return new RolesBean[size];
                }
            };
        }

     
        public AppAccountInfoVoBean() {
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(this.clientId);
            dest.writeString(this.userInfo);
            dest.writeString(this.accountName);
            dest.writeString(this.tenantId);
            dest.writeString(this.userName);
            dest.writeString(this.accountId);
            dest.writeString(this.password);
            dest.writeString(this.salt);
            dest.writeString(this.userId);
            dest.writeInt(this.isFinger);
            dest.writeInt(this.isWaidai);
            dest.writeInt(this.isEmergency);
            dest.writeString(this.sex);
            dest.writeString(this.useState);
            dest.writeString(this.emergencyPwd);
            dest.writeTypedList(this.roles);
        }

        protected AppAccountInfoVoBean(Parcel in) {
            this.clientId = in.readString();
            this.userInfo = in.readString();
            this.accountName = in.readString();
            this.tenantId = in.readString();
            this.userName = in.readString();
            this.accountId = in.readString();
            this.password = in.readString();
            this.salt = in.readString();
            this.userId = in.readString();
            this.isFinger = in.readInt();
            this.isWaidai = in.readInt();
            this.isEmergency = in.readInt();
            this.sex = in.readString();
            this.useState = in.readString();
            this.emergencyPwd = in.readString();
            this.roles = in.createTypedArrayList(RolesBean.CREATOR);
        }

        public static final Creator<AppAccountInfoVoBean> CREATOR = new Creator<AppAccountInfoVoBean>() {
            @Override
            public AppAccountInfoVoBean createFromParcel(Parcel source) {
                return new AppAccountInfoVoBean(source);
            }

            @Override
            public AppAccountInfoVoBean[] newArray(int size) {
                return new AppAccountInfoVoBean[size];
            }
        };
    }

    public static class AccessTokenBean implements Parcelable {
        /**
         * createTime : 2019-02-19
         * tokenId : bb8c09839c12c9179dab5487eeff34af
         * username : admin
         * clientId : OCI
         * authenticationId : 69e4e670ebcdd324b5102d99ea181076
         * refreshToken : 09a186223df5f9d81e5b4e753168551d
         * tokenType : Bearer
         * tokenExpiredSeconds : 54000
         * refreshTokenExpiredSeconds : 7200
         * userDto : null
         */

        private String createTime;
        private String tokenId;
        private String username;
        private String clientId;
        private String authenticationId;
        private String refreshToken;
        private String tokenType;
        private int tokenExpiredSeconds;
        private int refreshTokenExpiredSeconds;
        private String userDto;

        public String getCreateTime() {
            return createTime;
        }

        public void setCreateTime(String createTime) {
            this.createTime = createTime;
        }

        public String getTokenId() {
            return tokenId;
        }

        public void setTokenId(String tokenId) {
            this.tokenId = tokenId;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getClientId() {
            return clientId;
        }

        public void setClientId(String clientId) {
            this.clientId = clientId;
        }

        public String getAuthenticationId() {
            return authenticationId;
        }

        public void setAuthenticationId(String authenticationId) {
            this.authenticationId = authenticationId;
        }

        public String getRefreshToken() {
            return refreshToken;
        }

        public void setRefreshToken(String refreshToken) {
            this.refreshToken = refreshToken;
        }

        public String getTokenType() {
            return tokenType;
        }

        public void setTokenType(String tokenType) {
            this.tokenType = tokenType;
        }

        public int getTokenExpiredSeconds() {
            return tokenExpiredSeconds;
        }

        public void setTokenExpiredSeconds(int tokenExpiredSeconds) {
            this.tokenExpiredSeconds = tokenExpiredSeconds;
        }

        public int getRefreshTokenExpiredSeconds() {
            return refreshTokenExpiredSeconds;
        }

        public void setRefreshTokenExpiredSeconds(int refreshTokenExpiredSeconds) {
            this.refreshTokenExpiredSeconds = refreshTokenExpiredSeconds;
        }

        public String getUserDto() {
            return userDto;
        }

        public void setUserDto(String userDto) {
            this.userDto = userDto;
        }


        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(this.createTime);
            dest.writeString(this.tokenId);
            dest.writeString(this.username);
            dest.writeString(this.clientId);
            dest.writeString(this.authenticationId);
            dest.writeString(this.refreshToken);
            dest.writeString(this.tokenType);
            dest.writeInt(this.tokenExpiredSeconds);
            dest.writeInt(this.refreshTokenExpiredSeconds);
            dest.writeString(this.userDto);
        }

        public AccessTokenBean() {
        }

        protected AccessTokenBean(Parcel in) {
            this.createTime = in.readString();
            this.tokenId = in.readString();
            this.username = in.readString();
            this.clientId = in.readString();
            this.authenticationId = in.readString();
            this.refreshToken = in.readString();
            this.tokenType = in.readString();
            this.tokenExpiredSeconds = in.readInt();
            this.refreshTokenExpiredSeconds = in.readInt();
            this.userDto = in.readString();
        }

        public static final Creator<AccessTokenBean> CREATOR = new Creator<AccessTokenBean>() {
            @Override
            public AccessTokenBean createFromParcel(Parcel source) {
                return new AccessTokenBean(source);
            }

            @Override
            public AccessTokenBean[] newArray(int size) {
                return new AccessTokenBean[size];
            }
        };
    }


    public LoginResponseParam() {
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeByte(this.operateSuccess ? (byte) 1 : (byte) 0);
        dest.writeInt(this.id);
        dest.writeString(this.opFlg);
        dest.writeInt(this.pageNo);
        dest.writeInt(this.pageSize);
        dest.writeParcelable(this.userFeatureInfo, flags);
        dest.writeParcelable(this.appAccountInfoVo, flags);
        dest.writeString(this.systemType);
        dest.writeString(this.loginTime);
        dest.writeParcelable(this.accessToken, flags);
    }

    protected LoginResponseParam(Parcel in) {
        this.operateSuccess = in.readByte() != 0;
        this.id = in.readInt();
        this.opFlg = in.readString();
        this.pageNo = in.readInt();
        this.pageSize = in.readInt();
        this.userFeatureInfo = in.readParcelable(UserFeatureInfoBean.class.getClassLoader());
        this.appAccountInfoVo = in.readParcelable(AppAccountInfoVoBean.class.getClassLoader());
        this.systemType = in.readString();
        this.loginTime = in.readString();
        this.accessToken = in.readParcelable(AccessTokenBean.class.getClassLoader());
    }

    public static final Parcelable.Creator<LoginResponseParam> CREATOR = new Parcelable.Creator<LoginResponseParam>() {
        @Override
        public LoginResponseParam createFromParcel(Parcel source) {
            return new LoginResponseParam(source);
        }

        @Override
        public LoginResponseParam[] newArray(int size) {
            return new LoginResponseParam[size];
        }
    };
}
