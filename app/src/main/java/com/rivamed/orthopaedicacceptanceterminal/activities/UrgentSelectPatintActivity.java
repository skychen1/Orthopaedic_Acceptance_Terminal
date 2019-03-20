package com.rivamed.orthopaedicacceptanceterminal.activities;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.lzy.okgo.model.Response;
import com.rivamed.common.adapter.SimpleRecyclerAdapter;
import com.rivamed.common.http.OkGoUtil;
import com.rivamed.common.http.callback.DialogCallback;
import com.rivamed.common.utils.EventBusUtils;
import com.rivamed.orthopaedicacceptanceterminal.R;
import com.rivamed.orthopaedicacceptanceterminal.adapter.UrgentSelectPatientAdapter;
import com.rivamed.orthopaedicacceptanceterminal.app.UrlPath;
import com.rivamed.orthopaedicacceptanceterminal.bean.Event;
import com.rivamed.orthopaedicacceptanceterminal.bean.GetAllPatientResponseParam;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * @ProjectName: Orthopaedic_Acceptance_Terminal
 * @Package: com.rivamed.orthopaedicacceptanceterminal.activities
 * @ClassName: UrgentSelectPatintActivity
 * @Description: 订单申请-加急订单-选择患者
 * @Author: Amos_Bo
 * @CreateDate: 2019/2/26 17:19
 * @UpdateUser: 更新者
 * @UpdateDate: 2019/2/26 17:19
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class UrgentSelectPatintActivity extends OatBaseActivity {

    @BindView(R.id.rv_context)
    RecyclerView rvContext;
    private UrgentSelectPatientAdapter mUrgentSelectPatientAdapter;
    List<GetAllPatientResponseParam.PatientsBean> listData = new ArrayList<>();

    @Override
    protected int getContentLayoutId() {
        return R.layout.activity_urgent_selectpatient;
    }

    @Override
    public void initDataAndEvent(Bundle savedInstanceState) {
        initView();
        getAllPatient();
        initEvent();
    }

    private void initEvent() {
        mUrgentSelectPatientAdapter.setOnItemClickListener(new SimpleRecyclerAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                EventBusUtils.post(new Event.EventSelectPatint(listData.get(position)));
                finish();
            }

            @Override
            public void onItemLongClick(View view, int position) {

            }
        });
    }

    private void initView() {
        tvCenterTitle.setText("选择患者");
        mUrgentSelectPatientAdapter = new UrgentSelectPatientAdapter(getApplicationContext());
        mUrgentSelectPatientAdapter.setList(listData);
        rvContext.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        rvContext.setAdapter(mUrgentSelectPatientAdapter);
    }



    /**
     * 获取所有在院患者
     */
    private void getAllPatient() {
        OkGoUtil.getRequest(UrlPath.ORDER_GET_ALL_PATIENT, this,
                new DialogCallback<GetAllPatientResponseParam>(this) {
                    @Override
                    public void onSuccess(Response<GetAllPatientResponseParam> response) {
                        if (response.body() != null && response.body().getPatients() != null) {
                            listData.clear();
                            listData.addAll(response.body().getPatients());
                            mUrgentSelectPatientAdapter.notifyDataSetChanged();
                        }
                    }
                    @Override
                    public void onError(Response<GetAllPatientResponseParam> response) {
                        super.onError(response);
                    }
                });
    }
}
