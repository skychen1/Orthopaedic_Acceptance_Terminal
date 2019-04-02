package com.rivamed.orthopaedicacceptanceterminal.bean;

import java.util.List;

/**
 * @作者: 钱凯
 * @创建时间: 2019/3/27
 * @功能描述:
 */
public class CstCostSureRequestBean {

    /**
     * orderId : 4028829468dbccc20168dbd700c50000
     * suiteVos : [{"cstBoxCount":0,"instrumentBoxCount":0,"cstCount":0,"instrumentCount":0,"cstId":"40288297678748df0167875a3b730000","cstName":"医用纱布块呜呜呜呜呜呜呜呜呜呜呜呜呜呜呜呜呜呜呜呜","cstCode":"C002-10000","cstSpec":"常规","cstType":"1","num":1,"orderDetailId":"4028829468dbccc20168dbd700d20001"},{"cstBoxCount":0,"instrumentBoxCount":0,"cstCount":0,"instrumentCount":0,"cstId":"40288297678748df0167875a409a0007","cstName":"医用手术膜","cstCode":"C001-10004","cstSpec":"CC","cstType":"1","num":1,"orderDetailId":"4028829468dbccc20168dbd700d20002"}]
     */

    private String orderId;
    private List<SuiteVosBean> suiteVos;

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

    public static class SuiteVosBean {
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
    }
}
