package com.rivamed.orthopaedicacceptanceterminal.activities;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.widget.Button;
import android.widget.TextView;

import com.rivamed.orthopaedicacceptanceterminal.R;
import com.rivamed.orthopaedicacceptanceterminal.adapter.OrderLookUpDetailsAdapter;
import com.rivamed.orthopaedicacceptanceterminal.adapter.SupRoomCheckOrdDetailsAdapter;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * @ProjectName: Orthopaedic_Acceptance_Terminal
 * @Package: com.rivamed.orthopaedicacceptanceterminal.activities
 * @ClassName: OrderLookUpDetailsActivity
 * @Description: 供应室验收--订单详情
 * @Author: Amos_Bo
 * @CreateDate: 2019/2/27 14:00
 * @UpdateUser: 更新者
 * @UpdateDate: 2019/2/27 14:00
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class SupRoomCheckOrdDetailsActivity extends OatBaseActivity {
    @BindView(R.id.tv_op_name)
    TextView tvOpName;
    @BindView(R.id.tv_patient_name)
    TextView tvPatientName;
    @BindView(R.id.tv_patient_id)
    TextView tvPatientId;
    @BindView(R.id.tv_patient_case_id)
    TextView tvPatientCaseId;
    @BindView(R.id.tv_patient_brth)
    TextView tvPatientBrth;
    @BindView(R.id.tv_patient_sex)
    TextView tvPatientSex;
    @BindView(R.id.tv_patient_high)
    TextView tvPatientHigh;
    @BindView(R.id.tv_patient_doctor)
    TextView tvPatientDoctor;
    @BindView(R.id.tv_op_time)
    TextView tvOpTime;
    @BindView(R.id.rv_context)
    RecyclerView rvContext;
    @BindView(R.id.bt_bottom_left)
    Button btBottomLeft;
    @BindView(R.id.bt_bottom_medium)
    Button btBottomMedium;
    @BindView(R.id.bt_bottom_right)
    Button btBottomRight;

    private SupRoomCheckOrdDetailsAdapter mSupRoomCheckOrdDetailsAdapter;

    @Override
    protected int getContentLayoutId() {
        return R.layout.activity_superroom_checkord_details;
    }

    @Override
    public void initDataAndEvent(Bundle savedInstanceState) {

    }

    @OnClick(R.id.bt_bottom_right)
    public void onViewClicked() {
    }
}
