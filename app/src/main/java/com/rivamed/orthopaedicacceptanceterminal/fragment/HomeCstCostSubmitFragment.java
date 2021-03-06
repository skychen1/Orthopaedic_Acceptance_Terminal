package com.rivamed.orthopaedicacceptanceterminal.fragment;

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
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.lzy.okgo.model.Response;
import com.rivamed.common.adapter.SimpleRecyclerAdapter;
import com.rivamed.common.base.BaseFragment;
import com.rivamed.common.http.OkGoUtil;
import com.rivamed.common.http.callback.JsonCallback;
import com.rivamed.common.utils.BaseUtils;
import com.rivamed.common.utils.EventBusUtils;
import com.rivamed.common.utils.SPUtils;
import com.rivamed.orthopaedicacceptanceterminal.R;
import com.rivamed.orthopaedicacceptanceterminal.activities.CstCostDetailsActivity;
import com.rivamed.orthopaedicacceptanceterminal.activities.LoginActivityNew;
import com.rivamed.orthopaedicacceptanceterminal.adapter.SupRoomCheckOrderAdapter;
import com.rivamed.orthopaedicacceptanceterminal.app.Constants;
import com.rivamed.orthopaedicacceptanceterminal.app.UrlPath;
import com.rivamed.orthopaedicacceptanceterminal.bean.Event;
import com.rivamed.orthopaedicacceptanceterminal.bean.FindOrderRequestParam;
import com.rivamed.orthopaedicacceptanceterminal.bean.FindOrderResponseParam;
import com.rivamed.orthopaedicacceptanceterminal.views.ListPopupWindow;
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
 * @ClassName: CstCostSubmitFregment
 * @Description: 计费提报
 * @Author: Amos_Bo
 * @CreateDate: 2019/2/27 16:08
 * @UpdateUser: 更新者
 * @UpdateDate: 2019/2/27 16:08
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class HomeCstCostSubmitFragment extends BaseFragment {
    @BindView(R.id.view_top_search)
    SearchView mViewTopSearch;
    @BindView(R.id.rv_context)
    RecyclerView mRvContext;
    @BindView(R.id.tv_center_title)
    TextView mTvCenterTitle;
    @BindView(R.id.ll_top_root)
    RelativeLayout mLlTopRoot;
    Unbinder unbinder;
    @BindView(R.id.header)
    MaterialHeader mHeader;
    @BindView(R.id.refreshLayout)
    SmartRefreshLayout mRefreshLayout;
    @BindView(R.id.tv_top_username)
    TextView mTvTopUsername;
    @BindView(R.id.rl_logout)
    RelativeLayout mRlLogout;
    @BindView(R.id.tv_state)
    TextView mTvState;
    @BindView(R.id.ll_state)
    LinearLayout mLlState;
    Unbinder unbinder1;
    private SupRoomCheckOrderAdapter mSupRoomCheckOrderAdapter;
    List<FindOrderResponseParam.OciOrderVosBean> listData = new ArrayList<FindOrderResponseParam.OciOrderVosBean>();
    private String mContent;
    private int mPosotion = 0;
    List<String> listDataState = new ArrayList<String>();

    public static HomeCstCostSubmitFragment newInstance() {
        Bundle args = new Bundle();
        HomeCstCostSubmitFragment fragment = new HomeCstCostSubmitFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_ordcstcost_submit;
    }

    @Override
    public void initDataAndEvent(Bundle savedInstanceState) {
        EventBusUtils.register(this);
        listDataState.add("全部");
        listDataState.add("待计费提报");
        listDataState.add("已计费提报");
        mTvState.setText(listDataState.get(0));
        mTvTopUsername.setText(SPUtils.getString(getContext(), Constants.ORTHOPAEDIC_USER_NNAME, ""));
        mRlLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                logOut(LoginActivityNew.class);
            }
        });
        mTvCenterTitle.setText("耗材计费提报");
        mSupRoomCheckOrderAdapter = new SupRoomCheckOrderAdapter(getContext(),0);
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
                Intent intent = new Intent(getActivity(), CstCostDetailsActivity.class);
                intent.putExtra("orderId", listData.get(position).getOrderId());
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

        mLlState.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //选择状态
                showPop();
            }
        });
    }

    private void showPop() {
        new ListPopupWindow(getActivity(), listDataState, mLlState, new ListPopupWindow.IPopCallBack() {
            @Override
            public void callBack(String content, int posotion) {
                mTvState.setText(content);
                mPosotion = posotion;
                findOrder(new FindOrderRequestParam());
            }
        })
                .setWidthType(1)
                .setRightDistence(BaseUtils.dip2px(getActivity(), 16))
                .setTextSize(17)
                .showPopup(2);
    }

    /**
     * 订单查询
     *
     * @param findOrderRequestParam
     */
    private void findOrder(FindOrderRequestParam findOrderRequestParam) {
        switch (mPosotion) {
            case 0://全部
                findOrderRequestParam.setStatus("16,12");
                break;
            case 1://待计费提报
                findOrderRequestParam.setStatus("16");
                break;
            case 2://已计费提报
                findOrderRequestParam.setStatus("12");
                break;

            default:
                break;
        }

        OkGoUtil.postJsonRequest(UrlPath.ACCOUNT_FIND_ORDER, this, findOrderRequestParam,
                new JsonCallback<FindOrderResponseParam>() {
                    @Override
                    public void onSuccess(Response<FindOrderResponseParam> response) {
                        if (response.body() != null && response.body().getOciOrderVos() != null) {
                            listData.clear();
                            listData.addAll(response.body().getOciOrderVos());
                            mSupRoomCheckOrderAdapter.notifyDataSetChanged();
                        }
                    }

                    @Override
                    public void onError(Response<FindOrderResponseParam> response) {
                        super.onError(response);
                    }
                });
    }

    /**
     * 计费提报成功
     *
     * @param event
     */
    @Subscribe(threadMode = ThreadMode.MAIN, sticky = true)
    public void onEventSelectPatint(Event.EventOrderOpt event) {
        if (event.mFrom.equals("CstCostSureActivity") | event.mFrom.equals("HomeSupRoomCheckOrderFragment") | event.mFrom.equals("HomeNoseCheckOrderFragment")) {
            //计费提报成功,供应室验收订单,护士验收订单
            FindOrderRequestParam findOrderRequestParam = new FindOrderRequestParam();
            findOrderRequestParam.setTerm(mContent);
            findOrder(findOrderRequestParam);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        unbinder1 = ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder1.unbind();
    }
}
