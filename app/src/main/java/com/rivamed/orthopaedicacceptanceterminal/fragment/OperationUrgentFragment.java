package com.rivamed.orthopaedicacceptanceterminal.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.rivamed.common.base.BaseFragment;
import com.rivamed.common.utils.EventBusUtils;
import com.rivamed.common.utils.UIUtils;
import com.rivamed.orthopaedicacceptanceterminal.R;
import com.rivamed.orthopaedicacceptanceterminal.activities.SelectOperationSuiteActivity;
import com.rivamed.orthopaedicacceptanceterminal.activities.UrgentSelectOptActivity;
import com.rivamed.orthopaedicacceptanceterminal.activities.UrgentSelectPatintActivity;
import com.rivamed.orthopaedicacceptanceterminal.adapter.OperationPlanSuiteAdapter;
import com.rivamed.orthopaedicacceptanceterminal.bean.Event;
import com.rivamed.orthopaedicacceptanceterminal.bean.FindSuiteResponseParam;

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
    ArrayList<FindSuiteResponseParam.OciSuiteVosBean> listSuit = new ArrayList<>();
    private int mSelectSuitPosition;
    protected String mSurgeryDictId = "";
    protected String mPatientId = "";

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
        EventBusUtils.register(this);
        initView();
        mOperationPlanSuiteAdapter.setOnSelectSuitListener(new OperationPlanSuiteAdapter.OnClickSuitListener() {
            @Override
            public void OnSelectSuit(int position) {
                if (UIUtils.isFastDoubleClick())
                    return;
                mSelectSuitPosition = position;
                Intent intent = new Intent(getActivity(), SelectOperationSuiteActivity.class);
                intent.putExtra("from", "OperationUrgentFragment");
                startActivity(intent);
            }

            @Override
            public void OnAdd(int position) {
                FindSuiteResponseParam.OciSuiteVosBean bean = new FindSuiteResponseParam.OciSuiteVosBean();
                bean.setId(SystemClock.currentThreadTimeMillis() + "");
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

    @OnClick({R.id.img_edit, R.id.img_patient_edit})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.img_edit://手术名称
                startActivity(new Intent(getActivity(), UrgentSelectOptActivity.class));
                break;
            case R.id.img_patient_edit://患者姓名
                startActivity(new Intent(getActivity(), UrgentSelectPatintActivity.class));
                break;
            default:
                break;
        }
    }

    /**
     * 选择套餐
     *
     * @param event
     */
    @Subscribe(threadMode = ThreadMode.MAIN, sticky = true)
    public void onEventSelectSuit(Event.EventSelectSuit event) {
        if (event.data != null && event.data.getFrom().equals("OperationUrgentFragment")) {
            listSuit.get(mSelectSuitPosition).setSuiteName(event.data.getSuiteName());
            listSuit.get(mSelectSuitPosition).setVendorName(event.data.getVendorName());
            listSuit.get(mSelectSuitPosition).setSuiteId(event.data.getSuiteId());
            mOperationPlanSuiteAdapter.notifyDataSetChanged();
        }else if (event.data != null && event.data.getFrom().equals("OperationUrgentFragmentSubmit")) {
            listSuit.clear();
            listSuit.add(new FindSuiteResponseParam.OciSuiteVosBean());
            mOperationPlanSuiteAdapter.notifyDataSetChanged();
        }
    }

    /**
     * 选择手术
     *
     * @param event
     */
    @Subscribe(threadMode = ThreadMode.MAIN, sticky = true)
    public void onEventSelectOpt(Event.EventSelectOpt event) {
        if (event.data != null) {
            tvOpName.setText(event.data.getName());
            mSurgeryDictId = event.data.getSurgeryDictId();
        }
    }

    /**
     * 选择患者
     *
     * @param event
     */
    @Subscribe(threadMode = ThreadMode.MAIN, sticky = true)
    public void onEventSelectPatint(Event.EventSelectPatint event) {
        if (event.data != null) {
            tvPatientName.setText(event.data.getPatientName());
            mPatientId = event.data.getPatientId();
            tvPatientId.setText(mPatientId);
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        EventBusUtils.unregister(this);
    }
}
