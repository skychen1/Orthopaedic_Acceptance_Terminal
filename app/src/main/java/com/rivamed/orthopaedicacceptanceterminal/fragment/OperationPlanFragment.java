package com.rivamed.orthopaedicacceptanceterminal.fragment;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.TextView;

import com.rivamed.common.base.BaseFragment;
import com.rivamed.orthopaedicacceptanceterminal.R;
import com.rivamed.orthopaedicacceptanceterminal.adapter.OperationPlanSuiteAdapter;

import java.util.ArrayList;

import butterknife.BindView;

/**
 * @ProjectName: Orthopaedic_Acceptance_Terminal
 * @Package: com.rivamed.orthopaedicacceptanceterminal.fragment
 * @ClassName: OperationPlanFragment
 * @Description: 手术排班
 * @Author: Amos_Bo
 * @CreateDate: 2019/2/25 18:18
 * @UpdateUser: 更新者
 * @UpdateDate: 2019/2/25 18:18
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class OperationPlanFragment extends BaseFragment {
    @BindView(R.id.tv_op_name)
    TextView tvOpName;
    @BindView(R.id.iv_edit)
    ImageView ivEdit;
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
    @BindView(R.id.rv_suit)
    RecyclerView rvSuit;

    private OperationPlanSuiteAdapter mOperationPlanSuiteAdapter;

    public static  OperationPlanFragment newInstance() {
        Bundle args = new Bundle();
        OperationPlanFragment fragment = new OperationPlanFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_operation_plan;
    }

    @Override
    public void initDataAndEvent(Bundle savedInstanceState) {
        initView();
    }

    private void initView() {
        mOperationPlanSuiteAdapter = new OperationPlanSuiteAdapter(_mActivity);
        mOperationPlanSuiteAdapter.setList(new ArrayList<>());
        rvSuit.setLayoutManager(new LinearLayoutManager(_mActivity));
        rvSuit.setAdapter(mOperationPlanSuiteAdapter);
    }
}
