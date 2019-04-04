package com.rivamed.orthopaedicacceptanceterminal.fragment;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.lzy.okgo.model.Response;
import com.rivamed.common.adapter.SimpleRecyclerAdapter;
import com.rivamed.common.base.BaseFragment;
import com.rivamed.common.http.OkGoUtil;
import com.rivamed.common.http.callback.DialogCallback;
import com.rivamed.common.http.callback.JsonCallback;
import com.rivamed.common.utils.BaseUtils;
import com.rivamed.common.utils.EventBusUtils;
import com.rivamed.common.utils.SPUtils;
import com.rivamed.common.utils.ToastUtils;
import com.rivamed.orthopaedicacceptanceterminal.R;
import com.rivamed.orthopaedicacceptanceterminal.activities.LoginActivityNew;
import com.rivamed.orthopaedicacceptanceterminal.activities.OrderDetailsActivity;
import com.rivamed.orthopaedicacceptanceterminal.adapter.OrderLookUpAdapter;
import com.rivamed.orthopaedicacceptanceterminal.app.Constants;
import com.rivamed.orthopaedicacceptanceterminal.app.UrlPath;
import com.rivamed.orthopaedicacceptanceterminal.bean.Event;
import com.rivamed.orthopaedicacceptanceterminal.bean.FindOrderRequestParam;
import com.rivamed.orthopaedicacceptanceterminal.bean.FindOrderResponseParam;
import com.rivamed.orthopaedicacceptanceterminal.bean.FindOrderStatusResponseParam;
import com.rivamed.orthopaedicacceptanceterminal.views.ListPopupWindow;
import com.scwang.smartrefresh.header.MaterialHeader;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * @ProjectName: Orthopaedic_Acceptance_Terminal
 * @Package: com.rivamed.orthopaedicacceptanceterminal.fragment
 * @ClassName: OrderLookUpFragment
 * @Description: 订单查询
 * @Author: Amos_Bo
 * @CreateDate: 2019/2/27 9:43
 * @UpdateUser: 更新者
 * @UpdateDate: 2019/2/27 9:43
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class HomeOrderLookUpFragment extends BaseFragment {
    @BindView(R.id.tv_center_title)
    TextView tvCenterTitle;
    @BindView(R.id.tv_start_time)
    TextView tvStartTime;
    @BindView(R.id.ll_start_time)
    LinearLayout llStartTime;
    @BindView(R.id.tv_end_time)
    TextView tvEndTime;
    @BindView(R.id.ll_end_time)
    LinearLayout llEndTime;
    @BindView(R.id.ll_select_time)
    LinearLayout llSelectTime;
    @BindView(R.id.tv_state)
    TextView tvState;
    @BindView(R.id.ll_state)
    LinearLayout llState;
    @BindView(R.id.et_search_key)
    EditText etSearchKey;
    @BindView(R.id.btn_lookup)
    Button btnLookup;
    @BindView(R.id.ll_top_root)
    RelativeLayout mLlTopRoot;
    @BindView(R.id.rv_context)
    RecyclerView mRvContext;
    Unbinder unbinder;
    @BindView(R.id.header)
    MaterialHeader mHeader;
    @BindView(R.id.refreshLayout)
    SmartRefreshLayout mRefreshLayout;
    @BindView(R.id.tv_top_username)
    TextView mTvTopUsername;
    @BindView(R.id.rl_logout)
    RelativeLayout mRlLogout;

    private OrderLookUpAdapter mOrderLookUpAdapter;
    private Calendar mCa;
    private int mYear;
    private int mMonth;
    private int mDay;
    private List<FindOrderStatusResponseParam.DictsBean> mDicts = new ArrayList<>();
    List<FindOrderResponseParam.OciOrderVosBean> listData = new ArrayList<FindOrderResponseParam.OciOrderVosBean>();
    private String mValue = "";

    public static HomeOrderLookUpFragment newInstance() {
        Bundle args = new Bundle();
        HomeOrderLookUpFragment fragment = new HomeOrderLookUpFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_order_lookup;
    }

    @Override
    public void initDataAndEvent(Bundle savedInstanceState) {
        EventBusUtils.register(this);
        mTvTopUsername.setText(SPUtils.getString(getContext(), Constants.ORTHOPAEDIC_USER_NNAME, ""));
        mRlLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                logOut(LoginActivityNew.class);
            }
        });
        mCa = Calendar.getInstance();
        tvCenterTitle.setText("订单查询");
        mYear = mCa.get(Calendar.YEAR);
        mMonth = mCa.get(Calendar.MONTH);
        mDay = mCa.get(Calendar.DAY_OF_MONTH);
        tvStartTime.setText(mYear + "-" + (mMonth + 1) + "-" + mDay);
        tvEndTime.setText(mYear + "-" + (mMonth + 1) + "-" + mDay);
        BaseUtils.setInputLenWithNoBlank(etSearchKey, 50);
        mOrderLookUpAdapter = new OrderLookUpAdapter(getContext());
        mOrderLookUpAdapter.setList(listData);
        mRvContext.setLayoutManager(new LinearLayoutManager(getContext()));
        mRvContext.setAdapter(mOrderLookUpAdapter);
        getDataFromNet(false);
        mOrderLookUpAdapter.setOnItemClickListener(new SimpleRecyclerAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Intent intent = new Intent(getActivity(), OrderDetailsActivity.class);
                intent.putExtra("orderId", listData.get(position).getOrderId());
                intent.putExtra("from", "HomeOrderLookUpFragment");
                startActivity(intent);
            }

            @Override
            public void onItemLongClick(View view, int position) {

            }
        });
        mRefreshLayout.setEnableAutoLoadMore(false);
        mRefreshLayout.setEnableRefresh(true);//是否启用下拉刷新功能
        mRefreshLayout.setEnableLoadMore(false);//是否启用上拉加载功能
        mRefreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(RefreshLayout refreshLayout) {
                findOrder();
                mRefreshLayout.finishRefresh();
            }
        });
    }

    @OnClick({R.id.ll_start_time, R.id.ll_end_time, R.id.ll_state, R.id.btn_lookup})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.ll_start_time:
                DatePickerDialog datePickerDialog = new DatePickerDialog(getContext(),
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                                tvStartTime.setText(year + "-" + (month + 1) + "-" + dayOfMonth);
                            }
                        },
                        mYear, mMonth, mDay);
                datePickerDialog.show();
                break;
            case R.id.ll_end_time:
                DatePickerDialog datePickerDialog2 = new DatePickerDialog(getContext(),
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                                tvEndTime.setText(year + "-" + (month + 1) + "-" + dayOfMonth);
                            }
                        },
                        mYear, mMonth, mDay);
                datePickerDialog2.show();
                break;
            case R.id.ll_state:
                findOrderStatus();
                break;
            case R.id.btn_lookup:
                if (TextUtils.isEmpty(mValue)) {
                    ToastUtils.showShort("请选择状态");
                } else {
                    findOrder();
                }
                break;
            default:
                break;
        }
    }

    /**
     * 订单查询
     */
    private void findOrder() {
        if (TextUtils.isEmpty(mValue)) {
            return;
        }
        String content = etSearchKey.getText().toString().trim();
        FindOrderRequestParam findOrderRequestParam = new FindOrderRequestParam();
        findOrderRequestParam.setStatus(mValue);
        if (!TextUtils.isEmpty(content)) {
            findOrderRequestParam.setTerm(content);
        }
        findOrderRequestParam.setStartDate(tvStartTime.getText().toString().trim());
        findOrderRequestParam.setEndDate(tvEndTime.getText().toString().trim());
        OkGoUtil.postJsonRequest(UrlPath.ACCOUNT_FIND_ORDER, this, findOrderRequestParam,
                new DialogCallback<FindOrderResponseParam>(context) {
                    @Override
                    public void onSuccess(Response<FindOrderResponseParam> response) {
                        if (response.body() != null && response.body().getOciOrderVos() != null) {
                            listData.clear();
                            listData.addAll(response.body().getOciOrderVos());
                            mOrderLookUpAdapter.notifyDataSetChanged();
                        } else {
                            String msg = response.body().getMsg();
                            if (!TextUtils.isEmpty(msg)) {
                                ToastUtils.showShort(msg);
                            } else {
                                ToastUtils.showShort("访问网络失败");
                            }
                        }
                    }

                    @Override
                    public void onError(Response<FindOrderResponseParam> response) {
                        super.onError(response);
                    }
                });
    }


    /**
     * 获取订单状态
     */
    private void findOrderStatus() {
        if (mDicts.size() > 0) {
            showPop();
            getDataFromNet(false);
        } else {
            getDataFromNet(true);
        }
    }

    private void getDataFromNet(boolean isShowPop) {
        OkGoUtil.getRequest(UrlPath.ACCOUNT_ORDERSTATUS_LIST, this,
                new JsonCallback<FindOrderStatusResponseParam>() {
                    @Override
                    public void onSuccess(Response<FindOrderStatusResponseParam> response) {
                        if (response.body() != null && response.body().getDicts() != null) {
                            mDicts.clear();
                            mDicts.addAll(response.body().getDicts());
                            if (isShowPop) {
                                showPop();
                            }
                        }
                    }

                    @Override
                    public void onError(Response<FindOrderStatusResponseParam> response) {
                        super.onError(response);
                    }
                });
    }

    private void showPop() {
        List<String> listData = new ArrayList<String>();
        for (FindOrderStatusResponseParam.DictsBean dict : mDicts) {
            listData.add(dict.getDesc());
        }
        new ListPopupWindow(getActivity(), listData, llState, new ListPopupWindow.IPopCallBack() {
            @Override
            public void callBack(String content, int posotion) {
                tvState.setText(content);
                mValue = mDicts.get(posotion).getValue();
            }
        })
                .setWidthType(1)
                .setRightDistence(BaseUtils.dip2px(getActivity(), 16))
                .showPopup(2);
    }

    /**
     * 订单操作
     *
     * @param event
     */
    @Subscribe(threadMode = ThreadMode.MAIN, sticky = true)
    public void onEventSelectPatint(Event.EventOrderOpt event) {
        //        if (event.mFrom.equals("HomeOrderLookUpFragment")) {
        //        }
        //操作订单后刷新数据
        try {
            findOrder();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
