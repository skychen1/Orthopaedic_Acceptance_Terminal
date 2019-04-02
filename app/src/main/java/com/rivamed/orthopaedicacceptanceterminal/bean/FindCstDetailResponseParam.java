package com.rivamed.orthopaedicacceptanceterminal.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @ProjectName: Orthopaedic_Acceptance_Terminal
 * @Package: com.rivamed.orthopaedicacceptanceterminal.bean
 * @ClassName: FindCstDetailResponse
 * @Description: 耗材明细
 * @Author: Amos_Bo
 * @CreateDate: 2019/2/21 14:16
 * @UpdateUser: 更新者
 * @UpdateDate: 2019/2/21 14:16
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class FindCstDetailResponseParam implements Serializable {

    /**
     * id : 0
     * orderId : 40288ba969991d1d0169992775a40006
     * surgeryPatientVo : {"hisPatientId":"1003","patientName":"李开","gender":"男","caseNo":"病案号","surgeryName":"换头手术","doctorName":"-","birthday":"2019-02-28","status":"8"}
     * asepticCsts : [{"cstBoxCount":0,"instrumentBoxCount":0,"cstCount":0,"instrumentCount":0,"cstName":"载玻片（世泰）","cstCode":"2014wg00401897","cstSpec":"fddddfsd","cstType":"1","expireDate":"2019-02-14","batchNo":"222","cstNumber":"qwe","num":3}]
     * eliminationCsts : [{"cstBoxCount":0,"instrumentBoxCount":0,"cstCount":0,"instrumentCount":0,"cstName":"咽喉镜","cstCode":"2014wg00401977","cstSpec":"cvcx","cstType":"0","expireDate":"2019-02-14","batchNo":"ww","cstNumber":"ss","num":4}]
     */

    private int id;
    private String orderId;
    private SurgeryPatientVoBean surgeryPatientVo;
    private List<AsepticCstsBean> asepticCsts = new ArrayList<>();
    private List<EliminationCstsBean> eliminationCsts = new ArrayList<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public SurgeryPatientVoBean getSurgeryPatientVo() {
        return surgeryPatientVo;
    }

    public void setSurgeryPatientVo(SurgeryPatientVoBean surgeryPatientVo) {
        this.surgeryPatientVo = surgeryPatientVo;
    }

    public List<AsepticCstsBean> getAsepticCsts() {
        return asepticCsts;
    }

    public void setAsepticCsts(List<AsepticCstsBean> asepticCsts) {
        this.asepticCsts = asepticCsts;
    }

    public List<EliminationCstsBean> getEliminationCsts() {
        return eliminationCsts;
    }

    public void setEliminationCsts(List<EliminationCstsBean> eliminationCsts) {
        this.eliminationCsts = eliminationCsts;
    }

    public static class SurgeryPatientVoBean {
        /**
         * hisPatientId : 1003
         * patientName : 李开
         * gender : 男
         * caseNo : 病案号
         * surgeryName : 换头手术
         * doctorName : -
         * birthday : 2019-02-28
         * status : 8
         */

        private String hisPatientId;
        private String patientName;
        private String gender;
        private String caseNo;
        private String surgeryName;
        private String doctorName;
        private String birthday;
        private String status;
        private String scheduleTime = "";

        public String getScheduleTime() {
            return scheduleTime;
        }

        public void setScheduleTime(String scheduleTime) {
            this.scheduleTime = scheduleTime;
        }

        public String getHisPatientId() {
            return hisPatientId;
        }

        public void setHisPatientId(String hisPatientId) {
            this.hisPatientId = hisPatientId;
        }

        public String getPatientName() {
            return patientName;
        }

        public void setPatientName(String patientName) {
            this.patientName = patientName;
        }

        public String getGender() {
            return gender;
        }

        public void setGender(String gender) {
            this.gender = gender;
        }

        public String getCaseNo() {
            return caseNo;
        }

        public void setCaseNo(String caseNo) {
            this.caseNo = caseNo;
        }

        public String getSurgeryName() {
            return surgeryName;
        }

        public void setSurgeryName(String surgeryName) {
            this.surgeryName = surgeryName;
        }

        public String getDoctorName() {
            return doctorName;
        }

        public void setDoctorName(String doctorName) {
            this.doctorName = doctorName;
        }

        public String getBirthday() {
            return birthday;
        }

        public void setBirthday(String birthday) {
            this.birthday = birthday;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }
    }

    public static class AsepticCstsBean implements Serializable {
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
        private String cstName = "";
        private String cstCode = "";
        private String cstSpec = "";
        private String cstType = "";
        private String expireDate = "--";
        private String batchNo = "";
        private String cstNumber = "0";
        private String orderDetailId = "";
        private int num;
        private int maxNum;
        private String cstId;

        public int getMaxNum() {
            return maxNum;
        }

        public void setMaxNum(int maxNum) {
            this.maxNum = maxNum;
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

    public static class EliminationCstsBean implements Serializable {
        /**
         * cstBoxCount : 0
         * instrumentBoxCount : 0
         * cstCount : 0
         * instrumentCount : 0
         * cstName : 咽喉镜
         * cstCode : 2014wg00401977
         * cstSpec : cvcx
         * cstType : 0
         * expireDate : 2019-02-14
         * batchNo : ww
         * cstNumber : ss
         * num : 4
         */

        private int cstBoxCount;
        private int instrumentBoxCount;
        private int cstCount;
        private int instrumentCount;
        private String cstName = "";
        private String cstCode = "";
        private String cstSpec = "";
        private String cstType = "";
        private String expireDate = "--";
        private String batchNo = "";
        private String orderDetailId = "";
        private String cstNumber = "0";
        private int num;
        private int maxNum;
        private String cstId;

        public int getMaxNum() {
            return maxNum;
        }

        public void setMaxNum(int maxNum) {
            this.maxNum = maxNum;
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
}
