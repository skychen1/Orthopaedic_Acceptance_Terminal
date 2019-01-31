package com.rivamed.common.bean;

import java.io.Serializable;

/**
 * 项目名称:    Android_PV_2.6.1
 * 创建者:      DanMing
 * 创建时间:    2018/9/26 18:17
 * 描述:        TODO:
 * 包名:        high.rivamed.myapplication.bean
 * <p>
 * 更新者：     $$Author$$
 * 更新时间：   $$Date$$
 * 更新描述：   ${TODO}
 */
public class VersionBean implements Serializable {


    /**
     * operateSuccess : true
     * id : 0
     * opFlg : 200
     * pageNo : 1
     * pageSize : 20
     * systemVersion : {"versionId":"40287281675e7fe801675e8f105b0001","contextRoot":"1547445481144","description":"12312","parentId":"","systemName":"高值耗材诊间使用管理终端","systemType":"HOCT","useState":"1","version":"2.6.4","updateTime":"2019-01-14 13:59:01","createTime":"2018-11-29 16:21:33","apkFileName":"诊间计费v2.0.0.4_2019-01-08 10-37.apk"}
     * systemType : HOCT
     */

    private boolean operateSuccess;
    private int id;
    private String opFlg;
    private int pageNo;
    private int pageSize;
    private SystemVersionBean systemVersion;
    private String systemType;

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

    public SystemVersionBean getSystemVersion() {
        return systemVersion;
    }

    public void setSystemVersion(SystemVersionBean systemVersion) {
        this.systemVersion = systemVersion;
    }

    public String getSystemType() {
        return systemType;
    }

    public void setSystemType(String systemType) {
        this.systemType = systemType;
    }

    public static class SystemVersionBean implements Serializable {
        /**
         * versionId : 40287281675e7fe801675e8f105b0001
         * contextRoot : 1547445481144
         * description : 12312
         * parentId :
         * systemName : 高值耗材诊间使用管理终端
         * systemType : HOCT
         * useState : 1
         * version : 2.6.4
         * updateTime : 2019-01-14 13:59:01
         * createTime : 2018-11-29 16:21:33
         * apkFileName : 诊间计费v2.0.0.4_2019-01-08 10-37.apk
         */

        private String versionId;
        private String contextRoot;
        private String description;
        private String parentId;
        private String systemName;
        private String systemType;
        private String useState;
        private String version;
        private String updateTime;
        private String createTime;
        private String apkFileName;

        public String getVersionId() {
            return versionId;
        }

        public void setVersionId(String versionId) {
            this.versionId = versionId;
        }

        public String getContextRoot() {
            return contextRoot;
        }

        public void setContextRoot(String contextRoot) {
            this.contextRoot = contextRoot;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getParentId() {
            return parentId;
        }

        public void setParentId(String parentId) {
            this.parentId = parentId;
        }

        public String getSystemName() {
            return systemName;
        }

        public void setSystemName(String systemName) {
            this.systemName = systemName;
        }

        public String getSystemType() {
            return systemType;
        }

        public void setSystemType(String systemType) {
            this.systemType = systemType;
        }

        public String getUseState() {
            return useState;
        }

        public void setUseState(String useState) {
            this.useState = useState;
        }

        public String getVersion() {
            return version;
        }

        public void setVersion(String version) {
            this.version = version;
        }

        public String getUpdateTime() {
            return updateTime;
        }

        public void setUpdateTime(String updateTime) {
            this.updateTime = updateTime;
        }

        public String getCreateTime() {
            return createTime;
        }

        public void setCreateTime(String createTime) {
            this.createTime = createTime;
        }

        public String getApkFileName() {
            return apkFileName;
        }

        public void setApkFileName(String apkFileName) {
            this.apkFileName = apkFileName;
        }
    }
}
