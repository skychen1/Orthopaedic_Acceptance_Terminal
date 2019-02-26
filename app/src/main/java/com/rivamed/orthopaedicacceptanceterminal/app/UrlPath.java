package com.rivamed.orthopaedicacceptanceterminal.app;

/**
 * @ProjectName: Orthopaedic_Acceptance_Terminal
 * @Package: com.rivamed.orthopaedicacceptanceterminal.app
 * @ClassName: UrlPath
 * @Description: 接口常量
 * @Author: Amos_Bo
 * @CreateDate: 2019/2/19 10:51
 * @UpdateUser: 更新者
 * @UpdateDate: 2019/2/19 10:51
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class UrlPath {
    public static String ROOT_URL = "http://192.168.11.46:8018";
    /**
     * 帐号密码登录
     */
    public static final String LOGIN_NAME_PASSWORD = "/rmApi/restLogin/validateLoginPassword";
    /**
     * 主界面功能
     */
    public static final String ACCOUNT_FUNCS = "/rmApi/userManage/func" +
            "/getFuncsTreeByAccountIdForPad";
    /**
     * 订单详情
     */
    public static final String ACCOUNT_FIND_ORDER_BYID = "/basic/ociOrderDetail/findById";
    /**
     * 订单查询
     */
    public static final String ACCOUNT_FIND_ORDER = "/basic/ociOrder/findOrder";
    /**
     * 套餐明细（无菌、复消，器械）
     */
    public static final String ACCOUNT_FINDBY_SUITEID = "/basic/ociSuiteDetail/findBySuiteId";
    /**
     * 订单操作
     */
    public static final String ACCOUNT_OPERATOR_ORDER = "/basic/ociOrder/operatorOrder";
    /**
     * 套餐明细（耗材、器械）
     */
    public static final String ACCOUNT_FINDBY_ID = "/basic/ociSuiteDetail/findById";
    /**
     * 订单状态
     */
    public static final String ACCOUNT_ORDERSTATUS_LIST = "/basic/ociOrder/orderStatusList";
    /**
     * 计费提报
     */
    public static final String ACCOUNT_CHARGING_FEE = "/dhccApi/basic/ociFee/chargingFee";
    /**
     * 耗材明细
     */
    public static final String ACCOUNT_CST_DETAIL = "/basic/ociOrderDetail" +
            "/findCstDetailByOrderId";
    /**
     * 获取手术排班患者
     */
    public static final String ORDER_PATIENT_LIST = "/patient/surgeryInfo/getSurgeryPatient";
    /**
     * 套餐查询
     */
    public static final String ORDER_FIND_SUITE = "/basic/ociSuite/findSuite";
    /**
     * 套餐明细
     */
    public static final String ORDER_FIND_BY_ID = "/basic/ociSuiteDetail/findById";
    /**
     * 手术信息查询
     */
    public static final String ORDER_FIND_BY_STATUS = "/dict/surgeryDict/findByStatus";
    /**
     * 提交订单申请
     */
    public static final String ORDER_SAVE = "/basic/ociOrder/save";
    /**
     * 获取所有在院患者
     */
    public static final String ORDER_GET_ALL_PATIENT = "/patient/patient/getAllPatient";

}
