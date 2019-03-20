package com.rivamed.orthopaedicacceptanceterminal.activities;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.lzy.okgo.model.Response;
import com.rivamed.common.adapter.SimpleRecyclerAdapter;
import com.rivamed.common.http.OkGoUtil;
import com.rivamed.common.http.callback.DialogCallback;
import com.rivamed.common.utils.EventBusUtils;
import com.rivamed.common.utils.ToastUtils;
import com.rivamed.orthopaedicacceptanceterminal.R;
import com.rivamed.orthopaedicacceptanceterminal.adapter.SelectOperationPlanAdapter;
import com.rivamed.orthopaedicacceptanceterminal.app.UrlPath;
import com.rivamed.orthopaedicacceptanceterminal.bean.Event;
import com.rivamed.orthopaedicacceptanceterminal.bean.SurgeryPatientResponseParam;
import com.rivamed.orthopaedicacceptanceterminal.views.SearchView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * @ProjectName: Orthopaedic_Acceptance_Terminal
 * @Package: com.rivamed.orthopaedicacceptanceterminal.activities
 * @ClassName: SelectOperationPlanActivity
 * @Description: 选择手术排班页面
 * @Author: Amos_Bo
 * @CreateDate: 2019/2/26 10:09
 * @UpdateUser: 更新者
 * @UpdateDate: 2019/2/26 10:09
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class SelectOperationPlanActivity extends OatBaseActivity {
    @BindView(R.id.view_top_search)
    SearchView viewTopSearch;
    @BindView(R.id.rv_context)
    RecyclerView rvContext;
    @BindView(R.id.bt_bottom_left)
    Button btBottomLeft;
    @BindView(R.id.bt_bottom_medium)
    Button btBottomMedium;
    @BindView(R.id.bt_bottom_right)
    Button btBottomRight;

    private SelectOperationPlanAdapter mSelectOperationPlanAdapter;
    private List<SurgeryPatientResponseParam.SurgeryPatientVosBean> mSurgeryPatientVos = new ArrayList<>();

    @Override
    protected int getContentLayoutId() {
        return R.layout.activity_select_optplan;
    }

    @Override
    public void initDataAndEvent(Bundle savedInstanceState) {
        btBottomLeft.setText("取消");
        tvCenterTitle.setText("选择手术排班");
        mSelectOperationPlanAdapter = new SelectOperationPlanAdapter(getApplicationContext());
        mSelectOperationPlanAdapter.setList(mSurgeryPatientVos);
        rvContext.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        rvContext.setAdapter(mSelectOperationPlanAdapter);
        mSelectOperationPlanAdapter.setOnItemClickListener(new SimpleRecyclerAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                SurgeryPatientResponseParam.SurgeryPatientVosBean surgeryPatientVosBean = mSurgeryPatientVos.get(position);
                surgeryPatientVosBean.setHeight("--");
                EventBusUtils.post(new Event.EventSelectOperationPlan(surgeryPatientVosBean) );
                finish();
            }
            @Override
            public void onItemLongClick(View view, int position) {

            }
        });
        getSurgeryPatient("");
        EditText etSeach = viewTopSearch.getEtSeach();
        etSeach.setHint("请输入手术名称、患者姓名、患者ID、手术医生");
        etSeach.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                String content = etSeach.getText().toString();
                getSurgeryPatient(content);
                hideInputWindow(etSeach);
                return true;
            }
        });
        viewTopSearch.setOnEmptyInputListener(new SearchView.OnEmptyInputListener() {
            @Override
            public void OnEmptyInput() {
                getSurgeryPatient("");
            }
        });

    }

    /**
     * 获取手术排班患者
     *
     */
    private void getSurgeryPatient(String term) {
        Map<String, String> map = new HashMap<>(1);
        map.put("term", term);
        OkGoUtil.getRequest(UrlPath.ORDER_PATIENT_LIST, this,map,
                new DialogCallback<SurgeryPatientResponseParam>(this) {
                    @Override
                    public void onSuccess(Response<SurgeryPatientResponseParam> response) {
                        if (response.body().isOperateSuccess()) {
                            mSurgeryPatientVos.clear();
                            mSurgeryPatientVos.addAll(response.body().getSurgeryPatientVos());
                            mSelectOperationPlanAdapter.notifyDataSetChanged();
                        } else {
                            ToastUtils.showShort("访问失败");
                        }
                    }
                    @Override
                    public void onError(Response<SurgeryPatientResponseParam> response) {
                        super.onError(response);
                    }
                });
    }

    @OnClick({R.id.bt_bottom_left, R.id.bt_bottom_right})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.bt_bottom_left:
                finish();
                break;
            case R.id.bt_bottom_right:
                break;
        }
    }
}
