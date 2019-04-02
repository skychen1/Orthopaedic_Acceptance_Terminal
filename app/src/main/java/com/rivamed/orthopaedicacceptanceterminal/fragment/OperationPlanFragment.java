package com.rivamed.orthopaedicacceptanceterminal.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.TextView;

import com.rivamed.common.base.BaseFragment;
import com.rivamed.common.utils.EventBusUtils;
import com.rivamed.common.utils.UIUtils;
import com.rivamed.orthopaedicacceptanceterminal.R;
import com.rivamed.orthopaedicacceptanceterminal.activities.SelectOperationPlanActivity;
import com.rivamed.orthopaedicacceptanceterminal.activities.SelectOperationSuiteActivity;
import com.rivamed.orthopaedicacceptanceterminal.adapter.OperationPlanSuiteAdapter;
import com.rivamed.orthopaedicacceptanceterminal.bean.Event;
import com.rivamed.orthopaedicacceptanceterminal.bean.FindSuiteResponseParam;
import com.rivamed.orthopaedicacceptanceterminal.bean.SurgeryPatientResponseParam;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * @ProjectName: Orthopaedic_Acceptance_Terminal
 * @Package: com.rivamed.orthopaedicacceptanceterminal.fragment
 * @ClassName: OperationPlanFragment
 * @Description: 手术排班页面
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
    Unbinder unbinder;

    private OperationPlanSuiteAdapter mOperationPlanSuiteAdapter;
    ArrayList<FindSuiteResponseParam.OciSuiteVosBean> listSuit = new ArrayList<>();
    private int mSelectSuitPosition;
    protected String mPatientId;
    protected String mSurgeryId;

    public static OperationPlanFragment newInstance() {
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
        EventBusUtils.register(this);
        initView();
        mOperationPlanSuiteAdapter.setOnSelectSuitListener(new OperationPlanSuiteAdapter.OnClickSuitListener() {
            @Override
            public void OnSelectSuit(int position) {
                if (UIUtils.isFastDoubleClick())
                    return;
                mSelectSuitPosition = position;
                Intent intent = new Intent(getActivity(), SelectOperationSuiteActivity.class);
                intent.putExtra("from","OperationPlanFragment");
                startActivity(intent);
            }

            @Override
            public void OnAdd(int position) {
                FindSuiteResponseParam.OciSuiteVosBean bean = new FindSuiteResponseParam.OciSuiteVosBean();
                bean.setId(SystemClock.currentThreadTimeMillis()+"");
                listSuit.add(bean);
                mOperationPlanSuiteAdapter.notifyDataSetChanged();
            }
        });
    }

    private void initView() {
        mOperationPlanSuiteAdapter = new OperationPlanSuiteAdapter(_mActivity);
        listSuit.add(new FindSuiteResponseParam.OciSuiteVosBean());
        mOperationPlanSuiteAdapter.setList(listSuit);
        rvSuit.setLayoutManager(new LinearLayoutManager(_mActivity));
        rvSuit.setAdapter(mOperationPlanSuiteAdapter);
    }

    /**
     * 选择手术排班
     *
     * @param event
     */
    @Subscribe(threadMode = ThreadMode.MAIN, sticky = true)
    public void onEventSelectOperationPlan(Event.EventSelectOperationPlan event) {
        if (event.mSurgeryPatientVosBean != null) {
            SurgeryPatientResponseParam.SurgeryPatientVosBean item = event.mSurgeryPatientVosBean;
            tvOpName.setText(item.getSurgeryName());
            tvPatientName.setText(item.getPatientName());
            tvPatientBrth.setText(item.getBirthday());
            tvPatientId.setText(item.getHisPatientId());
            tvPatientHigh.setText(item.getHeight());
            tvPatientCaseId.setText(item.getCaseNo());
            tvPatientSex.setText(item.getGender());
            tvOpTime.setText(item.getScheduleTime());
            tvPatientDoctor.setText(item.getDoctorName());
            mPatientId = item.getPatientId();
            mSurgeryId = item.getSurgeryId();
        }
    }

    @OnClick(R.id.iv_edit)
    public void onViewClicked() {
        //编辑手术排班患者
        startActivity(new Intent(getActivity(), SelectOperationPlanActivity.class));
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        EventBusUtils.unregister(this);
    }

    /**
     * 选择套餐
     *
     * @param event
     */
    @Subscribe(threadMode = ThreadMode.MAIN, sticky = true)
    public void onEventSelectSuit(Event.EventSelectSuit event) {
        if (event.data != null&& event.data.getFrom().equals("OperationPlanFragment")) {
            listSuit.get(mSelectSuitPosition).setSuiteName(event.data.getSuiteName());
            listSuit.get(mSelectSuitPosition).setVendorName(event.data.getVendorName());
            listSuit.get(mSelectSuitPosition).setSuiteId(event.data.getSuiteId());
            mOperationPlanSuiteAdapter.notifyDataSetChanged();
        }else if (event.data != null&& event.data.getFrom().equals("OperationPlanFragmentSubmit")) {
            listSuit.clear();
            listSuit.add(new FindSuiteResponseParam.OciSuiteVosBean());
            mOperationPlanSuiteAdapter.notifyDataSetChanged();
        }
    }
}
