package com.rivamed.orthopaedicacceptanceterminal.fragment;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.lzy.okgo.model.Response;
import com.rivamed.common.base.BaseFragment;
import com.rivamed.common.http.OkGoUtil;
import com.rivamed.common.http.callback.DialogCallback;
import com.rivamed.orthopaedicacceptanceterminal.R;
import com.rivamed.orthopaedicacceptanceterminal.adapter.SupRoomCheckOrderAdapter;
import com.rivamed.orthopaedicacceptanceterminal.app.UrlPath;
import com.rivamed.orthopaedicacceptanceterminal.bean.FindOrderRequestParam;
import com.rivamed.orthopaedicacceptanceterminal.bean.FindOrderResponseParam;
import com.rivamed.orthopaedicacceptanceterminal.views.SearchView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.Unbinder;

/**
 * @ProjectName: Orthopaedic_Acceptance_Terminal
 * @Package: com.rivamed.orthopaedicacceptanceterminal.fragment
 * @ClassName: SupRoomCheckFragment
 * @Description: 器械处审核订单-待审核
 * @Author: Amos_Bo
 * @CreateDate: 2019/2/28 10:05
 * @UpdateUser: 更新者
 * @UpdateDate: 2019/2/28 10:05
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class HckDeptUnExamineOrderFragment extends BaseFragment {

    @BindView(R.id.tv_center_title)
    TextView mTvCenterTitle;
    @BindView(R.id.ll_top_root)
    RelativeLayout mLlTopRoot;
    @BindView(R.id.view_top_search)
    SearchView mViewTopSearch;
    @BindView(R.id.rv_context)
    RecyclerView mRvContext;
    Unbinder unbinder;

    List<FindOrderResponseParam.OciOrderVosBean> listData = new ArrayList<FindOrderResponseParam.OciOrderVosBean>();

    public static HckDeptUnExamineOrderFragment newInstance() {
        Bundle args = new Bundle();
        HckDeptUnExamineOrderFragment fragment = new HckDeptUnExamineOrderFragment();
        fragment.setArguments(args);
        return fragment;
    }

    private SupRoomCheckOrderAdapter mSupRoomCheckOrderAdapter;

    @Override
    public int getLayoutId() {
        return R.layout.fragment_suproom_checkord;
    }

    @Override
    public void initDataAndEvent(Bundle savedInstanceState) {
        mSupRoomCheckOrderAdapter = new SupRoomCheckOrderAdapter(getContext());
        mSupRoomCheckOrderAdapter.setList(listData);
        mRvContext.setLayoutManager(new LinearLayoutManager(getContext()));
        mRvContext.setAdapter(mSupRoomCheckOrderAdapter);
        FindOrderRequestParam findOrderRequestParam = new FindOrderRequestParam();
        findOrderRequestParam.setStatus("1");
        findOrder(findOrderRequestParam);
    }

    /**
     * 订单查询
     * @param findOrderRequestParam
     */
    private void findOrder(FindOrderRequestParam findOrderRequestParam) {
        OkGoUtil.postJsonRequest(UrlPath.ACCOUNT_FIND_ORDER, this, findOrderRequestParam,
                new DialogCallback<FindOrderResponseParam>(context) {
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

}
