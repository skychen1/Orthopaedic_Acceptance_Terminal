package com.rivamed.orthopaedicacceptanceterminal.fragment;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.rivamed.common.base.BaseFragment;
import com.rivamed.orthopaedicacceptanceterminal.R;
import com.rivamed.orthopaedicacceptanceterminal.adapter.OperationPlanSuiteAdapter;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * @ProjectName: Orthopaedic_Acceptance_Terminal
 * @Package: com.rivamed.orthopaedicacceptanceterminal.fragment
 * @ClassName: OperationPlanFragment
 * @Description: 加急订单
 * @Author: Amos_Bo
 * @CreateDate: 2019/2/25 18:18
 * @UpdateUser: 更新者
 * @UpdateDate: 2019/2/25 18:18
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class OperationUrgentFragment extends BaseFragment {
    @BindView(R.id.tv_op_name)
    TextView tvOpName;
    @BindView(R.id.img_edit)
    ImageView imgEdit;
    @BindView(R.id.tv_patient_name)
    TextView tvPatientName;
    @BindView(R.id.img_patient_edit)
    ImageView imgPatientEdit;
    @BindView(R.id.tv_patient_id)
    TextView tvPatientId;
    @BindView(R.id.rv_suit)
    RecyclerView rvSuit;
    Unbinder unbinder;
    private OperationPlanSuiteAdapter mOperationPlanSuiteAdapter;

    public static OperationUrgentFragment newInstance() {
        Bundle args = new Bundle();
        OperationUrgentFragment fragment = new OperationUrgentFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_urgent_order;
    }

    @Override
    public void initDataAndEvent(Bundle savedInstanceState) {
        initView();
    }

    private void initView() {
        mOperationPlanSuiteAdapter = new OperationPlanSuiteAdapter(_mActivity);
        mOperationPlanSuiteAdapter.setList(new ArrayList<>());
        mOperationPlanSuiteAdapter.setList(new ArrayList<>());
        rvSuit.setLayoutManager(new LinearLayoutManager(_mActivity));
        rvSuit.setAdapter(mOperationPlanSuiteAdapter);
    }

    @OnClick({R.id.img_edit, R.id.img_patient_edit})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.img_edit:
                break;
            case R.id.img_patient_edit:
                break;
            default:
                break;
        }
    }
}
