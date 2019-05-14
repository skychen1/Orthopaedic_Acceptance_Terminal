package com.rivamed.orthopaedicacceptanceterminal.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.lzy.okgo.model.Response;
import com.rivamed.common.http.OkGoUtil;
import com.rivamed.common.http.callback.DialogCallback;
import com.rivamed.common.utils.EventBusUtils;
import com.rivamed.common.utils.ToastUtils;
import com.rivamed.orthopaedicacceptanceterminal.R;
import com.rivamed.orthopaedicacceptanceterminal.adapter.CstCostSureAdapter;
import com.rivamed.orthopaedicacceptanceterminal.app.UrlPath;
import com.rivamed.orthopaedicacceptanceterminal.bean.CstsBean;
import com.rivamed.orthopaedicacceptanceterminal.bean.Event;
import com.rivamed.orthopaedicacceptanceterminal.bean.FindCstDetailResponseParam;
import com.rivamed.orthopaedicacceptanceterminal.bean.SubmitCostReqestAndResponseParam;
import com.rivamed.orthopaedicacceptanceterminal.views.SearchView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * @ProjectName: Orthopaedic_Acceptance_Terminal
 * @Package: com.rivamed.orthopaedicacceptanceterminal.activities
 * @ClassName: CstCostSureActivity
 * @Description: 确认计费耗材
 * @Author: Amos_Bo
 * @CreateDate: 2019/2/27 16:34
 * @UpdateUser: 更新者
 * @UpdateDate: 2019/2/27 16:34
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class CstCostSureActivity extends OatBaseActivity {
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
    private CstCostSureAdapter mCstCostSureAdapter;
    private List<FindCstDetailResponseParam.AsepticCstsBean> mCstCostDetailsSterilsData = new ArrayList<>();
    private List<FindCstDetailResponseParam.EliminationCstsBean> mCstCostDetailsEliminationData = new ArrayList<>();
    List<CstsBean> mListData = new ArrayList<CstsBean>();
    List<CstsBean> mListDataTemp = new ArrayList<CstsBean>();
    private String mOrderId;

    @Override
    protected int getContentLayoutId() {
        return R.layout.activity_cstcost_sure;
    }

    @Override
    public void initDataAndEvent(Bundle savedInstanceState) {
        btBottomLeft.setText("取消");
        tvCenterTitle.setText("请确认计费耗材");
        btBottomMedium.setVisibility(View.VISIBLE);
        Intent intent = getIntent();
        mOrderId = intent.getStringExtra("mOrderId");
        List<FindCstDetailResponseParam.AsepticCstsBean> cstCostDetailsSterilsData = (List<FindCstDetailResponseParam.AsepticCstsBean>) intent.getSerializableExtra("mCstCostDetailsSterilsFragmentListData");
        List<FindCstDetailResponseParam.EliminationCstsBean> cstCostDetailsEliminationData = (List<FindCstDetailResponseParam.EliminationCstsBean>) intent.getSerializableExtra("mCstCostDetailsEliminationFragmentListData");
        mCstCostDetailsSterilsData.addAll(cstCostDetailsSterilsData);
        mCstCostDetailsEliminationData.addAll(cstCostDetailsEliminationData);
        List<CstsBean> listData = getListData(mCstCostDetailsSterilsData, mCstCostDetailsEliminationData);
        mListData.addAll(listData);
        mListDataTemp.addAll(listData);
        if (mListData.size() > 0) {
            btBottomMedium.setText("只提交不结束");
            btBottomRight.setText("提交并结束订单");
        } else {
            btBottomMedium.setVisibility(View.GONE);
            btBottomRight.setText("确认提交并关闭订单");
        }
        mCstCostSureAdapter = new CstCostSureAdapter(getApplicationContext());
        mCstCostSureAdapter.setList(mListDataTemp);
        rvContext.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        rvContext.setAdapter(mCstCostSureAdapter);

        EditText etSeach = viewTopSearch.getEtSeach();
        etSeach.setHint("耗材名称、编码、规格/编号、批号");
        etSeach.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                String content = etSeach.getText().toString();
                searchData(content);
                hideInputWindow(etSeach);
                return true;
            }
        });
        viewTopSearch.setOnEmptyInputListener(new SearchView.OnEmptyInputListener() {
            @Override
            public void OnEmptyInput() {
                searchData("");
            }
        });

    }

    private void searchData(String content) {
        if (TextUtils.isEmpty(content)) {
            mListDataTemp.clear();
            mListDataTemp.addAll(mListData);
            mCstCostSureAdapter.notifyDataSetChanged();
        } else {
            mListDataTemp.clear();
            for (CstsBean item : mListData) {
                if (item.getCstName().contains(content) | item.getCstCode().contains(content) | item.getCstSpec().contains(content) | item.getBatchNo().contains(content)) {
                    mListDataTemp.add(item);
                }
            }
            mCstCostSureAdapter.notifyDataSetChanged();
        }

    }

    private List<CstsBean> getListData(List<FindCstDetailResponseParam.AsepticCstsBean> cstCostDetailsSterilsData, List<FindCstDetailResponseParam.EliminationCstsBean> cstCostDetailsEliminationData) {
        List<CstsBean> listData = new ArrayList<CstsBean>();
        for (FindCstDetailResponseParam.AsepticCstsBean item : cstCostDetailsSterilsData) {
            if (item.getNum() > 0) {
                CstsBean cstsBean = new CstsBean();
                cstsBean.setCstName(item.getCstName());
                cstsBean.setCstCode(item.getCstCode());
                cstsBean.setCstSpec(item.getCstSpec());
                cstsBean.setBatchNo(item.getBatchNo());
                cstsBean.setExpireDate(item.getExpireDate());
                cstsBean.setNum(item.getNum());
                cstsBean.setCstId(item.getCstId());
                cstsBean.setOrderDetailId(item.getOrderDetailId());
                cstsBean.setOrderSuiteId(item.getOrderSuiteId());
                listData.add(cstsBean);
            }
        }
        for (FindCstDetailResponseParam.EliminationCstsBean item : cstCostDetailsEliminationData) {
            if (item.getNum() > 0) {
                CstsBean cstsBean = new CstsBean();
                cstsBean.setCstName(item.getCstName());
                cstsBean.setCstCode(item.getCstCode());
                cstsBean.setCstSpec(item.getCstSpec());
                cstsBean.setBatchNo(item.getBatchNo());
                cstsBean.setExpireDate(item.getExpireDate());
                cstsBean.setNum(item.getNum());
                cstsBean.setCstId(item.getCstId());
                cstsBean.setOrderDetailId(item.getOrderDetailId());
                cstsBean.setOrderSuiteId(item.getOrderSuiteId());
                listData.add(cstsBean);
            }
        }
        return listData;
    }

    @OnClick({R.id.bt_bottom_left, R.id.bt_bottom_right, R.id.bt_bottom_medium})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.bt_bottom_left:
                finish();
                break;
            case R.id.bt_bottom_right:
                submit(true);
                break;
            case R.id.bt_bottom_medium:
                submit(false);
                break;
        }
    }

    private void submit(boolean isFinishOrder) {
        SubmitCostReqestAndResponseParam submitCostReqestAndResponseParam = new SubmitCostReqestAndResponseParam();
        submitCostReqestAndResponseParam.setOrderId(mOrderId);
        submitCostReqestAndResponseParam.setFinishOrder(isFinishOrder);
        for (CstsBean cstsBean : mListDataTemp) {
            SubmitCostReqestAndResponseParam.SuiteVosBean suiteVosBean = new SubmitCostReqestAndResponseParam.SuiteVosBean();
            suiteVosBean.setCstId(cstsBean.getCstId());
            suiteVosBean.setNum(cstsBean.getNum());
            suiteVosBean.setOrderSuiteId(cstsBean.getOrderSuiteId());
            suiteVosBean.setOrderDetailId(cstsBean.getOrderDetailId());
            submitCostReqestAndResponseParam.getSuiteVos().add(suiteVosBean);
        }
        submitCostData(submitCostReqestAndResponseParam);
    }

    /**
     * 计费提报
     *
     * @param costData
     */
    private void submitCostData(SubmitCostReqestAndResponseParam costData) {
        OkGoUtil.postJsonRequest(UrlPath.ACCOUNT_CHARGING_FEE, this, costData,
                new DialogCallback<SubmitCostReqestAndResponseParam>(this) {
                    @Override
                    public void onSuccess(Response<SubmitCostReqestAndResponseParam> response) {
                        if (response.body() != null && response.body().isOperateSuccess()) {
                            ToastUtils.showShort("提交成功");
                            EventBusUtils.post(new Event.EventOrderOpt("CstCostSureActivity"));
                            finish();
                        } else {
                            ToastUtils.showShort("提交失败");
                        }
                    }

                    @Override
                    public void onError(Response<SubmitCostReqestAndResponseParam> response) {
                        super.onError(response);
                    }
                });
    }

}
