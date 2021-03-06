package com.rivamed.orthopaedicacceptanceterminal.fragment;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.lzy.okgo.model.Response;
import com.rivamed.common.adapter.SimpleRecyclerAdapter;
import com.rivamed.common.base.BaseFragment;
import com.rivamed.common.http.OkGoUtil;
import com.rivamed.common.http.callback.JsonCallback;
import com.rivamed.common.utils.EventBusUtils;
import com.rivamed.orthopaedicacceptanceterminal.R;
import com.rivamed.orthopaedicacceptanceterminal.activities.OrderDetailsActivity;
import com.rivamed.orthopaedicacceptanceterminal.adapter.SupRoomCheckOrderAdapter;
import com.rivamed.orthopaedicacceptanceterminal.app.UrlPath;
import com.rivamed.orthopaedicacceptanceterminal.bean.Event;
import com.rivamed.orthopaedicacceptanceterminal.bean.FindOrderRequestParam;
import com.rivamed.orthopaedicacceptanceterminal.bean.FindOrderResponseParam;
import com.rivamed.orthopaedicacceptanceterminal.views.SearchView;
import com.scwang.smartrefresh.header.MaterialHeader;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * @ProjectName: Orthopaedic_Acceptance_Terminal
 * @Package: com.rivamed.orthopaedicacceptanceterminal.fragment
 * @ClassName: SupRoomCheckFragment
 * @Description: 器械处审核订单-待审核/待确认撤销
 * @Author: Amos_Bo
 * @CreateDate: 2019/2/28 10:05
 * @UpdateUser: 更新者
 * @UpdateDate: 2019/2/28 10:05
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
@SuppressLint("ValidFragment")
public class HckDeptUnExamineOrderFragment extends BaseFragment {

    private final int mType;//1为待审核 2为待确认撤销

    @BindView(R.id.view_top_search)
    SearchView mViewTopSearch;
    @BindView(R.id.rv_context)
    RecyclerView mRvContext;
    Unbinder unbinder;

    List<FindOrderResponseParam.OciOrderVosBean> listData = new ArrayList<FindOrderResponseParam.OciOrderVosBean>();
    @BindView(R.id.header)
    MaterialHeader mHeader;
    @BindView(R.id.refreshLayout)
    SmartRefreshLayout mRefreshLayout;
    Unbinder unbinder1;

    private SupRoomCheckOrderAdapter mSupRoomCheckOrderAdapter;
    private String mContent;

    public HckDeptUnExamineOrderFragment(int type) {
        mType = type;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_hck_dept_examine;
    }

    @Override
    public void initDataAndEvent(Bundle savedInstanceState) {
        EventBusUtils.register(this);
        mSupRoomCheckOrderAdapter = new SupRoomCheckOrderAdapter(getContext(),1);
        mSupRoomCheckOrderAdapter.setList(listData);
        mRvContext.setLayoutManager(new LinearLayoutManager(getContext()));
        mRvContext.setAdapter(mSupRoomCheckOrderAdapter);
        findOrder(new FindOrderRequestParam());

        EditText etSeach = mViewTopSearch.getEtSeach();
        etSeach.setHint("病案号、患者姓名、手术名称、订单号");
        etSeach.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                mContent = etSeach.getText().toString();
                FindOrderRequestParam findOrderRequestParam = new FindOrderRequestParam();
                findOrderRequestParam.setTerm(mContent);
                findOrder(findOrderRequestParam);
            }
        });

        mSupRoomCheckOrderAdapter.setOnItemClickListener(new SimpleRecyclerAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Intent intent = new Intent(getActivity(), OrderDetailsActivity.class);
                intent.putExtra("orderId", listData.get(position).getOrderId());
                intent.putExtra("from", "HckDeptUnExamineOrderFragment" + mType);
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
                FindOrderRequestParam findOrderRequestParam = new FindOrderRequestParam();
                findOrderRequestParam.setTerm(mContent);
                findOrder(findOrderRequestParam);
                mRefreshLayout.finishRefresh();
            }
        });
    }

    /**
     * 订单查询
     *
     * @param findOrderRequestParam
     */
    private void findOrder(FindOrderRequestParam findOrderRequestParam) {
        if (mType == 1) {
            findOrderRequestParam.setStatus("1");
        } else if (mType == 2) {
            findOrderRequestParam.setStatus("13");
        }
        OkGoUtil.postJsonRequest(UrlPath.ACCOUNT_FIND_ORDER, this, findOrderRequestParam,
                new JsonCallback<FindOrderResponseParam>() {
                    @Override
                    public void onSuccess(Response<FindOrderResponseParam> response) {
                        try {
                            if (response.body() != null && response.body().getOciOrderVos() != null) {
                                listData.clear();
                                listData.addAll(response.body().getOciOrderVos());
                                mSupRoomCheckOrderAdapter.notifyDataSetChanged();
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void onError(Response<FindOrderResponseParam> response) {
                        super.onError(response);
                    }
                });
    }

    /**
     * 订单操作
     *
     * @param event
     */
    @Subscribe(threadMode = ThreadMode.MAIN, sticky = true)
    public void onEventSelectPatint(Event.EventOrderOpt event) {
        if (event.mFrom.equals("HckDeptUnExamineOrderFragment" + mType)) {
            FindOrderRequestParam findOrderRequestParam = new FindOrderRequestParam();
            findOrderRequestParam.setTerm(mContent);
            findOrder(findOrderRequestParam);
        } else if (event.mFrom.equals("HomeOrderRequestFragment")) {
            //审核通过
            FindOrderRequestParam findOrderRequestParam = new FindOrderRequestParam();
            findOrderRequestParam.setTerm(mContent);
            findOrder(findOrderRequestParam);
        } else if (event.mFrom.equals("HomeOrderLookUpFragment")) {
            //订单查询--撤销
            FindOrderRequestParam findOrderRequestParam = new FindOrderRequestParam();
            findOrderRequestParam.setTerm(mContent);
            findOrder(findOrderRequestParam);
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        EventBusUtils.unregister(this);
        unbinder1.unbind();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        unbinder1 = ButterKnife.bind(this, rootView);
        return rootView;
    }
}
