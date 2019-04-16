package com.rivamed.orthopaedicacceptanceterminal.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.lzy.okgo.model.Response;
import com.rivamed.common.http.OkGoUtil;
import com.rivamed.common.http.callback.DialogCallback;
import com.rivamed.common.utils.EventBusUtils;
import com.rivamed.common.utils.SPUtils;
import com.rivamed.common.utils.ToastUtils;
import com.rivamed.orthopaedicacceptanceterminal.R;
import com.rivamed.orthopaedicacceptanceterminal.adapter.OrderLookUpDetailsAdapter;
import com.rivamed.orthopaedicacceptanceterminal.app.Constants;
import com.rivamed.orthopaedicacceptanceterminal.app.UrlPath;
import com.rivamed.orthopaedicacceptanceterminal.bean.Event;
import com.rivamed.orthopaedicacceptanceterminal.bean.FindOrderDetailResponseParam;
import com.rivamed.orthopaedicacceptanceterminal.bean.SaveOrderResponseParam;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * @ProjectName: Orthopaedic_Acceptance_Terminal
 * @Package: com.rivamed.orthopaedicacceptanceterminal.activities
 * @ClassName: OrderLookUpDetailsActivity
 * @Description: 订单详情页面
 * @Author: Amos_Bo
 * @CreateDate: 2019/2/27 14:00
 * @UpdateUser: 更新者
 * @UpdateDate: 2019/2/27 14:00
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class OrderDetailsActivity extends OatBaseActivity {
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
    @BindView(R.id.ll_bottom_root)
    LinearLayout mLlBottomRoot;

    private OrderLookUpDetailsAdapter mOrderLookUpDetailsAdapter;
    List<FindOrderDetailResponseParam.OciSuiteVosBean> listData = new ArrayList<FindOrderDetailResponseParam.OciSuiteVosBean>();
    private String mFrom = "";
    private String mOrderId;

    @Override
    protected int getContentLayoutId() {
        return R.layout.activity_order_lookup_details;
    }

    @Override
    public void initDataAndEvent(Bundle savedInstanceState) {
        EventBusUtils.register(this);
        mOrderId = getIntent().getStringExtra("orderId");
        if (!TextUtils.isEmpty(mOrderId)) {
            findOrderDetail(mOrderId);
        }
        tvCenterTitle.setText("订单详情");
        mOrderLookUpDetailsAdapter = new OrderLookUpDetailsAdapter(this);
        mOrderLookUpDetailsAdapter.setList(listData);
        rvContext.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        rvContext.setAdapter(mOrderLookUpDetailsAdapter);
        mFrom = getIntent().getStringExtra("from");

        mOrderLookUpDetailsAdapter.setOnSuitDetailClickListener(new OrderLookUpDetailsAdapter.OnSuitDetailClickListener() {
            @Override
            public void OnSuitDetailClick(int position) {
                if (mFrom.contains("HckDeptUnExamineOrderFragment")) {
                    //器械处审核订单
                    Intent intent = new Intent(OrderDetailsActivity.this, OptSuiteDetailsActivity.class);
                    intent.putExtra("suiteId", listData.get(position).getSuiteId());
                    intent.putExtra("from", mFrom);
                    startActivity(intent);
                } else if (mFrom.equals("HomeHckDeptCheckOrderFragment")) {
                    //器械处验收订单
                    Intent intent = new Intent(OrderDetailsActivity.this, SuiteDetailsActivity.class);
                    intent.putExtra("suiteId", listData.get(position).getSuiteId());
                    intent.putExtra("from", mFrom);
                    intent.putExtra("mOrderId", mOrderId);
                    startActivity(intent);
                } else if (mFrom.equals("HomeNoseCheckOrderFragment")) {
                    //护士验收订单
                    Intent intent = new Intent(OrderDetailsActivity.this, SuiteDetailsActivity.class);
                    intent.putExtra("suiteId", listData.get(position).getSuiteId());
                    intent.putExtra("from", mFrom);
                    intent.putExtra("mOrderId", mOrderId);
                    startActivity(intent);
                } else if (mFrom.equals("HomeSupRoomCheckOrderFragment")) {
                    //供应室验收订单
                    Intent intent = new Intent(OrderDetailsActivity.this, SuiteDetailsActivity.class);
                    intent.putExtra("suiteId", listData.get(position).getSuiteId());
                    intent.putExtra("from", mFrom);
                    intent.putExtra("mOrderId", mOrderId);
                    startActivity(intent);
                } else if (mFrom.equals("HomeOrderLookUpFragment")) {
                    //订单查询
                    Intent intent = new Intent(OrderDetailsActivity.this, SuiteDetailsActivity.class);
                    intent.putExtra("suiteId", listData.get(position).getSuiteId());
                    intent.putExtra("from", mFrom);
                    intent.putExtra("mOrderId", mOrderId);
                    startActivity(intent);
                }
            }
        });
        //设置底部按钮
        if (mFrom.contains("HckDeptUnExamineOrderFragment")) {
            //器械处审核订单
            btBottomLeft.setText("拒绝");
            btBottomRight.setText("通过");
        } else if (mFrom.equals("HomeHckDeptCheckOrderFragment")) {
            //器械处验收订单
            btBottomLeft.setText("拒绝");
            btBottomRight.setText("通过");
        } else if (mFrom.equals("HomeNoseCheckOrderFragment")) {
            //护士处验收订单
            mLlBottomRoot.setVisibility(View.GONE);
        } else if (mFrom.equals("HomeSupRoomCheckOrderFragment")) {
            //供应室验收订单
            mLlBottomRoot.setVisibility(View.GONE);
        } else if (mFrom.equals("HomeOrderLookUpFragment")) {
            //订单查询
            btBottomLeft.setVisibility(View.GONE);
            btBottomRight.setText("撤销订单");
            String orderStatus = getIntent().getStringExtra("orderStatus");
            boolean isDoctor = SPUtils.getBoolean(mContext, Constants.ORTHOPAEDIC_IS_DOCTOR, false);
            if ((!isDoctor)|(orderStatus!=null&&!orderStatus.equals("已下单"))) {
                btBottomRight.setVisibility(View.GONE);
            }
        }
    }

    /**
     * 获取订单详情
     *
     * @param orderId
     */
    private void findOrderDetail(String orderId) {
        Map<String, String> map = new HashMap<>(1);
        map.put("orderId", orderId);
        OkGoUtil.getRequest(UrlPath.ACCOUNT_FIND_ORDER_BYID, this, map,
                new DialogCallback<FindOrderDetailResponseParam>(this) {
                    @Override
                    public void onSuccess(Response<FindOrderDetailResponseParam> response) {
                        if (response.body() != null) {
                            listData.clear();
                            listData.addAll(response.body().getOciSuiteVos());
                            FindOrderDetailResponseParam.SurgeryPatientVoBean item = response.body().getSurgeryPatientVo();
                            tvOpName.setText(item.getSurgeryName());
                            tvPatientName.setText(item.getPatientName());
                            tvPatientBrth.setText(item.getBirthday());
                            tvPatientId.setText(item.getHisPatientId());
                            tvPatientHigh.setText("--");
                            tvPatientCaseId.setText(item.getCaseNo());
                            tvPatientSex.setText(item.getGender());
                            tvOpTime.setText(item.getScheduleTime());
                            tvPatientDoctor.setText(item.getDoctorName());
                            mOrderLookUpDetailsAdapter.notifyDataSetChanged();
                        }
                    }

                    @Override
                    public void onError(Response<FindOrderDetailResponseParam> response) {
                        super.onError(response);
                    }
                });
    }

    @OnClick({R.id.bt_bottom_left, R.id.bt_bottom_right})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.bt_bottom_left://拒绝
                switch (mFrom) {

                    case "HckDeptUnExamineOrderFragment1"://器械处审核订单--待审核
                        operatorOrder("3");
                        break;
                    case "HckDeptUnExamineOrderFragment2"://器械处审核订单--待确认撤销
                        operatorOrder("1");
                        break;
                    case "HomeHckDeptCheckOrderFragment"://器械处验收订单
                        operatorOrder("5");
                        break;
                    default:
                        break;
                }
                break;
            case R.id.bt_bottom_right://通过
                switch (mFrom) {
                    case "HckDeptUnExamineOrderFragment1"://器械处审核订单--待审核
                        operatorOrder("2");
                        break;
                    case "HckDeptUnExamineOrderFragment2"://器械处审核订单--待确认撤销
                        operatorOrder("14");
                        break;
                    case "HomeHckDeptCheckOrderFragment"://器械处验收订单
                        operatorOrder("4");
                        break;
                    case "HomeOrderLookUpFragment"://订单查询--撤销订单
                        operatorOrder("13");
                        break;
                    default:
                        break;
                }
                break;
        }
    }

    /**
     * 订单操作
     *
     * @param operator
     */
    private void operatorOrder(String operator) {
        Map<String, String> map = new HashMap<>(2);
        map.put("operator", operator);
        map.put("orderId", mOrderId);
        OkGoUtil.postJsonRequest(UrlPath.ACCOUNT_OPERATOR_ORDER, this, map,
                new DialogCallback<SaveOrderResponseParam>(this) {
                    @Override
                    public void onSuccess(Response<SaveOrderResponseParam> response) {
                        if (response.body() != null) {
                            if (response.body().isOperateSuccess()) {
                                ToastUtils.showShort("操作成功");
                                EventBusUtils.post(new Event.EventOrderOpt(mFrom));
                                finish();
                            } else {
                                String msg = response.body().getMsg();
                                if (!TextUtils.isEmpty(msg)) {
                                    ToastUtils.showShort(msg);
                                } else {
                                    ToastUtils.showShort("操作失败");
                                }
                            }

                        }
                    }

                    @Override
                    public void onError(Response<SaveOrderResponseParam> response) {
                        super.onError(response);
                    }
                });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBusUtils.unregister(this);
    }

    /**
     * 订单操作
     *
     * @param event
     */
    @Subscribe(threadMode = ThreadMode.MAIN, sticky = true)
    public void onEventSelectPatint(Event.EventOrderOpt event) {
        finish();
    }
}
