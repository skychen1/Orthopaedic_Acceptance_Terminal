package com.rivamed.orthopaedicacceptanceterminal.bean;

/**
 * @作者: 钱凯
 * @创建时间: 2019/3/18
 * @功能描述:EventBus事件
 */
public class Event {
    /**
     * 选择手术排班
     */
    public static class EventSelectOperationPlan {
        public SurgeryPatientResponseParam.SurgeryPatientVosBean mSurgeryPatientVosBean;

        public EventSelectOperationPlan(SurgeryPatientResponseParam.SurgeryPatientVosBean surgeryPatientVosBean) {
            mSurgeryPatientVosBean = surgeryPatientVosBean;
        }
    }

    /**
     * 选择套餐
     */
    public static class EventSelectSuit {
        public FindByIdResponseParam data;

        public EventSelectSuit(FindByIdResponseParam surgeryPatientVosBean) {
            data = surgeryPatientVosBean;
        }
    }

    /**
     * 选择患者
     */
    public static class EventSelectPatint {
        public GetAllPatientResponseParam.PatientsBean data;

        public EventSelectPatint(GetAllPatientResponseParam.PatientsBean patientsBean) {
            data = patientsBean;
        }
    }

    /**
     * 选择手术
     */
    public static class EventSelectOpt {
        public FindByStatusResponseParam.SurgeryDictsBean data;

        public EventSelectOpt(FindByStatusResponseParam.SurgeryDictsBean bean) {
            data = bean;
        }
    }
}
