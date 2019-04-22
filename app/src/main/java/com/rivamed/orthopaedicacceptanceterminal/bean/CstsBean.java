package com.rivamed.orthopaedicacceptanceterminal.bean;

/**
 * @作者: 钱凯
 * @创建时间: 2019/3/27
 * @功能描述:耗材bean
 */
public class CstsBean {
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
    private String orderDetailId;
    private String cstCode;
    private String cstSpec;
    private String cstType;
    private String expireDate;
    private String batchNo;
    private String cstNumber="0";
    private int num;
    private String cstId;
    private String orderSuiteId = "";

    public String getOrderSuiteId() {
        return orderSuiteId;
    }

    public void setOrderSuiteId(String orderSuiteId) {
        this.orderSuiteId = orderSuiteId;
    }

    public String getCstId() {
        return cstId;
    }

    public void setCstId(String cstId) {
        this.cstId = cstId;
    }

    public String getOrderDetailId() {
        return orderDetailId;
    }

    public void setOrderDetailId(String orderDetailId) {
        this.orderDetailId = orderDetailId;
    }

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

}
